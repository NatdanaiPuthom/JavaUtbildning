package Uppgifter;

public class Uppgift2
{
    public enum Grade
    {
        A,
        B,
        C,
        D,
        F
    }

    public Grade Status(int aGradePoint)
    {
        if (aGradePoint >= 90 && aGradePoint <= 100)
        {
            return Grade.A;
        }
        else if (aGradePoint >= 80 && aGradePoint <= 89)
        {
            return Grade.B;
        }
        else if (aGradePoint >= 70 && aGradePoint <= 79)
        {
            return Grade.C;
        }
        else if (aGradePoint >= 60 && aGradePoint <= 69)
        {
            return Grade.D;
        }
        else
        {
            return Grade.F;
        }
    }
}