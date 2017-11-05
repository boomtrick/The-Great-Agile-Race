package Test.Models;

import Models.Dice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DiceTest {
    @Test
            public void rollTest(){
        int low=0;
        int high=7;
        int numOfTest=64;
        for(int i=0; i<numOfTest; i++){
            assertTrue((Dice.roll()>low)&(Dice.roll()<high));

        }
    }

}
