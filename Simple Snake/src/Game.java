/*This class is in charge of running the gameplay of snake
 * @author Jeremy Levett*/
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements ActionListener,KeyListener{

	private static final long serialVersionUID = 1L;
	private ImageIcon imageTitle = new ImageIcon("snaketitle850_53.jpg");
	private ImageIcon flashImg = new ImageIcon("replay355_200.jpg");
	
	private ImageIcon frontUpSnakeImg = new ImageIcon("FrontUp.png");
	private ImageIcon frontDownSnakeImg = new ImageIcon("FrontDown.png");
	private ImageIcon frontRightSnakeImg = new ImageIcon("FrontRight.png");
	private ImageIcon frontLeftSnakeImg = new ImageIcon("FrontLeft.png");
	private ImageIcon normalSnakeImg  = new ImageIcon("Normal.png");
	private ImageIcon fruitImg  = new ImageIcon("Fruit.png");
	
	private Snake snake;
	private Fruit fruit;
	private Score score;
	private Timer timer;
	private int delay =100;
	private String direction;
	private boolean gamePause = true;
/**
 * Constructor starts the timer for the new game
 */
	Game(){	
		startNewGame();
		addKeyListener(this);		
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
	}
/**
 * Creates a new snake, fruit and score object. Essentially starting the game.
 */
	public void startNewGame() {
		snake = new Snake();
		direction = "right";
		fruit = new Fruit(33,24,snake.getSnake());
		score = new Score();//make a new score
	}
/**
 * Paints each frame in essence providing the graphics for the game.
 */
	public void paint(Graphics graphics) {
		drawBasicLayout(graphics);
		drawScore(graphics); 
  	    gamePlay(graphics);
		graphics.dispose();		
	}		
/**
 * Draws the basic graphics 
 * @param graphics provided by JPanel.
 */
	public void drawBasicLayout(Graphics graphics) {
		imageTitle.paintIcon(this, graphics, 0,0 );
		graphics.setColor(Color.GREEN);
		graphics.drawRect(0, 0, 843, 53);
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0,54,850,704);
	}
	
	/**
	 * Logic for making the game create new fruit, updating score, pause screen and snake.
	 * @param graphics provided by JPanel.
	 */
	public void gamePlay(Graphics graphics) {
		if(snake.snakeOnSelf()) {
			gamePause = true;	
	  	    startNewGame();
	  	}	  	    
	    if(gamePause) {
	    		graphics.setColor(Color.GREEN);
	    		graphics.drawRect(249, 199, 356, 201);
	    		flashImg.paintIcon(this, graphics, 250,200 );
	    }else{
			printFruit(graphics);
	  	    if(isSnakeHeadOnFruit(fruit.getfruitLocation())) {
				fruit = new Fruit(33,24, snake.getSnake());
				score.updateCurrentScore();
				printSnake(graphics, true);
	  	    }else 
	  	    	printSnake(graphics, false);
	    }   
	}
	 /**
	  * Draw the score 
	  * @param graphics provided by JPanel.
	  */
	public void drawScore(Graphics graphics) {
		graphics.drawString(("Current Score: "+ score.getCurrentScore()),600, 25);
		graphics.drawString(("Top Score:"+ score.getTopScore()), 600, 40);
	}
	/**
	 * Draw the fruit
	 * @param graphics provided by JPanel.
	 */
	public void printFruit(Graphics graphics) {
		fruitImg.paintIcon(this, graphics, 0+fruit.getfruitLocation()[0]*25, 54+fruit.getfruitLocation()[1]*25);
	}
	/**
	 * Logic for checking if the snakes head is on a fruit piece 
	 * @param fruitPos
	 * @return boolean type, true if the snakes head is on a fruit piece 
	 */
	public boolean isSnakeHeadOnFruit(int[] fruitPos){
		ArrayList<int[]> currentSnake = snake.getSnake(); 
		if(currentSnake.get(0)[0]==fruitPos[0]&&currentSnake.get(0)[1]==fruitPos[1])
			return true;
		else 
			return false;
	}
	/**Logic for updating the snake and printing the graphics for the snake based on its current direction and current position
	 */
	public void printSnake(Graphics graphics, boolean fruitEaten){
		ArrayList<int[]> currentSnake = snake.updateSnake(direction, fruitEaten);  
		boolean headpart = true;		
		for(int[] pos : currentSnake) {
			
			if(headpart) {
				switch(direction) {
				case("up"):		frontUpSnakeImg.paintIcon(this, graphics, (0+pos[0]*25),(54+pos[1]*25));	
								break;
				case("down"):	frontDownSnakeImg.paintIcon(this, graphics, (0+pos[0]*25),(54+pos[1]*25));	
							  	break;
				case("left"): 	frontLeftSnakeImg.paintIcon(this, graphics, (0+pos[0]*25),(54+pos[1]*25));	
				  			  	break;
				case("right"): 	frontRightSnakeImg.paintIcon(this, graphics, (0+pos[0]*25),(54+pos[1]*25));	
	  			}
				headpart = false;
			}else 
				normalSnakeImg.paintIcon(this, graphics, (0+pos[0]*25),(54+pos[1]*25));		
		}
	}
	@Override
	/**
	 * Repaints at the set timer interval. 
	 */
	public void actionPerformed(ActionEvent e) {
				repaint();
	}
	/**
	 * Logic for the key pressed. 
	 * Up, Down, Left, Right Key provide direction of the snake 
	 * Enter Key starts the game and pauses/continues it.
	 */
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_RIGHT && !direction.equals("left")) 
			direction = "right";
		else if(e.getKeyCode()==KeyEvent.VK_LEFT && !direction.equals("right")) 
			direction = "left";
		else if(e.getKeyCode()==KeyEvent.VK_UP && !direction.equals("down")) 
			direction = "up";
		else if(e.getKeyCode()==KeyEvent.VK_DOWN && !direction.equals("up")) 
			direction = "down";
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			gamePause = !gamePause;
		}
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) { 	
	}
	
	@Override
	public void keyTyped(KeyEvent e) {	
	}

}