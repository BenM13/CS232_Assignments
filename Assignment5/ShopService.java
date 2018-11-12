public class ShopService extends Item implements ForSale
{
    private int daysInShop; // time in days the service will take
    
    public ShopService()
    {
        super();
        daysInShop = 0; // default value
    }
    
    public ShopService(String initName, double initPrice)
    {
        super(initName, initPrice);
        daysInShop = 0;
    }

    public ShopService(String initName, double initPrice, int initDays)
    {
        super(initName, initPrice);
        daysInShop = initDays;
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

    public void setDaysInShop(int newDays)
    {
        daysInShop = newDays;
    }

    public int getDaysInShop()
    {
        return daysInShop;
    }
}