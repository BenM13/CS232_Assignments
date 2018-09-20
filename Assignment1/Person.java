import java.util.Scanner;
import java.util.regex.Pattern;

public class Person
{
    private final String PROMPT = "--> "; // to make console easier to read
    private final String REGEX = "^[a-zA-Z]+$"; // pattern for regular expression
    private String firstName, lastName;
    private double startingBalance, payRate, utilities, rent, groceries, other;
    private int hoursWorked, taxStatus;

    public void parseFirstName()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("\nEnter your first name with no spaces, numbers,");
        System.out.println("or special characters:");
        System.out.print(PROMPT);
        String firstNameInput = keyboard.nextLine();
        // regular expression to check if string is valid (i.e. no specials)
        if (Pattern.matches(REGEX, firstNameInput))
        {
            firstName = firstNameInput;
        } else {
            System.out.println("ERROR: Invalid character(s)");
            System.out.println("Name cannot contain spaces, number, " +
                               "or special characters");
            parseFirstName();
        }
    }

    public void parseLastName()
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
        nextLetter = keyboard.next().substring(0, 1); // only takes first letter of input
        while (!(nextLetter.equals(".")))
        {
            if (Pattern.matches(REGEX, nextLetter))
            {
                nameSoFar = nameSoFar + nextLetter;
                System.out.print(PROMPT);
                nextLetter = keyboard.next().substring(0, 1);
            } else {
                System.out.println("ERROR: Invalid character(s)");
                System.out.println("Name cannot contain spaces, number, " +
                                   "or special characters");
                parseLastName();
            }
        }
        lastName = nameSoFar;
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