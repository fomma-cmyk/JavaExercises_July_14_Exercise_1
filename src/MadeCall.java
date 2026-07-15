public class MadeCall {
    private Contact contact;
    private boolean success;
    private String number;

    public MadeCall(Contact contact, boolean success) {
        this.contact = contact;
        this.success = success;
    }

    public MadeCall(String number, boolean success) {
        this.number = number;
        this.success = success;
    }

    public void printMadeCall() 
    {
        if (this.number != null) {
            System.out.println("Number: " + this.number);
            System.out.println("Success: " + success);
        } 
        else {
            contact.printContact();
            System.out.println("Success: " + success);
        }
    }
}
