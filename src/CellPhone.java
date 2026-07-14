public class CellPhone {
    private float remainingCredit;
    private int madeCalls;
    private float rate;

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
        if (this.rate <= 0) {
            System.out.println("[ERROR] You must set the rate before");
        }
        if (this.remainingCredit < rate) {
            // send sms
            System.out.println("[SMS] 3Insufficient credit");
            return;
        }

        System.out.println("[DEBUG] " + this.rate);
        System.out.println("[DEBUG] " + minutes);
        System.out.println("[DEBUG] " + this.rate * minutes);

            float totalRate = this.rate * minutes;
            this.remainingCredit -= totalRate;


        this.madeCalls++;

    }

    public void checkAvailableCredit() {
        System.out.println("Available credit: " + this.remainingCredit);
    }

    public void checkMadeCalls() {
        System.out.println("Made calls: " + this.madeCalls);
    }

    public void resetMadeCalls() {
        this.madeCalls = 0;
        // send sms
    }
}
