/*Contains the main method
* @author Jeremy Levett*/
import javax.swing.JFrame;

public class Main {
	public static void main(String...arg) {
		
		JFrame mainWindow = new JFrame();
		Game game = new Game();  //Create new game object
		
		mainWindow.add(game);
		
		mainWindow.setBounds(20,20,850,704); //create dimensions of the main window.
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setVisible(true);
		mainWindow.setResizable(false);
		mainWindow.addKeyListener(game);
		
		
	}
}
