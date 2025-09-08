import Uppgifter.Uppgift2;

public class Main
{
    public static void main(String[] args)
    {
        Uppgift2 uppgift2 = new Uppgift2();

        final int points = 90;
        final Uppgift2.Grade grade = uppgift2.Status(points);

        System.out.print(grade);
    }
}