package Controllers;

import Models.DialogueSingleton;
import com.google.gson.Gson;
public class DialogueParser {



    Gson gson = new Gson();

    DialogueSingleton fact = gson.fromJson("{\"name\": \"John\"}", DialogueSingleton.class);



////For testing
    public static void main(String[] args)
    {
        System.out.println("test");
    }
}
