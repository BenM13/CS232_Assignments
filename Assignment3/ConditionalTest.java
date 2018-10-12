public class ConditionalTest
{
    public static void main(String[] args)
    {
       String nameA = "Something";
       String nameB = "Something else";
       int priorityA = 1;
       int priorityB = 2;

        if ((priorityA == priorityB) && (nameA.equals(nameB)))
            System.out.println("a and b have the same name and priority");
        else if (priorityA == priorityB)
            System.out.println("a and b have the same priority");
        else if (nameA.equals(nameB))
            System.out.println("a and b have the same name");
        else
            System.out.println("a and b are different.");
    }
}