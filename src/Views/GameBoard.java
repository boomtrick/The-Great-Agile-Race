package Views;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameBoard extends JFrame {

	private JFrame frame = new JFrame("The Great Agile Race");
	private JPanel board = null;
	public GameBoard(){
		
	}
	
	public void run(){
		
		board = this.buildBoard(10,7);
		
		frame.add(board);
		
		frame.setLocationByPlatform(true);


	    // ensures the frame is the minimum size it needs to be
	    // in order display the components within it
	    frame.pack();
	    // ensures the minimum size is enforced.

	    frame.setMinimumSize(board.getPreferredSize());
	    //frame.setResizable(false);
	    frame.setVisible(true);

	    Dialogue dialogue = new Dialogue();
	    dialogue.welcomeMessage(frame);

	}
	
	public JPanel buildBoard(int height , int width)
	{

		JPanel board = new Board(height,width, this.getImage());
		return board;
		
	}
	
	private BufferedImage getImage()
	{
		BufferedImage img = null;
	    
		try 
		{ 
			//img = ImageIO.read(new File("C:\\Users\\Mark\\Documents\\The-Great-Agile-Race\\src\\Views\\Images\\board.png"));
	         img = ImageIO.read(new File("src/Views/Images/board.png"));
	         System.out.println("image found");
	     } 
			catch (IOException e) {
	         System.out.println("No image found");
	     }
		
		return img;
	
	}

	private void createUIComponents() {
		// TODO: place custom component creation code here
	}
}