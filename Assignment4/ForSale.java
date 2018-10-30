public interface ForSale
{
    public boolean nameEquals(Item differentItem);
    /*
    Test whether current item has the same name
    as the argument item. Returns true/false.
    */

    public boolean priorityEquals(Item differentItem);
    /*
    tests whether current item has the same priority as
    the argument item. Returns true/false.
    */

    public boolean isDuplicate(Item differentItem);
    /*
    Test whether current item is identical to the argument item.
    For our purposes, two items are considered identical if both their
    name AND their prirority are the same. Returns true/flase.
    */

    public boolean checkArray(Item[] currentList, int currentLength);
    /*
    Loops through the list of Items that have been created so far.
    Checks for duplicates. If item i and item k have the same name or priority,
    user is prompted to change item k by calling either setName or setPriority. 
    Passes the item number (index + 1) to the set method. 
    Returns true if there were duplicate items, returns false otherwise. 
    */

    // all accessors and mutators below:
    public void setPriority(int itemNumber);

    public void setName(int itemNumber);

    public void setPrice(double newPrice);

    public void setPurchased(boolean bought);

    public String getName();

    public double getPrice();

    public int getPriority();

    public boolean getPurchased();
}