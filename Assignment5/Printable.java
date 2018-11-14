public interface Printable
{
    public void printLine();
    /**
    Skips to the next line
    */
    
    public void printLine(String output);
    /**
    Prints a line of text, advances to next line
    */

    public void printSingle(String output);
    /**
    Prints a String, does not advance to the next line
    */

    public void printSingle(int output);
    /**
    Prints an int, does not advance to the next line 
    */

    public void printSingle(double output);
    /**
    Prints a double, does not advance to the next line
    */
}