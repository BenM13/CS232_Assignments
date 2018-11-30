import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class FileOutput
{
    private String filename;
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
    }

    public FileOutput(String initName)
    /**
    Constructor of when user provides output file name 
    */
    {
        filename = initName;
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