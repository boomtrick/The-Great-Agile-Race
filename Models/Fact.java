package Models;


public class Fact {
	private int id;
	private String text;
	
	public Fact(int id, String text)
	{
		this.id = id;
		this.text = text;
	}
	
	public int getId()
	{
		return id;
	}
	
	public String getFact()
	{
		return text;
	}
	
}
