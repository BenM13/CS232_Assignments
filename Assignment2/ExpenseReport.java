public class ExpenseReport
{
    public static void main(String[] args)
    {
        double startingBalance, payRate, utilities, rent, groceries, other;
        int hoursWorked;
        Person benjy = new Person();

        System.out.println("Welcome to your weekly personal expense report.");
        System.out.println("To exit at anytime, type an exclamation mark (!),");
        System.out.println("then press ENTER.");
        System.out.println("Let's get started!");
        
        benjy.parseFirstName();
        benjy.parseLastName();
    
        benjy.inputExpenses();
        startingBalance = benjy.getStartingBalance();
        payRate = benjy.getPayRate();
        utilities = benjy.getUtilities();
        rent = benjy.getRent();
        hoursWorked = benjy.getHoursWorked();
        groceries = benjy.getGroceries();
        other = benjy.getOther();



        //System.out.println("My name is: " + benjy.getFirstName()
        //                    + " " + benjy.getLastName());

    }
}