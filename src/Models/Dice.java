package Models;

import java.util.Random;

import static Config.BoardConstants.DIE_SIZE;

public class Dice implements DiceI {

    /**
     * created by Azamat
     *
     * The method generates random integers between numbers(including) 1 and 6
     */
    @Override
    public int roll(){
        Random rand=new Random();
        int randomNum= rand.nextInt(DIE_SIZE)+1;
        return randomNum;
    }
}
