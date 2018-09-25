import java.lang.Math;

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
        benjy.inputTaxStatus();
    
        // get instance variables from Person
        benjy.inputExpenses();
        startingBalance = benjy.getStartingBalance();
        payRate = benjy.getPayRate();
        utilities = benjy.getUtilities();
        rent = benjy.getRent();
        hoursWorked = benjy.getHoursWorked();
        groceries = benjy.getGroceries();
        other = benjy.getOther();


        // put all the input variables into a list
        double[] allInputs = {startingBalance, payRate, utilities, rent, (double)hoursWorked,
                              groceries, other};
        
        // loop through list to find highest value
        double max = allInputs[0];
        for (int i = 1; i < allInputs.length; i++)
        {
            if (allInputs[i] > max)
            {
                max = allInputs[i];
            } else {
                continue;
            }
        }
        
        // loop through list to find lowest value
        double min = allInputs[0];
        for (int i = 1; i < allInputs.length; i++)
        {
            if (allInputs[i] < min)
            {
                min = allInputs[i];
            } else {
                continue;
            }
        }

        // loop through list to find total
        double total = 0;
        for (int i = 0; i < allInputs.length; i++)
        {
            total += allInputs[i];
        }

        int numInputs = allInputs.length;
        double avg = (startingBalance + payRate + utilities + rent + hoursWorked + groceries + other
                     / numInputs);

        
        // displays report
        System.out.println("Maximum: " + max);
        System.out.println("Minimum:" + min);

        System.out.print("\nWeekly Expense Report. OWNER: " + benjy.getFirstName() +
                            " " + benjy.getLastName());
        System.out.println("  TAX STATUS: " + benjy.getTaxStatus());
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("Input details:");
        System.out.println("NUMBER OF INPUTS |  HIGHEST NUMBER  |  LOWEST NUMBER   |      TOTAL       | AVERAGE NUMBER");
        System.out.println(numInputs + "                   " + max + "                 " + min + "                  " 
                            + total + "                " + Math.round(avg));
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("Expense breakdown");
        System.out.println("Starting Balance: $" + startingBalance);
        System.out.println("Total expenses: $" + (rent + utilities + groceries + other));
        System.out.println("Total revenue: $" + (payRate * hoursWorked));
        System.out.println("RESULTING BALANCE: $" +
                            ((startingBalance + (payRate * hoursWorked)) - (rent + utilities + groceries + other)));
    }
}