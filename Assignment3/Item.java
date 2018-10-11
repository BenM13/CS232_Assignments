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

    public boolean isDuplicate(Item differentItem)
    /*
    Test whether current item has the same attributes as another item
    For the purpose depuplicating, items are considered equal if EITHER
    their name OR priority are the same. Returns true/false.
    */
    {
        boolean matches;
        if ((name.equals(differentItem.name) || (priority == differentItem.priority)))
            matches = true;
        else
            matches = false;
        return matches;
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
            System.out.println("Enter the priority for your " + name
                               + " as a whole number");
            System.out.println("(Lowest priority indicates highest priority)");
            priorityInput = Utilities.inputInt();
        // Utilities.inputInt() returns 0 if there is a problem with the input
        } while (priorityInput == 0);
        priority = priorityInput;
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