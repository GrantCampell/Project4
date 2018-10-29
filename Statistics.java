import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author Grant Campbell
 * @version 10/28/2018
 * 
 *          A class that stores information about the most notable observatoins
 *          from the data read in. It is used to store the minimum, maximum,
 *          average, and total values. It is also used to turn Strings into
 *          GregorianCalendars and ZonedDateTimes and comparing dates to each
 *          other.
 */
public class Statistics extends Observation
{
    /**
     * An immutable String that contains the format of a date time String
     */
    protected final String DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH";

    protected void DateTimeFormatter()
    {
        // TODO: Complete this method
    }

    /**
     * A GregorianCalendar that contains the date of the data collection
     */
    private GregorianCalendar utcDateTime;

    /**
     * A ZonedDateTime that contains the date of the data collection
     */
    private ZonedDateTime zdtDateTime;

    /**
     * An int value containing the number of stations reporting valid data
     */
    private int numberOfReportingStations;

    /**
     * A StatsType containing the StatsType of a Statistics object
     */
    private StatsType statType;

    /**
     * A constructor for the Statistics class that stores data in a Statistics
     * object if the date is passed in as a ZonedDateTime.
     * 
     * @param value
     *            The value of a Statistics object
     * @param stid
     *            The Station ID of a Statistics object
     * @param ZonedDateTime
     *            The ZonedDateTime containing the date and time of the data
     *            requested.
     * @param numberOfValidStations
     *            The number of stations that reported valid data for that
     *            Statistics object
     * @param inStatType
     *            The StatsType that the Statistics object contains
     */
    public Statistics(double value, String stid, ZonedDateTime dateTime, int numberOfValidStations,
            StatsType inStatType)
    {
        super(value, stid);
        this.zdtDateTime = dateTime;
        this.numberOfReportingStations = numberOfValidStations;
        this.statType = inStatType;
    }

    /**
     * A constructor for the Statistics class that stores data in a Statistics
     * object if the date is passed in as a Gregorian Calendar.
     * 
     * @param value
     *            The value of a Statistics object
     * @param stid
     *            The Station ID of a Statistics object
     * @param dateTime
     *            The GregorianCalendar that contains the date and time of data
     *            collection.
     * @param numberOfValidStations
     *            The number of stations that reported valid data for that
     *            Statistics object
     * @param inStatType
     *            The StatsType that the Statistics object contains
     */
    public Statistics(double value, String stid, GregorianCalendar dateTime, int numberOfValidStations,
            StatsType inStatType)
    {
        super(value, stid);
        this.utcDateTime = dateTime;
        this.numberOfReportingStations = numberOfValidStations;
        this.statType = inStatType;
    }

    /**
     * Creates a GregorianCalendar from a String that contains the date and time
     * 
     * @param dateTimeStr
     *            A string containing the date and time of data collection
     * @return The GregorianCalendar containing the date and time form the String
     */
    public GregorianCalendar createDateFromString(String dateTimeStr)
    {
        String[] temp = new String[3];
        String[] temp2 = new String[3];

        temp = dateTimeStr.split("-");
        temp2 = temp[2].split("'");

        int year = Integer.parseInt(temp[0]);
        int month = Integer.parseInt(temp[1]);
        int day = Integer.parseInt(temp2[0]);
        int hour = Integer.parseInt(temp2[1]);
        int minute = Integer.parseInt(temp2[2]);

        GregorianCalendar gregDate = new GregorianCalendar(year, month, day, hour, minute);
        return gregDate;
    }

    /**
     * Creates a ZonedDateTime from a String that contains the date and time
     * 
     * @param dateTimeStr
     *            A string containing the date and time of data collection
     * @return The GregorianCalendar containing the date and time form the String
     */
    public ZonedDateTime createZDateFromString(String dateTimeStr)
    {
        String[] temp = new String[3];
        String[] temp2 = new String[3];

        temp = dateTimeStr.split("-");
        temp2 = temp[2].split("'");

        int year = Integer.parseInt(temp[0]);
        int month = Integer.parseInt(temp[1]);
        int day = Integer.parseInt(temp2[0]);
        int hour = Integer.parseInt(temp2[1]);
        int minute = Integer.parseInt(temp2[2]);

        LocalDateTime localDate = LocalDateTime.of(year, month, day, hour, minute);

        ZonedDateTime zonedDate = ZonedDateTime.of(localDate, ZoneId.of("America/Chicago"));

        return zonedDate;
    }

    /**
     * Creates a String containing the date and time from a GregorianCalendar
     * 
     * @param inCalendar
     *            The GregorianCalendar to be turned into a String
     * @return A String containing the date and time of data collection
     */
    public String createStringFromDate(GregorianCalendar inCalendar)
    {
        String year = String.valueOf(inCalendar.get(Calendar.YEAR));

        // If any value is a one-digit number, a 0 is put in front of it
        String month;
        if (inCalendar.get(Calendar.MONTH) < 10)
        {
            month = "0" + String.valueOf(inCalendar.get(Calendar.MONTH));
        }
        else
        {
            month = String.valueOf(inCalendar.get(Calendar.MONTH));
        }

        String day;
        if (inCalendar.get(Calendar.DAY_OF_MONTH) < 10)
        {
            day = "0" + String.valueOf(inCalendar.get(Calendar.DAY_OF_MONTH));
        }
        else
        {
            day = String.valueOf(inCalendar.get(Calendar.DAY_OF_MONTH));
        }

        String hour;
        if (inCalendar.get(Calendar.HOUR_OF_DAY) < 10)
        {
            hour = "0" + String.valueOf(inCalendar.get(Calendar.HOUR_OF_DAY));
        }
        else
        {
            hour = String.valueOf(inCalendar.get(Calendar.HOUR_OF_DAY));
        }

        String minute;
        if (inCalendar.get(Calendar.MINUTE) < 10)
        {
            minute = "0" + String.valueOf(inCalendar.get(Calendar.MINUTE));
        }
        else
        {
            minute = String.valueOf(inCalendar.get(Calendar.MINUTE));
        }

        return year + "-" + month + "-" + day + "'" + hour + "'" + minute;
    }

    public String createStringFromDate(ZonedDateTime inCalendar)
    {
        String year = String.valueOf(inCalendar.getYear());

        // If any value is a one-digit number, a 0 is put in front of it
        String month;
        if (inCalendar.getMonthValue() < 10)
        {
            month = "0" + String.valueOf(inCalendar.getMonthValue());
        }
        else
        {
            month = String.valueOf(inCalendar.getMonthValue());
        }

        String day;
        if (inCalendar.getDayOfMonth() < 10)
        {
            day = "0" + String.valueOf(inCalendar.getDayOfMonth());
        }
        else
        {
            day = String.valueOf(inCalendar.getDayOfMonth());
        }

        String hour;
        if (inCalendar.getHour() < 10)
        {
            hour = "0" + String.valueOf(inCalendar.getHour());
        }
        else
        {
            hour = String.valueOf(inCalendar.getHour());
        }

        String minute;
        if (inCalendar.getMinute() < 10)
        {
            minute = "0" + String.valueOf(inCalendar.getMinute());
        }
        else
        {
            minute = String.valueOf(inCalendar.getMinute());
        }

        return year + "-" + month + "-" + day + "'" + hour + "'" + minute;
    }

    /**
     * Returns the number of reporting stations
     * 
     * @return the number of reporting stations
     */
    public int getNumberOfReportingStations()
    {
        return numberOfReportingStations;
    }

    /**
     * Returns utcDateTime
     * 
     * @return utcDateTime
     */
    public String getUTCDateTime()
    {
        return createStringFromDate(utcDateTime);
    }

    /**
     * Checks to see if a GregorianCalendar contains a date newer than a specified
     * date.
     * 
     * @return Whether or not the GregorianCalendar is newer than inDateTime
     */
    public boolean newerThan(GregorianCalendar inDateTime)
    {
        boolean isNewerThan = false;

        if (utcDateTime.get(Calendar.YEAR) == inDateTime.get(Calendar.YEAR))
        {
            // NEXT LAYER
            if (utcDateTime.get(Calendar.MONTH) == inDateTime.get(Calendar.MONTH))
            {
                // NEXT LAYER
                if (utcDateTime.get(Calendar.DAY_OF_MONTH) == inDateTime.get(Calendar.DAY_OF_MONTH))
                {
                    // NEXT LAYER
                    {
                        if (utcDateTime.get(Calendar.HOUR_OF_DAY) == inDateTime.get(Calendar.HOUR_OF_DAY))
                        {
                            // NEXT LAYER
                            if (utcDateTime.get(Calendar.MINUTE) == inDateTime.get(Calendar.MINUTE))
                            {
                                isNewerThan = false;
                            }
                            else if (utcDateTime.get(Calendar.MINUTE) > inDateTime.get(Calendar.MINUTE))
                            {
                                isNewerThan = true;
                            }
                            else
                            {
                                isNewerThan = false;
                            }
                        }
                        else if (utcDateTime.get(Calendar.HOUR_OF_DAY) > inDateTime.get(Calendar.HOUR_OF_DAY))
                        {
                            isNewerThan = true;
                        }
                        else
                        {
                            isNewerThan = false;
                        }
                    }
                }
                else if (utcDateTime.get(Calendar.DAY_OF_MONTH) > inDateTime.get(Calendar.DAY_OF_MONTH))
                {
                    isNewerThan = true;
                }
                else
                {
                    isNewerThan = false;
                }
            }
            else if (utcDateTime.get(Calendar.MONTH) > inDateTime.get(Calendar.MONTH))
            {
                isNewerThan = true;
            }
            else
            {
                isNewerThan = false;
            }
        }
        else if (utcDateTime.get(Calendar.YEAR) > inDateTime.get(Calendar.YEAR))
        {
            isNewerThan = true;
        }
        else
        {
            isNewerThan = false;
        }

        return isNewerThan;
    }

    /**
     * Checks to see if a GregorianCalendar contains a date older than a specified
     * date.
     * 
     * @return Whether or not the GregorianCalendar is older than inDateTime
     */
    public boolean olderThan(GregorianCalendar inDateTime)
    {
        boolean isOlderThan = false;

        if (utcDateTime.get(Calendar.YEAR) == inDateTime.get(Calendar.YEAR))
        {
            // NEXT LAYER
            if (utcDateTime.get(Calendar.MONTH) == inDateTime.get(Calendar.MONTH))
            {
                // NEXT LAYER
                if (utcDateTime.get(Calendar.DAY_OF_MONTH) == inDateTime.get(Calendar.DAY_OF_MONTH))
                {
                    // NEXT LAYER
                    {
                        if (utcDateTime.get(Calendar.HOUR_OF_DAY) == inDateTime.get(Calendar.HOUR_OF_DAY))
                        {
                            // NEXT LAYER
                            if (utcDateTime.get(Calendar.MINUTE) == inDateTime.get(Calendar.MINUTE))
                            {
                                isOlderThan = false;
                            }
                            else if (utcDateTime.get(Calendar.MINUTE) < inDateTime.get(Calendar.MINUTE))
                            {
                                isOlderThan = true;
                            }
                            else
                            {
                                isOlderThan = false;
                            }
                        }
                        else if (utcDateTime.get(Calendar.HOUR_OF_DAY) < inDateTime.get(Calendar.HOUR_OF_DAY))
                        {
                            isOlderThan = true;
                        }
                        else
                        {
                            isOlderThan = false;
                        }
                    }
                }
                else if (utcDateTime.get(Calendar.DAY_OF_MONTH) < inDateTime.get(Calendar.DAY_OF_MONTH))
                {
                    isOlderThan = true;
                }
                else
                {
                    isOlderThan = false;
                }
            }
            else if (utcDateTime.get(Calendar.MONTH) < inDateTime.get(Calendar.MONTH))
            {
                isOlderThan = true;
            }
            else
            {
                isOlderThan = false;
            }
        }
        else if (utcDateTime.get(Calendar.YEAR) < inDateTime.get(Calendar.YEAR))
        {
            isOlderThan = true;
        }
        else
        {
            isOlderThan = false;
        }

        return isOlderThan;
    }

    /**
     * Checks to see if a GregorianCalendar contains a the same date as a specified
     * date.
     * 
     * @return Whether or not the GregorianCalendar is the same as inDateTime
     */
    public boolean sameAs(GregorianCalendar inDateTime)
    {
        boolean isSameAs = false;

        if (utcDateTime.get(Calendar.YEAR) == inDateTime.get(Calendar.YEAR)
                && utcDateTime.get(Calendar.MONTH) == inDateTime.get(Calendar.MONTH)
                && utcDateTime.get(Calendar.DAY_OF_MONTH) == inDateTime.get(Calendar.DAY_OF_MONTH)
                && utcDateTime.get(Calendar.HOUR_OF_DAY) == inDateTime.get(Calendar.HOUR_OF_DAY)
                && utcDateTime.get(Calendar.MINUTE) == inDateTime.get(Calendar.MINUTE))
        {
            isSameAs = true;
        }

        return isSameAs;
    }

    public boolean newerThan(ZonedDateTime inDateTime)
    {
        // TODO: Complete this method
        return true;
        ;
    }

    public boolean olderThan(ZonedDateTime inDateTime)
    {
        // TODO: Complete this method
        return true;
    }

    public boolean sameAs(ZonedDateTime inDateTime)
    {
        // TODO: Complete this method
        return true;
    }

    public String toString()
    {
        String out = "";

        out += this.getStid();
        out += " ";
        out += this.getValue();

        return out;
    }
}
