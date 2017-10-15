package Models;

import java.util.List;
import java.util.NoSuchElementException;

/*
    Response gathers the Facts and the Quizzes into one object.  All attributes
    are assigned to their corresponding variable name.
    Also holds methods to get by attributes
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




    //Overloaded method that converts String to int
    protected String getFactByID(String ID) throws NoSuchElementException {
        int intID = Integer.parseInt(ID);

        String fact;
        //While we're in the Fact array, iterate
        for(int i=0; i < getFact().size(); i++){
            //If ID in array, pull it
            if (getFact().get(i).getId() == intID){
                fact = getFact().get(i).getText();
                return fact;
            }

        }
        throw new NoSuchElementException("Fact does not exist given ID");
    }



    //Returns a fact by given ID
    protected String getFactByID(int ID) throws NoSuchElementException{
        String fact;
        //While we're in the Fact array, iterate
        for(int i=0; i < getFact().size(); i++){
            //If ID in array, pull it
            if (getFact().get(i).getId() == ID){
                fact = getFact().get(i).getText();
                return fact;
            }

        }
        throw new NoSuchElementException("Fact does not exist given ID");
    }


    //Returns a quiz object by given ID
    protected Quiz getQuizByID(int ID) throws NoSuchElementException{


        Quiz quiz;
        for(int i=0; i < getQuiz().size(); i++){
            //If ID in array, pull it
            if (getQuiz().get(i).getId() == ID){
                quiz = getQuiz().get(i);
                return quiz;
            }

        }
        throw new NoSuchElementException("Quiz does not exist given ID");
    }


}