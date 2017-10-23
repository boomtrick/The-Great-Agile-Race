import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import Views.*;

/**
 * Created by zalmangagerman on 10/8/17.
 */
public class Main {
    public static void main(String[] args) {
        //Main file
    	
    	JFrame frame = new JFrame("The Great Agile Race");
    	JPanel board = new Board(10,7);
    	 BufferedImage img = null;
         try {
             img = ImageIO.read(new File("C:\\Users\\Mark\\Documents\\The-Great-Agile-Race\\src\\Views\\Images\\board.png"));
             System.out.println("image found");
         } catch (IOException e) {
             System.out.println("No image found");
         }
         

         BackgroundPanel t = new BackgroundPanel(img);
         t.setTransparentAdd(false);
         frame.setContentPane(t);
    	frame.add(board);
    	
    	frame.setLocationByPlatform(true);

        // ensures the frame is the minimum size it needs to be
        // in order display the components within it
        frame.pack();
        // ensures the minimum size is enforced.

        frame.setMinimumSize(board.getPreferredSize());
        frame.setVisible(true);



    	
    }
}
