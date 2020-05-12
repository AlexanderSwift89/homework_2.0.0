public class Contact {
    private String name;
    private String surname;
    private String phone;
    private Enum group;

    public Contact() {
    }

    public Contact(String name, String surname, String phone, Enum group) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public Enum getGroup() {
        return group;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setGroup(Enum group) {
        this.group = group;
    }

    public static void toString(Contact contact) {
        System.out.println(contact.name + " " + contact.surname + " " + contact.phone + " " + contact.group);
    }
}
