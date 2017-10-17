package Controllers;

import java.awt.Image;
import java.util.ArrayList;
/**
 * 
 * @author Azamat
 *This is concrete class for player objects;
 *I provided two seperate identical classes for Team A and Team B, so that there is clear seperation between teams
 *
 */
public class Team extends PlayerAbsract{

	public Team(String name, Image image, int id) {
		super(name, image, id);
		
	}
	@SuppressWarnings("hiding")
	public static ArrayList <PlayerI> makeTeam (int numOfPlayersInTeam){
		/**
		 * the methods creates ArrayList of player objects 
		 */
		 ArrayList <PlayerI> playerList = new ArrayList<Controllers.PlayerI>();
		String name = null;
		Image img = null;
		int id;
		PlayerI player;
		for (int i=1; i<numOfPlayersInTeam;) {
			//TODO
			//name = ... //need to pass name from interface
			//img=...    // need to path name to piece file

			id=i;
			player = new Team(name,img, id);
			playerList.add(player);
			
		}
		return playerList;
	}

}
