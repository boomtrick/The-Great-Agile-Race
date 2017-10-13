package Controllers;

import Models.Fact;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

//Parses Dialogue.json
public class DialogueParser {

    public static void main(String[] args)
    {

        Gson gson = new Gson();

        try (Reader reader = new FileReader("src/Config/Dialogue.json")) {
            // Convert JSON to Java Object
            Fact fact = gson.fromJson(reader, Fact.class);
            System.out.println(fact.toString());


            //List<Fact> facts = fact.getFact();

            // Convert JSON to JsonElement, and later to String
            /*JsonElement json = gson.fromJson(reader, JsonElement.class);
            String jsonInString = gson.toJson(json);
            System.out.println(jsonInString);*/

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
