import java.util.Scanner;

public class ShoppingTrip
{
    public static void main(String[] args)
    {
        final int NUM_ITEMS = 2;
        Item[] itemList = new Item[NUM_ITEMS];

        System.out.println("Welcome to the Mountain-side Ski Shop!");
        System.out.println("Check out our products/shop services listed below:");
        System.out.println("-----------------------");
        System.out.println("A) Ski Goggles: $24.99");
        System.out.println("B) Ski helmet: $34.95");
        System.out.println("C) Face Mask: $11.99");
        System.out.println("D) Ski gloves $19.98");
        System.out.println("E) Pack of hand warmers: $4.99");
        System.out.println("F) Pack of toe warmers: $4.99");
        System.out.println("G) Ski binding adjustment: $10.25");
        System.out.println("H) Ski edge sharpening: $14.97");
        System.out.println("I) Ski wax: $10.99");
        System.out.println("J) Daily locker rental: $6.89");
        
        System.out.println("Please enter a letter corersponding to the "
                           + "item you wish to purchase");
        // create item objects one by one
        for (int i = 0; i < itemList.length; i++)
        {
            char choice;
            do // repeat prompt until user enters valid char
            {
                System.out.println("\nEnter a letter for item " + (i + 1));
                choice = Utilities.inputChar();
            // inputchar() returns '!' if there is a problem with the input
            } while (choice == '!');
            switch (choice) {
                case 'A':
                    itemList[i] = new Item("Goggles", 24.99);
                    break;
                case 'B':
                    itemList[i] = new Item("Helmet", 34.95);
                    break;
                case 'C':
                    itemList[i] = new Item("Face mask", 11.99);
                    break;
                case 'D':
                    itemList[i] = new Item("Gloves", 19.98);
                    break;
                case 'E':
                    itemList[i] = new Item("Hand warmers", 4.99);
                    break;
                case 'F':
                    itemList[i] = new Item("Toe warmers", 4.99);
                    break;
                case 'G':
                    itemList[i] = new Item("Binding adjustment", 10.25);
                    break;
                case 'H':
                    itemList[i] = new Item("Edge sharpening", 14.97);
                    break;
                case 'I':
                    itemList[i] = new Item("Ski wax", 10.99);
                    break;
                case 'J':
                    itemList[i] = new Item("Locker rental", 6.89);
                    break;
                default:
                    Utilities.quitProgram("Invalid item input");
                    break;         
                }
            System.out.println("You chose " + itemList[i].getName());
            System.out.println("\nHow badly do you need this item?");
            itemList[i].setPriority();
            while (itemList[i].checkArray(itemList, (i + 1))); {
                checkArray(itemList, (i + 1));
            }
        }

        

        for (int i = 0; i < itemList.length; i++) // Test printing
        {
            System.out.print("Item " + (i + 1) + ": ");
            System.out.println(itemList[i].getName());
            System.out.println("Priority " + itemList[i].getPriority());
            System.out.println();
        }
    }
}