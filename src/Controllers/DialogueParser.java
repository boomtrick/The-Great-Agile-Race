package Controllers;

import Models.Fact;
import com.google.gson.Gson;
public class DialogueParser {



    Gson gson = new Gson();

    Fact fact = gson.fromJson("{\"name\": \"John\"}", Fact.class);
    //DialogueSingleton fact = gson.fromJson("{\"name\": \"John\"}", DialogueSingleton.class);
//Code will go here to parse Json



////For testing
    public static void main(String[] args)
    {
        System.out.println("test");
    }
}
