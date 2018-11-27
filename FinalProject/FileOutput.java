import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class FileOutput
{
    private String filename;
    private PrintWriter outputStream;

    public FileOutput()
    {
        filename = "sampleOutput.csv";
        outputStream = null;
    }

    public FileOutput(String initFile)
    {
        filename = initFile;
        outputStream = null;
    }

    public void openFile()
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
    {
        outputStream.close();
    }

    public void writeLine(String line)
    {
        outputStream.println(line);
    }

}