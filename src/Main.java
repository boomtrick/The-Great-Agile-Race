import javax.swing.JFrame;

import Controllers.BoardController;

/**
 * Created by zalmangagerman on 10/8/17.
 */
public class Main {
    public static void main(String[] args) {
        //Main file
    	
    	JFrame frame = new JFrame("The Great Agile Race");
    	frame.add(new BoardController(7,10));
    	
    	frame.setLocationByPlatform(true);

        // ensures the frame is the minimum size it needs to be
        // in order display the components within it
        frame.pack();
        // ensures the minimum size is enforced.
        frame.setMinimumSize(frame.getSize());
        frame.setVisible(true);
    	
    }
}
