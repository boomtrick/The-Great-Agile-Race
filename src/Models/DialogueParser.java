package Models;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

/*Parses a JSON file indicated by filePath
* Returns response for manipulation */

public class DialogueParser {

    private Response response;
    private String filePath = "src/Config/Dialogue.json";


    public DialogueParser(){
        readInResponse(filePath);
    }

    //Use this to get the fields you want
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



    //Catch error for this
    private String getFactByID(int ID) {
        String fact ="no fact found";
        //While we're in the Fact array, iterate
        for(int i=0; i < response.getFact().size(); i++){
            //If ID in array, pull it
            if (response.getFact().get(i).getId() == 1){
                fact = response.getFact().get(i).getText();
            }

        }
        return fact;
    }


    //Samples to retrieve fields
    public static void main(String[] args)
    {
        DialogueParser dp = new DialogueParser();
        Response response = dp.getResponse();

        //Prints out the first fact
        System.out.println(response.getFact().get(0).getText());
        //Prints out the first fact id
        System.out.println(response.getFact().get(0).getId());
        //Prints out the first question of the first quiz
        System.out.println(response.getQuiz().get(0).getQuestion().toString());

        //Prints out fact by ID 1
        System.out.println(dp.getFactByID(1));

       // System.out.println(fact);


    }
}
