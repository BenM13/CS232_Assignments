import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.Arrays;
import java.lang.NumberFormatException;
import java.lang.StringIndexOutOfBoundsException;

public class Utilities
{
    private static int newInt; // for use with inputInt()
    private static char newChar; // for use with inputChar()
    private static final String PROMPT = "--> ";
    private static final String REGEX = "[A-J]"; // pattern for regular expression. 

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
            System.out.println("ERROR: Must enter a positive whole number.");
            return 0;
        }
        if (newInt <= 0) // priority can't be negative
            System.out.println("ERROR: Must enter a positive whole number.");
        return newInt;
    }
    
    public static void selectionSort(Item[] cart)
    /**
    Sorts the array into ascending order.
    Every element in cart must have a value
    */
    {
        for (int i = 0; i < cart.length - 1; i++)
        {        
            // place the correct value in cart[index]
            int indexOfNextSmallest = findLowestPriority(i, cart);
            interchange(i, indexOfNextSmallest, cart);
        }
    }

    private static int findLowestPriority(int startIndex, Item[] cart)
    /**
    Returns the index of the item with the lowest priority.
    Starts searching from the index provided with startIndex.
    Stops at last element.
    */
    {
        int min = cart[startIndex].getPriority();
        int indexOfMin = startIndex;
        for (int i = startIndex + 1; i < cart.length; i++)
        {
            if (cart[i].getPriority() < min)
            {
                min = cart[i].getPriority();
                indexOfMin = i;
            }
        }
        return indexOfMin;
    }

    private static void interchange(int i, int j, Item[] cart)
    {
        Item temporary = cart[i];
        cart[i] = cart[j];
        cart[j] = temporary; //original value of cart[i]
    }

    private static void writePositive(double amount)
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

        System.out.print(dollars);
        System.out.print('.');

        if (cents < 10)
            System.out.print('0');
        System.out.print(cents);
    }

    public static void writeMoney(double amount)
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
            System.out.print('$');
            writePositive(amount);
        } else {
            double positiveAmount = amount * -1;
            System.out.print('$');
            System.out.print('-');
            writePositive(positiveAmount);
        }
    }
}   