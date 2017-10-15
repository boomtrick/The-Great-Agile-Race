package Models;

public class Fact {
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
