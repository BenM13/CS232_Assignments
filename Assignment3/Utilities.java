import java.util.Scanner;
import java.util.regex.Pattern;
import java.lang.NumberFormatException;
import java.lang.StringIndexOutOfBoundsException;

public class Utilities
{
    private static int newInt; // for use with checkInt and convertInt
    private static char newChar;
    private static final String PROMPT = "--> ";
    private static final String REGEX = "[A-J]";

    public static void quitProgram()
    /*
    Safely exits the program without an error message
    */
    {
        System.out.println("Now exiting...goodbye!");
        System.exit(0);
    }

    public static void quitProgram(String message)
    /*
    Safely exits the program and prints error message.
    Must pass a message as a string when calling this method.
    */
    {
        System.out.println("ERROR: " + message);
        System.out.println("Now exiting...please restart and try again.");
        System.exit(0);
    }

    public static char inputChar()
    /*
    Prompts user for a letter, takes input as a string
    Converts string to all uppercase. Tries to take character at
    position 0. If the index is out of bound (i.e. user types in nothing
    and hits ENTER anyways) returns an exclamation mark '!' char.
    Checks if char is in range A through J. Returns '!' char if not in range.
    */
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.print(PROMPT);
        String inputString = keyboard.nextLine().toUpperCase();
        try
        {
            newChar = inputString.charAt(0);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("ERROR: Invalid input.");
            return '!';
        }
        if (!(Pattern.matches(REGEX, inputString.substring(0, 1))))
        {
            System.out.println("ERROR: Must enter a letter A through J.");
            newChar = '!';
        }
        return newChar;
    }

    public static int inputInt()
    /*
    Prompts user for an integer. Takes input as a string.
    Tries to convert string to an int. Returns 0 if string can't
    be converted. Otherwise, returns the input as an int. 
    */
    {
        System.out.print(PROMPT);
        Scanner keyboard = new Scanner(System.in);
        String inputString = keyboard.nextLine();
        System.out.println();
        try
        {
            newInt = Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            System.out.println("ERROR: Must enter a whole number.");
            return 0;
        }
        return newInt;
    }
}