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
public class TeamB extends PlayerAbsract {

	public TeamB(String name, Image image, int id) {
		super(name, image, id);
		// TODO Auto-generated constructor stub
	}
	public static ArrayList <PlayerI> makeTeam (int numOfPlayersInTeam){
		 ArrayList <PlayerI> playerList=new ArrayList<PlayerI>();
		String name ;
		Image img;
		int id;
		PlayerI player;
		for (int i=1; i<numOfPlayersInTeam;) {
			//TODO 
			//name = ... //need to pass name from interface
			//img=...    // need to path name to piece file 
			id=i;
			//player = new TeamA(name,img, id);
			//playerList.add(player);
			
		}
		return playerList;
	}

	
}
