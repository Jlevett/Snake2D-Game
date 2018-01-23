/*Creates a valid fruit and holds its x & y location
 * @author Jeremy Levett*/

import java.util.ArrayList;

public class Fruit {
	private int fruitXLocation;
	private int fruitYLocation;
	
	/**
	 * Constructor that creates fruit in valid location
	 * ie location is within bounds of game and not made in the location of the snkae
	 * 
	 * @param xSize the x bounds of the game
	 * @param ySize the y bounds of the game
	 * @param snake the list of the x,y positions of the current snake.
	 */
	Fruit(int xSize, int ySize, ArrayList<int[]> snake){
		ArrayList<int[]> grid = new ArrayList<>();
			for(int y=0;y<ySize; y++)
				for(int x=0;x<xSize; x++)
					grid.add(new int[] {x, y});
		grid.removeAll(snake);
		int randomIndex = (int)(Math.random()*(double)(grid.size()+1));
		
		fruitXLocation = grid.get(randomIndex)[0];
		fruitYLocation = grid.get(randomIndex)[1];
	}
	/**
	 * Returns the x and y location of the fruit object
	 * 
	 * @return the x and y location of the fruit as an array of ints.
	 */
	public int[] getfruitLocation(){
		return new int[]{fruitXLocation, fruitYLocation};
	}

}
