import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.EnumMap;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.TreeMap;

public class MapData
{
    private HashMap dataCatalog = new HashMap<String, ArrayList<Observation>>();
    
    private EnumMap statistics = new EnumMap<StatsType, TreeMap<String, Statistics>>();
    
    private TreeMap paramPositions = new TreeMap<String, Integer>();
    
    /**
     * An int value of 10, that is the number of missing observations
     */
    private static final int NUMBER_OF_MISSING_OBSERVATIONS = 10;

    /**
     * An integer that holds the number of stations reporting valid data
     */
    private Integer numberOfStations;

    /**
     * A final String containing the stat name "TA9M"
     */
    private static final String TA9M = "TA9M";

    /**
     * A final String containing the stat name "TAIR"
     */
    private static final String TAIR = "TAIR";

    /**
     * A final String containing the stat name "SRAD"
     */
    private static final String SRAD = "SRAD";

    /**
     * A final String containing the stat name "STID"
     */
    private static final String STID = "STID";

    /**
     * A string containing the station ID "Mesonet"
     */
    private static final String MESONET = "Mesonet";

    /**
     * A String object that stores the fileName as created by the createFileName
     * method
     */
    private String fileName;

    /**
     * A GregorianCalendar object that stores the date and time of the data
     * collection
     */
    private GregorianCalendar utcDateTime;

    /**
     * A reference variable for the MINIMUM enum value
     */
    StatsType min = StatsType.MINIMUM;

    /**
     * A reference variable for the MAXIMUM enum value
     */
    StatsType max = StatsType.MAXIMUM;

    /**
     * A reference variable for the AVERAGE enum value
     */
    StatsType avg = StatsType.AVERAGE;

    /**
     * A reference variable for the TOTAL enum value
     */
    StatsType tot = StatsType.TOTAL;

    /**
     * A new ArrayList that stores the valid tair data
     */
    ArrayList<Observation> tairValid = new ArrayList<Observation>();

    /**
     * A new ArrayList that stores the valid ta9m data
     */
    ArrayList<Observation> ta9mValid = new ArrayList<Observation>();

    /**
     * A new ArrayList that stores the valid srad data
     */
    ArrayList<Observation> sradValid = new ArrayList<Observation>();

    /**
     * The constuctor for the MapData class. Takes in information about the file
     * requested, and pushes the data through the rest of the program
     * 
     * @param year
     *            The year the data was collected
     * @param month
     *            The month the data was collected
     * @param day
     *            The day the data was collected
     * @param hour
     *            The hour the data was collected
     * @param minute
     *            The minute the data was collected
     * @param directory
     *            The folder in which the data is stored
     */
    public MapData(int year, int month, int day, int hour, int minute, String directory)
    {
        //TODO: Rewrite
    }

    /**
     * Uses the date and time to create a file name based on that data
     * 
     * @return currentFileName The fileName of the requested data
     */
    public String createFileName(int year, int month, int day, int hour, int minute, String directory)
    {
        //TODO: Make NEcessary Adjustments
        // Creates an empty String to hold the new fileName
        String currentFileName = "";

        // Uses the GregorianCalendar object utcDateTime to access the date and time
        // Creates a fileName using that data
        String fileYear = String.valueOf(utcDateTime.get(Calendar.YEAR));

        // If any value is a one-digit number, a 0 is put in front of it
        String fileMonth;
        if (utcDateTime.get(Calendar.MONTH) < 10)
        {
            fileMonth = "0" + String.valueOf(utcDateTime.get(Calendar.MONTH));
        }
        else
        {
            fileMonth = String.valueOf(utcDateTime.get(Calendar.MONTH));
        }

        String fileDay;
        if (utcDateTime.get(Calendar.DAY_OF_MONTH) < 10)
        {
            fileDay = "0" + String.valueOf(utcDateTime.get(Calendar.DAY_OF_MONTH));
        }
        else
        {
            fileDay = String.valueOf(utcDateTime.get(Calendar.DAY_OF_MONTH));
        }

        String fileHour;
        if (utcDateTime.get(Calendar.HOUR_OF_DAY) < 10)
        {
            fileHour = "0" + String.valueOf(utcDateTime.get(Calendar.HOUR_OF_DAY));
        }
        else
        {
            fileHour = String.valueOf(utcDateTime.get(Calendar.HOUR_OF_DAY));
        }

        String fileMinute;
        if (utcDateTime.get(Calendar.MINUTE) < 10)
        {
            fileMinute = "0" + String.valueOf(utcDateTime.get(Calendar.MINUTE));
        }
        else
        {
            fileMinute = String.valueOf(utcDateTime.get(Calendar.MINUTE));
        }

        // Appends the pieces of the fileName together with the .mdf suffix
        currentFileName = fileYear + fileMonth + fileDay + fileHour + fileMinute + ".mdf";

        return currentFileName;
    }

    /**
     * Finds the position in an array of each parameter requested
     * 
     * @param inParamString
     *            The entry point for the method
     * @throws IOException
     *             Throws an exception if an invalid input is used
     */
    private void parseParamHeader(String inParamString) throws IOException
    {
        //TODO: REWRITE
        //ALSO MAKE THE inParamString the requested ID
        BufferedReader br = new BufferedReader(new FileReader(directory + "/" + fileName));

        // String containing a line of data from the file
        String strg;

        // Reads the header in and stores it nowhere. We want the third line
        strg = br.readLine();

        // Reads in the second line and stores it nowhere
        strg = br.readLine();

        // Reads in the third line.
        // We'll use the header to find the location of each of our parameters
        strg = br.readLine();

        // Split this string into an array list.
        // This way if more variables are added in the future, the program can handle
        // them.
        ArrayList<String> header = new ArrayList<String>(Arrays.asList(strg.split("\\s+")));

        // The for loop will search for the correct parameters
        // A break statment could be added that executes once all vairables have been
        // assigned a value that is not -1
        for (int i = 0; i < header.size(); ++i)
        {
            if (header.get(i).equalsIgnoreCase(STID))
            {
                stidPosition = i;
            }
            else if (header.get(i).equalsIgnoreCase(TAIR))
            {
                tairPosition = i;
            }
            else if (header.get(i).equalsIgnoreCase(SRAD))
            {
                sradPosition = i;
            }
            else if (header.get(i).equalsIgnoreCase(TA9M))
            {
                ta9mPosition = i;
            }

        }

    }

    /**
     * Calls the createFileName method and pulls in the data from that file. The
     * data is then sorted into arrays corresponding to the correct statistic. After
     * bringing in the data the arrays are resized from a capacity of 1000 to one of
     * a perfect size.
     * 
     * @throws IOException
     *             throws an exception of a input is invalid
     */
    public void parseFile() throws IOException
    {
        parseParamHeader("go to parse header");
        BufferedReader br = new BufferedReader(new FileReader(directory + "/" + fileName));

        // String containing a line of data from the file
        String strg;

        // Reads the header and stores it nowhere, moving the buffered reader to the
        // next line
        strg = br.readLine();

        // The second line is also useless so we store it nowhere and move on
        strg = br.readLine();

        // We also do not need the third line
        strg = br.readLine();

        // Creates an empty temporary string to store each line of the input while the
        // object is created
        String temp = "";

        // Runs through the input file and reads each line into a player object
        // Counter will indicate the size the new array needs to be
        numberOfStations = 0;
        while ((temp = br.readLine()) != null)
        {
            String[] tempString = new String[24];
            tempString = temp.split("\\s+");

            sradData.add(new Observation(Double.parseDouble(tempString[sradPosition]), tempString[stidPosition]));
            tairData.add(new Observation(Double.parseDouble(tempString[tairPosition]), tempString[stidPosition]));
            ta9mData.add(new Observation(Double.parseDouble(tempString[ta9mPosition]), tempString[stidPosition]));

            ++numberOfStations;
        }

        br.close();

        // Calculates all statistics for the data
        calculateStatistics(sradData, SRAD);
        calculateStatistics(tairData, TAIR);
        calculateStatistics(ta9mData, TA9M);
    }

    /**
     * Uses the ArrayLists created by the parseFile method to calculate the maximum,
     * minimum, average, and totals for each parameter. The calculations only use
     * the valid data.
     * 
     * @param inData
     *            The ArrayList that is being used
     * @param paramId
     *            The parameter type having statistics calculated
     */
    private void calculateAllStatistics(ArrayList<Observation> inData, String paramId)
    {
       //TODO: Rewrite
    }
    
    //TODO: Add new methods

    /**
     * Creates and returns a String that is the final output for the program. The
     * string contains the weather statistics as well as the date and time. Each
     * section of the data is separated by a line of "=".
     * 
     * @return output the final output String that will print to the console
     */
    public String toString()
    {
        String fileYear = String.valueOf(utcDateTime.get(Calendar.YEAR));

        // If any value is a one-digit number, a 0 is put in front of it
        String fileMonth;
        if (utcDateTime.get(Calendar.MONTH) < 10)
        {
            fileMonth = "0" + String.valueOf(utcDateTime.get(Calendar.MONTH));
        }
        else
        {
            fileMonth = String.valueOf(utcDateTime.get(Calendar.MONTH));
        }

        String fileDay;
        if (utcDateTime.get(Calendar.DAY_OF_MONTH) < 10)
        {
            fileDay = "0" + String.valueOf(utcDateTime.get(Calendar.DAY_OF_MONTH));
        }
        else
        {
            fileDay = String.valueOf(utcDateTime.get(Calendar.DAY_OF_MONTH));
        }

        String fileHour;
        if (utcDateTime.get(Calendar.HOUR_OF_DAY) < 10)
        {
            fileHour = "0" + String.valueOf(utcDateTime.get(Calendar.HOUR_OF_DAY));
        }
        else
        {
            fileHour = String.valueOf(utcDateTime.get(Calendar.HOUR_OF_DAY));
        }

        String fileMinute;
        if (utcDateTime.get(Calendar.MINUTE) < 10)
        {
            fileMinute = "0" + String.valueOf(utcDateTime.get(Calendar.MINUTE));
        }
        else
        {
            fileMinute = String.valueOf(utcDateTime.get(Calendar.MINUTE));
        }

        // Creates a String that will store the entire output of the weather data
        String output = "";
        for (int i = 0; i < 58; ++i)
        {
            output += "=";
        }
        output += "\n";
        output += "=== " + fileYear + "-" + fileMonth + "-" + fileDay + " " + fileHour + ":" + fileMinute + " ===";
        output += "\n";
        for (int i = 0; i < 58; ++i)
        {
            output += "=";
        }
        output += "\n";

        // Determines if there is too much missing data to print tair statistics
        if ((numberOfStations - tairValid.size()) > NUMBER_OF_MISSING_OBSERVATIONS)
        {
            output += "Not enough valid air temperature data";
            output += "\n";
        }
        else
        {
            output += "Maximum Air Temperature[1.5m] = " + tairMax.getValue() + " C at " + tairMax.getStid();
            output += "\n";
            output += "Minimum Air Temperature[1.5m] = " + tairMin.getValue() + " C at " + tairMin.getStid();
            output += "\n";
            output += "Average Air Temperature[1.5m] = " + tairAverage.getValue() + " C at " + tairAverage.getStid();
            output += "\n";
        }
        for (int i = 0; i < 58; ++i)
        {
            output += "=";
        }
        output += "\n";
        for (int i = 0; i < 58; ++i)
        {
            output += "=";
        }

        // Determines if there is too much data missing to print ta9m statistics
        if ((numberOfStations - ta9mValid.size()) > NUMBER_OF_MISSING_OBSERVATIONS)
        {
            output += "Not enough valid air temperature  at 9 meters data";
            output += "\n";
        }
        else
        {
            output += "\n";
            output += "Maximum Air Temperature[9.0m] = " + ta9mMax.getValue() + " C at " + ta9mMax.getStid();
            output += "\n";
            output += "Minimum Air Temperature[9.0m] = " + ta9mMin.getValue() + " C at " + ta9mMin.getStid();
            output += "\n";
            output += "Average Air Temperature[9.0m] = " + ta9mAverage.getValue() + " C at " + ta9mAverage.getStid();
            output += "\n";
        }
        for (int i = 0; i < 58; ++i)
        {
            output += "=";
        }
        output += "\n";
        for (int i = 0; i < 58; ++i)
        {
            output += "=";
        }

        // Determines if there is too much missing data to print srad statistics
        if ((numberOfStations - sradValid.size()) > NUMBER_OF_MISSING_OBSERVATIONS)
        {
            output += "Not enough valid solar radiation data";
            output += "\n";
        }
        else
        {
            output += "\n";
            output += "Maximum Solar Radiation[1.5m] = " + sradMax.getValue() + " W/m^2 at " + sradMax.getStid();
            output += "\n";
            output += "Minimum Solar Radiation[1.5m] = " + sradMin.getValue() + " W/m^2 at " + sradMin.getStid();
            output += "\n";
            output += "Average Solar Radiation[1.5m] = " + sradAverage.getValue() + " W/m^2 at "
                    + sradAverage.getStid();
            output += "\n";
        }
        for (int i = 0; i < 58; ++i)
        {
            output += "=";
        }

        return output;
    }

}
