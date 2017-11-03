package Views;

import javax.imageio.ImageIO;
import javax.swing.*;

import Config.BoardConstants.TeamColor;
import Models.Player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameBoard extends JFrame implements ActionListener{

	private JFrame frame = new JFrame("The Great Agile Race");
	private JPanel board = null;
	private JButton btnStartGame = null;
	private JLabel txtBlueTeam = null;
	private JLabel txtRedTeam;
	private JButton btnAddPlayerRed;
	private JButton btnAddPlayerBlue;
	private List<JLabel> lblPlayersBlue = new ArrayList<JLabel>();
	private List<JLabel> lblPlayersRed = new ArrayList<JLabel>();
	private JSplitPane pane;
	private JComponent filledSidePanel;

	public GameBoard(){

	}
	
	public void run(){
		
		board = this.buildBoard(10,7);

		//frame.add(board);

		frame.setLocationByPlatform(true);

		//Init and create side panel
		JComponent sidePanel = new JPanel();
		filledSidePanel = this.buildSidePanel(sidePanel);


		//Split the frames to display
		pane = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT,
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

		this.btnStartGame = new JButton("Start Game");
		this.btnAddPlayerRed = new JButton("Add Player");
		this.btnAddPlayerBlue = new JButton("Add Player");

		this.txtBlueTeam = new JLabel("Blue Team");
		this.txtRedTeam = new JLabel("Red Team");

		setUpTeams();

		//Makes layout vertical
		panelIn.setLayout(new BoxLayout(panelIn, BoxLayout.Y_AXIS));
		panelIn.add(txtBlueTeam);

		for (JLabel player : lblPlayersBlue){
			panelIn.add(player);
		}

		panelIn.add(btnAddPlayerBlue);
		panelIn.add(txtRedTeam);

		for (JLabel player : lblPlayersRed){
			panelIn.add(player);
		}
		panelIn.add(btnAddPlayerRed);
		panelIn.add(btnStartGame);

		//Add listeners here for side panel
		btnAddPlayerBlue.addActionListener(this);
		btnAddPlayerRed.addActionListener(this);
		return panelIn;

	}
	
	private JComponent updateSidePanel()
	{
		JComponent panelIn = new JPanel();
		this.btnStartGame = new JButton("Start Game");
		this.btnAddPlayerRed = new JButton("Add Player");
		this.btnAddPlayerBlue = new JButton("Add Player");

		this.txtBlueTeam = new JLabel("Blue Team");
		this.txtRedTeam = new JLabel("Red Team");

		//Makes layout vertical
		panelIn.setLayout(new BoxLayout(panelIn, BoxLayout.Y_AXIS));
		panelIn.add(txtBlueTeam);

		for (JLabel player : lblPlayersBlue){
			panelIn.add(player);
		}

		panelIn.add(btnAddPlayerBlue);
		panelIn.add(txtRedTeam);

		for (JLabel player : lblPlayersRed){
			panelIn.add(player);
		}
		panelIn.add(btnAddPlayerRed);
		panelIn.add(btnStartGame);
		
		return panelIn;
	}

	/**
	 *  This updates board whenever a change occurs.
	 */
	private void updateBoard()
	{
	
		frame.repaint();
	}
	
	public void actionPerformed(ActionEvent event){
		JButton button = (JButton) event.getSource();
		//}
		if(button.equals(btnAddPlayerRed)){
			String name = JOptionPane.showInputDialog(frame,"Welcome to Team Red.  What's your name? ");
			if (!name.isEmpty()){
				//put a new piece on the board
				
				for(int i = 0; i < lblPlayersRed.size(); i++)
				{
					if(lblPlayersRed.get(i).getText().equals("<Empty Slot>"))
					{
						lblPlayersRed.get(i).setText(name);
						//TO DO add player to board controller.
						break;
					}
					
				}
				
				updateBoard();

			}

		}
		if(button.equals(btnAddPlayerBlue)){
			String name = JOptionPane.showInputDialog("Welcome to Team Blue.  What's your name? ");
			if (!name.isEmpty()){
				//put a new piece on the board

			}
		}
	}
	
	
	private void setUpTeams()
	{
		//Create labels for player names
		for (int i = 0; i <= 6; i++){
			lblPlayersBlue.add(i, new JLabel("<Empty Slot>"));
			lblPlayersRed.add(i, new JLabel("<Empty Slot>"));
		}
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