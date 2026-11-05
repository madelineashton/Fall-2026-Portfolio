import java.util.*;
public class RockPaperScissors {
	
	// welcome statement
	public static void welcome() {
		System.out.println("Welcome to 'Rock, Paper, Scissors'!'");
	}
	
	// prompting user
	public static int userMove() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please make your move: choose 1 for rock, 2 for paper, or 3 for scissors");
		int userMove = scan.nextInt();
		return userMove;
	}
	
	// randomize opponent move
	public static int CPUMove() {
		Random random = new Random();
		int CPUMove = random.nextInt(3) + 1;
		return CPUMove;
	}
	
	// determine result
	public static int compare(int userMove, int CPUMove) {
		if(userMove == CPUMove) {
			System.out.println("It's a tie!");
			return 3;
		}else if(userMove == 1 && CPUMove == 2) {
			System.out.println("You picked rock. CPU picked paper. YOU LOSE!");
			return 2;
		}else if(userMove == 1 && CPUMove == 3) {
			System.out.println("You picked rock. CPU picked scissors. YOU WIN!");
			return 1;
		}else if(userMove == 2 && CPUMove == 1) {
			System.out.println("You picked paper. CPU picked rock. YOU WIN!");
			return 1;
		}else if(userMove == 2 && CPUMove == 3) {
			System.out.println("You picked paper. CPU picked scissors. YOU LOSE!");
			return 2;
		}else if(userMove == 3 && CPUMove == 1) {
			System.out.println("You picked scissors. CPU picked rock. YOU LOSE!");
			return 2;
		}else
			return 1;
	}
	

	public static void main(String[] args) {
		boolean playAgain = true;
		boolean validInput = false;
		int userScore = 0;
		int CPUScore = 0;
		int numTies = 0;
		int userMove;
		// execute game
		do {
			welcome();
			// data validation
			do{
				userMove = userMove();
				try {
					if(userMove == 1 || userMove == 2 || userMove == 3) {
						validInput = true;
					}else
						throw new Exception("Invalid input. Try again!");
				}catch(Exception e) {
					System.out.println(e.getMessage());
					validInput = false;
				}
			}while(!validInput);
			
			int CPUMove = CPUMove();
			
			// compute score
			int result = compare(userMove, CPUMove);
			if(result == 1)
				userScore++;
			else if(result == 2)
				CPUScore++;
			else
				numTies++;
			
			// output score
			System.out.println("User: " + userScore + ", CPU: " + CPUScore + ", Ties: " + numTies);
			
			// prompt user to play again
			Scanner scan = new Scanner(System.in);
			System.out.println("Do you want to play again? Enter 1 for 'yes' or something else for 'no': ");
			int decision = scan.nextInt();
			if(decision == 1) {
				System.out.println();
				playAgain = true;
			}else{
				System.out.println("Thank you for playing. Goodbye!");
				playAgain = false;
			}
				
		}while(playAgain);

	}

}
