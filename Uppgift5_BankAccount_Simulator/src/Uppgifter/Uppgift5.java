package Uppgifter;

import java.util.Scanner;

public class Uppgift5
{
    private double myCurrentBalance = 100.0;

    public void ShowBalance()
    {
        System.out.println("\nBalance: " + myCurrentBalance);
    }

    public boolean Running()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nDo you want to add balance or withdraw?");
        System.out.print("Please enter \"A\" for Add Balance or \"W\" for Withdraw: ");

        String input = scanner.nextLine().trim().toLowerCase();

        while (input.isEmpty()
                || (input.charAt(0) != 'a' && input.charAt(0) != 'w')
        )
        {
            System.out.print("Please enter \"A\" for Add Balance or \"W\" for Withdraw: ");
            input = scanner.nextLine().trim().toLowerCase();
        }

        if (input.charAt(0) == 'a')
        {
            return AddBalance(scanner);
        } else
        {
            return Withdraw(scanner);
        }
    }

    private boolean AddBalance(Scanner aScanner)
    {
        System.out.print("\nHow much would you like to add?: ");
        double amount = aScanner.nextDouble();

        if (amount <= 1.0f)
        {
            System.out.print("Please enter minimum 1.0: ");
            return false;
        }

        myCurrentBalance += amount;
        System.out.println("Successfully added. New balance: " + myCurrentBalance);
        return true;
    }

    private boolean Withdraw(Scanner aScanner)
    {
        System.out.print("\nHow much would you like to withdraw?: ");
        double amount = aScanner.nextDouble();

        if (myCurrentBalance < amount)
        {
            System.out.println("Not enough balance. Current balance: " + myCurrentBalance);
            return false;
        }

        myCurrentBalance -= amount;
        System.out.println("Successfully withdraw. New balance: " + myCurrentBalance);
        return true;
    }
}