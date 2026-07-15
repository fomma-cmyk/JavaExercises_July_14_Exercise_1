
import java.util.HashSet;
import java.util.Scanner;

public class CellPhone {
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean isPhoneOn = true;
    private float remainingCredit;
    private HashSet<MadeCall> madeCalls = new HashSet<>();
    private float rate;
    private Contacts contacts;
    private SlotMachine slotMachine;

    public CellPhone() {
        this.contacts = new Contacts();
        this.slotMachine = new SlotMachine();

        contacts.createContact("3675636745", "Francesco");
        contacts.createContact("309624378", "Mattia");
    }

    public Contacts getContacts() {
        return this.contacts;
    }

    // private static SlotMachine getSlotMachine() {
    //     return slotMachine;
    // }

    public void rechargeWallet(int amount) {
        int[] availableAmounts = {5, 10, 25};

        for (int i : availableAmounts) {
            if (i == amount) {
                this.remainingCredit += amount;
                System.out.println("[SMS] We confirm you have recharged your wallet of " + amount + "$");
                return;
            }
            

        }
        
        System.out.println("Invalid amount");
    }

    public void setRate(float rate) {
        // this.rate = rate / (float)minutes;
        this.rate = rate / 100;

        System.out.println("[SMS] We confirm you have set the rate of 0." + rate + "$");
    }

    public void callPerson (String number, int minutes) {
        if (contacts.findContact(number) == null) {
            System.out.println("[ERROR] Contact does not exist in your list");
            return;
        }
        if (this.rate <= 0) {
            System.out.println("[ERROR] You must set the rate before");
        }

        float totalRate = this.rate * minutes;
        
        if (this.remainingCredit < totalRate) {
            // send sms
            madeCalls.add(new MadeCall(contacts.findContact(number), false));
            System.out.println("[SMS] Insufficient credit");
            return;
        }
        
        this.remainingCredit -= totalRate;
        // System.out.println("[DEBUG] " + this.rate);
        // System.out.println("[DEBUG] " + minutes);
        // System.out.println("[DEBUG] " + this.rate * minutes);

        

        // System.out.println(contacts.findContact(number));
        // System.out.println(new MadeCall(contacts.findContact(number), true));

        madeCalls.add(new MadeCall(contacts.findContact(number), true));


        // this.madeCalls++;

    }

    public void checkAvailableCredit() {
        System.out.println("Available credit: " + this.remainingCredit);
    }

    public void checkMadeCalls() {
        System.out.println("Made calls: ");
        for (MadeCall mc : this.madeCalls) {
            mc.printMadeCall();
        }
        System.out.println("Count: " + this.madeCalls.size());
    }

    public void resetMadeCalls() {
        this.madeCalls.clear();
        // send sms
        System.out.println("[SMS] Made class cleared");
    }


    public void listenForInputs() {
        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1 -> handleWalletRecharge();
            case 2 -> handleSetRate();
            case 3 -> handleCall();
            case 4 -> handleCredit();
            case 5 -> handleMadeCalls();
            case 6 -> handleResetMadeCalls();
            case 7 -> handleCreateContact();
            case 8 -> handleRemoveContact();
            case 9 -> handleListContacts();
            case 10 -> slotMachine.initializeSlotMachine();
            case 11 -> turnOffPhone();
            default -> System.out.println("Invalid input");
        }

        System.out.println("\n");
    }



    private void handleWalletRecharge() {
        System.out.println("Enter recharge amount of 5, 10 or 25");
        int amount = scanner.nextInt();
        this.rechargeWallet(amount);
    }

    private void handleSetRate() {
        System.out.println("Enter rate in cents: ");
        float amount = scanner.nextFloat();

        setRate(amount);
    }

    private void handleCall() {
        System.out.println("Enter phone number:");
        String number = scanner.next();
        System.out.println("Enter call duration in minutes");
        int minutes = scanner.nextInt();

        callPerson(number, minutes);
    }

    private void handleCredit()
    {
        checkAvailableCredit();
    }

    private void handleMadeCalls() {
        checkMadeCalls();
    }

    private void handleResetMadeCalls() {
        resetMadeCalls();
    }

    private void turnOffPhone() {
        isPhoneOn = false;
    }

    private void handleCreateContact() {
        System.out.println("Enter contact number: ");
        String number = scanner.next();
        System.out.println("Enter contact name: ");
        String name = scanner.next();

        getContacts().createContact(number, name);
    }
    
    private void handleRemoveContact() {
        System.out.println("Enter contact number: ");
        String number = scanner.next();

        getContacts().removeContact(number);
    }

    private void handleListContacts() {
        getContacts().listContacts();
    }
}
