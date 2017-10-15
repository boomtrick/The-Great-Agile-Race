package Controllers;

import Models.Response;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class DialogueParser {

    private Response response;

    public Response getResponse() {
        return response;
    }

    //Parses Dialogue.json into the response object
    private void ReadInResponse() throws FileNotFoundException {
        Reader reader = new FileReader("src/Config/Dialogue.json");
        Gson gson = new Gson();
        response = gson.fromJson(reader, Response.class);
    }





    //Test
    public static void main(String[] args)
    {



    }
}
