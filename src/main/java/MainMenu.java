import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    static List<String> mainMenuOptions;

    private static void initMenu() {
        mainMenuOptions = new ArrayList<>();
        mainMenuOptions.add("List Books");
        mainMenuOptions.add("Checkout Book");
        mainMenuOptions.add("Return Book");
        mainMenuOptions.add("List Movies");
        mainMenuOptions.add("Checkout Movie");
        mainMenuOptions.add("Display your info");
        mainMenuOptions.add("Quit");
    }

    public static int display() {
        initMenu();
        int selectedOption;
        do {
            System.out.println("\n========== Main menu ==========");
            System.out.println("========== Select an option ==========");
            for (int i = 1; i <= mainMenuOptions.size(); i++) {
                System.out.println(i + ": " + mainMenuOptions.get(i-1));
            }

            selectedOption = getMainMenuSelectedOption();
            return selectedOption;

        }while(true);
    }

    static int getMainMenuSelectedOption() {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        while ((i < 1) || (i > mainMenuOptions.size())) {
            System.out.println("Invalid option, please select again");
            i = scan.nextInt();
        }
        return i;
    }
}
