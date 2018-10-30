public class Gear extends Item implements ForSale
{
    private boolean preOwned; // True if gear is used, false if new condition
    
    public Gear()
    {
        super();
        preOwned = false; // In this store, items are new unless otherwise noted
    }

    public Gear(String initName, double initPrice)
    {
        super(initName, initPrice);
        preOwned = false;
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