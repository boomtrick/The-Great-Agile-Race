package Models;




import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;



import Models.Fact;

public class FactTest {
	
	int id = 52;
	String text = "this is fact!!";
	Fact fact = new Fact(id,text);
	
	@Test
	public void getText()
	{
		assertEquals(text,fact.getText());
	}
	
	@Test
	public void getId(){
		assertEquals(id,fact.getId());
	}

}
