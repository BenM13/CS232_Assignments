public class ExpenseReport
{
    public static void main(String[] args)
    {
        Person benjy = new Person();

        System.out.println("Welcome to your weekly personal expense report.");
        System.out.println("To exit at anytime, type an exclamation mark (!),");
        System.out.println("then press ENTER.");
        System.out.println("Let's get started!");
        
        benjy.parseFirstName();
        benjy.parseLastName();

        System.out.println("My name is: " + benjy.getFirstName()
                            + " " + benjy.getLastName());

        benjy.inputExpenses();
    }
}