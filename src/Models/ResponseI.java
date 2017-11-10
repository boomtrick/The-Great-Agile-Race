package Models;

import java.util.List;

/**
 * Created by zalmangagerman on 11/10/17.
 */
public interface ResponseI {
    List<FactI> getFact();
    void setFact(List<FactI> fact);
    List<QuizI> getQuiz();
    void setQuiz(List<QuizI> quiz);
}
