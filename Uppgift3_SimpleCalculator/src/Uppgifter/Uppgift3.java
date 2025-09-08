package Uppgifter;

import java.util.Scanner;

public class Uppgift3
{
    final private char[] myOperations = {'+', '-', '*', '/'};

    public char ChooseOperation()
    {
        Scanner scanner = new Scanner(System.in);
        char operation = '0';

        System.out.println("Pick a operation: Addition(+), Substraction(-), Multiplication(*) or Division(/).");

        while (true)
        {
            System.out.print("Operation: ");
            final String input = scanner.nextLine().trim().toLowerCase();

            if (input.isEmpty())
            {
                System.out.println("Please pick a operation before proceeding.");
                continue;
            }

            operation = input.charAt(0);

            for (char character : myOperations)
            {
                if (character == operation)
                {
                    return operation;
                }
            }

            System.out.println("Please pick a correct operation.");
        }
    }

    public double ReadNumericInput()
    {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        return scanner.nextDouble();
    }

    public double Calculate(char aOperation, double aValueA, double aValueB)
    {
        double result = 0.0;

        switch (aOperation)
        {
            case '+':
                result = aValueA + aValueB;
                break;
            case '-':
                result = aValueA - aValueB;
                break;
            case '*':
                result = aValueA * aValueB;
                break;
            case '/':
                if (aValueB == 0)
                {
                    result = -1.0;
                    System.out.println("Division by zero error!");
                }
                else
                {
                    result = aValueA / aValueB;
                }
                break;
            default:
                System.out.println("Shouldn't be possible to reach here.");
                break;
        }

        return result;
    }
}