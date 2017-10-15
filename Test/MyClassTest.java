import Controllers.DialogueParser;
import Models.Response;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class MyClassTest {
    @Test
    public void testSomething() {


        Response response = null;
        try {
            Response response = DialogueParser.GetResponse();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String value = response.getFact().get(0).getFact();

        System.out.print(value);
        // System.out.println(response.getFact().getId().get;
        //System.out.println("Object:" + fact);

        //System.out.print(jsonFact);

        //List<Fact> facts = fact.getFact();

        // Convert JSON to JsonElement, and later to String
            /*JsonElement json = gson.fromJson(reader, JsonElement.class);
            String jsonInString = gson.toJson(json);
            System.out.println(jsonInString);*/
    }
}