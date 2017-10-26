package Views;

import Controllers.TileController;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static Config.BoardConstants.TeamColor.BLUE;
import static Config.BoardConstants.TeamColor.RED;

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
	         img = ImageIO.read(new File("/Views/Images/board.png"));
	         System.out.println("image found");
	     } 
			catch (IOException e) {
	         System.out.println("No image found");
	     }
		
		return img;
	
	}
		
}