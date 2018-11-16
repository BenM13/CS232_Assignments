/**
Exception class for handling bad user input.
This exception is thrown anytime a user does not
follow input instrucitons. 
*/
public class BadInputException extends Exception
{
    public BadInputException()
    {
        super("Input criteria not met");
    }

    public BadInputException(String message)
    {
        super(message);
    }
}