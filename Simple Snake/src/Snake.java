/*Holds position of the snake and updates it length when required
 * * @author Jeremy Levett*/
import java.util.ArrayList;

public class Snake{
	
	private ArrayList<int[]> snakePos = new ArrayList<>();
	
	/**
	 * Constructor creates a default snake of 15 positions
	 */
	public Snake(){
		for(int i=20; i>0; i--)
			snakePos.add(new int[] {i+5,15});
	
	}
	/**Updates the snake position arraylist based on the direction of the snake list, if it has eaten fruit.
	 * 	 * 
	 * @param Direction string that can either be up,down,left or right. 
	 * @param fruitEaten a boolean that indicates if a fruit is eaten or not
	 * @return another arraylist object that contains the snake positions. 
	 * This arraylist could be altered as it is not the original object of the snake position .
	 */
	public ArrayList<int[]> updateSnake(String direction, boolean fruitEaten) {
		if(direction.equals("up")) 
			if(snakePos.get(0)[1]==0)
				snakePos.add(0,new int[] {snakePos.get(0)[0],24});
			else			
			snakePos.add(0,new int[] { snakePos.get(0)[0],snakePos.get(0)[1]-1});
		else if(direction.equals("down")) 
			if(snakePos.get(0)[1]==24)
				snakePos.add(0,new int[] {snakePos.get(0)[0],0});
			else
				snakePos.add(0,new int[] {snakePos.get(0)[0],snakePos.get(0)[1]+1});
		else if(direction.equals("right")) 
			if(snakePos.get(0)[0]==33)
				snakePos.add(0,new int[] {0,snakePos.get(0)[1]});
			else
				snakePos.add(0,new int[] {snakePos.get(0)[0]+1,snakePos.get(0)[1]});
		else if(direction.equals("left")) 
			if(snakePos.get(0)[0]==0)
				snakePos.add(0,new int[] {33,snakePos.get(0)[1]});
			else
				snakePos.add(0,new int[] {snakePos.get(0)[0]-1,snakePos.get(0)[1]});	
		
		if(!fruitEaten)
			snakePos.remove((snakePos.size()-1));

		return new ArrayList<>(snakePos);
	}
	/**Returns a new arraylist of object of the snakes x and y positions
	 * 
	 * @return another arraylist object that contains the snake positions. 
	 * This arraylist could be altered as it is not the original object of the snake position .
	 */
	public ArrayList<int[]> getSnake(){
		return new ArrayList<>(snakePos);	
	}
	
	/**
	 * Checks if the snake is ontop of its self. In other words
	 * if it contains the same int array values (snake position) in the list
	 * @return a boolean. True if it is on its self. False if it is not on its self.
	 */
	public boolean snakeOnSelf() {
		int count=0;
		for(int[] i : snakePos)
			for(int[] u: snakePos)
				if(i[0]== u[0] && i[1]==u[1])
					count++;
		if(count>snakePos.size()) {
			return true;
			}
		else 
			return false;
	}
}
