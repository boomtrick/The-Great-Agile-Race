package Models;

import java.util.Random;

public class Fact implements FactI {
	/*
        Holds getters, setters and methods for accessing Fact data
     */
	private int id;
	private String text;




	public Fact(DialogueParserI dp)
	{
		Random rand = new Random();
		id = rand.nextInt(25) + 1;
		Response response = dp.getResponse();
		this.text =  response.getFactByID(id);
	}

//
//	//Checks if given fact was seen by player, if yes, return true
//	public boolean wasSeenBy(Player playerIn){
//
//		return false;
//	}

    @Override
	public String getText() {
        return text;
    }
	@Override
	public int getId()
	{
		return id;
	}
	@Override
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public void setText(String text) {
		this.text = text;
	}


}
