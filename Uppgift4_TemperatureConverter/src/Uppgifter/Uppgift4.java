package Uppgifter;

import java.util.Scanner;

public class Uppgift4
{
    public enum ConvertTo
    {
        CelsiusToFahrenheit,
        FahrenheitToCelsius
    }

    public void Lobby()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWelcome to temperature converter!");
        System.out.println("Here you can convert between Celsius and Fahrenheit!");
        System.out.print("\nPlease input temperature: ");

        final double temperature = scanner.nextDouble();

        System.out.println("\nChoose what to convert to. Celsius(C) or Fahrenheit(F)");
        String convertTypeAsString = scanner.nextLine().trim().toLowerCase();

        while (convertTypeAsString.isEmpty() ||
                (convertTypeAsString.charAt(0) != 'c' && convertTypeAsString.charAt(0) != 'f')
        )
        {
            System.out.print("Please enter \"C\" (Fahrenheit to Celsius) or \"F\" (Celsius to Fahrenheit): ");
            convertTypeAsString = scanner.nextLine().trim();
        }

        Uppgift4.ConvertTo convertToAsEnum = Uppgift4.ConvertTo.CelsiusToFahrenheit;

        if (convertTypeAsString.charAt(0) == 'f')
        {
            convertToAsEnum = Uppgift4.ConvertTo.FahrenheitToCelsius;
        }

        final double newTemperature = ConvertTemperature(convertToAsEnum,temperature);

        System.out.println();

        switch(convertToAsEnum)
        {
            case Uppgift4.ConvertTo.CelsiusToFahrenheit:
                System.out.println("Fahrenheit is " + newTemperature);
                break;
            case Uppgift4.ConvertTo.FahrenheitToCelsius:
                System.out.println("Celsius is " + newTemperature);
                break;
            default:
                System.out.println("Shouldn't be possible to reach here. Please find the bug(s).");
                break;

        }
    }

    public double ConvertTemperature(final ConvertTo aTypeToConvert, final double aTemperature)
    {
        switch (aTypeToConvert)
        {
            case CelsiusToFahrenheit:
            {
                final double newValue = aTemperature * (9.0/5.0) + 32.0;
                return newValue;
            }
            case FahrenheitToCelsius:
            {
                final double newValue = (aTemperature - 32.0) * (5.0/9.0);
                return newValue;
            }
            default:
                System.out.println("Shouldn't be possible to reach here. Please find the bug(s).");
                return aTemperature;
        }
    }

    public void PrintSuggestion(final double aCelsiusTemperature)
    {
        if (aCelsiusTemperature < 0.0)
        {
            System.out.println("Mycket kallt - ta på dig vinterkläder!");
        }
        else if (aCelsiusTemperature >= 0.0 && aCelsiusTemperature < 10.0)
        {
            System.out.println("Kallt - jacka behövs.");
        }
        else if (aCelsiusTemperature >= 10.0f && aCelsiusTemperature < 20.0)
        {
            System.out.println("Svalt - lätt jacka.");
        }
        else if (aCelsiusTemperature >= 20.0 && aCelsiusTemperature < 30.0)
        {
            System.out.println("Behagligt - t-shrt räcker!");
        }
        else
        {
            System.out.println("Varmt - short och linne!");
        }
    }
}