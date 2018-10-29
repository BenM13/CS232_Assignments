public class Item implements ForSale
{
    private String name;
    private double price;
    private int priority;
    private boolean purchased;

    public Item()
    {
        name = "n/a";
        price = 0;
        priority = 0;
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
        purchased = false; // default
    }

    public boolean nameEquals(Item differentItem)
    /*
    Test whether current item has the same name
    as the argument item. Returns true/false.
    */
    {
        boolean matches;
        if (name.equals(differentItem.name))
            matches = true;
        else
            matches = false;
        return matches;
    }

    public boolean priorityEquals(Item differentItem)
    /*
    tests whether current item has the same priority as
    the argument item. Returns true/false.
    */
    {
        boolean matches;
        if (priority == differentItem.priority)
            matches = true;
        else
            matches = false;
        return matches;
    }

    public boolean isDuplicate(Item differentItem)
    /*
    Test whether current item is identical to the argument item.
    For our purposes, two items are considered identical if both their
    name AND their prirority are the same. Returns true/flase.
    */
    {
        boolean matches;
        if ((name.equals(differentItem.name) && (priority == differentItem.priority)))
            matches = true;
        else
            matches = false;
        return matches;
    }

    public boolean checkArray(Item[] currentList, int currentLength)
    /*
    Loops through the list of Items that have been created so far.
    Checks for duplicates. If item i and item k have the same name or priority,
    user is prompted to change item k by calling either setName or setPriority. 
    Passes the item number (index + 1) to the set method. 
    Returns true if there were duplicate items, returns false otherwise. 
    */
    {
        boolean hasDuplicates = false; // assume no duplicates at first
        for (int i = 0; i < currentLength; i++)
        {
            for (int k = i + 1; k < currentLength; k++)
            {
                if (currentList[i].isDuplicate(currentList[k])) {
                    System.out.println("ERROR: Items #" + (i + 1) + " and #" + (k + 1));
                    System.out.println("have the same name and priority");
                    currentList[k].setName(k + 1);
                    System.out.println("Please change the priority");
                    currentList[k].setPriority(k + 1);
                    hasDuplicates = true;
                }
                else if (currentList[i].nameEquals(currentList[k])) {
                    System.out.println("ERROR: Items #" + (i + 1) + " and #" + (k + 1));
                    System.out.println("have the same name.");
                    currentList[k].setName(k + 1);
                    hasDuplicates = true;
                } else if (currentList[i].priorityEquals(currentList[k])) {
                    System.out.println("ERROR: Items #" + (i + 1) + " and #" + (k + 1));
                    System.out.println("have the same priority.");
                    System.out.println("Please change the priority.");
                    currentList[k].setPriority(k + 1);
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
        int priorityInput;
        do // repeats prompt until user enters a valid int
        {
            System.out.println("Enter the priority for item #" + itemNumber +
                            " as a whole number");
            System.out.println("(Lower number indicates higher priority)");
            priorityInput = Utilities.inputInt();
        // Utilities.inputInt() returns 0 if there is a problem with the input
        } while (priorityInput <= 0);
        priority = priorityInput;
    }

    public void setName(int itemNumber)
    /*
    Prompts user to choose a different item.
    This method is called if checkArray detects a duplicate.
    Uses a similar switch statement as seen in main. However, 
    for each case it simply modifies an existing Item object rather than 
    creating a new one. Calls the setPrice method and passes the corresponding
    price as a double. NOTE: The 'this.' is not needed. It just makes me feel 
    better having come from Python, ok?
    */
    {
        System.out.println("Please select a different option " +
                           "for item #" + itemNumber);
        System.out.println("Refer to the options menu at the top.");
        char choice;
        do // repeat prompt until user enters valid char
        {
            System.out.println("Enter a letter for a differnt item");
            choice = Utilities.inputChar();
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
                this.name = "Face mask";
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
}
