public class Gear extends Item implements ForSale
{
    // private boolean preOwned; // True if gear is used, false if new condition
    
    public Gear()
    {
        super();
        // preOwned = null;
    }

    public Gear(String initName, double initPrice)
    {
        super(initName, initPrice);
        //reOwned = isPreOwned;
    }
}