import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.lang.NumberFormatException;
import java.lang.StringIndexOutOfBoundsException;

public class Utilities
{
    private static IO_Manager io = new IO_Manager(); 

    public static void quitProgram()
    /*
    Safely exits the program without an error message
    */
    {
        io.printLine("Now exiting...goodbye!");
        System.exit(0);
    }

    public static void quitProgram(String message)
    /*
    Safely exits the program and prints error message.
    Must pass a message as a string when calling this method.
    */
    {
        io.printLine("ERROR: " + message);
        io.printLine("Now exiting...please restart and try again.");
        System.exit(0);
    }

    
    public static void selectionSort(ArrayList<Item> cart)
    /**
    Sorts the array into ascending order by its priority.
    Every element in cart must have a value
    */
    {
        for (int i = 0; i < cart.size() - 1; i++)
        {        
            // place the correct value in cart[index]
            int indexOfNextSmallest = findLowestPriority(i, cart);
            interchange(i, indexOfNextSmallest, cart);
        }
    }

    private static int findLowestPriority(int startIndex, ArrayList<Item> cart)
    /**
    Returns the index of the item with the lowest priority.
    Starts searching from the index provided with startIndex.
    Stops at last element.
    */
    {
        int min = cart.get(startIndex).getPriority();
        int indexOfMin = startIndex;
        for (int i = startIndex + 1; i < cart.size(); i++)
        {
            if (cart.get(i).getPriority() < min)
            {
                min = cart.get(i).getPriority();
                indexOfMin = i;
            }
        }
        return indexOfMin;
    }

    private static void interchange(int i, int j, ArrayList<Item> cart)
    {
        Item temporary = cart.get(i);
        cart.set(i, cart.get(j));
        cart.set(j, temporary);
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