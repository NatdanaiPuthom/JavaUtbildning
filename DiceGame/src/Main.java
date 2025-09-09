import java.util.Random;
import java.util.Scanner;
import Simple.Bunco;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Random rng = new Random();

        Bunco game = new Bunco();
        game.Welcome();
        game.Lobby();
    }
}