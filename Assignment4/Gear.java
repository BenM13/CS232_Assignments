/**
This is a class for physical, tangible items.
The Gear class adds an additional instance variable, preOwned,
which is set to true if the item is in used condition and false
if the item is in new condition. The default value is false.
In this "shop" we assume that all items are new unless otherwise
noted. 
*/

public class Gear extends Item implements ForSale
{
    private boolean preOwned; // True if gear is used, false if new condition
    
    public Gear()
    {
        super();
        preOwned = false; // default value
    }

    public Gear(String initName, double initPrice)
    {
        super(initName, initPrice);
        preOwned = false; // default value
    }

    public Gear(String initName, double initPrice, boolean isUsed)
    {
        super(initName, initPrice);
        preOwned = isUsed;
    }

    public boolean nameEquals(Item differentItem)
    {
        return this.getName().equals(differentItem.getName());
    }

    public boolean priorityEquals(Item differentItem)
    {
        return this.getPriority() == differentItem.getPriority();
    }

    public boolean isDuplicate(Item differentItem)
    {
        return ((this.getName().equals(differentItem.getName())) &&
                (this.getPriority() == differentItem.getPriority()));
    }

    public void setPreOwned(boolean isUsed)
    {
        preOwned = isUsed;
    }

    public boolean getPreOwned()
    {
        return preOwned;
    }
}