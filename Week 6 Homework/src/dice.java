import javax.swing.JOptionPane;

public class dice {

	public static void main(String[] args) {

		String response;

		int wins = 0; // variable for how many wins
		int losses = 0; // variable for how many losses
		int gamesplayed = 0; // variable for how many times the game has been
								// played
		int numberodds = 0; // variable for how many times the dice has rolled
							// an odd number
		int numberevens = 0; // variable for how many times the dice has rolled
								// an even number

		do { // loops game based on while condition

			int diceroll = 1 + (int) (Math.random() * 6); // rolls number
															// between 1 and 6

			String dicerollanswer = String.valueOf(diceroll);
			JOptionPane.showMessageDialog(null, dicerollanswer); // displays
																	// answer to
																	// dice roll

			/* asks player whether they think the dice rolled even or odd */
			String odd_or_even = JOptionPane
					.showInputDialog("The dice was rolled. Do you think the answer was odd or even?");
			String guess = String.valueOf(odd_or_even);

			/*
			 * assigns odd to variable dice if it rolled 1,3, or 5; otherwise
			 * assigns even
			 */
			String dice = (diceroll == 1) || (diceroll == 3) || (diceroll == 5) ? "odd" : "even";

			/* adds to the even or odd counter based on dice roll */
			if ((diceroll == 1) || (diceroll == 3) || (diceroll == 5)) {
				numberodds++;
			} else if ((diceroll == 2) || (diceroll == 4) || (diceroll == 6)) {
				numberevens++;
			}

			/*
			 * displays win message if player guess and dice roll even/odd
			 * status match
			 */
			if (dice.equalsIgnoreCase(guess)) {
				String win = String.format("You are correct! You win!");
				JOptionPane.showMessageDialog(null, win);
				wins++;
			}

			/*
			 * displays lose message if player guess and dice roll even/odd
			 * status differ
			 */
			else if (!dice.equalsIgnoreCase(guess)) {
				String lose = String.format("You are wrong! You lose!");
				JOptionPane.showMessageDialog(null, lose);
				losses++;
			}

			/* adds 1 to the gamesplayed counter after every game played */
			gamesplayed++;

			/* displays wins and losses */
			String ratio = String.format("You have won %d time(s) and lost %d time(s).", wins, losses);
			JOptionPane.showMessageDialog(null, ratio);

			/* displays number of games played */
			String played = String.format("You have played %d game(s).", gamesplayed);
			JOptionPane.showMessageDialog(null, played);

			/* displays number of odds and evens the computer has generated */
			String oddsandevens = String.format("The system has generated %d odd and %d evens.", numberodds,
					numberevens);
			JOptionPane.showMessageDialog(null, oddsandevens);

			/*calculates win percentage*/
			int winpercent = (wins * 100)/gamesplayed;
			String percentage = String.format("Your win percentage is %d percent.", winpercent);
			JOptionPane.showMessageDialog(null, percentage);			
			
			/*
			 * displays input message asking if the player would like to play
			 * again
			 */
			String playAgain = JOptionPane.showInputDialog("Would you like to play again?");
			response = String.valueOf(playAgain);

			/*
			 * displays goodbye message if player inputs something other than
			 * yes
			 */
			if (!playAgain.equalsIgnoreCase("yes")) {
				String later = String.format("Goodbye.");
				JOptionPane.showMessageDialog(null, later);

			}

			/* loops game as long as the player inputs some variation of yes */
		} while (response.equalsIgnoreCase("yes"));

	}
}