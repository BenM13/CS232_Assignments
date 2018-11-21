import java.util.HashMap;
import java.sql.SQLException;

public class ConnectionDemo
{
    public static void main(String[] args)
    {
        HashMap<String, String> flags = new HashMap<>();
        flags.put("--opt_in", "email_opt_in = 1");
        flags.put("--paid", "payed = 1");
        flags.put("--audit", "payed = 0");
        flags.put("--viewed", "viewed = 1");
        flags.put("--completed", "completed = 1");

        SQLiteConnection db = new SQLiteConnection();
        
        if (Utilities.checkForFlag(args, "--help"))
        {
            System.out.println("You asked for help.");
            System.out.println("Unfortunately I have no answers.");
            Utilities.quitProgram();
        }

        String[] parts = {Utilities.formatCourses(args), Utilities.formatFlags(args, flags), 
                          Utilities.formatOptIn(args)};

        String query = Utilities.buildQuery(parts);

        db.createConnection();
        db.runQuery(query);
        db.printResults();
        db.closeConnection();
    }
}