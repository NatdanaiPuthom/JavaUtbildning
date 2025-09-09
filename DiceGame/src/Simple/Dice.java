package Simple;

import java.util.Random;

public class Dice
{
    private int myValue = 0;
    private int myFaceAmount = 0;

    public Dice()
    {
        SetFaceAmount(6);
    }

    public Dice(final int aFaceAmount)
    {
        SetFaceAmount(aFaceAmount);
    }

    public int Roll()
    {
        Random rng = new Random();
        myValue = rng.nextInt(myFaceAmount) + 1;

        return myValue;
    }

    public void Reset()
    {
        myValue = 0;
    }

    private void SetFaceAmount(final int aFaceAmount)
    {
        myFaceAmount = aFaceAmount;
    }

    public int GetValue()
    {
        return myValue;
    }
}