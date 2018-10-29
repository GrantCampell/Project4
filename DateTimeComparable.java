import java.time.ZonedDateTime;
import java.util.GregorianCalendar;

/**
 * @author Grant Campbell
 * @version 10/28/2018
 * 
 *          A Comparable that is used with the Statistics class to compare
 *          dates.
 *
 */
public interface DateTimeComparable
{
    /**
     * Compares two GregorianCalendar objects and returns true if 'this' is newer
     * than inDateTimeUTC.
     * 
     * @param inDateTimeUTC
     * @return boolean stating whether or not the reference variable is newer than
     *         the parameter.
     */
    public boolean newerThan(GregorianCalendar inDateTimeUTC);

    /**
     * Compares two GregorianCalendar objects and returns true if 'this' is older
     * than inDateTimeUTC.
     * 
     * @param inDateTimeUTC
     * @return boolean stating whether or not the reference variable is older than
     *         the parameter.
     */
    public boolean olderThan(GregorianCalendar inDateTimeUTC);

    /**
     * Compares two GregorianCalendar objects and returns true if 'this' is the same
     * as inDateTimeUTC.
     * 
     * @param inDateTimeUTC
     * @return boolean stating whether or not the reference variable is the same as
     *         the parameter.
     */
    public boolean sameAs(GregorianCalendar inDateTimeUTC);

    /**
     * Compares two ZonedDateTime objects and returns true if 'this' is newer than
     * inDateTimeUTC.
     * 
     * @param inDateTimeUTC
     * @return boolean stating whether or not the reference variable is newer than
     *         the parameter.
     */
    public boolean newerThan(ZonedDateTime inDateTimeUTC);

    /**
     * Compares two ZonedDateTime objects and returns true if 'this' is older than
     * inDateTimeUTC.
     * 
     * @param inDateTimeUTC
     * @return boolean stating whether or not the reference variable is older than
     *         the parameter.
     */
    public boolean olderThan(ZonedDateTime inDateTimeUTC);

    /**
     * Compares two ZonedDateTime objects and returns true if 'this' is the same as
     * inDateTimeUTC.
     * 
     * @param inDateTimeUTC
     * @return boolean stating whether or not the reference variable is the same as
     *         the parameter.
     */
    public boolean sameAs(ZonedDateTime inDateTimeUTC);
}
