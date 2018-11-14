public class PrintingDemo
{
    public static void main(String[] args)
    {
        IO_Manager io = new IO_Manager();
        io.printLine("Hi!");
        io.printSingle("One");
        io.printLine();
        io.printSingle(1);
        io.printLine();
        io.printSingle(1.1);
        int random = 5;
        // io.printLine(random);
        io.printLine("this is a " + random + " a line of text.");
    }
}