package Views;

import javax.imageio.ImageIO;
import javax.swing.*;

import Config.BoardConstants.TeamColor;
import Controllers.BoardController;
import Models.Player;
import Models.Team;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameBoard extends JFrame implements ActionListener{

	private BoardController boardController;
	private JFrame frame = new JFrame("The Great Agile Race");
	private Board board = null;
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


	public Board buildBoard(int height , int width)
	{

		Board board = new Board(height,width, this.getImage());
		return board;

	}

	public JComponent buildSidePanel(JComponent panelIn){

		this.btnStartGame = new JButton("Start Game");
		this.btnAddPlayerRed = new JButton("Add Player");
		this.btnAddPlayerBlue = new JButton("Add Player");

		this.txtBlueTeam = new JLabel("Blue Team");
		this.txtRedTeam = new JLabel("Red Team");

		//Create labels for player names
				for (int i = 0; i <= 6; i++){
					lblPlayersBlue.add(i, new JLabel("<Empty Slot>"));
					lblPlayersRed.add(i, new JLabel("<Empty Slot>"));
				}

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
		btnStartGame.addActionListener(this::buttonEvent);
		return panelIn;

	}

	public void actionPerformed(ActionEvent event){
		buttonEvent(event);
		frame.repaint();
	}

	private void buttonEvent(ActionEvent event) {
		JButton button = (JButton) event.getSource();



		if(button.equals(btnAddPlayerRed)){
			String name = JOptionPane.showInputDialog(frame,"Welcome to Team Red.  What's your name? ");
			if (!name.isEmpty()){
				
				for(int i = 0; i < lblPlayersRed.size(); i++)
				{
					if(lblPlayersRed.get(i).getText().equals("<Empty Slot>"))
					{
						lblPlayersRed.get(i).setText(name);
						Player player = null;
						
						try {
							player = new Player (name, ImageIO.read(new File("src/Views/Images/red-piece_1.png")), i,TeamColor.RED);
						
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						board.initPieces(player);
						break;
					}
					
				}
			}

		}
		if(button.equals(btnAddPlayerBlue)){
			String name = JOptionPane.showInputDialog("Welcome to Team Blue.  What's your name? ");
			if (!name.isEmpty()){
				for(int i = 0; i < lblPlayersBlue.size(); i++)
				{
					if(lblPlayersBlue.get(i).getText().equals("<Empty Slot>"))
					{
						lblPlayersBlue.get(i).setText(name);
						
						Player player = null;
						
						try {
							player = new Player (name, ImageIO.read(new File("src/Views/Images/blue-piece.png")), i,TeamColor.BLUE);
						
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						board.initPieces(player);
						
						break;
					}
					
				}

			}
		}

		/*Look at what's been filled in and create board base d on that*/
		if(button.equals(btnStartGame)){

			//create the teams
			//create the players

			//check how many names were filled in
			//save that count

			//Count for blue
			int bluePlayerCount = 0;
			for(int i = 0; i < lblPlayersBlue.size(); i++)
			{
				if(!lblPlayersBlue.get(i).getText().equals("<Empty Slot>"))
				{
					bluePlayerCount++;
				}
			}
			//Count for red
			int redPlayerCount = 0;
			for(int i = 0; i < lblPlayersRed.size(); i++)
			{
				if(!lblPlayersRed.get(i).getText().equals("<Empty Slot>"))
				{
					bluePlayerCount++;
				}
			}
			//create team

			Team blueTeam = new Team(TeamColor.BLUE, bluePlayerCount);
			Team redTeam = new Team(TeamColor.RED, redPlayerCount);

			System.out.println(bluePlayerCount);
			System.out.println(redPlayerCount);

			//need to initialize pieces

		}
	}


	private BufferedImage getImage()
	{
		BufferedImage img = null;
	    
		try 
		{ 
	         img = ImageIO.read(new File("src/Views/Images/board.png"));
	         System.out.println("image found");
	     } 
			catch (IOException e) {
	         System.out.println("No image found");
	     }
		
		return img;
	
	}
}