public interface ForSale
{
    public boolean nameEquals(Item differentItem);

    public boolean priorityEquals(Item differentItem);

    public boolean isDuplicate(Item differentItem);

    public boolean checkArray(Item[] currentList, int currentLength);

    public void setPriority(int itemNumber);

    public void setName(int itemNumber);

    public void setPrice(double newPrice);

    public void setPurchased(boolean bought);

    public String getName();

    public double getPrice();

    public int getPriority();

    public boolean getPurchased();
}