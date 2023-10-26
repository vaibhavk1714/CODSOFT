import java.util.*;

public class NumberGuesser {
	
	static Scanner sc = new Scanner(System.in);
	static Random r = new Random();
	
	public static void choiceHandler(int choice) {
		
		switch (choice) {
			case 1: { 
				startGame();
				break;
			}
			case 2: {
				System.out.println("Game Over...\nThanks for playing!!");
				break;
			}
			default:
				System.out.println("Please enter a valid option");
			}
	}
	
	public static void startGame() {
		
		boolean playAgain = true;
        int score = 0;
		
		while(playAgain) {
			int attempts = 4;
			int randomNumber = r.nextInt(100) + 1;
			
            System.out.println("\nYou have 4 attempts to guess the number...\n" + randomNumber);
			while(attempts != 0) {
				
				System.out.print("\nEnter a number: ");
				int guessedNumber = sc.nextInt();
				
				if(guessedNumber == randomNumber) {
					System.out.println("\nCongratulations your answer is correct!!\n");
                    score++;
                    break;
				}
				else if (guessedNumber > randomNumber) {
					System.out.println("\nYour guess is higher than the answer\n");
				}
				else {
					System.out.println("\nYour guess is lower than the answer\n");
				}
				attempts--;
				System.out.println(attempts + " attempts left...\n");
			}
		
			System.out.println("The random number was: " + randomNumber + "\n");
			System.out.println("Would you like to play again?\n Press Y to play again\n Press N to exit");
            String play = sc.next();
            
            if(!play.equals("Y"))
                playAgain = false;
		}
		
        System.out.println("Your score is: " + score);
	}
	
	
	public static void main(String[] args) { 		

		int choice;
		
		System.out.println("\nWelcome to the Number Game\n");
		System.out.println("Would you like to start the game?\n 1: Press 1 to start\n 2: Press 2 to exit\n");
		
		choice = sc.nextInt();
		
		choiceHandler(choice);
	}
}
