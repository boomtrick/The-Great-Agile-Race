package Models;

import Config.BoardConstants.TeamColor;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static Config.BoardConstants.BLUE_PIECE_FILE;
import static Config.BoardConstants.IMAGE_ENDING;
import static Config.BoardConstants.RED_PIECE_FILE;
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
public class Player implements PlayerI {

	private final String playerName;
	private BufferedImage playerPiece;
	private final int playerID;
	private PositionI playerPosition;
	private final TeamColor side;
	private ArrayList<Integer> knownFactIDs;

	public Player(String name, int id, TeamColor team, int teamMemberNum) {
		assert teamMemberNum <= 4;
        assert teamMemberNum >= 0;
        playerName=name;
		playerID=id;
		side=team;
        playerPosition= startingPosition();
        try {
            if (side == RED){
                playerPiece = ImageIO.read(new File(RED_PIECE_FILE + teamMemberNum + IMAGE_ENDING));
            } else if (side == BLUE){
                playerPiece = ImageIO.read(new File(BLUE_PIECE_FILE + teamMemberNum + IMAGE_ENDING));
            } else {
                System.out.println("image found");
            }
        }
        catch (IOException e) {
            System.out.println("No image found");
            playerPiece = null;
        }
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
	public void rememberFact(FactI factIn){
		knownFactIDs.add(factIn.getId());
	}

	@Override
	public boolean checkIfKnowsFact(FactI factIn) {
		//if player knows fact
		if(knownFactIDs.contains(factIn.getId())){
			return true;
		}
		return false;
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
