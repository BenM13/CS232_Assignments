import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.lang.NullPointerException;

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
        this.URL = "jdbc:sqlite:test.db";
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
            System.out.println("Connection established.");
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
    /** 
    Closes the statement and connection objects
    */
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

    public void printResults(String[] args)
    /** 
    Creates an object of the FileOutput class.
    If user provided an output file name, that name is passed
    to the constructor. Otherwise, default constructor is used. 
    Uses this new object to create an output file
    and write the results of the query to that file.
    */
    {
        String outputFile = Utilities.getOutputFile(args);
        FileOutput exporter;
        if (outputFile != null)
        {
            exporter = new FileOutput(outputFile);
        } else {
            exporter = new FileOutput();
        }
        exporter.openFile();
        try
        {
            exporter.writeLine("id\tcourse\tstudent\temail");
            while (results.next())
            {
                exporter.writeLine(results.getString("id") + "\t" +
                                   results.getString("course") + "\t" +
                                   results.getString("student") + "\t" +
                                   results.getString("email"));
            }
        } catch (SQLException e) {
            System.out.println("Unable to retrieve results:");
            System.out.println("\t" + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Unable to retrieve results");
            System.out.println("\t" + e.getMessage());
        }
        exporter.closeFile();
    }
}