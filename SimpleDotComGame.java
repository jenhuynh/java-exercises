import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SimpleDotComGame {

    public static void main (String [] args) {
        // DECLARE an int variable to hold the number of user guesses, named numOfGuesses
        int numOfGuesses = 0;
        // 1. Make the single SimpleDotCom Object.
        SimpleDotCom dot = new SimpleDotCom();
        //COMPUTE a random number between 0 and 4 that will be the starting location cell position
        int randomNum = (int) (Math.random() * 5);
        //MAKE an int array with 3 ints using the randomly-generated number, that number incremented by 1, and that number incremented by 2 (example: 3,4,5)
        int [] randomNumArr = {randomNum, randomNum + 1, randomNum + 2};

        //create instance of GameHelper
        GameHelper gameHelper = new GameHelper();

        //INVOKE the setLocationCells() method on the SimpleDotCom instance
        dot.setLocationCells(randomNumArr);

        //DECLARE a boolean variable representing the state of the game, named isAlive. SET it to true
        //isAlive means you are still alive until you hit all cells
        boolean isAlive = true;
//WHILE the dot com is still alive (isAlive == true) :
        while (isAlive == true){
            //GET user input from the command line
            //Scanner sc = new Scanner(System.in);
            // System.out.print("Enter your guess -");
//            int userGuess = sc.nextInt();
            //String result = dot.checkYourself(userGuess);
            String guess = gameHelper.getUserInput("enter a number");
            // CHECK the user guess
            //INVOKE the checkYourself() method on the SimpleDotCom instance
            String result = dot.checkYourself(guess);
            //INCREMENT numOfGuesses variable
            numOfGuesses++;
            //// CHECK for dot com death
            //IF result is "kill"
            if (result == "kill"){
                //SET isAlive to false (which means we won't enter the loop again)
                isAlive = false;
                // PRINT the number of user guesses
                System.out.println(numOfGuesses);
            }
        }

    }
}

class SimpleDotCom {
    //DECLARE an int array to hold the location cells. Call it locationCells
    int [] locationCells;

    //DECLARE an int to hold the number of hits. Call it numOfHits and SET it to 0.
    //numOfHits  how many times a user hits the battleship
    int numOfHits = 0;
    /*
       DECLARE a setLocationCells() setter method that takes an int array (which has the three cell)
       locations as ints (2,3,4, etc.).
       */
    public void setLocationCells(int[] cellLocations) {
        locationCells =   cellLocations;
    }

    //DECLARE a checkYourself() method that takes a String for the user's guess ("1", "3", etc.),
    //checks it, and returns a result representing a "hit", "miss", or "kill".
    public String checkYourself(String guess){
        //convert user guess to an int
        int convertedGuessInt = Integer.parseInt(guess);
//        int [] cellLocations1 = new int [3];
        String result = "miss";
//            cellLocations1[0] = 2;
//            cellLocations1[1] = 3;
//            cellLocations1[2] = 4;
        //repeat with each of the location cells in the int array
        for(int cell : locationCells ) {
            //compare the user guess to the location cell
            if (convertedGuessInt == cell) {
                result = "hit";
                //if user guess matches, increment the number of hits
                numOfHits = numOfHits + 1;
                break;
            } //end if
        } //end for
        //We're out of the loop, but see if we're now hit 3 times.
        // IF numberOfHits is 3, return "kill"
        if(numOfHits == locationCells.length) {
            result = "kill"; //bug
        }
        //display result for the user ("Miss" unless it was changed to "Hit" or "Kill"
        System.out.println(result);
        //return result back to the calling method
        return result ;
    } //end method

}

class GameHelper {
    public String getUserInput(String prompt) {
        String inputLine = null;
        System.out.print(prompt + " ");
        try {
            BufferedReader is = new BufferedReader(
                    new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0 ) return null;
        } catch (IIOException e) {
            System.out.println("IOException: " + e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputLine;
    }
}
//import javax.imageio.IIOException;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class SimpleDotComGame {
//
//    public static void main (String [] args) {
//        // DECLARE an int variable to hold the number of user guesses, named numOfGuesses
//        int numOfGuesses = 0;
//    // 1. Make the single SimpleDotCom Object.
//        SimpleDotCom dot = new SimpleDotCom();
//        //COMPUTE a random number between 0 and 4 that will be the starting location cell position
//        int randomNum = (int) (Math.random() * 5);
//        //MAKE an int array with 3 ints using the randomly-generated number, that number incremented by 1, and that number incremented by 2 (example: 3,4,5)
//         int [] randomNumArr = {randomNum, randomNum + 1, randomNum + 2};
//
//         //create instance of GameHelper
//        GameHelper gameHelper = new GameHelper();
//
//        //INVOKE the setLocationCells() method on the SimpleDotCom instance
//        dot.setLocationCells(randomNumArr);
//
//        //DECLARE a boolean variable representing the state of the game, named isAlive. SET it to true
//        //isAlive means you are still alive until you hit all cells
//        boolean isAlive = true;
////WHILE the dot com is still alive (isAlive == true) :
//        //create array to hold guesses
//      String [] userGuesses = new String[7];
//
//        while (isAlive == true){
//            //GET user input from the command line
//            //Scanner sc = new Scanner(System.in);
//            // System.out.print("Enter your guess -");
////            int userGuess = sc.nextInt();
//            //String result = dot.checkYourself(userGuess);
//            String guess = gameHelper.getUserInput("enter a number");
//            //check that guess is inside of the array
//            //trying to fix bug
//            for (int x = 0; x < userGuesses.length; x++){
//                if ( userGuesses[x] == guess){
//                    //String result = dot.checkYourself(userGuess);
//                    guess = gameHelper.getUserInput("Try a number you haven't used!");
//                } else {
//                   userGuesses[x] = guess;
//                   System.out.println(userGuesses[x]);
//                }
//            }
//
//            // CHECK the user guess
//            //INVOKE the checkYourself() method on the SimpleDotCom instance
//               String result = dot.checkYourself(guess);
//
//
//            //INCREMENT numOfGuesses variable
//                numOfGuesses++;
//            //// CHECK for dot com death
//            //IF result is “kill”
//                if (result == "kill"){
//                    //SET isAlive to false (which means we won’t enter the loop again)
//                      isAlive = false;
//                    // PRINT the number of user guesses
//                    System.out.println(numOfGuesses);
//                }
//
//        }
//
//    }
//}
//
//class SimpleDotCom {
//    //DECLARE an int array to hold the location cells. Call it locationCells
//    int [] locationCells;
//
//    //DECLARE an int to hold the number of hits. Call it numOfHits and SET it to 0.
//    //numOfHits  how many times a user hits the battleship
//    int numOfHits = 0;
//    /*
//       DECLARE a setLocationCells() setter method that takes an int array (which has the three cell)
//       locations as ints (2,3,4, etc.).
//       */
//    public void setLocationCells(int[] cellLocations) {
//        locationCells =   cellLocations;
//    }
//
//    //DECLARE a checkYourself() method that takes a String for the user’s guess (“1”, “3”, etc.),
//    //checks it, and returns a result representing a “hit”, “miss”, or “kill”.
//    public String checkYourself(String guess){
//        //convert user guess to an int
//        int convertedGuessInt = Integer.parseInt(guess);
////        int [] cellLocations1 = new int [3];
//        String result = "miss";
////            cellLocations1[0] = 2;
////            cellLocations1[1] = 3;
////            cellLocations1[2] = 4;
//        //repeat with each of the location cells in the int array
//        for(int cell : locationCells ) {
//            //compare the user guess to the location cell
//            if (convertedGuessInt == cell) {
//                result = "hit";
//                //if user guess matches, increment the number of hits
//                numOfHits = numOfHits + 1;
//                break;
//            } //end if
//        } //end for
//        //We're out of the loop, but see if we're now hit 3 times.
//        // IF numberOfHits is 3, return "kill"
//        if(numOfHits == locationCells.length) {
//            result = "kill"; //bug
//        }
//        //display result for the user ("Miss" unless it was changed to "Hit" or "Kill"
//        System.out.println(result);
//        //return result back to the calling method
//        return result ;
//    } //end method
//
//}
//
// class GameHelper {
//    public String getUserInput(String prompt) {
//        String inputLine = null;
//        System.out.print(prompt + " ");
//        try {
//            BufferedReader is = new BufferedReader(
//                    new InputStreamReader(System.in));
//            inputLine = is.readLine();
//            if (inputLine.length() == 0 ) return null;
//        } catch (IIOException e) {
//            System.out.println("IOException: " + e);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        //condition
////        if (inputLine == ){
////            return "Guess again. Do not enter the same number more than once.";
////        }
//        return inputLine;
//    }
//}
