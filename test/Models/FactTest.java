package Models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

public class FactTest {
	
	@Test public void testGetters() {
		Response mockResponse = mock(Response.class);
		int expectedId = 584325;
		String expectedAnswer = "answer";
		when(mockResponse.getFactByID(expectedId)).thenReturn(expectedAnswer);
		Fact actualFact = new Fact(expectedId, mockResponse);
		assertEquals(expectedAnswer, actualFact.getText());
		assertEquals(expectedId, actualFact.getId());
	}
}
