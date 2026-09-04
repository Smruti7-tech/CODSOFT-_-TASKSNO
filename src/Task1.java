import java.util.Random;
import java.util.Scanner;
public class Task1 {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        Random random=new Random();
        int number=random.nextInt(100)+1;
        int guess;
        int attempts=0;
        System.out.println("Guess a number between 1 and 100");

        do {
            System.out.print("Enter your guess:");
            guess=sc.nextInt();
            attempts++;

            if(guess<number){
                System.out.println("Too low! Try again");
            }
            else if(guess>number){
                System.out.println("Too high! Try again");
            }
            else{
                System.out.println("Hurrayy! U got it");
                System.out.println("You guessed it in" + attempts + "attempts.");
            }
        }
        while(guess != number);
        sc.close();





            }

        }


