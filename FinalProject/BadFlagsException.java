/** 
Exception class for handling contradicting flags
*/

public class BadFlagsException extends Exception 
{
    public BadFlagsException()
    {
        super("Query not executed: Invalid arguments.");
    }

    public BadFlagsException(String message)
    {
        super(message);
    }
}