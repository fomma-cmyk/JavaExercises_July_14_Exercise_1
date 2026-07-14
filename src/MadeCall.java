public class MadeCall {
    private Contact contact;
    private boolean success;

    public MadeCall(Contact contact, boolean success) {
        this.contact = contact;
        this.success = success;
    }

    public void printMadeCall() {
        contact.printContact();
        System.out.println("Success: " + success);
    }
}
