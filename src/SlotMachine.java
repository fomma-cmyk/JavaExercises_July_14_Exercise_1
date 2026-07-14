
import java.util.Scanner;

public class SlotMachine {
    private static final Scanner scanner =  new Scanner(System.in);
    private static boolean isPlaying = true;
    private static int timesPlayed = 0;
    private static int timesWon = 0;
    private static int timesLost = 0;

    public SlotMachine() {

    }

    public void initializeSlotMachine() {
        while (isPlaying) {
            projectMenu();
            handleInputs();
        }
    }

    private static void projectMenu() {
        System.out.println("===== SLOT MACHINE =====");
        System.out.println("1. Play");
        System.out.println("2. Exit");
    }

    private static void handleInputs() {
        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> play();
            case 2 -> exit();
            default -> System.out.println("No choice with this number");
        }
    }

    private static void exit() {
        System.out.println("You played " + timesPlayed + " times, won " + timesWon + " and lost " + timesLost);
        isPlaying = false;
    }

    private static void play() {
        int x = (int)(Math.random() * 5) + 1;
        int y = (int)(Math.random() * 5) + 1;
        int z = (int)(Math.random() * 5) + 1;

        System.out.println("Your results are: ");
        System.out.println(x + "  " + y + "  " + z);


        if (x == y && y == z) {
            System.out.println("You won");
            timesWon++;
        }
        else {
            timesLost++;
            System.out.println("You lost");
        }

        timesPlayed++;
    }
}
