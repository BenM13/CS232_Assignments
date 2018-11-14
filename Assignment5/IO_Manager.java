import java.util.Scanner;
import java.util.regex.Pattern;
import java.lang.NumberFormatException;
import java.lang.StringIndexOutOfBoundsException;

public class IO_Manager implements Printable
{
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
}