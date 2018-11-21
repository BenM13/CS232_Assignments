import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConnection
{
    private final String URL;
    private Connection conn;
    private Statement stmt;
    private ResultSet results;

    public SQLiteConnection()
    /**
    Default constructor. Sets the database URL
    to one of the test database files in the
    current directory.
    */
    {
        this.URL = "jdbc:sqlite:test2.db";
        this.conn = null;
        this.stmt = null;
        this.results = null;
    }

    public SQLiteConnection(String initURL)
    {
        this.URL = initURL;
        this.conn = null;
        this.stmt = null;
        this.results = null;
    }

    public void createConnection()
    /**
    Creates a connection object to the SQLite database.
    This object is stored as an instance variable of
    the SQLiteConnection class
    */
    {
        try
        {
            conn = DriverManager.getConnection(URL);
            System.out.println("Successfully connected to the database!");
        } catch (SQLException e) {
            System.out.println("Error: Unable to connect to database:");
            System.out.println("\t" + e.getMessage());
        }
    }

    public void runQuery(String query)
    /** 
    Creates a statement objects. Runs the provided query.
    Saves result set object as instance variable of 
    SQLiteConnection class
    */
    {
        try
        {
            stmt = conn.createStatement();
            results = stmt.executeQuery(query);
            System.out.println("Executing query...");
        } catch (SQLException e) {
            System.out.println("There was a problem with the query:");
            System.out.println("\t" + e.getMessage());
        }
    }
    public void closeConnection()
    {
        try
        {
            if ((conn == null) || (stmt == null))
            {
                throw new SQLException("Connection and/or statement object is null");
            } else {
                conn.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            System.out.println("Error: Unable to close connection:");
            System.out.println("\t" + e.getMessage());
        }
    }

    public void printResults()
    {
        try
        {
            while (results.next())
            {
                System.out.println(results.getString("student_id") + "\t" +
                                   results.getString("student_name") + "\t" +
                                   results.getString("student_email") + "\t" +
                                   results.getBoolean("email_opt_in"));
            }
        } catch (SQLException e) {
            System.out.println("Unable to retrieve results:");
            System.out.println("\t" + e.getMessage());
        }
    }
}