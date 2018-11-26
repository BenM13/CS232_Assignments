import java.util.HashMap;

public class ArgumentDemo
{
    public static void main(String[] args)
    {
        HashMap<String, String> flags = new HashMap<>();
        flags.put("opt_in", "email_opt_in = 1");
        flags.put("paid", "paid = 1");
        flags.put("audit", "paid = 0");
        flags.put("viewed", "viewed = 1");
        flags.put("completed", "completed = 1");

        String[] parts = {Utilities.formatCourses(args), Utilities.formatFlags(args, flags), 
                          Utilities.formatOptIn(args)};

        for (String s: parts)
        {
            System.out.println(s);
        }
    }
}