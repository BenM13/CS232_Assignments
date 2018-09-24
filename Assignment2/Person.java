import java.util.Scanner;
import java.util.regex.Pattern;

public class Person
{
    private final String PROMPT = "--> "; // to make console easier to read
    private final String EXIT = "!"; // stop condition
    private final String REGEX = "^[a-zA-Z]+$"; // pattern for regular expression
    private String firstName, lastName;
    private double startingBalance, payRate, utilities, rent, groceries, other;
    private int hoursWorked, taxStatus;


    private void quitProgram()
    /*
    This method is called whenever the user enters the
    stop condition (!) and will exit the program
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
        Scanner keyboard = new Scanner(System.in);
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
        Scanner keyboard = new Scanner(System.in);
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

    public void inputExpenses()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Now, let's get some more info");
        System.out.println("How much money did you have in your account" +
                           "\nat the start of the week? (Negatives are allowed)");
        String startBalanceInput = keyboard.next();
        startingBalance = 
        System.out.println(startBalanceInput);
        
        
    }
    
    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }
}