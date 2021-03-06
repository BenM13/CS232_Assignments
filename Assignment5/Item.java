import java.util.ArrayList; 

public abstract class Item implements ForSale
{
    private String name;
    private double price;
    private int priority;
    private int quantity;
    private int numBought;
    private boolean purchased;

    public Item()
    {
        name = "n/a";
        price = 0;
        priority = 0;
        quantity = 0;
        numBought = 0;
        purchased = false;
    }

    public Item(String initName, double initPrice)
    /*
    Class constructor. Variables priority and purchased each have
    a default value and will be modified later with their respective
    set methods. 
    */
    {
        name = initName;
        price = initPrice;
        priority = 0; // default. Will be changed later
        quantity = 0;
        numBought = 0;
        purchased = false; // default
    }

    public abstract boolean nameEquals(Item differentItem);
    
    public abstract boolean priorityEquals(Item differentItem);
    
    public abstract boolean isDuplicate(Item differentItem);
    
    public boolean checkArray(ArrayList<Item> currentList, int currentLength)
    /*
    Loops through the list of Items that have been created so far.
    Checks for duplicates. If item i and item k have the same name or priority,
    user is prompted to change item k by calling either setName or setPriority. 
    Passes the item number (index + 1) to the set method. 
    Returns true if there were duplicate items, returns false otherwise. 
    */
    {
        IO_Manager io = new IO_Manager();
        boolean hasDuplicates = false; // assume no duplicates at first
        for (int i = 0; i < currentLength; i++)
        {
            for (int k = i + 1; k < currentLength; k++)
            {
                if (currentList.get(i).nameEquals(currentList.get(k))) 
                {
                    io.printLine("ERROR: Items #" + (i + 1) + " and #" + (k + 1));
                    io.printLine("have the same name.");
                    currentList.get(k).setName(k + 1);
                    hasDuplicates = true;
                }
            }
        }
        return hasDuplicates;        
    }

    public void setPriority(int itemNumber)
    /*
    Takes item number as an argument. This will be used to show which item
    the user needs to change. itemNumber will always equal index + 1.
    Prompts user for an integer. Checks input to make sure it's valid
    Updates the value of priority. 
    */
    {
        IO_Manager io = new IO_Manager();
        int priorityInput;
        do // repeats prompt until user enters a valid int
        {
            io.printLine("Enter the priority for item #" + itemNumber +
                            " as a whole number");
            io.printLine("(Lower number indicates higher priority)");
            priorityInput = io.inputInt();
        // Utilities.inputInt() returns 0 if there is a problem with the input
        } while (priorityInput <= 0);
        priority = priorityInput;
    }

    public void setQuantity(int itemNumber)
    {
        IO_Manager io = new IO_Manager();
        int quantityInput;
        do // repeats prompt until user enters a valid int
        {
            io.printSingle("Enter a quantity greater than 0 ");
            io.printLine("for item # " + itemNumber);
            quantityInput = io.inputInt();
        } while (quantityInput <= 0);
        quantity = quantityInput;
    }

    public void setName(int itemNumber)
    /**
    Prompts user to choose a different item.
    This method is called if checkArray detects a duplicate.
    Uses a similar switch statement as seen in main. However, 
    for each case it simply modifies an existing Item object rather than 
    creating a new one. Calls the setPrice method and passes the corresponding
    price as a double. NOTE: The 'this.' is not needed. It just makes me feel 
    better having come from Python, ok?
    */
    {
        IO_Manager io = new IO_Manager();
        io.printLine("Please select a different option " +
                           "for item #" + itemNumber);
        io.printLine("Refer to the options menu at the top.");
        char choice;
        do // repeat prompt until user enters valid char
        {
            io.printLine("Enter a letter for a differnt item");
            choice = io.inputChar();
            // inputchar() returns '!' if there is a problem with the input
        } while (choice == '!');
        switch (choice) {
            case 'A':
                this.name = "Goggles";
                this.setPrice(25.99);
                break;
            case 'B':
                this.name = "Helmet";
                this.setPrice(34.95);
                break;
            case 'C':
                this.name = "Face Mask";
                this.setPrice(11.99);
                break;
            case 'D':
                this.name = "Gloves";
                this.setPrice(19.98);
                break;
            case 'E':
                this.name = "Hand warmers";
                this.setPrice(4.99);
                break;
            case 'F':
                this.name = "Toe warmers";
                this.setPrice(4.99);
                break;
            case 'G':
                this.name = "Binding adjustment";
                this.setPrice(10.25);
                break;
            case 'H':
                this.name = "Edge sharpening";
                this.setPrice(14.97);
                break;
            case 'I':
                this.name = "Ski wax";
                this.setPrice(10.99);
                break;
            case 'J':
                this.name = "Locker rental";
                this.setPrice(6.89);
                break;
            default:
                Utilities.quitProgram("Invalid item input");
                break;         
        }
    }
    
    public void setPrice(double newPrice)
    /*
    Updates the price of the current Item object
    */
    {
        price = newPrice;
    }

    public void setPurchased(boolean bought)
    /*
    Updates the purchased status of an item
    */
    {
        purchased = bought;
    }

    public void setNumBought(int numPurchased)
    {
        numBought = numPurchased;
    }

    // All access methods listed below
    public String getName()
    {
        return name;
    }

    public double getPrice()
    {
        return price;
    }

    public int getPriority()
    {
        return priority;
    }

    public boolean getPurchased()
    {
        return purchased;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public int getNumBought()
    {
        return numBought;
    }
}