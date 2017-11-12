package Views;

import Config.BoardConstants.TeamColor;
import Controllers.BoardController;
import Models.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static Config.BoardConstants.COL_SIZE;
import static Config.BoardConstants.ROW_SIZE;

public class GameBoard extends JFrame implements ActionListener{

	private BoardController gameMaster;
	private JFrame frame = new JFrame("The Great Agile Race");
	private Board board = null;

	private JTextArea gameLog;
	private JScrollPane scroll;
	private JLabel txtBlueTeam = null;
	private JLabel txtRedTeam;

	private JButton btnRollDice;
	private JButton btnAddPlayerBlue;
	private JButton btnAddPlayerRed;
	private JButton btnStartGame = null;
	private List<JLabel> lblPlayersBlue = new ArrayList<JLabel>();
	private List<JLabel> lblPlayersRed = new ArrayList<JLabel>();
	private JSplitPane pane;
	private JComponent filledSidePanel;

	private String [] redPieces;
	private String [] bluePieces;
	private String [] diceImages;

    private final String EMPTY_SLOT = "<EMPTY SLOT>";

	List<Player> redPlayers = new ArrayList<Player>();
	List<Player> bluePlayers = new ArrayList<Player>();
	public GameBoard(){
	}

	public void run(){

		board = this.buildBoard(COL_SIZE,ROW_SIZE);

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

	//Shows a fact that's randomized
	public void triggerRandomFact(){
		Random rand = new Random();
		int n = rand.nextInt(25)+1;
		Fact newFact = new Fact(n);
		//Shows random fact
		JOptionPane.showMessageDialog(frame, newFact.getText());
		//Note that player has seen the fact
	}

	public JComponent buildSidePanel(JComponent panelIn){


		this.gameLog = new JTextArea(20,10);
		this.scroll = new JScrollPane(gameLog);

		this.btnStartGame = new JButton("Start Game");
		this.btnRollDice = new JButton("Roll Dice");
		this.btnRollDice.setVisible(false);
		this.btnAddPlayerRed = new JButton("Add Player");
		this.btnAddPlayerBlue = new JButton("Add Player");

		this.txtBlueTeam = new JLabel("Blue Team");
		this.txtRedTeam = new JLabel("Red Team");

		//Create labels for player names
		for (int i = 0; i <4; i++){
			lblPlayersBlue.add(i, new JLabel(EMPTY_SLOT));
			lblPlayersRed.add(i, new JLabel(EMPTY_SLOT));
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
		panelIn.add(btnRollDice);

		//Adds in the game log
		panelIn.add(scroll);
		//Add listeners here for side panel
		btnAddPlayerBlue.addActionListener(this);
		btnAddPlayerRed.addActionListener(this);
		btnStartGame.addActionListener(this::buttonEvent);
		btnRollDice.addActionListener(this::buttonEvent);
		return panelIn;

	}

	public void actionPerformed(ActionEvent event){
		buttonEvent(event);
		frame.repaint();
	}

	private void buttonEvent(ActionEvent event) {
		JButton button = (JButton) event.getSource();


		TeamI redTeam = new Team(TeamColor.RED);
		TeamI blueTeam = new Team(TeamColor.BLUE);

		if(button.equals(btnAddPlayerRed)){
			String name = JOptionPane.showInputDialog(frame,"Welcome to Team Red.  What's your name? ");
            if (!name.isEmpty()){
				for(int i = 0; i < lblPlayersRed.size(); i++) {
					if(lblPlayersRed.get(i).getText().equals(EMPTY_SLOT)) {
						lblPlayersRed.get(i).setText(name);
                        gameLog.append(name +" added to Red Team.\n");
                        Player newPlayer = new Player(name,i, TeamColor.RED,redPlayers.size());
                        redPlayers.add(newPlayer);
						board.initPieces(newPlayer);
						break;
                    } } } }

        if(button.equals(btnAddPlayerBlue)){
			String name = JOptionPane.showInputDialog("Welcome to Team Blue.  What's your name? ");

			if (!name.isEmpty()){
				for(int i = 0; i < lblPlayersBlue.size(); i++)  {
					if(lblPlayersBlue.get(i).getText().equals(EMPTY_SLOT))  {
						lblPlayersBlue.get(i).setText(name);
                        gameLog.append(name +" added to Blue Team.\n");
                        Player newPlayer = new Player(name,i, TeamColor.BLUE,bluePlayers.size());
                        bluePlayers.add(newPlayer);
						board.initPieces(newPlayer);
						//board.initPieces(blueTeam.addPlayerByName(name, i));
						break;
                    } } } }

		/*Look at what's been filled in and create board base d on that*/
		if(button.equals(btnStartGame)){

			SetupGame();

			gameLog.append("Game START.\n");
			btnAddPlayerBlue.setVisible(false);
			btnAddPlayerRed.setVisible(false);

		}
		/*Look at what's been filled in and create board base d on that*/
		if(button.equals(btnRollDice)){

			RollDice();

			triggerRandomFact();

		}
	}

	private void RollDice() {
		Dice rollDice = new Dice();
		int rollNum = rollDice.roll();
		gameLog.append("Dice rolled "+rollNum+".\n");
	}

	private void SetupGame() {

		int bluePlayerCount = 0;
		for(int i = 0; i < lblPlayersBlue.size(); i++)
		{
			if(!lblPlayersBlue.get(i).getText().equals(EMPTY_SLOT))
			{
				bluePlayerCount++;


			}
		}
		//Count for red
		int redPlayerCount = 0;
		for(int i = 0; i < lblPlayersRed.size(); i++)
		{
			if(!lblPlayersRed.get(i).getText().equals(EMPTY_SLOT))
			{
				redPlayerCount++;
			}
		}
		//create team

		//Team blueTeam = new Team(TeamColor.BLUE, bluePlayers);
		Team redTeam = new Team(TeamColor.RED);

		System.out.println(bluePlayerCount);
		System.out.println(redPlayerCount);



		//Hide startgame button
		btnStartGame.setVisible(false);
		btnRollDice.setVisible(true);
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