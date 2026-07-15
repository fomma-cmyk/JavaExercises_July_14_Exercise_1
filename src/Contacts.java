
import java.util.HashSet;

public class Contacts {
    private HashSet<Contact> contacts = new HashSet<>(); 

    public Contacts() {

    }

    public void createContact(String number, String name) {
        Contact newContact = new Contact(number, name);

        contacts.add(newContact);
    }

    public void removeContact(String number) {
        Contact toRemove = findContact(number);
        contacts.remove(toRemove);
    }

    public void listContacts() {
        for (Contact c : contacts) {
            c.printContact();
        }
    }


    public Contact findContact(String number) {
        Contact contact = contacts.stream()
            .filter(c -> c.number.equals(number))
            .findFirst()
            .orElse(null);

        // System.out.println("[DEBUG] " + contact);

        return contact;
    }
    
}