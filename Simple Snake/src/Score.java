/*Holds the object score including the current and top score. 
 * Note only holds top score for the game.
 * Each new part of the snake represents 10 points
* @author Jeremy Levett*/
public class Score {
	private static int topScore=0;
	private int currentScore=0;
		/**Updates the current score. If current score is greater than top score it will make it the new top score.
		 * Top score is static so every time a new round of snake occurs it will not be redeclared, hence hold its value. 
		 */
		public void updateCurrentScore() {
			currentScore = currentScore+10;
			if(currentScore>topScore)
				topScore = currentScore;
		}
		/**
		 * Returns the current score of the snake object.
		 * @return current score of the snake object
		 */
		public int getCurrentScore() {
			return currentScore;
		}
		/**Returns the highest score reached of the snake object during the instance of the game. 
		 * 
		 * @return highest score reached of the snake object during the instance of the game.
		 */
		public int getTopScore() {
			return topScore;
		}

}
