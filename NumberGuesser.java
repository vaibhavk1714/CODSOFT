import java.util.*;

public class NumberGuesser {
	
	static Scanner sc = new Scanner(System.in);
	static Random r = new Random();
	
	public static void choiceHandler(int choice) {
		
		// Do appropriate tasks according to user choice
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
		// Initialize necessary variables such as score and a boolean to track if user wants to play again
		boolean playAgain = true;
        	int score = 0;
		
		// If user wants to play again then repeat the steps
		while(playAgain) {
			int attempts = 4;
			int randomNumber = r.nextInt(100) + 1; // Random number generation
			
            		System.out.println("\nYou have 4 attempts to guess the number...\n" + randomNumber);
			while(attempts != 0) {
				
				System.out.print("\nEnter a number: ");
				int guessedNumber = sc.nextInt();
				
				// If the guess is correct we increment the score else we assist the user with some hints
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
			
			// Print the random number and query if the user wants to play again
			System.out.println("The random number was: " + randomNumber + "\n");
			System.out.println("Would you like to play again?\n Press Y to play again\n Press N to exit");
            		String play = sc.next();
			
			// If the user does'nt  want to play then exit the loop
	           	if(!play.equals("Y"))
	                	playAgain = false;
		}
			
		// Print the final score
        	System.out.println("Your score is: " + score);
	}
	
	
	public static void main(String[] args) { 		

		int choice;
		
		System.out.println("\nWelcome to the Number Game\n");

		//Give choice to user about the game
		System.out.println("Would you like to start the game?\n 1: Press 1 to start\n 2: Press 2 to exit\n");
		choice = sc.nextInt();
		
		choiceHandler(choice);
	}
}
