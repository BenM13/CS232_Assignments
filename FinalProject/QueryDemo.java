import java.sql.ResultSet;
import java.sql.SQLException;
import java.lang.NullPointerException;

public class QueryDemo
{
    public static String getCourses(String rawCourses)
    {
        String[] splitCourses = rawCourses.split(",");
        for (int i = 0; i < splitCourses.length; i++)
        {
            splitCourses[i] = String.format("'%s'", splitCourses[i]);
        }
        return String.format("(%s)", String.join(", ", splitCourses));
    }


    public static void main(String[] args)
    {
        String query;
        String courseNumber = null;

        if (args.length <= 0)
        {
            System.out.println("Error: Please enter course number as the 1st positional argument.");
            System.exit(0);
        } else {
            courseNumber = args[0];
        }

        OracleConnection obscured = new OracleConnection();
        obscured.createConnection();

        if ((args.length > 1) && (args[1].equalsIgnoreCase("Opt-in")))
        {
            query = "SELECT DISTINCT pc.username, person.email, names.profile_name full_name " +
                    "FROM (SELECT pcourse.user_id, pcourse.username FROM whmitx_person_course pcourse " +
                    "WHERE pcourse.course_id IN " + getCourses(args[0]) + ") pc JOIN ( SELECT user_id, email " +
                    "FROM whmitx_person WHERE email_opt_in_flag = '1') person ON person.user_id = pc.user_id " +
                    "JOIN whmitx_person_name names ON names.user_id = pc.user_id WHERE ROWNUM <= 20";
        } else {
            query = "SELECT DISTINCT pc.username, person.email, names.profile_name full_name " +
                    "FROM (SELECT pcourse.user_id, pcourse.username FROM whmitx_person_course pcourse " +
                    "WHERE pcourse.course_id IN " + getCourses(args[0]) + ") pc JOIN ( SELECT user_id, email " +
                    "FROM whmitx_person) person ON person.user_id = pc.user_id JOIN whmitx_person_name names " +
                    "ON names.user_id = pc.user_id WHERE ROWNUM <= 20";
        }

        ResultSet queryResults = obscured.runQuery(query);

        try
        {
            while (queryResults.next())
            {
                String username = queryResults.getString("USERNAME");
                String email = queryResults.getString("EMAIL");
                System.out.println(username + "\t" + email);
            }
        } catch (SQLException e) {
            System.out.println("There was a problem getting the results:\n" +
                               e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("There was a poroblem getting results:\n" +
                               e.getMessage());
        }

        obscured.closeConnection();
    }
}