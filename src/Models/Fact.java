package Models;

import java.util.Random;
public class Fact {
	/*
        Holds getters, setters and methods for accessing Fact
        Please do not change the constructors/variables for this class, it's needed for GSON to work properly
     */
	private int id;
	private String text;




	public Fact(int id)
	{

		DialogueParserI dp = new DialogueParser();
		Response response = dp.getResponse();

		this.id = id;
		this.text =  response.getFactByID(id);
	}

	public Fact() {
		//There should be such a thing as an empty fact // todo
	}

//
//	//Checks if given fact was seen by player, if yes, return true
//	public boolean wasSeenBy(Player playerIn){
//
//		return false;
//	}

    public String getText() {
        return text;
    }
	public int getId()
	{
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setText(String text) {
		this.text = text;
	}


}
