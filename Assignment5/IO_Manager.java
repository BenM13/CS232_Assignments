import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.lang.NumberFormatException;
import java.lang.StringIndexOutOfBoundsException;

/**
Class to manage all user input and
all output to the console
*/
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

    public int inputInt()
    /*
    Prompts user for an integer. Takes input as a string.
    Tries to convert string to an int. Returns 0 if string can't
    be converted. Otherwise, returns the input as an int. 
    */
    {
        printSingle(PROMPT);
        Scanner keyboard = new Scanner(System.in);
        String inputString = keyboard.nextLine();
        Utilities.checkForExit(inputString);
        printLine();
        try
        {
            newInt = Integer.parseInt(inputString);
            if (newInt <= 0)
            {
                throw new BadInputException("ERROR: Must enter a positive whole number");
            }
            return newInt;
        } catch (NumberFormatException e) {
            printLine("ERROR: Input must be a whole number.");
            return 0;
        } catch (BadInputException e) {
            printLine(e.getMessage());
            return 0;
        }
    }

    public String inputName()
    /**
    Prompts user for first name. Takes input as string.
    First checks for exit condition. Tries to match input with
    regex patter (no specials allowed). Throws BadInputException
    if pattern does not match. Returns the string. 
    */
    {
        printSingle(PROMPT);
        Scanner keyboard = new Scanner(System.in);
        String inputString = keyboard.nextLine();
        Utilities.checkForExit(inputString);
        try
        {
            if (!Pattern.matches(REGEX_NAME, inputString))
            {
                throw new BadInputException("ERROR: No spaces or special characters");
            }
            return inputString;
        } catch (BadInputException e) {
            printLine(e.getMessage());
            return "!";
        }
    }

    public void writePurchased(ArrayList<Item> cart, double money)
    {
        String filename = "receipt.txt";
        PrintWriter outputStream = null;
        try
        {
            outputStream = new PrintWriter(filename);
        } catch (FileNotFoundException e) {
            Utilities.quitProgram(e.getMessage());
        }
        
        int counter = 1;
        outputStream.print("Your starting balance was ");
        writeMoneyToFile(money, outputStream);
        outputStream.println("\n");
        outputStream.println("You purchased:");
        for (int i = 0; i < cart.size(); i++)
        {
            Item currentItem = cart.get(i);
            if (currentItem.getPurchased())
            {
                outputStream.println(counter + ") " + currentItem.getName());
                outputStream.print("\t" + currentItem.getQuantity() + " @ ");
                writeMoneyToFile(currentItem.getPrice(), outputStream);
                outputStream.println();
                counter++;
            }
        }
        outputStream.close();
    }

    private static void writePositiveToFile(double amount, PrintWriter currentFile)
    /*
    NOTE: This method is from Listing 6.14 in Chapter 6 
    of the Walter Savitch Java textbook.
    Precondition: amount >= 0
    Displays amonut in dollars and cents notation.
    Rounds after two decinal places.
    Omits the dollar sign.
    */
    {
        int allCents = (int)(Math.round(amount * 100));
        int dollars = allCents / 100;
        int cents = allCents % 100;

        currentFile.print(dollars);
        currentFile.print('.');

        if (cents < 10)
            currentFile.print('0');
        currentFile.print(cents);
    }

    public static void writeMoneyToFile(double amount, PrintWriter currentFile)
    /*
    NOTE: This method is from Listing 6.14 in Chapter 6
    of the Walter Savitch Java textbook. 
    Displays amount in dollars and cents notation i.e. $##.##
    Rounds after two decimal places.
    Does not advance to the next line after input.
    */
    {
        if (amount >= 0)
        {
            currentFile.print('$');
            writePositiveToFile(amount, currentFile);
        } else {
            double positiveAmount = amount * - 1;
            currentFile.print('$');
            currentFile.print('-');
            writePositiveToFile(positiveAmount, currentFile);
        }
    }
}