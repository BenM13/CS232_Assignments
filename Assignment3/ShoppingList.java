import java.util.Scanner;

public class ShoppingList
{
    public int priority;
    public final String PROMPT = "--> ";

    public static void main(String[] args)
    {
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
        System.out.println("J) Cup of hot chocolate: $2.00");

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Which item would you like?");
        System.out.print(PROMPT);
        char choice = keyboard.nextChar();
        System.out.println("How badly do you need it?");
        System.out.println("Give a priority as a whole number");
        System.out.print(PROMPT);
        int priority = keyboard.nextInt();
        
        // instantiate object based on item selection
        switch (choice) {
            case 'A':
                Item goggles = new Item("Goggles", 25, priority);
                System.out.println("You chose " + goggles.getName());
                break;
            case 'B':
                Item helmet = new Item("Helmet", 35, priority);
                System.out.println("You chose" + helmet.getName());
                break;
            case 'C':
                // code
                break;
            case 'D':
                // code
                break;
            case 'E':
                // code
                break;
            case 'F':
                // code
                break;
            case 'G':
                // code
                break;
            case 'H':
                // code
                break;
            case 'I':
                // code
                break;
            case 'J':
                // code
                break;
        }

    }
}