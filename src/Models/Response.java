package Models;

import java.util.List;
import java.util.NoSuchElementException;

/*
    Response gathers the Facts and the Quizzes into one object.  All attributes
    are assigned to their corresponding variable name.
    Also holds methods to get by attributes
 */
public class Response implements ResponseI {

    //Vars
    private List<QuizI> quizzes;
    private List<FactI> facts;

    //Getters and setters for facts array
    @Override
    public List<FactI> getFact() {
        return facts;
    }
    @Override
    public void setFact(List<FactI> fact) {
        this.facts = fact;
    }

    //Getters and setters for quizzes array
    @Override
    public List<QuizI> getQuiz() {
        return quizzes;
    }
    @Override
    public void setQuiz(List<QuizI> quiz) {
        quizzes = quiz;
    }





    //Returns fact by String ID
    protected String getFactByID(String ID) throws NoSuchElementException {
        int intID = Integer.parseInt(ID);
        String fact;
        //While we're in the facts array, iterate
        for(int i=0; i < getFact().size(); i++){
            //If ID in array, pull it
            if (getFact().get(i).getId() == intID){
                fact = getFact().get(i).getText();
                return fact;
            }
        }
        throw new NoSuchElementException("facts does not exist given ID");
    }



    //Returns fact by int ID
    protected String getFactByID(int ID) throws NoSuchElementException{
        String fact;
        //While we're in the facts array, iterate
        for(int i=0; i < getFact().size(); i++){
            //If ID in array, pull it
            if (getFact().get(i).getId() == ID){
                fact = getFact().get(i).getText();
                return fact;
            }
        }
        throw new NoSuchElementException("facts does not exist given ID");
    }


    //Returns quiz object by given int ID
    protected QuizI getQuizByID(int ID) throws NoSuchElementException{
        QuizI quiz;
        for(int i=0; i < getQuiz().size(); i++){
            //If ID in array, pull it
            if (getQuiz().get(i).getId() == ID){
                quiz = getQuiz().get(i);
                return quiz;
            }

        }
        throw new NoSuchElementException("quizzes does not exist given ID");
    }

    //Returns quiz object by given String ID
    protected QuizI getQuizByID(String ID) throws NoSuchElementException{

        int intID = Integer.parseInt(ID);
        QuizI quiz;
        for(int i=0; i < getQuiz().size(); i++){
            //If ID in array, pull it
            if (getQuiz().get(i).getId() == intID){
                quiz = getQuiz().get(i);
                return quiz;
            }
        }
        throw new NoSuchElementException("quizzes does not exist given ID");
    }


}