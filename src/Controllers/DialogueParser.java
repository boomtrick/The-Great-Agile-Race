package Controllers;

import Models.Response;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class DialogueParser {

    private Response response;
    private String filePath = "src/Config/Dialogue.json";

    public DialogueParser(){
        readInResponse(filePath);
    }

    public Response getResponse() {
        return response;
    }

    //Parses Dialogue.json into the response object
    private void readInResponse(String filePathIn) {
        Reader reader = null;//"src/Config/Dialogue.json"
        try {
            reader = new FileReader(filePathIn);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        response = gson.fromJson(reader, Response.class);
    }


    //Test Sample
    public static void main(String[] args)
    {
        DialogueParser dp = new DialogueParser();
        Response response = dp.getResponse();

        //Prints out the first fact
        System.out.println(response.getFact().get(0).getText());
        //Prints out the first question of the first quiz
        System.out.println(response.getQuiz().get(0).getQuestion().toString());




    }
}
