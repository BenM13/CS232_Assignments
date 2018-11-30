import java.util.HashMap;
import java.sql.SQLException;

public class ConnectionDemo
{
    public static void main(String[] args)
    {
        HashMap<String, String> flags = new HashMap<>();
        flags.put("opt_in", "email_opt_in = 1");
        flags.put("paid", "paid = 1");
        flags.put("audit", "paid = 0");
        flags.put("viewed", "viewed = 1");
        flags.put("not_viewed", "viewed = 0");
        flags.put("completed", "completed = 1");
        flags.put("not_completed", "completed = 0");

        SQLiteConnection db = new SQLiteConnection();
        
        if (Utilities.checkForFlag(args, "--help"))
        {
            System.out.println("You asked for help.");
            System.out.println("Unfortunately I have no answers.");
            Utilities.quitProgram();
        }

        String query = Utilities.buildQuery(args, flags);

        db.createConnection();
        db.runQuery(query);
        db.printResults(args);
        db.closeConnection();
    }
}