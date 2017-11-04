package Models;

import Config.BoardConstants.TeamColor;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static Config.BoardConstants.TeamColor.BLUE;
import static Config.BoardConstants.TeamColor.RED;

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
	private final BufferedImage playerPiece;
	private final int playerID;
	private PositionI playerPosition;
	private final TeamColor side;

	public PlayerAbsract(String name, BufferedImage image, int id, TeamColor team) {
		playerName=name;
		playerPiece=image;
		playerID=id;
		side=team;
		playerPosition= startingPosition();
	}

	public BufferedImage getGamePiece(){
		BufferedImage img = null;

		try
		{
			if (side == RED){//return red image

				img = ImageIO.read(new File("src/Views/Images/red-piece.png"));

			} else if (side == BLUE){

				img = ImageIO.read(new File("src/Views/Images/blue-piece.png"));
			}

			System.out.println("image found");
		}
		catch (IOException e) {
			System.out.println("No image found");
		}

		return img;
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
	public BufferedImage getPlayerPiece() {
		return playerPiece;
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
