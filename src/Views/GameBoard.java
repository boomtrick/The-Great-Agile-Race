package Views;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameBoard extends JFrame {

	private JFrame frame = new JFrame("The Great Agile Race");
	private JPanel board = null;
	private JButton btnNewPlayer = null;
	private JLabel txtBlueTeam = null;
	private JLabel txtRedTeam;
	private JButton btnAddPlayerRed;
	private JButton btnAddPlayerBlue;

	public GameBoard(){

	}
	
	public void run(){
		
		board = this.buildBoard(10,7);

		//frame.add(board);

		frame.setLocationByPlatform(true);

		//Init and create side panel
		JComponent sidePanel = new JPanel();
		JComponent filledSidePanel = this.buildSidePanel(sidePanel);


		//Split the frames to display
		JSplitPane pane = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT,
				board, filledSidePanel );
		frame.add(pane);


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

	public JComponent buildSidePanel(JComponent panelIn){

		this.btnNewPlayer = new JButton("New Player");
		this.btnAddPlayerRed = new JButton("Add Player");
		this.btnAddPlayerBlue = new JButton("Add Player");

		this.txtBlueTeam = new JLabel("Blue Team");
		this.txtRedTeam = new JLabel("Red Team");

		//When new game button is pressed, populate to ask for inputs
		btnAddPlayerRed.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

				btnNewPlayer.setVisible(false);
			}
		});




		//Makes layout vertical
		panelIn.setLayout(new BoxLayout(panelIn, BoxLayout.Y_AXIS));
		panelIn.add(txtBlueTeam);

		panelIn.add(btnAddPlayerBlue);
		panelIn.add(txtRedTeam);

		panelIn.add(btnAddPlayerRed);
		panelIn.add(btnNewPlayer);

		return panelIn;

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