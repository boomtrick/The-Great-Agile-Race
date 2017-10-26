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
	private final String playerName;
	private final Image playerPiece;
	private final int playerID;
	private PositionI playerPosition;
	private final TeamColor side;

	public PlayerAbsract(String name, Image image, int id, TeamColor team) {
		playerName=name;
		playerPiece=image;
		playerID=id;
		side=team;
		playerPosition= startingPosition();
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

	@Override
	public String getPlayerName() {
		return playerName;
	}

	@Override
	public Image getPlayerPiece() {
		return playerPiece;
	}

	@Override
	public int getPlayerID() {
		return playerID;
	}

	@Override
	public PositionI getPlayerPosition() {
		return playerPosition;
	}

	@Override
	public void setPlayerPosition(PositionI playerPosition) {
		this.playerPosition = playerPosition;
	}

    public static PositionI startingPosition() {
        return new Position();
    }

}
