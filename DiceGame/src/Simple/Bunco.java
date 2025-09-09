package Simple;

import java.util.Scanner;

public class Bunco
{
    final private String[] myRulesText;
    private Dice myExampleDice;
    private Dice[] myRollingDices;
    private int myCurrentRound = 0;
    private int myPlayerScore = 0;
    private int myAIScore = 0;

    public Bunco()
    {
        final int faceAmount = 6;

        myExampleDice = new Dice(faceAmount);
        myRollingDices = new Dice[9];

        myRulesText = new String[]
                {
                        "\nRules:"
                        , "\nEach round has a number: 1, 2, 3, 4, 5, 6. If any of the dice match the round number, you score a point."
                        , "\nKeep rolling until you score no points. By the end of six rounds, the team with the most points wins!"
                };

        for (int i = 0; i < myRollingDices.length; i++)
        {
            myRollingDices[i] = new Dice(faceAmount);
        }
    }

    public void Welcome()
    {
        System.out.println("\nWelcome to Bunco!");
        ShowRules();
    }

    public void Lobby()
    {
        System.out.print("\n\nPress Enter to play.");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (input.isEmpty() == false)
        {
            System.out.println("Try pressing enter again.");
            input = scanner.nextLine();
        }

        StartGame();
    }

    private void ShowRules()
    {
        for (String string : myRulesText)
        {
            System.out.print(string);
        }
    }

    public void StartGame()
    {
        myCurrentRound = 1;

        for (int i = 0; i < myRollingDices.length; i++)
        {
            myRollingDices[i].Reset();
        }

        Play();
    }

    public void NextRound()
    {
        ++myCurrentRound;
        Play();
    }

    public int RollDices()
    {
        int score = 0;
        final int targetValue = myExampleDice.GetValue();

        for (int i = 0; i < myRollingDices.length; i++)
        {
            final int value = myRollingDices[i].Roll();

            if (value == targetValue)
            {
                ++score;
            }
        }

        System.out.print("Dice rolled: ");

        for (int i = 0; i < myRollingDices.length; i++)
        {
            System.out.print(myRollingDices[i].GetValue());
            System.out.print(", ");
        }

        System.out.println();

        return score;
    }

    public void Play()
    {
        final int exampleValue = myExampleDice.Roll();

        System.out.println("\nCurrent round: " + myCurrentRound);
        System.out.println("Example Value: " + exampleValue);

        System.out.println("\nPlayer:");
        myPlayerScore = RollDices();
        System.out.println("Current score: " + myPlayerScore);

        System.out.println();

        System.out.println("AI:");
        myAIScore = RollDices();
        System.out.println("Current score: " + myAIScore);

        System.out.print("\nPress Enter to continue.");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (input.isEmpty() == false)
        {
            System.out.println("Try pressing enter again.");
            input = scanner.nextLine();
        }

        if (myCurrentRound < 6)
        {
            NextRound();
        }
        else
        {
            String winner = "Player!";

            if (myPlayerScore < myAIScore)
            {
                winner = "AI!";
            }

            if (myPlayerScore == myAIScore)
            {
                winner = "a draw!";
            }

            System.out.println();
            System.out.printf("The Game is over. The winner is... %s",winner);
        }
    }
}