package Uppgifter;

import java.util.ArrayList;
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
        CalculateAndPrintStudentsAverageScore(studentGrades);
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

    private void CalculateAndPrintStudentsAverageScore(int[][] aStudentGrades)
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

        for (int i = 0; i < studentAverageScore.length; i++)
        {
            System.out.printf("Student(%d) average score: %d%n", i, studentAverageScore[i]);
        }
    }

    private void CalculateAmountOfStudentsWithPassedScore(final int aScoreToPass)
    {
        //int[] passedStudents = new int[aStudentGrades.length];
    }
}