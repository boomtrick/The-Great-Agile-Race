package Controllers;

import Config.BoardConstants.TeamColor;

import java.awt.*;
/**
 * 
 * @author Azamat
 * This abstract class for player objects 
 * Each object has a its name, a piece, Id number to differentiate from other players 
 * When object is created, its position is set to 0,0 before rolling dice. Therefore, it can not be seen before rolling dice
 *
 */

public abstract class PlayerAbsract implements PlayerI  {
	private String playerName; 
	private Image playerPiece;
	private int playerID;
	private Position playerPosition;
	private TeamColor side;
	public PlayerAbsract(String name, Image image, int id, TeamColor team) {
		playerName=name;
		playerPiece=image;
		playerID=id;
		side=team;
		playerPosition=new Position();
		
	}
	

	@Override
	public void move(int i, int j) {
		playerPosition.setPosition(i, j);
	}

	@Override
	public int getId() {
		return playerID;
	}

	@Override
	public TeamColor getTeam() {
		return side;
	}


	public String getPlayerName() {
		return playerName;
	}


	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}


	public Image getPlayerPiece() {
		return playerPiece;
	}


	public void setPlayerPiece(Image playerPiece) {
		this.playerPiece = playerPiece;
	}


	public int getPlayerID() {
		return playerID;
	}


	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}


	public Position getPlayerPosition() {
		return playerPosition;
	}


	public void setPlayerPosition(Position playerPosition) {
		this.playerPosition = playerPosition;
	}

}
