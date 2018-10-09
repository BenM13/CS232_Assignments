public class Item
{
    private String name;
    private double price;
    private int priority;

    public Item (String initName, double initPrice, int initPriority)
    {
        name = initName;
        price = initPrice;
        priority = initPriority;
    }

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