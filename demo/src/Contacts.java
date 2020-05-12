import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.*;
import java.util.Scanner;

public class Contacts {
    Map<String, Contact> contacts = new HashMap<>();

    public void setContacts(String phone, Contact contact) {
        contacts.put(phone, contact);
    }

    public void deleteContacts(String name, String surname) {
        Iterator<String> iter = contacts.keySet().iterator();
        Contact contact = new Contact();
        while (iter.hasNext()) {
            String nameIt = iter.next();
            contact = contacts.get(nameIt);
            if (name.equals(contact.getName()) && surname.equals(contact.getSurname())) {
                iter.remove();
            } else {
                System.out.println("Вы ввели не корректные данные. Проверьте вводимые фамилию или имя.");
            }
        }
    }

    public boolean checkContacts(String phone) {
        return contacts.containsKey(phone);
    }

    public void findContacts(String phone) {
        if ((contacts.get(phone)).equals(null)) {
            System.out.println("Номер телефона в телефонном справочнике не найден.");
        } else {
            Contact.toString(contacts.get(phone));
        }
    }

    public void editContacts(String phone) {
        Iterator<String> iter = contacts.keySet().iterator();
        Contact contact = new Contact();
        Scanner scanner = new Scanner(System.in);
        while (iter.hasNext()) {
            String nameIt = iter.next();
            contact = contacts.get(nameIt);
            if (phone.equals(contact.getPhone())) {
                System.out.println("1. Изменить имя");
                System.out.println("2. Изменить фамилию");
                System.out.println("3. Изменить номер телефона");
                System.out.println("4. Изменить группу");
                System.out.println("Выберите пункт из меню (1-4)");
                int id = Integer.parseInt(scanner.nextLine());
                if (id == 1) {
                    System.out.println("Введите новое имя:");
                    contact.setName(scanner.nextLine());
                } else if (id == 2) {
                    System.out.println("Введите новую фамилию:");
                    contact.setSurname(scanner.nextLine());
                } else if (id == 3) {
                    System.out.println("Введите новый номер телефона:");
                    contact.setPhone(scanner.nextLine());
                } else if (id == 4) {
                    System.out.println("Введите новую группу:");
                } else {
                    System.out.println("Вы ввели не правильное значение, допустимые значения от 1 до 4. Повторите ввод пожалуйста.");
                }
            }
        }
    }

    public Set<String> getKeyContacts() {
        return contacts.keySet();
    }

    public Contact getValueContacts(String key) {
        return contacts.get(key);
    }
}