import java.util.HashMap;

public class Utilities
{
    public static boolean checkForFlag(String[] args, String flag)
    /** 
    Takees an array of command line arguemtns as the method
    argument, as well as the flag to search for as a string.
    Loops through the argument array. Returns true if flag
    matches one of the arguments. 
    */
    {
        boolean matches = false;
        for (int i = 0; i < args.length; i++)
        {
            if (args[i].equalsIgnoreCase(flag))
            {
                matches = true;
                break;
            }
        }
        return matches;
    }

    public static String formatCourses(String[] args)
    /** 
    Parses through the args array searching for course numbers. 
    Any argument that does not start with a dash '-' is assumed to be a 
    course number. While looping through the array, this method uses
    a StringBuilder to construct a tuple of course number seperated by
    a comma. The return is a String in such as "(COURSE1, COURSE2,... COURSEn)"
    */
    {
        StringBuilder sb = new StringBuilder();
        boolean atBeginning = true;
        for (String s: args)
        {
            if (s.charAt(0) != '-')
            {
                if (atBeginning)
                {
                    sb.append(String.format("'%s'", s));
                    atBeginning = false;
                } else {
                    sb.append(String.format(", '%s'", s));
                }
            }
        }
        return String.format("(%s)", sb.toString());
    }

    public static String formatFlags(String[] args, HashMap<String, String> dict)
    {
        StringBuilder sb = new StringBuilder();
        boolean atBeginning = true;
        for (String s: args)
        {
            if ((s.charAt(0) == '-') && (!s.equalsIgnoreCase("--opt_in")))
            {
                String value = dict.get(s);
                if (atBeginning)
                {
                    sb.append(String.format("%s", value));
                    atBeginning = false;
                } else {
                    sb.append(String.format(" AND %s", value));
                }
            }
        }
        return String.format("%s", sb.toString());
    }

    public static void quitProgram()
    {
        System.out.println("Now exiting...goodbye!");
        System.exit(0);
    }
}