import java.util.Scanner;

public class ShoppingTrip
{
    public static void main(String[] args)
    {
        final int NUM_ITEMS = 7;
        Item[] shoppingCart = new Item[NUM_ITEMS];
        Item[] sortedCart = new Item[NUM_ITEMS];
        int[] priorityList = new int[NUM_ITEMS];
        double balance = 59; // start with $59.00 to spend

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
        System.out.println("-----------------------");
        System.out.println("Pick " + NUM_ITEMS + " things you want to get.");
        System.out.println("Please enter a letter corersponding to the "
                           + "item you wish to purchase");
        
        /*
        Create Item objects one by one. Prompts user to enter a letter. 
        Checks that letter is valid. If valid creates Item object with appropriate
        name and price variables according to switch statement. 
        */
        for (int i = 0; i < NUM_ITEMS; i++)
        {
            char choice;
            do // repeat prompt until user enters valid char
            {
                System.out.println("\nEnter a letter for item " + (i + 1));
                choice = Utilities.inputChar();
            // inputChar() returns '!' if there is a problem with the input
            } while (choice == '!');
            switch (choice) {
                case 'A':
                    shoppingCart[i] = new Item("Goggles", 24.99);
                    break;
                case 'B':
                    shoppingCart[i] = new Item("Helmet", 34.95);
                    break;
                case 'C':
                    shoppingCart[i] = new Item("Face mask", 11.99);
                    break;
                case 'D':
                    shoppingCart[i] = new Item("Gloves", 19.98);
                    break;
                case 'E':
                    shoppingCart[i] = new Item("Hand warmers", 4.99);
                    break;
                case 'F':
                    shoppingCart[i] = new Item("Toe warmers", 4.99);
                    break;
                case 'G':
                    shoppingCart[i] = new Item("Binding adjustment", 10.25);
                    break;
                case 'H':
                    shoppingCart[i] = new Item("Edge sharpening", 14.97);
                    break;
                case 'I':
                    shoppingCart[i] = new Item("Ski wax", 10.99);
                    break;
                case 'J':
                    shoppingCart[i] = new Item("Locker rental", 6.89);
                    break;
                default:
                    Utilities.quitProgram("Invalid item input");
                    break;         
                }
            System.out.println("You chose " + shoppingCart[i].getName());
            System.out.println("\nHow badly do you need this item?");
            shoppingCart[i].setPriority(i + 1);
            while (shoppingCart[i].checkArray(shoppingCart, (i + 1))); {
                shoppingCart[i].checkArray(shoppingCart, (i + 1));
            }
            System.out.print("Successfully added " + shoppingCart[i].getName() +
                               " with priority " + shoppingCart[i].getPriority());
            System.out.println(" to cart.");
        }

        // create priority array and sort the shopping cart
        priorityList = Utilities.sortPriority(shoppingCart);
        sortedCart = Utilities.sortShoppingCart(shoppingCart, priorityList);

        for (int i = 0; i < sortedCart.length; i++)
        {
            if (balance >= sortedCart[i].getPrice())
            {
                balance -= sortedCart[i].getPrice();
                sortedCart[i].setPurchased(true);
            }
        }
        
        // print purchased items
        System.out.println("\nYour starting balance was $59.00");
        System.out.println("You purchased:");
        int counter = 1; // counter for display purposes;
        for (int i = 0; i < NUM_ITEMS; i++)
        {
            if (sortedCart[i].getPurchased())
            {
                System.out.println(counter + ") " + sortedCart[i].getName());
                System.out.print("\t@ ");
                Utilities.writeMoney(sortedCart[i].getPrice());
                System.out.println();
                counter++;
            }
        }

        // print items not purchased
        System.out.println("\nYou did not have enough money for:");
        counter = 1; // reset counter
        for (int i = 0; i < NUM_ITEMS; i++)
        {
            if (!(sortedCart[i].getPurchased()))
            {
                System.out.println(counter + ") " + sortedCart[i].getName());
                System.out.print("\t@ ");
                Utilities.writeMoney(sortedCart[i].getPrice());
                System.out.println();
                counter++;
            }
        }

        // print leftover balance
        System.out.print("\nYour remaining balance is ");
        Utilities.writeMoney(balance);
        System.out.println("\n");
    }
}