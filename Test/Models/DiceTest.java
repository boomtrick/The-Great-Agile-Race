package Models;

import Models.Dice;
import org.junit.jupiter.api.Test;

import static Config.BoardConstants.DIE_SIZE;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DiceTest {
    @Test
    public void rollTest() throws Exception {
        int numOfTest=64;
        Dice actualDie = new Dice();
        int actualRoll;
        for(int i=0; i<numOfTest; i++){
            actualRoll = actualDie.roll();
            assertTrue(actualRoll > 0);
            assertTrue(actualRoll <= DIE_SIZE);
        }
    }
}
