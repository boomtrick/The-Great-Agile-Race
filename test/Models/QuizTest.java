package Models;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuizTest {

    @Test public void testSettersAndGetters() throws Exception {
        int expectedId = 73;
        String expectedQuestion = "what is the answer?";
        String expectedA = "A";
        String expectedB = "B";
        String expectedC = "C";
        String expectedD = "D";
        String expectedAnswer = "C";
        int expectedRelevantFact = 6;
        QuizI actualQuiz = new Quiz();
        actualQuiz.setId(expectedId);
        actualQuiz.setQuestion(expectedQuestion);
        actualQuiz.setA(expectedA);
        actualQuiz.setB(expectedB);
        actualQuiz.setC(expectedC);
        actualQuiz.setD(expectedD);
        actualQuiz.setAnswer(expectedAnswer);
        actualQuiz.setRelatedFact(expectedRelevantFact);
        assertEquals(expectedId, actualQuiz.getId());
        assertEquals(expectedQuestion, actualQuiz.getQuestion());
        assertEquals(expectedA, actualQuiz.getA());
        assertEquals(expectedB, actualQuiz.getB());
        assertEquals(expectedC, actualQuiz.getC());
        assertEquals(expectedD, actualQuiz.getD());
        assertEquals(expectedAnswer, actualQuiz.getAnswer());
        assertEquals(expectedRelevantFact, actualQuiz.getRelatedFact());
    }
}
