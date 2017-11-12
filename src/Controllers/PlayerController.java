package Controllers;

import Config.BoardConstants;
import Models.Player;
import Models.Position;

import java.util.ArrayList;
import java.util.HashMap;

public class PlayerController {
    private ArrayList <Player> teamRed_;
    private ArrayList <Player>teamBlue_;
    private Player currentPlayer;
    HashMap<Position, Position> sprintGate;
    public PlayerController(ArrayList<Player> teamRed, ArrayList<Player> teamBlue){
        teamRed_=teamRed;
        teamBlue_=teamBlue;
        currentPlayer=teamRed_.get(0);
        sprintGate=new HashMap<Position, Position>();
        setupGates();

    }
    private void setupGates(){
        sprintGate.put(new Position(2,0 ), new Position(1,6));
        sprintGate.put(new Position(4,0 ), new Position(3,6));
        sprintGate.put(new Position(6,0 ), new Position(1,6));
        sprintGate.put(new Position(8,0 ), new Position(7,6));


    }
    public void turn(int moves) {
        // this method takes t
        int row = currentPlayer.getPlayerPosition().getRow();
        int col = currentPlayer.getPlayerPosition().getCol();

        do {
            boolean even = row % 2 == 0 ? true : false;

            if (even) {
                if (row == 0 && col < 6) {
                    if (col - moves < 0) {
                        currentPlayer.move(0,0);
                        return;
                    }
                }
                if (col == 0) {
                    row -= 1;
                    currentPlayer.move(row,col);
                    moves--;
                } else if (col >= moves) { // enough room to stay on same row
                    col -= moves;
                    currentPlayer.move(row,col);
                    moves = 0;
                } else if (col < moves) { // need to go up a row
                    // calculate how many moves will be used to complete the row
                    moves = moves - col;
                    currentPlayer.move(row,0);

                    col = currentPlayer.getPlayerPosition().getCol();
                }

            } else {
                if (col == 6) {
                    row -= 1;
                    currentPlayer.move(row, col);
                    moves--;
                } else if (col + moves < 6) { // enough room to stay on same
                    // row
                    col += moves;
                    currentPlayer.move(row, col);
                    moves = 0;
                    break;
                } else if (col + moves >= 6) { // need to go up a row
                    // calc how many moves left in this row
                    moves = moves - (6 - col);
                    currentPlayer.move(row, 6);
                    row = currentPlayer.getPlayerPosition().getRow();
                    col = currentPlayer.getPlayerPosition().getCol();
                }
            }
        } while (moves != 0);
    }

    public Player switchPlayer() {
        if ((currentPlayer.getTeam().equals(BoardConstants.TeamColor.RED))&&currentPlayer.getId() + 1 < teamRed_.size()) {
            currentPlayer = teamRed_.get(currentPlayer.getId()+1);}
        else{
            currentPlayer=teamBlue_.get(0);
        }

        if ( (currentPlayer.getTeam().equals(BoardConstants.TeamColor.BLUE))&&(currentPlayer.getId() + 1 < teamBlue_.size())){
            currentPlayer = teamBlue_.get(currentPlayer.getId()+1);}


        else {
            currentPlayer =teamRed_.get(0);
        }
        return currentPlayer;
    }

}
