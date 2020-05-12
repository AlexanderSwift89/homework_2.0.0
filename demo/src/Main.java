import java.util.Scanner;

/**
 * Java. Missed calls.
 *
 * @author Aleksandr Liapunov
 * @version 1.16.1 date April 21, 2020
 */

class Main {
    public static void main(String[] args) {
        boolean check = true;
        Scanner scanner = new Scanner(System.in);
        Contacts contacts = new Contacts();
        MissedCalled missedCalled = new MissedCalled();
        //создание массива контактов
        Contact contactUser0 = new Contact("Александр", "Петров", "+7-911-831-17-18", Group.WORK);
        Contact contactUser1 = new Contact("Сергей", "Иванов", "+7-916-541-18-19", Group.FRIENDS);
        Contact contactUser2 = new Contact("Сергей", "Павлович", "+7-925-831-17-18", Group.WORK);
        Contact contactUser3 = new Contact("Алексей", "Игоревич", "+7-902-125-15-21", Group.WORK);
        Contact contactUser4 = new Contact("Степан", "Андреевич", "+7-901-712-81-19", Group.WORK);
        contacts.setContacts(contactUser0.getPhone(), contactUser0);
        contacts.setContacts(contactUser1.getPhone(), contactUser1);
        contacts.setContacts(contactUser2.getPhone(), contactUser2);
        contacts.setContacts(contactUser3.getPhone(), contactUser3);
        contacts.setContacts(contactUser4.getPhone(), contactUser4);

        while (check) {
            System.out.println("1. Добавить контакт");
            System.out.println("2. Добавить пропущенный вызов");
            System.out.println("3. Вывести все пропущеные вызовы");
            System.out.println("4. Очистить пропущенные вызовы");
            System.out.println("5. Удалить контакт по имени и фамилии");
            System.out.println("6. Редактировать контакт (поиск по номеру телефона)");
            System.out.println("7. Поиск контакта по номеру телефона");
            System.out.println("8. Выход");
            System.out.println("Выберите пункт из меню (1-8)");
            int id = Integer.parseInt(scanner.nextLine());
            if (id == 1) {
                Contact contact = new Contact();
                System.out.println("Введите имя:");
                contact.setName(scanner.nextLine());
                System.out.println("Введите фамилию:");
                contact.setSurname(scanner.nextLine());
                System.out.println("Введите номер телефона:");
                contact.setPhone(scanner.nextLine());
                System.out.println("Введите группу:");
                String inGroup = scanner.nextLine();
                if (inGroup.equals("WORK")) {
                    contact.setGroup(Group.WORK);
                } else if (inGroup.equals("FRIENDS")) {
                    contact.setGroup(Group.FRIENDS);
                } else if (inGroup.equals("FAMILY")) {
                    contact.setGroup(Group.FAMILY);
                } else {
                    System.out.println("Введенная вами группа не существует");
                }
                contacts.setContacts(contact.getPhone(), contact);
            } else if (id == 2) {
                System.out.println("Введите номер телефона пропущенного звонка:");
                missedCalled.addMissedCalled(scanner.nextLine());
            } else if (id == 3) {
                System.out.println("Список пропущенных звонков:");
                missedCalled.getAllMissedCalled(contacts);
            } else if (id == 4) {
                System.out.println("Список пропущенных звонков очищен");
                missedCalled.clearAllMissedCalled();
            } else if (id == 5) {
                System.out.println("Введите имя и фамилию контакта, что бы его удалить:");
                String[] subStr = scanner.nextLine().split(" ");
                contacts.deleteContacts(subStr[0], subStr[1]);
            } else if (id == 6) {
                System.out.println("Введите номер телефона контакта для редактирования");
                contacts.editContacts(scanner.nextLine());
            } else if (id == 7) {
                System.out.println("Введите номер телефона контакта для поиска");
                contacts.findContacts(scanner.nextLine());
            } else if (id == 8) {
                check = false;
            } else {
                System.out.println("Вы ввели не правильное значение, допустимые значения от 1 до 8. Повторите ввод пожалуйста.");
            }
        }
        for (String disContact : contacts.getKeyContacts()) {
            Contact.toString(contacts.getValueContacts(disContact));
        }
    }
}