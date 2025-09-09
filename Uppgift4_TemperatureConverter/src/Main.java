import Uppgifter.Uppgift3;

public class Main
{
    public static void main(String[] args)
    {
        final Uppgift3 uppgift3 = new Uppgift3();

        final char operation = uppgift3.ChooseOperation();

        System.out.print("Enter first value: ");
        final double valueA = uppgift3.ReadNumericInput();

        System.out.print("Enter second value: ");
        final double valueB = uppgift3.ReadNumericInput();

        final double result = uppgift3.Calculate(operation, valueA, valueB);
        System.out.print("Result: " + result);
    }
}