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

/**
 * @author Grant Campbell
 * @version 10/28/2018
 * 
 *          A class that takes in the time and date of a weather measurement,
 *          and outputs a String containing the maximum, minimum, and average,
 *          of the air temperature at 1.5 meters, the air temperature at 9
 *          meters, and the solar radiation.
 *
 */
public class MapData
{
    /**
     * HashMap with a String key and an ArrayList value. Used to store data from the
     * .mdf files.
     */
    private HashMap<String, ArrayList<Observation>> dataCatalog;

    /**
     * EnumMap containing significant Stats for each parameter.
     */
    private EnumMap<StatsType, TreeMap<String, Statistics>> statistics = new EnumMap<>(StatsType.class);

    /**
     * TreeMap containing the positions of each parameter on the file. Param name
     * String is the key.
     */
    private TreeMap<String, Integer> paramPositions = new TreeMap<>();

    /**
     * TreeMap that temporarily holds statistics as they are moved into the
     * statistics EnumMap.
     */
    TreeMap<String, Statistics> tempStatHolder = new TreeMap<>();

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
     * A final String containing the stat name "WSPD"
     */
    private static final String WSPD = "WSPD";

    /**
     * A final String containing the stat name "PRES"
     */
    private static final String PRES = "PRES";

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

    ArrayList<Observation> sradData = new ArrayList<Observation>();
    ArrayList<Observation> tairData = new ArrayList<Observation>();
    ArrayList<Observation> ta9mData = new ArrayList<Observation>();
    ArrayList<Observation> wspdData = new ArrayList<Observation>();
    ArrayList<Observation> presData = new ArrayList<Observation>();

    Statistics tairMin;
    Statistics tairMax;
    Statistics tairAvg;
    Statistics ta9mMin;
    Statistics ta9mMax;
    Statistics ta9mAvg;
    Statistics sradMin;
    Statistics sradMax;
    Statistics sradAvg;
    Statistics wspdMin;
    Statistics wspdMax;
    Statistics wspdAvg;
    Statistics presMin;
    Statistics presMax;
    Statistics presAvg;

    public Statistics getTairMin()
    {
        return tairMin;
    }

    public Statistics getTairMax()
    {
        return tairMax;
    }

    public Statistics getTairAvg()
    {
        return tairAvg;
    }

    public Statistics getTa9mMin()
    {
        return ta9mMin;
    }

    public Statistics getTa9mMax()
    {
        return ta9mMax;
    }

    public Statistics getTa9mAvg()
    {
        return ta9mAvg;
    }

    public Statistics getSradMin()
    {
        return sradMin;
    }

    public Statistics getSradMax()
    {
        return sradMax;
    }

    public Statistics getSradAvg()
    {
        return sradAvg;
    }

    public Statistics getWspdMin()
    {
        return wspdMin;
    }

    public Statistics getWspdMax()
    {
        return wspdMax;
    }

    public Statistics getWspdAvg()
    {
        return wspdAvg;
    }

    public Statistics getPresMin()
    {
        return presMin;
    }

    public Statistics getPresMax()
    {
        return presMax;
    }

    public Statistics getPresAvg()
    {
        return presAvg;
    }

    public MapData(String filename)
    {
        fileName = filename;
        prepareDataCatalog();
    }

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
        utcDateTime = new GregorianCalendar(year, month, day, hour, minute);
        fileName = createFileName(year, month, day, hour, minute, directory);
        prepareDataCatalog();
    }

    /**
     * Uses the date and time to create a file name based on that data
     * 
     * @param year
     *            The year the data was recorded
     * @param month
     *            The month the data was recorded
     * @param day
     *            The day the data was recorded
     * @param hour
     *            The hour the data was recorded
     * @param minute
     *            The minute the data was recorded
     * @param directory
     *            The directory holding the recorded data
     * @return currentFileName The fileName of the requested data
     */
    public String createFileName(int year, int month, int day, int hour, int minute, String directory)
    {
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
        currentFileName = directory + "/" + fileYear + fileMonth + fileDay + fileHour + fileMinute + ".mdf";

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
        BufferedReader br = new BufferedReader(new FileReader(fileName));

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
            if (header.get(i).equalsIgnoreCase(inParamString))
            {
                paramPositions.put(inParamString, i);
                break;
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
        parseParamHeader(TA9M);
        parseParamHeader(SRAD);
        parseParamHeader(TAIR);
        parseParamHeader(WSPD);
        parseParamHeader(PRES);
        parseParamHeader(STID);

        BufferedReader br = new BufferedReader(new FileReader(fileName));

        // Reads the header and stores it nowhere, moving the buffered reader to the
        // next line
        br.readLine();

        // The second line is also useless so we store it nowhere and move on
        br.readLine();

        // We also do not need the third line
        br.readLine();

        // Creates an empty temporary string to store each line of the input while the
        // object is created
        String temp = "";

        // Runs through the input file and reads each line into a player object
        // Counter will indicate the size the new array needs to be
        // Creates temp arrays to be stored in dataCatalog

        numberOfStations = 0;
        while ((temp = br.readLine()) != null)
        {
            String[] tempString = new String[24];
            tempString = temp.split("\\s+");

            sradData.add(new Observation(Double.parseDouble(tempString[paramPositions.get(SRAD)]),
                    tempString[paramPositions.get(STID)]));
            tairData.add(new Observation(Double.parseDouble(tempString[paramPositions.get(TAIR)]),
                    tempString[paramPositions.get(STID)]));
            ta9mData.add(new Observation(Double.parseDouble(tempString[paramPositions.get(TA9M)]),
                    tempString[paramPositions.get(STID)]));
            wspdData.add(new Observation(Double.parseDouble(tempString[paramPositions.get(WSPD)]),
                    tempString[paramPositions.get(STID)]));
            presData.add(new Observation(Double.parseDouble(tempString[paramPositions.get(PRES)]),
                    tempString[paramPositions.get(STID)]));

            ++numberOfStations;
        }

        dataCatalog.put(TAIR, tairData);
        dataCatalog.put(TA9M, ta9mData);
        dataCatalog.put(SRAD, sradData);
        dataCatalog.put(WSPD, wspdData);
        dataCatalog.put(PRES, presData);

        br.close();

        // Calculates all statistics for the data
        calculateStatistics();
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
        // Sorts through the data and finds all of the valid observations
        ArrayList<Observation> validList = new ArrayList<Observation>();
        for (int i = 0; i < numberOfStations; ++i)
        {
            if (inData.get(i).isValid())
            {
                // The valid data is stored in a new ArrayList
                validList.add(inData.get(i));
            }
        }

        // Min
        Statistics statMin = new Statistics(validList.get(0).getValue(), validList.get(0).getStid(), utcDateTime,
                validList.size(), StatsType.MINIMUM);

        // Checks to see if there is any other valid Observation that is smaller than
        // statMin
        for (int i = 0; i < validList.size(); ++i)
        {
            if (validList.get(i).getValue() <= statMin.getValue())
            {
                statMin = new Statistics(validList.get(i).getValue(), validList.get(i).getStid(), utcDateTime,
                        validList.size(), StatsType.MINIMUM);
            }
        }

        // Max
        Statistics statMax = new Statistics(validList.get(0).getValue(), validList.get(0).getStid(), utcDateTime,
                validList.size(), StatsType.MAXIMUM);

        // Checks to see if there is any other valid Observation that is larger than
        // statMax
        for (int i = 0; i < validList.size(); ++i)
        {
            if (validList.get(i).getValue() >= statMax.getValue())
            {
                statMax = new Statistics(validList.get(i).getValue(), validList.get(i).getStid(), utcDateTime,
                        validList.size(), StatsType.MAXIMUM);
            }
        }

        // Average
        double sum = 0;

        for (int i = 0; i < validList.size(); ++i)
        {
            sum += validList.get(i).getValue();
        }

        // Creates a preliminary average value
        double averageValue = sum / validList.size();
        // Multiplies it by 10
        averageValue = averageValue * 10;
        // Rounds it to the nearest whole number
        averageValue = Math.round(averageValue);
        // Divides it by 10 to get our decimal place back
        averageValue = averageValue / 10;

        Statistics statAverage = new Statistics(averageValue, MESONET, utcDateTime, validList.size(),
                StatsType.AVERAGE);

        Statistics statTotal = new Statistics(sum, MESONET, utcDateTime, validList.size(), StatsType.AVERAGE);

        String one = paramId + "Min";
        String two = paramId + "Max";
        String three = paramId + "Average";

        tempStatHolder.put(one, statMin);
        tempStatHolder.put(two, statMax);
        tempStatHolder.put(three, statAverage);

        statistics.put(StatsType.MINIMUM, tempStatHolder);

        statistics.put(StatsType.MAXIMUM, tempStatHolder);

        statistics.put(StatsType.AVERAGE, tempStatHolder);

        if (paramId.equalsIgnoreCase(SRAD))
        {
            String four = paramId + "Total";
            tempStatHolder.put(four, statTotal);

            statistics.put(StatsType.TOTAL, tempStatHolder);
        }

        if (inData.equals(tairData))
        {
            tairMin = statMin;
            tairMax = statMax;
            tairAvg = statAverage;
        }
        else if (inData.equals(ta9mData))
        {
            ta9mMin = statMin;
            ta9mMax = statMax;
            ta9mAvg = statAverage;
        }
        else if (inData.equals(sradData))
        {
            sradMin = statMin;
            sradMax = statMax;
            sradAvg = statAverage;
        }
        else if (inData.equals(wspdData))
        {
            wspdMin = statMin;
            wspdMax = statMax;
            wspdAvg = statAverage;
        }
        else if (inData.equals(presData))
        {
            presMin = statMin;
            presMax = statMax;
            presAvg = statAverage;
        }
    }

    /**
     * Initializes the dataCatalog for 'this' Object.
     */
    private void prepareDataCatalog()
    {
        dataCatalog = new HashMap<>();
    }

    /**
     * Calculates the statistics for each requested parameter.
     */
    private void calculateStatistics()
    {
        calculateAllStatistics(dataCatalog.get(TAIR), TAIR);
        calculateAllStatistics(dataCatalog.get(TA9M), TA9M);
        calculateAllStatistics(dataCatalog.get(SRAD), SRAD);
        calculateAllStatistics(dataCatalog.get(WSPD), WSPD);
        calculateAllStatistics(dataCatalog.get(PRES), PRES);
    }

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
        if ((numberOfStations - statistics.get(StatsType.MAXIMUM).get("TAIRMax")
                .getNumberOfReportingStations()) > NUMBER_OF_MISSING_OBSERVATIONS)
        {
            output += "Not enough valid air temperature data";
            output += "\n";
        }
        else
        {
            output += "Maximum Air Temperature[1.5m] = " + statistics.get(StatsType.MAXIMUM).get("TAIRMax").getValue()
                    + " C at " + statistics.get(StatsType.MAXIMUM).get("TAIRMax").getStid();
            output += "\n";
            output += "Minimum Air Temperature[1.5m] = " + statistics.get(StatsType.MINIMUM).get("TAIRMin").getValue()
                    + " C at " + statistics.get(StatsType.MINIMUM).get("TAIRMin").getStid();
            output += "\n";
            output += "Average Air Temperature[1.5m] = "
                    + statistics.get(StatsType.AVERAGE).get("TAIRAverage").getValue() + " C at "
                    + statistics.get(StatsType.AVERAGE).get("TAIRAverage").getStid();
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
        if ((numberOfStations - statistics.get(StatsType.MAXIMUM).get("TA9MMax")
                .getNumberOfReportingStations()) > NUMBER_OF_MISSING_OBSERVATIONS)
        {
            output += "\nNot enough valid air temperature at 9 meters data";
            output += "\n";
        }
        else
        {
            output += "\n";
            output += "Maximum Air Temperature[9.0m] = " + statistics.get(StatsType.MAXIMUM).get("TA9MMax").getValue()
                    + " C at " + statistics.get(StatsType.MAXIMUM).get("TA9MMax").getStid();
            output += "\n";
            output += "Minimum Air Temperature[9.0m] = " + statistics.get(StatsType.MINIMUM).get("TA9MMin").getValue()
                    + " C at " + statistics.get(StatsType.MINIMUM).get("TA9MMin").getStid();
            output += "\n";
            output += "Average Air Temperature[9.0m] = "
                    + statistics.get(StatsType.AVERAGE).get("TA9MAverage").getValue() + " C at "
                    + statistics.get(StatsType.AVERAGE).get("TA9MAverage").getStid();
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
        if ((numberOfStations - statistics.get(StatsType.MAXIMUM).get("SRADMax")
                .getNumberOfReportingStations()) > NUMBER_OF_MISSING_OBSERVATIONS)
        {
            output += "\nNot enough valid solar radiation data";
            output += "\n";
        }
        else
        {
            output += "\n";
            output += "Maximum Solar Radiation[1.5m] = " + statistics.get(StatsType.MAXIMUM).get("SRADMax").getValue()
                    + " W/m^2 at " + statistics.get(StatsType.MAXIMUM).get("SRADMax").getStid();
            output += "\n";
            output += "Minimum Solar Radiation[1.5m] = " + statistics.get(StatsType.MINIMUM).get("SRADMin").getValue()
                    + " W/m^2 at " + statistics.get(StatsType.MINIMUM).get("SRADMin").getStid();
            output += "\n";
            output += "Average Solar Radiation[1.5m] = "
                    + statistics.get(StatsType.AVERAGE).get("SRADAverage").getValue() + " W/m^2 at "
                    + statistics.get(StatsType.AVERAGE).get("SRADAverage").getStid();
            output += "\n";
        }
        for (int i = 0; i < 58; ++i)
        {
            output += "=";
        }

        return output;
    }

}
