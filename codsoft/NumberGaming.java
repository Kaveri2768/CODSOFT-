package numbergame;
import java.util.Random;
import java.util.Scanner;

public class NumberGaming {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	     Random rdm = new Random();
         Scanner sc_obj = new Scanner(System.in);
         int mA = 6; //Maximum Attempts
         int score = 0;
         int rd=1;//Round Number

         System.out.println("Welcome to the Number Guessing Game!");
         boolean play = true;

         while (play) {
             int targetNum = rdm.nextInt(100) + 1;
             int attmpts = 1;
             
             System.out.println("Round-"+rd+":Can you guess the number between 1 and 100 .");
             
             while (attmpts <= mA) {
                 System.out.print("\tAttempt ("+attmpts+"/"+mA+") - Enter your guess: ");
                 int guessNum = sc_obj.nextInt();
                 attmpts++;

                 if (guessNum == targetNum) {
                     System.out.println("\tCongratulations! You guessed the number in " + attmpts + " attempts.");
                     score++;
                     break;
                 } else if (guessNum < targetNum) {
                     System.out.println("\tToo low. Try again.");
                 } else {
                     System.out.println("\tToo high. Try again.");
                 }

                 if (attmpts > mA) {
                     System.out.println("\tSorry, you've reached the maximum number of attempts. The number was: " + targetNum);
                 }
             }

             System.out.print("Do you want to play again? (yes/no): ");
             String playChoice = sc_obj.next().toLowerCase();
             if (playChoice.equals("no")) {
                 play = false;
             }
             rd++;
         }

         System.out.println("Thanks for playing,we hope you enjoyed the game. Your total score: " + score);

	}

}