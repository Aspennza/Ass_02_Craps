import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Random gen = new Random();
        Scanner in = new Scanner(System.in);
        int die1 = 0;
        int die2 = 0;
        int dieSum = 0;
        int point = 0;
        String playAgain = "";
        String roll = "";

        do {
            System.out.print("\nPress any key to roll the dice! ");
            roll = in.nextLine();

            die1 = gen.nextInt(6) + 1;
            die2 = gen.nextInt(6) + 1;
            dieSum = die1 + die2;

            System.out.println("\nYour first die rolled a " + die1 + ".");
            System.out.println("\nYour second die rolled a " + die2 + ".");
            System.out.println("\nThe sum of your rolls is " + dieSum + ".");

            if(dieSum == 2 || dieSum == 3 || dieSum == 12) {
                System.out.println("\nYou crapped out! Game over.");
            } else if(dieSum == 7 || dieSum == 11) {
                System.out.println("\nYou rolled a natural! You win!");
            } else {
                point = dieSum;
                System.out.println("\nYour sum of " + dieSum + " is now the point! Roll this number again before rolling a 7 to win!");

                do {
                    System.out.print("\nPress any key to roll the dice! ");
                    roll = in.nextLine();

                    die1 = gen.nextInt(6) + 1;
                    die2 = gen.nextInt(6) + 1;
                    dieSum = die1 + die2;

                    System.out.println("\nYour first die rolled a " + die1 + ".");
                    System.out.println("\nYour second die rolled a " + die2 + ".");
                    System.out.println("\nThe sum of your rolls is " + dieSum + ".");

                    if(dieSum == point) {
                        System.out.println("\nCongratulations! You rolled the point of " + point + " and won!");
                    } else if(dieSum == 7) {
                        System.out.println("\nYou rolled a 7 and lost.");
                    } else {
                        System.out.println("\nYou didn't roll a seven or the point, so you can keep trying for the point!");
                    }
                }while(dieSum != point && dieSum != 7);
            }
            System.out.print("\nWould you like to play again? Enter Y or press any other key to quit: ");
            playAgain = in.nextLine();
        }while(playAgain.equalsIgnoreCase("Y"));
    }
}