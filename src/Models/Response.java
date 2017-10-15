package Models;

import java.util.List;
/*
    Response gathers the Facts and the Quizzes into one object.  All attributes
    are assigned to their corresponding variable name.
 */
public class Response {


    //Getters and setters for Fact array
    public List<Fact> getFact() {
        return Fact;
    }
    public void setFact(List<Fact> fact) {
        this.Fact = fact;
    }
    List<Fact> Fact;


    //Getters and setters for Quiz array
    public List<Models.Quiz> getQuiz() {
        return Quiz;
    }

    public void setQuiz(List<Models.Quiz> quiz) {
        Quiz = quiz;
    }

    List<Quiz> Quiz;
}