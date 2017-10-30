package Models;

public class Fact implements SpecialEvent {
	/*
        Holds getters, setters and methods for accessing Fact data
     */
	private int id;
	private String text;




	public Fact(int id, String text)
	{
		this.id = id;
		this.text = text;
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
