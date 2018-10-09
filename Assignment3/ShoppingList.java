import java.util.Scanner;

public class ShoppingList
{
    public static void main(String[] args)
    {
        int priority;
        final String PROMPT = "--> ";

        System.out.println("Welcome to the Mountain-side Ski Shop!");
        System.out.println("Check out our products/shop services listed below:");
        System.out.println("-----------------------");
        System.out.println("A) Ski Goggles: $25.00");
        System.out.println("B) Ski helmet: $35.00");
        System.out.println("C) Face Mask: $12.00");
        System.out.println("D) Ski gloves $20.00");
        System.out.println("E) Pack of hand warmers: $5.00");
        System.out.println("F) Pack of toe warmers: $5.00");
        System.out.println("G) Ski binding adjustment: $10.00");
        System.out.println("H) Ski edge sharpening: $15.00");
        System.out.println("I) Ski wax: $12.00");
        System.out.println("J) Daily locker rental: $7.00");

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Which item would you like?");System.out.println("Enter the letter corresponding to the item you want");
        char choice = Utilities.inputChar();
        System.out.println("How badly do you need it?");
        System.out.println("Give a priority as a whole number");
        System.out.print(PROMPT);
        priority = keyboard.nextInt();
        
        // instantiate object based on item selection
        switch (choice) {
            case 'A':
                Item goggles = new Item("Goggles", 25, priority);
                System.out.println("You chose " + goggles.getName());
                break;
            case 'B':
                Item helmet = new Item("Helmet", 35, priority);
                System.out.println("You chose " + helmet.getName());
                break;
            case 'C':
                Item mask = new Item("Face mask", 12, priority);
                System.out.println("You chose " + mask.getName());
                break;
            case 'D':
                Item gloves = new Item("Gloves", 20, priority);
                System.out.println("You chose " + gloves.getName());
                break;
            case 'E':
                Item handWarmers = new Item("Hand warmers", 5, priority);
                System.out.println("You chose " + handWarmers.getName());
                break;
            case 'F':
                Item toeWarmers = new Item("Toe warmers", 5, priority);
                System.out.println("You chose " + toeWarmers.getName());
                break;
            case 'G':
                Item adjustment = new Item("Binding adjustment", 10, priority);
                System.out.println("You chose " + adjustment.getName());
                break;
            case 'H':
                Item sharpening = new Item("Edge sharpening", 15, priority);
                System.out.println("You chose " + sharpening.getName());
                break;
            case 'I':
                Item wax = new Item("Ski wax", 12, priority);
                System.out.println("You chose " + wax.getName());
                break;
            case 'J':
                Item locker = new Item("Locker rental", 7, priority);
                System.out.println("You chose " + locker.getName());
                break;
            default:
                Utilities.quitProgram("Invalid item input");
                break;         
        }
    }
}