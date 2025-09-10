import java.util.Random;

public class Student
{
    private final String myName;
    private final int myExamResult;
    private StudentGrade.eGrade myGrade = StudentGrade.eGrade.F;

    Student(final String aName)
    {
        myName = aName;

        Random rng = new Random();
        myExamResult = rng.nextInt(0, 100 + 1);

        AssignGrade(myExamResult);
    }

    public String GetName()
    {
        return myName;
    }

    public int GetResult()
    {
        return myExamResult;
    }

    public StudentGrade.eGrade GetGrade()
    {
        return myGrade;
    }

    private void AssignGrade(final int aScore)
    {
        if (aScore >= 90 && aScore <= 100)
        {
            myGrade = StudentGrade.eGrade.A;
        } else if (aScore >= 70 && aScore < 90)
        {
            myGrade = StudentGrade.eGrade.B;
        } else if (aScore >= 50 && aScore < 70)
        {
            myGrade = StudentGrade.eGrade.C;
        } else if (aScore >= 30 && aScore < 50)
        {
            myGrade = StudentGrade.eGrade.D;
        }
        else if (aScore >= 10 && aScore < 30)
        {
            myGrade = StudentGrade.eGrade.E;
        }
        else
        {
            myGrade = StudentGrade.eGrade.F;
        }
    }
}