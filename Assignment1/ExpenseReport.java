public class ExpenseReport
{
    public static void main(String[] args)
    {
        Person benjy = new Person();
        benjy.parseFirstName();
        benjy.parseLastName();

        System.out.println("My name is: " + benjy.getFirstName()
                            + " " + benjy.getLastName());
    }
}