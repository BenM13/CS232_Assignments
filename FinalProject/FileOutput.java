import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileOutput
{
    private String filename;
    private FileWriter file;
    private PrintWriter outputStream;

    public FileOutput()
    /**
    Default constructor. If the user does not provide
    a name for the output file, program will automatically
    send output to "results.csv".
    */
    {
        filename = "results.csv";
        outputStream = null;
        file = null;
    }

    public FileOutput(String initName)
    /**
    Constructor of when user provides output file name 
    */
    {
        filename = initName;
        file = null;
        outputStream = null;
    }

    public void openFile()
    /**
    Instantiates output file name. 
    Exits program if an exception is thrown while opening
    */
    {
        try
        {
            outputStream = new PrintWriter(filename);
        } catch (FileNotFoundException e) {
            System.out.println("Error opening the file" + filename);
            Utilities.quitProgram();
        }
    }

    public void openLog()
    /**
    Instantiaties FileWriter object with append option set to true.
    Instantiaties PrintWriter ojbect using the FileWriter
    Exits program if an exception is thrown.
    */
    {
        try
        {
            file = new FileWriter(filename, true); // use append mode
            outputStream = PrintWriter(file);
        } catch (IOException e) {
            System.out.println("Error opening the log file");
            Utilties.quitProgram();
        }
    }

    public void closeFile()
    /**
    Closes the outputStream object 
    */
    {
        outputStream.close();
    }

    public void writeLine(String line)
    {
        outputStream.println(line);
    }

    public void setFilename(String newFile)
    {
        filename = newFile;
    }

    public String getFilename()
    {
        return filename;
    }

}