import java.util.Scanner;
import java.util.regex.Pattern;
import java.lang.NumberFormatException;
import java.lang.StringIndexOutOfBoundsException;

public class IO_Manager implements Printable
{
    private char newChar;
    private int newInt;
    private static final String PROMPT = "--> ";
    private static final String REGEX_CHOICE = "[A-J]"; // pattern for choosing items
    private static final String REGEX_NAME = "^[a-zA-Z]+$"; // pattern for name input

    public void printLine()
    /**
    Skips to the next line
    */
    {
        System.out.println();
    }
    
    public void printLine(String output)
    /**
    Prints a String and advances to the next line 
    */
    {
        System.out.println(output);
    }

    public void printSingle(String output)
    /**
    Prints a String, does not advance to the next line
    */
    {
        System.out.print(output);
    }

    public void printSingle(int output)
    /*
    Prints an int, does not advance to the next line
    */
    {
        System.out.print(output);
    }

    public void printSingle(double output)
    /**
    Prints a double, does not advance to the next line
    */
    {
        System.out.println(output);
    }

    public void checkForExit(String input)
    /**
    Checks for the exit conition "--exit".
    Quits program if input matches conidition
    */
    {
        if (input.equalsIgnoreCase("--exit"))
        {
            Utilities.quitProgram();
        }
    }

    public char inputChar()
    /*
    Prompts user for a letter, takes input as a string
    Converts string to all uppercase. Tries to take character at
    position 0. If the index is out of bound (i.e. user types in nothing
    and hits ENTER anyways) returns an exclamation mark '!' char.
    Checks if char is in range A through J. Returns '!' char if not in range.
    */
    {
        Scanner keyboard = new Scanner(System.in);
        printSingle(PROMPT);
        String inputString = keyboard.nextLine().toUpperCase();
        Utilities.checkForExit(inputString);
        try
        {
            newChar = inputString.charAt(0);
            if (!Pattern.matches(REGEX_CHOICE, inputString.substring(0, 1)))
            {
                throw new BadInputException("ERROR: Must enter a letter A through J.");
            }
            return newChar;
        } catch (StringIndexOutOfBoundsException e) {
            printLine("ERROR: Invalid input.");
            return '!';
        } catch (BadInputException e) {
            printLine(e.getMessage());
            return '!';
        }
    }
}