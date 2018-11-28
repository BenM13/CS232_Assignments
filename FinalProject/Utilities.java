import java.util.HashMap;

public class Utilities
{
    public static boolean checkForFlag(String[] args, String flag)
    /** 
    Takes an array of command line arguemtns as the method
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

    public static boolean checkExtension(String argument)
    /**
    Checks if the given String contains a .txt or .csv extension.
    */
    {
        boolean matches = false;
        if (argument.contains(".txt") || argument.contains(".csv"))
        {
            matches = true;
        }
        return matches;
    }

    public static String getOutputFile(String[] args)
    {
        String filename = null;
        for (String s: args)
        {
            if (s.contains(".txt") || s.contains(".csv"))
            {
                filename = s;
                break;
            }
        }
        return filename;
    }

    public static String formatCourses(String[] args)
    /** 
    Parses through the args array searching for course numbers. 
    Any argument that does not start with a dash '-' is assumed to be a 
    course number. While looping through the array, this method uses
    a StringBuilder to construct a tuple of course numbers seperated by
    a comma. The return is a String such as "(COURSE1, COURSE2, ... COURSEn)"
    If args contains no course numbers, returns "= course_number", which will
    search for all course numbers when added to the query.
    */
    {
        StringBuilder sb = new StringBuilder();
        boolean atBeginning = true;
        int counter = 0; // number of courses added to string builder
        for (String s: args)
        {
            if ((s.charAt(0) != '-') && (!checkExtension(s)))
            {
                if (atBeginning)
                {
                    sb.append(String.format("'%s'", s));
                    atBeginning = false;
                } else {
                    sb.append(String.format(", '%s'", s));
                }
                counter++;
            }
        }
        if (counter > 0)
        {
            return String.format("IN (%s)", sb.toString());
        } else {
            return "= course_number";
        }
    }

    public static String formatFlags(String[] args, HashMap<String, String> dict)
    /**
    Parses through the args array searching for flags. Any argument with beginning
    with a dash '-' is assumed to be a flag. Skips the "--opt_in flag", this flag is 
    addressed in the formatOptIn() method. formats arguments with corresponding value
    from HashMap. 
    */
    {
        StringBuilder sb = new StringBuilder();
        for (String s: args)
        {
            if ((s.charAt(0) == '-') && (!s.replaceAll("-", "").equalsIgnoreCase("opt_in")))
            {
                String value = dict.get(s.replaceAll("-", ""));
                if (value != null)
                {
                    sb.append(String.format(" AND %s", value));
                }
            }
        }
        return String.format("%s", sb.toString());
    }

    public static String formatOptIn(String[] args)
    /** 
    Checks the argument array for the opt_in flag. 
    If the opt_in flag is present, returns its corresponding
    query clause. Otherwise returns a blank string.
    */
    {
        String statement = "";
        for (String s: args)
        {
            s = s.replaceAll("-", "");
            if (s.equalsIgnoreCase("opt_in"))
            {
                statement = " WHERE email_opt_in = 1";
                break;
            }
        }
        return statement;
    }

    public static String buildQuery(String[] options)
    /**
    Takes an array of Strings as its argument. These strings will be 
    used to fill the place holders within the query.
    */
    {
        String query = "SELECT c.student_id AS id, c.course_number AS course, " +
                       "students.student_name AS student, students.student_email AS email " +
                       "FROM (SELECT * FROM courses_taken WHERE course_number %s %s) c " +
                       "JOIN students ON students.student_id = c.student_id %s";
        return String.format(query, options[0], options[1], options[2]);
    }

    public static void quitProgram()
    /**
    Safely exits the program 
    */
    {
        System.out.println("Now exiting...goodbye!");
        System.exit(0);
    }
}