public class Contact {
    public String number;
    public String name;


    public Contact(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public void printContact() {
        System.out.println("Phone number: " + number);
        System.out.println("Phone name: " + name);
    }
}
