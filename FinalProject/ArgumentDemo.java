import java.util.HashMap;

public class ArgumentDemo
{
    public static void main(String[] args)
    {
        HashMap<String, String> flags = new HashMap<>();
        flags.put("--opt_in", "email_opt_in = 1");
        flags.put("--paid", "payed = 1");
        flags.put("--audit", "payed = 0");
        flags.put("--viewed", "viewed = 1");
        flags.put("--completed", "completed = 1");

        System.out.println("Courses:");
        System.out.println(Utilities.formatCourses(args));

        System.out.println("\nFlag options:");
        System.out.println(Utilities.formatFlags(args, flags));
    }
}