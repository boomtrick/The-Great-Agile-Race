package Models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactTest {
	
	int id = 52;
	String text = "this is fact!!";
	Fact fact = new Fact(id);
	
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
