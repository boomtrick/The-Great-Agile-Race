import Views.BackgroundPanel;
import Views.Board;
import Views.GameBoard;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by zalmangagerman on 10/8/17.
 */
public class Main {
    public static void main(String[] args) {
        //Main file

    	GameBoard gameBoard = new GameBoard();
    	gameBoard.run();
    	
    }
}
