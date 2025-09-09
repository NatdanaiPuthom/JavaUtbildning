import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rng = new Random();

        System.out.println("välkommen till världens coolaste tärningsspel!!!");

        while(true){

            System.out.println("tryck enter för att kasta tärning:");
            sc.nextLine();

            int dice = (int)(Math.random() *6) +1;
            int dice2 = rng.nextInt(1,7);
            System.out.println("du slog en:");
            System.out.println(dice);
            System.out.println("datorn slog en:");
            System.out.println(dice2);

            if( dice > dice2){
                System.out.println("du vann!!!");
            } else if(dice < dice2){
                System.out.println("datorn vann .... :(");
            } else {
                System.out.println("det blev oavgjort...");
            }


        }

    }































    private static void myMethod() {
        int x = 10;

        int y = 5;

        if (x < y) {
            System.out.println("en utskrift");

        }


        if (x < y) {
            System.out.println("en utskrift");

        } else {
            System.out.println("en annan utskrift");
        }


        if (x < y) {
            System.out.println("en utskrift");

        } else if(x > y) {
            System.out.println("en annan utskrift");
        } else {
            System.out.println("en tredje utskrift");
        }


        switch (x) {
            case 7:
                System.out.println("en annna grej");
                break;
            case 1,2,3,4,5:
                System.out.println("en grej");
                break;
            default:
                System.out.println("hittar inte den?");

        }

        switch (x){
            case 1 -> System.out.println("hej");
            case 2 -> System.out.println("adjö");
            case 3 -> {
                System.out.println("en rad");
                System.out.println("en rad till");
            }
            default -> System.out.println("default");
        }

        for(int i = 0; i < 10; i++){
            System.out.println(i);
        }

        while(x < 10){
            System.out.println(x);

            x++;
        }

        do{
            System.out.println(x);

            x++;

        } while (x < 10);

        String text = "hello";

        int[] array = {1,2,3,4,5};

        for(int i: array){
            System.out.println(i);
        }

        for (char c: text.toCharArray()){
            System.out.println(c);
        }
    }
}