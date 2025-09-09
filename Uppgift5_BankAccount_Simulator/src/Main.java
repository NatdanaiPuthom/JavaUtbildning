import Uppgifter.Uppgift5;

public class Main
{
    public static void main(String[] args)
    {
        Uppgift5 uppgift5 = new Uppgift5();

        uppgift5.ShowBalance();

        while (true)
        {
            boolean status = uppgift5.Running();

            if (status == false)
            {
                System.out.println("\nPolice will be here shorty, please wait.");
                break;
            }
        }
    }
}