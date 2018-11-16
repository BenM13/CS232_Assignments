public interface Printable
{
    void printLine();
    /**
    Skips to the next line
    */
    
    void printLine(String output);
    /**
    Prints a line of text, advances to next line
    */

    void printSingle(String output);
    /**
    Prints a String, does not advance to the next line
    */

    void printSingle(int output);
    /**
    Prints an int, does not advance to the next line 
    */

    void printSingle(double output);
    /**
    Prints a double, does not advance to the next line
    */
}