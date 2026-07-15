
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    public static boolean isPhoneOn = true;
    private static CellPhone cellPhone;
   

    public static void main(String[] args) throws Exception {
        cellPhone = new CellPhone();

       

        while (isPhoneOn) {
            callCellMenu();
            cellPhone.listenForInputs();
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
        System.out.println("7. Create contact");
        System.out.println("8. Remove contact");
        System.out.println("9. List contacts");
        System.out.println("10. Slot machine");
        System.out.println("11. Call by contacts index");
        System.out.println("12. Turn off");
    }

    

   

}
