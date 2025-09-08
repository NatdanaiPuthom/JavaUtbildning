package Uppgifter;

public class Uppgift1
{
    public enum Category
    {
        Barn,
        Tonaring,
        Vuxen,
        Senior,
        Unknown
    }

    public Category Status(int aAge)
    {
      if (aAge >= 0 && aAge < 13)
      {
          return Category.Barn;
      }
      else if (aAge >= 13 && aAge <= 19)
      {
          return Category.Tonaring;
      }
      else if (aAge >= 20 && aAge <= 64)
      {
          return Category.Vuxen;
      }
      else if (aAge >= 65)
      {
          return Category.Senior;
      }

      return Category.Unknown;
    }
}