import java.io.IOException;

/**
 * 
 * @author Grant Campbell
 * @version 10/28/2018
 * 
 *          Driver for the program. Takes in date and time to have data found
 *          for. Prints out the resulting statistics.
 */
public class Driver
{

    public static void main(String[] args) throws IOException
    {
        /**
         * The year to be tested
         */
        final int YEAR = 2018;

        /**
         * The month to be tested
         */
        final int MONTH = 8;

        /**
         * The day to be tested
         */
        final int DAY = 1;

        /**
         * The hour to be tested
         */
        final int HOUR = 7;

        /**
         * The minute to be tested
         */
        final int MINUTE = 00;

        /**
         * The directory the data is found in
         */
        final String directory = "data";

        /**
         * Creates the MapData for the data
         */
        MapData mapData = new MapData(YEAR, MONTH, DAY, HOUR, MINUTE, directory);

        /**
         * Entry point of the program. Pushes the rest of the instructions.
         */
        mapData.parseFile();

        /**
         * Prints out the data summary.
         */
        System.out.println(mapData);
        
        new MapFrame("Oklahoma Mesonet");

    }

}
