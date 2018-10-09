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

    public void setPriority(int newPriority)
    {
        priority = newPriority;
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