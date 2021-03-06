import java.util.ArrayList;

public class ShoppingTrip
{
    public static void main(String[] args)
    {
        final int NUM_ITEMS = 7;
        ArrayList<Item> shoppingCart = new ArrayList<>(NUM_ITEMS);
        IO_Manager io = new IO_Manager();
        String name;
        double budget;    
    
        io.printLine("Welcome to the Mountain-side Ski Shop!");
        io.printLine("Type your first name without spaces or special characters");
        io.printLine("To exit, type \"--exit\" into the console");
        do 
        {
            name = io.inputName();   
        // io.inputName returns "!" if there's a problem with the input
        } while (name.equalsIgnoreCase("!"));

        io.printLine("How much money would you like to spend today?");
        io.printLine("Enter a positive whole number greater than 0.");
        do
        {
            budget = (double)io.inputInt();
        } while (budget <= 0);
        double balance = budget;

        io.printLine("Check out our products/shop services listed below:");
        io.printLine("-----------------------");
        io.printLine("A) Used Ski Goggles: $24.99");
        io.printLine("B) Used Ski helmet: $34.95");
        io.printLine("C) Face Mask: $11.99");
        io.printLine("D) Ski gloves $19.98");
        io.printLine("E) Pack of hand warmers: $4.99");
        io.printLine("F) Pack of toe warmers: $4.99");
        io.printLine("G) Ski binding adjustment: $10.25");
        io.printLine("H) Ski edge sharpening: $14.97");
        io.printLine("I) Ski waxing: $10.99");
        io.printLine("J) Daily lock er rental: $6.89");
        io.printLine("-----------------------");
        io.printLine("Pick " + NUM_ITEMS + " things you want to get.");
        io.printLine("Please enter a letter corersponding to the "
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
                io.printLine("\nEnter a letter for item " + (i + 1));
                choice = io.inputChar();
            // inputChar() returns '!' if there is a problem with the input
            } while (choice == '!');
            switch (choice) {
                case 'A':
                    Gear goggles = new Gear("Used Goggles", 24.99, true);
                    shoppingCart.add(i, goggles);
                    break;
                case 'B':
                    Gear helmet = new Gear("Used Helmet", 34.95, true);
                    shoppingCart.add(i, helmet);
                    break;
                case 'C':
                    Gear mask = new Gear("Face Mask", 11.99, false);
                    shoppingCart.add(i, mask);
                    break;
                case 'D':
                    Gear gloves = new Gear("Gloves", 19.98, false);
                    shoppingCart.add(i, gloves);
                    break;
                case 'E':
                    Gear handWarmers = new Gear("Hand warmers", 4.99, false);
                    shoppingCart.add(i, handWarmers);
                    break;
                case 'F':
                    Gear toeWarmers = new Gear("Toe warmers", 4.99, false);
                    shoppingCart.add(i, toeWarmers);
                    break;
                case 'G':
                    ShopService adjustment = new ShopService("Binding adjustment", 10.25, 3);
                    shoppingCart.add(i, adjustment);
                    break;
                case 'H':
                    ShopService sharpening = new ShopService("Edge sharpening", 14.97, 2);
                    shoppingCart.add(i, sharpening);
                    break;
                case 'I':
                    ShopService wax = new ShopService("Ski waxing", 10.99, 1);
                    shoppingCart.add(i, wax);
                    break;
                case 'J':
                    ShopService locker = new ShopService("Locker rental", 6.89, 1);
                    shoppingCart.add(i, locker);
                    break;
                default:
                    Utilities.quitProgram("Invalid item input");
                    break;         
                }
            io.printLine("You chose " + shoppingCart.get(i).getName());
            io.printLine("\nHow many would like to purchase?");
            shoppingCart.get(i).setQuantity(i + 1);
            io.printLine("\nHow badly do you need this item?");
            shoppingCart.get(i).setPriority(i + 1);
            while (shoppingCart.get(i).checkArray(shoppingCart, (i + 1))) 
            {
                shoppingCart.get(i).checkArray(shoppingCart, (i + 1));
            }
            io.printSingle("Successfully added " + shoppingCart.get(i).getName() +
                               " with priority " + shoppingCart.get(i).getPriority());
            io.printLine(" to cart.");
        }

        // sort shopping cart array by priority
        Utilities.selectionSort(shoppingCart);

        for (int i = 0; i < shoppingCart.size(); i++)
        // loop through items and buy them!
        {
            Item currentItem = shoppingCart.get(i);
            int currentQuantity = currentItem.getQuantity();
            if (balance >= (currentItem.getPrice() * currentQuantity))
            {
                balance -= (currentItem.getPrice() * currentQuantity);
                currentItem.setPurchased(true);
                currentItem.setNumBought(currentQuantity);
            }
        }
        
        // print purchased items
        io.printLine("\nOkay " + name + ", it's time to checkout.");
        io.printSingle("Your starting balance was ");
        Utilities.writeMoney(budget);
        io.printLine();
        io.printLine("You purchased:");
        int counter = 1; // counter for display purposes;
        for (int i = 0; i < NUM_ITEMS; i++)
        {
            Item currentItem = shoppingCart.get(i);
            if (currentItem.getPurchased())
            {
                io.printLine(counter + ") " + currentItem.getName());
                io.printSingle("\t" + currentItem.getQuantity() + " @ ");
                Utilities.writeMoney(currentItem.getPrice());
                io.printLine();
                counter++;
            }
        }

        // print items not purchased
        io.printLine("\nYou did not have enough money for:");
        counter = 1; // reset counter
        for (int i = 0; i < NUM_ITEMS; i++)
        {
            Item currentItem = shoppingCart.get(i);
            if (!currentItem.getPurchased())
            {
                io.printLine(counter + ") " + currentItem.getName());
                io.printSingle("\t" + currentItem.getQuantity() + " @ ");
                Utilities.writeMoney(currentItem.getPrice());
                io.printLine();
                counter++;
            }
        }

        // print leftover balance
        io.printSingle("\nYour remaining balance is ");
        Utilities.writeMoney(balance);
        System.out.println("\n");

        io.writeReceipt(shoppingCart, budget, balance);
    }
}