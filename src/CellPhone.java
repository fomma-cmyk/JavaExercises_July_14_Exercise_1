
import java.util.HashSet;

public class CellPhone {
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

    public SlotMachine getSlotMachine() {
        return this.slotMachine;
    }

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
        }
        if (this.rate <= 0) {
            System.out.println("[ERROR] You must set the rate before");
        }
        if (this.remainingCredit < rate) {
            // send sms
            madeCalls.add(new MadeCall(contacts.findContact(number), false));
            System.out.println("[SMS] 3Insufficient credit");
            return;
        }

        // System.out.println("[DEBUG] " + this.rate);
        // System.out.println("[DEBUG] " + minutes);
        // System.out.println("[DEBUG] " + this.rate * minutes);

        float totalRate = this.rate * minutes;
        this.remainingCredit -= totalRate;

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
}
