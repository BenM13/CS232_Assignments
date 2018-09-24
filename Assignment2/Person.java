import java.util.Scanner;
import java.util.regex.Pattern;
import java.lang.NumberFormatException;

public class Person
{
    private final String PROMPT = "--> "; // to make console easier to read
    private final String EXIT = "!"; // stop condition
    private final String REGEX = "^[a-zA-Z]+$"; // pattern for regular expression
    private String firstName, lastName, taxStatus;
    private double startingBalance, payRate, utilities, rent, groceries, other;
    private int hoursWorked;
    
    Scanner keyboard = new Scanner(System.in);

    private void quitProgram()
    /*
    This method is called whenever the user enters the
    stop condition (!) or if number inputs are bad 
    and will exit the program. 
    */
    {
        System.out.println("Now exiting. Come back soon!");
        System.exit(0);
    }
    
    public void parseFirstName()
    /*
    Takes no arguments. Inputs user's first name as a string. First checks for 
    stop value. Checks Regex pattern to parse out special characters. Updates 
    firstName if valid, otherwise the method restarts. 
    */
    {
        System.out.print("\nEnter your first name with no spaces, numbers,");
        System.out.println("or special characters:");
        System.out.print(PROMPT);
        String firstNameInput = keyboard.nextLine();
        if (firstNameInput.equals(EXIT))
        {
            quitProgram();
        } else if (Pattern.matches(REGEX, firstNameInput)) {
            firstName = firstNameInput;
        } else {
            System.out.println("ERROR: Invalid character(s)");
            System.out.println("Name cannot contain spaces, number, " +
                               "or special characters");
            parseFirstName();
        }
    }

    public void parseLastName()
    /*
    Takes no arguments. Inputs user's last name one character at
    a time. For each line of input, only the first letter is saved as string.
    First checks for stop condition. Checks Regex for invalid characters.
    If valid, adds letter to the end of nameSoFar. Otherwise the method restarts
    */
    {
        String nextLetter;
        String nameSoFar = "";
        System.out.println("\nEnter your last name one letter at a time.");
        System.out.println("Type a letter then hit ENTER.");
        System.out.println("Special Characters and numbers will not be accepted.");
        System.out.println("When you're done, " +
                           "type a period (.) followed by ENTER");
        System.out.print(PROMPT);
        nextLetter = keyboard.nextLine().substring(0, 1); // only takes first letter of input
        while (!(nextLetter.equals(".")))
        {
            if (nextLetter.equals(EXIT))
            {
                quitProgram();
            } else if (Pattern.matches(REGEX, nextLetter)) {
                nameSoFar += nextLetter;
                System.out.print(PROMPT);
                nextLetter = keyboard.nextLine().substring(0, 1);
            } else {
                System.out.println("ERROR: Invalid character(s)");
                System.out.println("Name cannot contain spaces, number, " +
                                   "or special characters");
                parseLastName();
            }
        }
        lastName = nameSoFar;
    }

    private double checkDouble(String input)
    /*
    Takes a string as an arguments. Returns a double.
    Whenever the user enters a double, this method is called.
    It takes user's input as a string. First checks for stop condition.
    Then tries to convert the string to a double. If it can be converted,
    method returns the input as a double. If it cannot be converted, 
    error is caught and quitProgram is called. 
    */
    {
        if (input.equals(EXIT))
        {
            quitProgram();
        } else {
            try
            {
                // x is a throw-away variable for try block
                double x = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("FATAL ERROR: Invalid input");
                System.out.println("Input must be a decimal number.");
                System.out.println("Restart program and try agian.");
                quitProgram();
            }
        }
        return Double.parseDouble(input);
    }

    private int checkInt(String input)
    /*
    Takes a string as an argument. Returns an int. Whenever
    the user enters an int, this method is called. It takes the user's
    input as a string. First checks for the stop condition. then tries 
    to convert the string to a double. If it can be converted, method 
    returns the input as an int. Otherwise an error message is displayed
    and quitProgram() is called. 
    */
    {
        if (input.equals(EXIT))
        {
            quitProgram();
        } else {
            try
            {
                // x is a throw-away variable for try block
                int x = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("FATAL ERROR: Invalid input.");
                System.out.println("Input must be a decimal number.");
                System.out.println("Restart program and try again.");
                quitProgram();
            }
        }
        return Integer.parseInt(input);
    }

    public void inputExpenses()
    {
        System.out.println("\nHow much money did you have in your account");
        System.out.println("at the start of the week?");
        System.out.println("(IMPORTANT: must enter a number with or without a decimal)");
        System.out.print(PROMPT);
        startingBalance = checkDouble(keyboard.next());
        
        System.out.println("\nNow, for your expenses:");
        System.out.println("How much did you spend on utilities this week?");
        System.out.println("(Gas, cable, internet, etc.)");
        System.out.print(PROMPT);
        utilities = checkDouble(keyboard.next());

        System.out.println("\nHow much is your weekly rent?");
        System.out.print(PROMPT);
        rent = checkDouble(keyboard.next());

        System.out.println("\nHow much did you spend on groceries this week?");
        System.out.print(PROMPT);
        groceries = checkDouble(keyboard.next());

        System.out.println("\nAny other expenses? (Restaurants? Entertainment? etc.");
        System.out.println("Just enter '0' if you have no additional expenses.");
        System.out.print(PROMPT);
        other = checkDouble(keyboard.next());

        System.out.println("\nOk, now let's get your revenue:");
        System.out.println("How much do you make an hour?");
        System.out.print(PROMPT);
        payRate = checkDouble(keyboard.next());

       
        System.out.println("\nHow many hours did your work this week?");
        System.out.println("(This number must be an integer, no decimals allowed.)");
        System.out.print(PROMPT);
        hoursWorked = checkInt(keyboard.next());
    }

    public void inputTaxStatus()
    {
        System.out.println("\nEnter your tax status based on the guide below");
        System.out.println("Dependent: 1");
        System.out.println("Single: 2");
        System.out.println("Married: 3");
        System.out.println("Must enter either 1, 2, or 3.");
        int taxStatusInput = keyboard.nextInt(); 
        switch (taxStatusInput)
        {
            case 1:
                taxStatus = "Dependent";
                break;
            case 2:
                taxStatus = "Single";
                break;
            case 3:
                taxStatus = "Married";
                break;
            default:
                System.out.println("ERROR: Invalid input.");
                System.out.println("Must enter either 1, 2, or 3.");
                inputTaxStatus();
                break;
        }
    }
    
    /*
    All the access methods are listed below
    These will be used to build the report in the
    main method
    */
    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getTaxStatus()
    {
        return taxStatus;
    }

    public double getStartingBalance()
    {
        return startingBalance;
    }

    public double getUtilities()
    {
        return utilities;
    }

    public double getRent()
    {
        return rent;
    }

    public double getOther()
    {
        return other;
    }

    public double getGroceries()
    {
        return groceries;
    }

    public int getHoursWorked()
    {
        return hoursWorked;
    }

    public double getPayRate()
    {
        return payRate;
    }


}