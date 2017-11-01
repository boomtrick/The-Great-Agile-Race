package Views;

import Controllers.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static Config.BoardConstants.TeamColor.RED;

public class GameBoard extends JFrame {

	private JFrame frame = new JFrame("The Great Agile Race");
	private JPanel board = null;
	private JButton btnStartGame = null;
	private JLabel txtBlueTeam = null;
	private JLabel txtRedTeam;
	private JButton btnAddPlayerRed;
	private JButton btnAddPlayerBlue;
	private List<JLabel> lblPlayersBlue = new ArrayList<JLabel>();
	private List<JLabel> lblPlayersRed = new ArrayList<JLabel>();

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

		//Code for action listeners

		ActionListener addPlayerListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event){
				JButton button = (JButton) event.getSource();

				//}
				if(button.equals(btnAddPlayerRed)){
					BufferedImage img = null;
					String name = JOptionPane.showInputDialog("Welcome to Team Red.  What's your name? ");
					if (!name.isEmpty()){
						try {
							img = ImageIO.read(new File("src/Views/Images/red-piece.png"));
						} catch (IOException e) {
							e.printStackTrace();
						}
						lblPlayersRed.get(0).setText(name);
						Player newPlayer = new Player(name, img, 1, RED);
						//newPlayer.setPlayerPosition();
						//put a new piece on the board

					}

				}
				if(button.equals(btnAddPlayerBlue)){
					String name = JOptionPane.showInputDialog("Welcome to Team Blue.  What's your name? ");
					if (!name.isEmpty()){
						lblPlayersBlue.get(0).setText(name);
						//put a new piece on the board

					}
				}
			}
		};


		//Add listeners here for side panel
		btnAddPlayerBlue.addActionListener(addPlayerListener);
		btnAddPlayerRed.addActionListener(addPlayerListener);
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