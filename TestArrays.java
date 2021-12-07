public class TestArrays {
    public static void main(String[] args){
        //create array of 4 islands
        String [] islands = new String[4];
        //create array of 3 integer indexes
        int [] index = new int[4];
        //set specific islands to names
        islands[0] = "Bermuda";
        islands[1] = "Fiji";
        islands[2] = "Azores";
        islands[3] = "Cozumel";
        //set array of indices
        index[0] = 1;
        index[1] = 3;
        index[2] = 0;
        index[3] = 2;

        int ref;
        int y = 0;
        while (y < 4) {
            ref = index[y];
            System.out.print("island = " );
            System.out.println(islands[ref]);
            y = y + 1;
        }
    }
}
