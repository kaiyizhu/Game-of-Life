
package dev.SeanZhang.utils;

//import stuffs
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Sean Zhang
 */

//this will contain useful utility methods for the game
public class Utils {
    //loadFileAsString returns the file as a string.
    public static String loadFileAsString(String path) {
        //creates StringBuilder class.
        StringBuilder builder = new StringBuilder();
        
        //this try-catch block will read in the file at the parameter variable
        //path and appends it to the builder.
        try {
            //creates bufferedReader object which will read in the file.
            BufferedReader br = new BufferedReader(new FileReader(path));
            //temp variable for reading in lines
            String line;
            //this loop will read until there is no next line.
            while((line=br.readLine()) != null) {
                //appends the builder object with the line read in and adds
                //new line.
                builder.append(line+"\n");
            }
            //closes the buffered reader.
            br.close();
        //catches the exception if there is no file.    
        } catch(IOException e) {
            //prints the error to the console
            e.printStackTrace();
        }
        
        //returns the builder object as a string.
        return builder.toString();
    }
    
    //parseInt method. Takes in the String we want to convert into an integer
    //as a parameter called number.
    public static int parseInt(String number) {
        //try-catch loop to prevent fatal errors such as the inability to 
        //convert the string to an integer.
        try {
            //returns the string as an ineger with the Integer.parseInt method.
            return Integer.parseInt(number);
        //otherwise, the numberFormaatException is caught
        } catch (NumberFormatException e) {
            //prints error to console
            e.printStackTrace();
            //returns zero
            return 0;
        }
    } //end of parseInt method.
}
