package Uppgifter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Uppgift7
{
    public void Run()
    {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> students = new ArrayList<String>();

        final int amountOfGrades = 5;
        final int scoreToPassGrade = 50;
        int studentAmounts = -1;

        while (studentAmounts < 1)
        {
            System.out.print("\nHow many students?: ");
            studentAmounts = scanner.nextInt();
        }

        while (students.size() < studentAmounts)
        {
            System.out.printf("\nEnter student(%d) name: ", students.size());
            String name = scanner.next().trim();

            while (name.isEmpty())
            {
                System.out.println("Student name cannot be blank. Please enter again.");
                System.out.printf("\nEnter student(%d) name: ", students.size());
                name = scanner.next().trim();
            }

            students.add(name);
        }

        int[][] studentGrades = new int[students.size()][amountOfGrades];

        AssignRandomGrades(studentGrades);
        ShowStudentGrades(studentGrades);

        final int[] studentAverage = CalculateStudentsAverageScore(studentGrades);
        PrintStudentsAverage((studentAverage));

        CalculateAmountOfStudentsWithPassedScore(studentGrades, scoreToPassGrade);

        final int bestStudentIndex = FindBestStudent(studentAverage);
        System.out.printf("%nBest student is %s%n", students.get(bestStudentIndex));

        PrintSortedStudentsAverage(studentAverage, students);
    }

    private void AssignRandomGrades(int[][] aStudentGrades)
    {
        Random rng = new Random();

        for (int i = 0; i < aStudentGrades.length; i++)
        {
            for (int j = 0; j < aStudentGrades[i].length; j++)
            {
                aStudentGrades[i][j] = rng.nextInt(0, 100 + 1);
            }
        }
    }

    private void ShowStudentGrades(int[][] aStudentGrades)
    {
        System.out.println();

        for (int i = 0; i < aStudentGrades.length; i++)
        {
            for (int j = 0; j < aStudentGrades[i].length; j++)
            {
                System.out.printf("Student(%d) Grade(%d) Score(%d)%n", i, j, aStudentGrades[i][j]);
            }

            System.out.println();
        }
    }

    private int[] CalculateStudentsAverageScore(int[][] aStudentGrades)
    {
        int[] studentAverageScore = new int[aStudentGrades.length];

        for (int i = 0; i < aStudentGrades.length; i++)
        {
            studentAverageScore[i] = 0;

            for (int j = 0; j < aStudentGrades[i].length; j++)
            {
                studentAverageScore[i] += aStudentGrades[i][j];
            }

            studentAverageScore[i] /= aStudentGrades[i].length;
        }

        return studentAverageScore;
    }

    private void PrintStudentsAverage(int[] aStudentAverageScore)
    {
        for (int i = 0; i < aStudentAverageScore.length; i++)
        {
            System.out.printf("Student(%d) average score: %d%n", i, aStudentAverageScore[i]);
        }
    }

    private void CalculateAmountOfStudentsWithPassedScore(final int[][] aStudentGrades, final int aScoreToPass)
    {
        int amountStudentPassed = 0;

        for (int i = 0; i < aStudentGrades.length; i++)
        {
            int tempPassed = 0;

            for (int j = 0; j < aStudentGrades[i].length; j++)
            {
                if (aStudentGrades[i][j] >= aScoreToPass)
                {
                    tempPassed += 1;
                }
            }

            if (tempPassed >= 3)
            {
                amountStudentPassed += 1;
            }
        }

        System.out.println("\nStudent passed: " + amountStudentPassed);
    }

    private int FindBestStudent(final int[] aStudentAverage)
    {
        int highestAverageIndex = 0;

        for (int i = 0; i < aStudentAverage.length; i++)
        {
           if (aStudentAverage[i] > highestAverageIndex)
           {
               highestAverageIndex = i;
           }
        }

        return highestAverageIndex;
    }

    private void PrintSortedStudentsAverage(final int[] aStudentAverage, ArrayList<String> aStudentsList)
    {
        int[] indexMapToStudent;
        int[] sortedStudentAverage = Arrays.copyOf(aStudentAverage, aStudentAverage.length);

        for (int i = 0; i < aStudentAverage.length; i++)
        {
            for (int j = i + 1; j < aStudentAverage.length; j++)
            {
                if (aStudentAverage[i] > aStudentAverage[j])
                {
                    int temp = aStudentAverage[i];
                    sortedStudentAverage[i] = aStudentAverage[i];
                    sortedStudentAverage[j] = temp; //Something's wrong
                }
            }
        }

        System.out.println();

        for (int i = 0; i < sortedStudentAverage.length; i++)
        {
            System.out.println(" " + sortedStudentAverage[i]);
        }
    }
}