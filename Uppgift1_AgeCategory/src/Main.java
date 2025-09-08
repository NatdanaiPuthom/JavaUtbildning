import Uppgifter.Uppgift1;

public class Main
{
    public static void main(String[] args)
    {
        Uppgift1 uppgift1 = new Uppgift1();

        final int age = 10;
        final Uppgift1.Category category = uppgift1.Status(age);

        System.out.print(category);
    }
}