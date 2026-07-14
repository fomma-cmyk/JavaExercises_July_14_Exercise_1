
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean isPhoneOn = true;
    private static CellPhone cellPhone;

    public static void main(String[] args) throws Exception {
        cellPhone = new CellPhone();

        while (isPhoneOn) {
            callCellMenu();
            listenForInputs();
        }




        
    }

    private static void callCellMenu() {
        System.out.println("===== PHONE MENU =====");
        System.out.println("1. Recharge wallet");
        System.out.println("2. Set rate");
        System.out.println("3. Call");
        System.out.println("4. Available credit");
        System.out.println("5. Made calls counter");
        System.out.println("6. Reset calls");
        System.out.println("7. Turn off");
    }

    private static void listenForInputs() {
        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1 -> handleWalletRecharge();
            case 2 -> handleSetRate();
            case 3 -> handleCall();
            case 4 -> handleCredit();
            case 5 -> handleMadeCalls();
            case 6 -> handleResetMadeCalls();
            case 7 -> turnOffPhone();
            default -> System.out.println("Invalid input");
        }

        System.out.println("\n\n\n");
    }



    private static void handleWalletRecharge() {
        System.out.println("Enter recharge amount of 5, 10 or 25");
        int amount = scanner.nextInt();
        cellPhone.rechargeWallet(amount);
    }

    private static void handleSetRate() {
        System.out.println("Enter rate in cents: ");
        float amount = scanner.nextFloat();

        cellPhone.setRate(amount);
    }

    private static void handleCall() {
        System.out.println("Enter phone number:");
        String number = scanner.next();
        System.out.println("Enter call duration in minutes");
        int minutes = scanner.nextInt();

        cellPhone.callPerson(number, minutes);
    }

    private static void handleCredit()
    {
        cellPhone.checkAvailableCredit();
    }

    private static void handleMadeCalls() {
        cellPhone.checkMadeCalls();
    }

    private static void handleResetMadeCalls() {
        cellPhone.resetMadeCalls();
    }

    private static void turnOffPhone() {
        isPhoneOn = false;
    }

}
