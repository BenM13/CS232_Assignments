import java.util.Scanner;
import java.util.ArrayList;

public class ShoppingTrip
{
    public static void main(String[] args)
    {
        final int NUM_ITEMS = 3; // Change to 7 before final submission!!
        // Item[] shoppingCart = new Item[NUM_ITEMS];
        ArrayList<Item> shoppingCart = new ArrayList<>(NUM_ITEMS);
        double balance = 59; // start with $59.00 to spend

        System.out.println("Welcome to the Mountain-side Ski Shop!");
        System.out.println("Check out our products/shop services listed below:");
        System.out.println("-----------------------");
        System.out.println("A) Used Ski Goggles: $24.99");
        System.out.println("B) Used Ski helmet: $34.95");
        System.out.println("C) Face Mask: $11.99");
        System.out.println("D) Ski gloves $19.98");
        System.out.println("E) Pack of hand warmers: $4.99");
        System.out.println("F) Pack of toe warmers: $4.99");
        System.out.println("G) Ski binding adjustment: $10.25");
        System.out.println("H) Ski edge sharpening: $14.97");
        System.out.println("I) Ski waxing: $10.99");
        System.out.println("J) Daily lock er rental: $6.89");
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
                    Gear goggles = new Gear("Used Goggles", 24.99, true);
                    // shoppingCart[i] = goggles;
                    shoppingCart.add(i, goggles);
                    break;
                case 'B':
                    Gear helmet = new Gear("Used Helmet", 34.95, true);
                    // shoppingCart[i] = helmet;
                    shoppingCart.add(i, helmet);
                    break;
                case 'C':
                    Gear mask = new Gear("FaceMask", 11.99, false);
                    // shoppingCart[i] = mask;
                    shoppingCart.add(i, mask);
                    break;
                case 'D':
                    Gear gloves = new Gear("Gloves", 19.98, false);
                    // shoppingCart[i] = gloves;
                    shoppingCart.add(i, gloves);
                    break;
                case 'E':
                    Gear handWarmers = new Gear("Hand warmers", 4.99, false);
                    // shoppingCart[i] = handWarmers;
                    shoppingCart.add(i, handWarmers);
                    break;
                case 'F':
                    Gear toeWarmers = new Gear("Toe warmers", 4.99, false);
                    // shoppingCart[i] = toeWarmers;
                    shoppingCart.add(i, toeWarmers);
                    break;
                case 'G':
                    ShopService adjustment = new ShopService("Binding adjustment", 10.25, 3);
                    // shoppingCart[i] = adjustment;
                    shoppingCart.add(i, adjustment);
                    break;
                case 'H':
                    ShopService sharpening = new ShopService("Edge sharpening", 14.97, 2);
                    // shoppingCart[i] = sharpening;
                    shoppingCart.add(i, sharpening);
                    break;
                case 'I':
                    ShopService wax = new ShopService("Ski waxing", 10.99, 1);
                    // shoppingCart[i] = wax;
                    shoppingCart.add(i, wax);
                    break;
                case 'J':
                    ShopService locker = new ShopService("Locker rental", 6.89, 1);
                    // shoppingCart[i] = locker;
                    shoppingCart.add(i, locker);
                    break;
                default:
                    Utilities.quitProgram("Invalid item input");
                    break;         
                }
            System.out.println("You chose " + shoppingCart.get(i).getName());
            System.out.println("\nHow badly do you need this item?");
            shoppingCart.get(i).setPriority(i + 1);
            while (shoppingCart.get(i).checkArray(shoppingCart, (i + 1))); 
            {
                shoppingCart.get(i).checkArray(shoppingCart, (i + 1));
            }
            System.out.print("Successfully added " + shoppingCart.get(i).getName() +
                               " with priority " + shoppingCart.get(i).getPriority());
            System.out.println(" to cart.");
        }

        // sort shopping cart array by priority
        Utilities.selectionSort(shoppingCart);

        for (int i = 0; i < shoppingCart.size(); i++)
        {
            // if (balance >= shoppingCart[i].getPrice())
            if (balance >= shoppingCart.get(i).getPrice())
            {
                balance -= shoppingCart.get(i).getPrice();
                // shoppingCart[i].setPurchased(true);
                shoppingCart.get(i).setPurchased(true);
            }
        }
        
        // print purchased items
        System.out.println("\nYour starting balance was $59.00");
        System.out.println("You purchased:");
        int counter = 1; // counter for display purposes;
        for (int i = 0; i < NUM_ITEMS; i++)
        {
            if (shoppingCart.get(i).getPurchased())
            {
                System.out.println(counter + ") " + shoppingCart.get(i).getName());
                System.out.print("\t@ ");
                Utilities.writeMoney(shoppingCart.get(i).getPrice());
                System.out.println();
                counter++;
            }
        }

        // print items not purchased
        System.out.println("\nYou did not have enough money for:");
        counter = 1; // reset counter
        for (int i = 0; i < NUM_ITEMS; i++)
        {
            if (!(shoppingCart.get(i).getPurchased()))
            {
                System.out.println(counter + ") " + shoppingCart.get(i).getName());
                System.out.print("\t@ ");
                Utilities.writeMoney(shoppingCart.get(i).getPrice());
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