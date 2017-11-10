package Models;

/**
 * Created by zalmangagerman on 11/10/17.
 */
public interface QuizI extends SpecialEventI {
	//Checks if answer is correct, returns true or false
	boolean isCorrect(String answerIn);
	String getAnswer();
	String getOptions();
	String getOption(String option);
	int getRelatedFact();
	@Override
	int getId();
	String getQuestion();
	void setId(int id);
	void setQuestion(String question);
	void setA(String a);
	void setB(String b);
	void setC(String c);
	void setD(String d);
	void setAnswer(String answer);void setRelatedFact(int relatedFact);
	String getA();
	String getB();
	String getC();
	String getD();
}
