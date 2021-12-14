///////////////// BUG FIXED REVISED CODE WITH ARRAYLIST ///////////////////////////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DotComBust {
    //declare and initialize variables we need
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
    private int numOfGuesses = 0;
    private void setUpGame() {
// first make three dot com objects and give them a name and location into the arraylist
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("Go2.com");
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);
        //instructions for the user
        System.out.println("Your goal is to sink three dot coms.");
        System.out.println("Pets.com, eToys.com, Go2.com");
        System.out.println("Try to sink them all in the fewest number of guesses");
        //repeating each DotCom in the list
        for (DotCom dotComToSet : dotComsList) {
            //ask the helper for a DotCom location (an ArrayList of Strings)
            ArrayList<String> newLocation = helper.placeDotCom(3);
            //call the setter method on this DotCom to give it the location you got from the helper
            dotComToSet.setLocationCells(newLocation);
        } // close for loop
    } // close setUpgame method
    private void startPlaying() {
        //checking if the DotCom list is NOT empty (the ! means NOT which is the same as (dotComList.isEmpty() == false)
        while(!dotComsList.isEmpty()) {
            //get user input
            String userGuess = helper.getUserInput("Enter a guess");
            //call our checkUserGuess method
            checkUserGuess(userGuess);
        } // close while
        //call our finishGame method
        finishGame();
    } // close startPlaying method
    private void checkUserGuess(String userGuess) {
        //increment the number of guesses the user has made
        numOfGuesses++;
        //assume it’s a ‘miss’, unless told otherwise
        String result = "miss";
        //repeat with all DotComs in the list
        for(int x = 0; x < dotComsList.size(); x++) {
           // ask the DotCom to check the user guess, looking for a hit (or kill)
            result = dotComsList.get(x).checkYourself(userGuess);
            if (result.equals("hit")) {
                //get out of the loop early, no point in testing the others
                break;
            }
            //this guy’s dead, so take him out of the DotComs list then get out of the loop
            if (result.equals("kill")) {
                dotComsList.remove(x);
                break;
            }
        } // close for
        //print the result for the user
        System.out.println(result);
    } // close method
    private void finishGame() {
        //print a message telling the user how they did in the game
        System.out.println("All Dot Coms are dead! Your stock is now worthless.");
        if (numOfGuesses <= 18) {
            System.out.println("It only took you " + numOfGuesses + " guesses.");
            System.out.println(" You got out before your options sank.");
        } else {
            System.out.println("Took you long enough. "+ numOfGuesses + " guesses.");
            System.out.println("Fish are dancing with your options");
        }
    } // close method
    public static void main (String[] args) {
        //create the game object
        DotComBust game = new DotComBust();
        //tell the game object to set up the gam
        game.setUpGame();
        //tell the game object to start the main game play loop (keeps asking for user input and checking the guess)
        game.startPlaying();
    } // close method
}
class DotCom {
    //declare instance variables
    private ArrayList<String> locationCells;
    private String name;
    //A setter method that updates the DotCom’s location. (Random location provided by the GameHelper placeDotCom( ) method.)
    public void setLocationCells(ArrayList<String> loc) {
        locationCells = loc;
    }
    public void setName(String n) {
        name = n;
    }
    public String checkYourself(String userInput) {
        String result = "miss";
        //The ArrayList indexOf( ) method in action! If the user guess is one of the entries in the ArrayList, indexOf( )
         //will return its ArrayList location. If not, indexOf( ) will return -1.
        int index = locationCells.indexOf(userInput);
        //Using ArrayList’s remove( ) method to delete an entry
        if (index >= 0) {
            locationCells.remove(index);
            //Using the isEmpty( ) method to see if all of the locations have been guessed
            if (locationCells.isEmpty()) {
                result = "kill";
                //Tell the user when a DotCom has been sunk.
                System.out.println("Ouch! You sunk " + name + " : ( ");
            } else {
                //Return: ‘miss’ or ‘hit’ or ‘kill’
                result = "hit";
            } // close if
        } // close if
        return result;
    } // close method
} // close class

class GameHelper {
    private static final String alphabet = "abcdefg";
    private int gridLength = 7;
    private int gridSize = 49;
    private int [] grid = new int[gridSize];
    private int comCount = 0;
    public String getUserInput(String prompt) {
        String inputLine = null;
        System.out.print(prompt + " ");
        try {
            BufferedReader is = new BufferedReader(
                    new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0 ) return null;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return inputLine.toLowerCase();
    }
    public ArrayList<String> placeDotCom(int comSize) {
        ArrayList<String> alphaCells = new ArrayList<String>();
// holds 'f6' type coords
        String temp = null; // temporary String for concat
        int [] coords = new int[comSize]; // current candidate coords
        int attempts = 0; // current attempts counter
        boolean success = false; // flag = found a good location ?
        int location = 0; // current starting location
        comCount++; // nth dot com to place
        int incr = 1; // set horizontal increment
        if ((comCount % 2) == 1) { // if odd dot com (place vertically)
            incr = gridLength; // set vertical increment
        }
        while ( !success & attempts++ < 200 ) { // main search loop (32)
            location = (int) (Math.random() * gridSize); // get random starting point
//System.out.print(" try " + location);
            int x = 0; // nth position in dotcom to place
            success = true; // assume success
            while (success && x < comSize) { // look for adjacent unused spots
                if (grid[location] == 0) { // if not already used
                    coords[x++] = location; // save location
                    location += incr; // try 'next' adjacent
                    if (location >= gridSize){ // out of bounds - 'bottom'
                        success = false; // failure
                    }
                    if (x>0 && (location % gridLength == 0)) { // out of bounds - right edge
                        success = false; // failure
                    }
                } else { // found already used location
// System.out.print(" used " + location);
                    success = false; // failure
                }
            }
        } // end while
        int x = 0; // turn location into alpha coords
        int row = 0;
        int column = 0;
// System.out.println("\n");
        while (x < comSize) {
            grid[coords[x]] = 1; // mark master grid pts. as 'used'
            row = (int) (coords[x] / gridLength); // get row value
            column = coords[x] % gridLength; // get numeric column value
            temp = String.valueOf(alphabet.charAt(column)); // convert to alpha
            alphaCells.add(temp.concat(Integer.toString(row)));
            x++;
// System.out.print(" coord "+x+" = " + alphaCells.get(x-1));
        }
// System.out.println("\n");
        return alphaCells;
    }
}

/////////////////////// OLD CODE //////////////////////////////
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
//        // 1. Make the single SimpleDotCom Object.
//        SimpleDotCom dot = new SimpleDotCom();
//        //COMPUTE a random number between 0 and 4 that will be the starting location cell position
//        int randomNum = (int) (Math.random() * 5);
//        //MAKE an int array with 3 ints using the randomly-generated number, that number incremented by 1, and that number incremented by 2 (example: 3,4,5)
//        int [] randomNumArr = {randomNum, randomNum + 1, randomNum + 2};
//
//        //create instance of GameHelper
//        GameHelper gameHelper = new GameHelper();
//
//        //INVOKE the setLocationCells() method on the SimpleDotCom instance
//        dot.setLocationCells(randomNumArr);
//
//        //DECLARE a boolean variable representing the state of the game, named isAlive. SET it to true
//        //isAlive means you are still alive until you hit all cells
//        boolean isAlive = true;
////WHILE the dot com is still alive (isAlive == true) :
//        while (isAlive == true){
//            //GET user input from the command line
//            //Scanner sc = new Scanner(System.in);
//            // System.out.print("Enter your guess -");
////            int userGuess = sc.nextInt();
//            //String result = dot.checkYourself(userGuess);
//            String guess = gameHelper.getUserInput("enter a number");
//            // CHECK the user guess
//            //INVOKE the checkYourself() method on the SimpleDotCom instance
//            String result = dot.checkYourself(guess);
//            //INCREMENT numOfGuesses variable
//            numOfGuesses++;
//            //// CHECK for dot com death
//            //IF result is "kill"
//            if (result.equals("kill")){
//                //SET isAlive to false (which means we won't enter the loop again)
//                isAlive = false;
//                // PRINT the number of user guesses
//                System.out.println(numOfGuesses);
//            }
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
//    //DECLARE a checkYourself() method that takes a String for the user's guess ("1", "3", etc.),
//    //checks it, and returns a result representing a "hit", "miss", or "kill".
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
//class GameHelper {
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
//        return inputLine;
//    }
//}