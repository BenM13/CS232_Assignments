public class ShopService extends Item implements ForSale
{
    // private int daysInShop // time in days service will take
    
    public ShopService()
    {
        super();
        // daysInShop = 0;
    }
    
    public ShopService(String initName, double initPrice)
    {
        super(initName, initPrice);
        //reOwned = isPreOwned;
    }
}