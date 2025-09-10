package Uppgifter;

import java.util.Random;

public class Uppgift6
{
    private enum eDay
    {
        Monday,
        Tuesday,
        Wednesday,
        Thursday,
        Friday,
        Saturday,
        Sunday,
        Size
    }

    final private double[] myDailyTemperature;

    public Uppgift6()
    {
        myDailyTemperature = new double[eDay.Size.ordinal()];
    }

    public void ShowThisWeekTemperatureData()
    {
        GenerateThisWeekTemperature();
        ShowThisTemperature();
        ShowAverageTemperatureThisWeek();
        ShowHighestTemperatureThisWeek();
        ShowLowestTemperatureThisWeek();
        ShowThisWeekGraph();
    }

    private void GenerateThisWeekTemperature()
    {
        Random rng = new Random();

        for (int i = 0; i < myDailyTemperature.length; i++)
        {
            myDailyTemperature[i] = rng.nextDouble(18, 30);
        }
    }

    private void ShowThisTemperature()
    {
        System.out.println("\nThis week temperature: ");

        for (int i = 0; i < myDailyTemperature.length; i++)
        {
            System.out.printf("%s: %.2f%n", eDay.values()[i], myDailyTemperature[i]);
        }
    }

    private void ShowAverageTemperatureThisWeek()
    {
        double average = 0.0;

        for (int i = 0; i < myDailyTemperature.length; i++)
        {
            average += myDailyTemperature[i];
        }

        if (myDailyTemperature.length > 0)
        {
            average = average / myDailyTemperature.length;
        }

        System.out.printf("%nAverage temperature this week: %.2f%n", average);
    }

    private void ShowHighestTemperatureThisWeek()
    {
        double highestTemperature = myDailyTemperature[0];

        for (int i = 0; i < myDailyTemperature.length; i++)
        {
            if (highestTemperature < myDailyTemperature[i])
            {
                highestTemperature = myDailyTemperature[i];
            }
        }

        System.out.printf("Highest temperature this week: %.2f%n", highestTemperature);
    }

    private void ShowLowestTemperatureThisWeek()
    {
        double lowestTemperature = myDailyTemperature[0];

        for (int i = 0; i < myDailyTemperature.length; i++)
        {
            if (lowestTemperature > myDailyTemperature[i])
            {
                lowestTemperature = myDailyTemperature[i];
            }
        }

        System.out.printf("Lowest temperature this week: %.2f%n", lowestTemperature);
    }

    private void ShowThisWeekGraph()
    {
        System.out.println();

        final double degreesPerStar = 2.0;

        for (int i = 0; i < myDailyTemperature.length; i++)
        {
            final double temperature = myDailyTemperature[i];
            final int stars = (int) Math.floor(Math.max(0.0, temperature / degreesPerStar));
            final String bar = "*".repeat(stars);

            System.out.printf("%-9s | %-15s (%.1f °C)%n", eDay.values()[i], bar, temperature);
        }
    }
}