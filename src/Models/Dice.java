package Models;

import java.util.Random;

public class Dice {

    public static int roll(){
        /**
         * created by Azamat
         *
         * The method generates random integers between numbers(including) 1 and 6
         */
        Random rand=new Random();
       int randomNum= rand.nextInt(6)+1;

        return randomNum;
    }
   /* public static void main (String[] args){
        for (int i=0; i<60; i++){
            System.out.println(Dice.roll());
        }
*/
    }

