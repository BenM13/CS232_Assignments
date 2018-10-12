public class Item
{
    private String name;
    private double price;
    private int priority;

    public Item(String initName, double initPrice)
    {
        name = initName;
        price = initPrice;
        priority = 0;
    }

    private boolean nameEquals(Item differentItem)
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

    private boolean priorityEquals(Item differentItem)
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
    {
        boolean hasDuplicates = false; //
        for (int i = 0; i < currentLength; i++)
        {
            for (int k = i + 1; k < currentLength; k++)
            {
                if (currentList[i].isDuplicate(currentList[k])) {
                    System.out.println("ERROR: Items # " + (i + 1) + " and " + (k + 1));
                    System.out.println("have the same name and priority");
                    currentList[i].setName();
                    System.out.println("Please change the priority");
                    currentList[i].setPriority();
                    hasDuplicates = true;
                }
                else if (currentList[i].nameEquals(currentList[k])) {
                    System.out.println("ERROR: Items # " + (i + 1) + " and " + (k + 1));
                    System.out.println("have the same name.");
                    currentList[i].setName();
                    hasDuplicates = true;
                } else if (currentList[i].priorityEquals(currentList[k])) {
                    System.out.println("ERROR: Items # " + (i + 1) + " and " + (k + 1));
                    System.out.println("have the same priority.");
                    System.out.println("Please change the priority.");
                    currentList[i].setPriority();
                    hasDuplicates = true;
                }
            }
        }
        return hasDuplicates;        
    }

    public void setPriority()
    /*
    Prompts user for an integer. Checks input to make sure it's valid
    Updates the value of priority. 
    */
    {
        int priorityInput;
        do // repeats prompt until user enters a valid int
        {
            System.out.println("Enter the priority for this item"
                               + " as a whole number");
            System.out.println("(Lower number indicates higher priority)");
            priorityInput = Utilities.inputInt();
        // Utilities.inputInt() returns 0 if there is a problem with the input
        } while (priorityInput <= 0);
        priority = priorityInput;
    }

    public void setName()
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
        System.out.println("Please select a different item that " +
                           "has not been already been used.");
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
}