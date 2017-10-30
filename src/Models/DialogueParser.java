package Models;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

import com.google.gson.Gson;

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

        //Prints out fact by ID 1, String or int
        System.out.println(response.getFactByID("01"));
        System.out.println(response.getFactByID(1));

        //Prints quiz object by ID, gets options
        System.out.println("Question: "+response.getQuizByID(1).getQuestion());

        System.out.println("Options: "+ response.getQuizByID(1).getOptions());
        //Get answer
        System.out.println("Correct Answer: "+ response.getQuizByID(1).getAnswer());

        //Checks if answer is correct or not
        System.out.println("Answering 'a'... "+ response.getQuizByID(1).isCorrect("a"));
        System.out.println("Answering 'b'... "+ response.getQuizByID(1).isCorrect("b"));

       // System.out.println(fact);


    }
}
