import java.util.Scanner;

public class ShoppingTripDemo
{
    public static void main(String[] args)
    {
        final int NUM_ITEMS = 7;
        Item[] itemList = new Item[NUM_ITEMS];

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
        
        System.out.println("Please enter a letter corersponding to the "
                           + "item you wish to purchase");
        for (int i = 0; i < itemList.length; i++)
        {
            char choice;
            do
            {
                System.out.println("\nEnter a letter for item " + (i + 1));
                choice = Utilities.inputChar();
            // inputchar() returns '!' if there is a problem with the input
            } while (choice == '!');
            switch (choice) {
                case 'A':
                    itemList[i] = new Item("Goggles", 25);
                    break;
                case 'B':
                    itemList[i] = new Item("Helmet", 35);
                    break;
                case 'C':
                    itemList[i] = new Item("Face mask", 12);
                    break;
                case 'D':
                    itemList[i] = new Item("Gloves", 20);
                    break;
                case 'E':
                    itemList[i] = new Item("Hand warmers", 5);
                    break;
                case 'F':
                    itemList[i] = new Item("Toe warmers", 5);
                    break;
                case 'G':
                    itemList[i] = new Item("Binding adjustment", 10);
                    break;
                case 'H':
                    itemList[i] = new Item("Edge sharpening", 15);
                    break;
                case 'I':
                    itemList[i] = new Item("Ski wax", 12);
                    break;
                case 'J':
                    itemList[i] = new Item("Locker rental", 7);
                    break;
                default:
                    Utilities.quitProgram("Invalid item input");
                    break;         
                }
            System.out.println("You chose " + itemList[i].getName());
            System.out.println("\nHow badly do you need this item?");
            int priorityInput;
            do // repeats until user enters a valid int
            {
                System.out.println("Enter the priority for item " + (i + 1)
                        + "as a whole number");
                System.out.println("(Lowest priority indicates highest priority)");
                priorityInput = Utilities.inputInt();
            // inputInt() returns 0 if there is a problem with the input
            } while (priorityInput == 0);
            itemList[i].setPriority(priorityInput);
        }

        for (int i = 0; i < itemList.length; i++)
        {
            System.out.print("Item " + (i + 1) + ": ");
            System.out.println(itemList[i].getName());
            System.out.println("Priority: " + itemList[i].getPriority());
        }
    }
}