import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.GregorianCalendar;

import org.junit.Test;

import junit.framework.Assert;

/**
 * 
 * @author Grant Campbell
 * @version 10/28/2018
 * 
 *          Tests code and methods from the Statistics class
 */
public class StatisticsTest
{
    /**
     * LocalDateTime used to create ZonedDateTime for testing
     */
    LocalDateTime localDate = LocalDateTime.of(2018, 8, 30, 17, 45);

    /**
     * A ZonedDateTime to be used in tests
     */
    ZonedDateTime testZone = ZonedDateTime.of(localDate, ZoneId.of("America/Chicago"));

    /**
     * LocalDateTime used to create ZonedDateTime for testing
     */
    LocalDateTime localDate2 = LocalDateTime.of(2018, 8, 30, 17, 44);

    /**
     * A ZonedDateTime to be used in tests
     */
    ZonedDateTime testZone2 = ZonedDateTime.of(localDate2, ZoneId.of("America/Chicago"));

    /**
     * LocalDateTime used to create ZonedDateTime for testing
     */
    LocalDateTime localDate3 = LocalDateTime.of(2018, 8, 30, 17, 46);

    /**
     * A ZonedDateTime to be used in tests
     */
    ZonedDateTime testZone3 = ZonedDateTime.of(localDate3, ZoneId.of("America/Chicago"));

    /**
     * LocalDateTime used to create ZonedDateTime for testing
     */
    LocalDateTime localDate4 = LocalDateTime.of(2017, 8, 30, 17, 45);

    /**
     * A ZonedDateTime to be used in tests
     */
    ZonedDateTime testZone4 = ZonedDateTime.of(localDate4, ZoneId.of("America/Chicago"));

    /**
     * LocalDateTime used to create ZonedDateTime for testing
     */
    LocalDateTime localDate5 = LocalDateTime.of(2019, 8, 30, 17, 45);

    /**
     * A ZonedDateTime to be used in tests
     */
    ZonedDateTime testZone5 = ZonedDateTime.of(localDate5, ZoneId.of("America/Chicago"));

    /**
     * LocalDateTime used to create ZonedDateTime for testing
     */
    LocalDateTime localDate6 = LocalDateTime.of(2018, 7, 30, 17, 45);

    /**
     * A ZonedDateTime to be used in tests
     */
    ZonedDateTime testZone6 = ZonedDateTime.of(localDate6, ZoneId.of("America/Chicago"));

    /**
     * LocalDateTime used to create ZonedDateTime for testing
     */
    LocalDateTime localDate7 = LocalDateTime.of(2018, 9, 30, 17, 45);

    /**
     * A ZonedDateTime to be used in tests
     */
    ZonedDateTime testZone7 = ZonedDateTime.of(localDate7, ZoneId.of("America/Chicago"));

    /**
     * LocalDateTime used to create ZonedDateTime for testing
     */
    LocalDateTime localDate8 = LocalDateTime.of(2018, 8, 29, 17, 45);

    /**
     * A ZonedDateTime to be used in tests
     */
    ZonedDateTime testZone8 = ZonedDateTime.of(localDate8, ZoneId.of("America/Chicago"));

    /**
     * LocalDateTime used to create ZonedDateTime for testing
     */
    LocalDateTime localDate9 = LocalDateTime.of(2018, 8, 31, 17, 45);

    /**
     * A ZonedDateTime to be used in tests
     */
    ZonedDateTime testZone9 = ZonedDateTime.of(localDate9, ZoneId.of("America/Chicago"));

    /**
     * LocalDateTime used to create ZonedDateTime for testing
     */
    LocalDateTime localDate10 = LocalDateTime.of(2018, 8, 30, 16, 45);

    /**
     * A ZonedDateTime to be used in tests
     */
    ZonedDateTime testZone10 = ZonedDateTime.of(localDate10, ZoneId.of("America/Chicago"));

    /**
     * LocalDateTime used to create ZonedDateTime for testing
     */
    LocalDateTime localDate11 = LocalDateTime.of(2018, 8, 30, 18, 45);

    /**
     * A ZonedDateTime to be used in tests
     */
    ZonedDateTime testZone11 = ZonedDateTime.of(localDate11, ZoneId.of("America/Chicago"));

    /**
     * LocalDateTime used to create ZonedDateTime for testing
     */
    LocalDateTime localDate12 = LocalDateTime.of(2018, 12, 1, 1, 00);

    /**
     * A ZonedDateTime to be used in tests
     */
    ZonedDateTime testZone12 = ZonedDateTime.of(localDate12, ZoneId.of("America/Chicago"));

    /**
     * A dateTimeStr to be used for testing
     */
    String dateTimeStr = "2020-12-31'5'59";

    /**
     * A GregorianCalendar to be used in tests
     */
    GregorianCalendar testCal = new GregorianCalendar(2018, 8, 30, 17, 45);

    /**
     * A GregorianCalendar to be used in tests
     */
    GregorianCalendar testCal2 = new GregorianCalendar(2018, 8, 30, 17, 44);

    /**
     * A GregorianCalendar to be used in tests
     */
    GregorianCalendar testCal3 = new GregorianCalendar(2018, 8, 30, 17, 46);

    /**
     * A GregorianCalendar to be used in tests
     */
    GregorianCalendar testCal4 = new GregorianCalendar(2017, 8, 30, 17, 45);

    /**
     * A GregorianCalendar to be used in tests
     */
    GregorianCalendar testCal5 = new GregorianCalendar(2019, 8, 30, 17, 45);

    /**
     * A GregorianCalendar to be used in tests
     */
    GregorianCalendar testCal6 = new GregorianCalendar(2018, 7, 30, 17, 45);

    /**
     * A GregorianCalendar to be used in tests
     */
    GregorianCalendar testCal7 = new GregorianCalendar(2018, 9, 30, 17, 45);

    /**
     * A GregorianCalendar to be used in tests
     */
    GregorianCalendar testCal8 = new GregorianCalendar(2018, 8, 29, 17, 45);

    /**
     * A GregorianCalendar to be used in tests
     */
    GregorianCalendar testCal9 = new GregorianCalendar(2018, 8, 31, 17, 45);

    /**
     * A GregorianCalendar to be used in tests
     */
    GregorianCalendar testCal10 = new GregorianCalendar(2018, 8, 30, 16, 45);

    /**
     * A GregorianCalendar to be used in tests
     */
    GregorianCalendar testCal11 = new GregorianCalendar(2018, 8, 30, 18, 45);

    /**
     * A GregorianCalendar to be used in tests
     */
    GregorianCalendar testCalSp = new GregorianCalendar(2015, 10, 1, 1, 00);

    /**
     * A Statistics object to be used in tests
     */
    Statistics testStat = new Statistics(10.0, "Mesonet", testCal, 100, StatsType.AVERAGE);

    /**
     * A Statistics object to be used in tests
     */
    Statistics testStat2 = new Statistics(10.0, "Mesonet", testZone, 100, StatsType.AVERAGE);

    /**
     * Tests the createDateFromString method
     */
    @Test
    public void testCreateDateFromString()
    {
        Assert.assertEquals(testStat.createDateFromString(dateTimeStr), new GregorianCalendar(2020, 12, 31, 5, 59));
    }

    /**
     * Tests the createZDateFromString method
     */
    @Test
    public void testCreateZDateFromString()
    {
        Assert.assertEquals(testStat.createZDateFromString(dateTimeStr),
                ZonedDateTime.of(LocalDateTime.of(2020, 12, 31, 5, 59), ZoneId.of("America/Chicago")));
    }

    /**
     * Tests the cerateStringFromDate methods
     */
    @Test
    public void testCreateStringFromDate()
    {
        Assert.assertEquals(testStat.createStringFromDate(testCal), "2018-08-30'17'45");
        Assert.assertEquals(testStat.createStringFromDate(testCalSp), "2015-10-01'01'00");
    }

    /**
     * Tests the createStringFromDate with a ZonedTime method
     */
    @Test
    public void testCreateStringFromZDate()
    {
        Assert.assertEquals(testStat.createStringFromDate(testZone), "2018-08-30'17'45");
        Assert.assertEquals(testStat.createStringFromDate(testZone12), "2018-12-01'01'00");
    }

    /**
     * Tests the getNumberOfReportingStations method
     */
    @Test
    public void testGetNumberOfReportingStations()
    {
        Assert.assertEquals(testStat.getNumberOfReportingStations(), 100);
    }

    /**
     * Tests the getUTCDateTime method
     */
    @Test
    public void testGetUTCDateTime()
    {
        Assert.assertEquals(testStat.getUTCDateTimeString(), "2018-08-30'17'45");
    }

    /**
     * Tests the newerThan methods for both GregorianCalendar and ZonedDateTime
     */
    @Test
    public void testNewerThan()
    {
        // Tests the GregorianCalendars
        Assert.assertEquals(testStat.newerThan(testCal), false);
        Assert.assertEquals(testStat.newerThan(testCal2), true);
        Assert.assertEquals(testStat.newerThan(testCal3), false);
        Assert.assertEquals(testStat.newerThan(testCal4), true);
        Assert.assertEquals(testStat.newerThan(testCal5), false);
        Assert.assertEquals(testStat.newerThan(testCal6), true);
        Assert.assertEquals(testStat.newerThan(testCal7), false);
        Assert.assertEquals(testStat.newerThan(testCal8), true);
        Assert.assertEquals(testStat.newerThan(testCal9), false);
        Assert.assertEquals(testStat.newerThan(testCal10), true);
        Assert.assertEquals(testStat.newerThan(testCal11), false);

        // Tests the ZonedDateTimes
        Assert.assertEquals(testStat.newerThan(testZone), false);
        Assert.assertEquals(testStat.newerThan(testZone2), true);
        Assert.assertEquals(testStat.newerThan(testZone3), false);
        Assert.assertEquals(testStat.newerThan(testZone4), true);
        Assert.assertEquals(testStat.newerThan(testZone5), false);
        Assert.assertEquals(testStat.newerThan(testZone6), true);
        Assert.assertEquals(testStat.newerThan(testZone7), false);
        Assert.assertEquals(testStat.newerThan(testZone8), true);
        Assert.assertEquals(testStat.newerThan(testZone9), false);
        Assert.assertEquals(testStat.newerThan(testZone10), true);
        Assert.assertEquals(testStat.newerThan(testZone11), false);
    }

    /**
     * Tests the olderThan methods for both GregorianCalendar and ZonedDateTime
     */
    @Test
    public void testOlderThan()
    {
        // Tests the GregorianCalendars
        Assert.assertEquals(testStat.olderThan(testCal), false);
        Assert.assertEquals(testStat.olderThan(testCal2), false);
        Assert.assertEquals(testStat.olderThan(testCal3), true);
        Assert.assertEquals(testStat.olderThan(testCal4), false);
        Assert.assertEquals(testStat.olderThan(testCal5), true);
        Assert.assertEquals(testStat.olderThan(testCal6), false);
        Assert.assertEquals(testStat.olderThan(testCal7), true);
        Assert.assertEquals(testStat.olderThan(testCal8), false);
        Assert.assertEquals(testStat.olderThan(testCal9), true);
        Assert.assertEquals(testStat.olderThan(testCal10), false);
        Assert.assertEquals(testStat.olderThan(testCal11), true);

        // Tests the ZonedDateTimes
        Assert.assertEquals(testStat.olderThan(testZone), false);
        Assert.assertEquals(testStat.olderThan(testZone2), false);
        Assert.assertEquals(testStat.olderThan(testZone3), true);
        Assert.assertEquals(testStat.olderThan(testZone4), false);
        Assert.assertEquals(testStat.olderThan(testZone5), true);
        Assert.assertEquals(testStat.olderThan(testZone6), false);
        Assert.assertEquals(testStat.olderThan(testZone7), true);
        Assert.assertEquals(testStat.olderThan(testZone8), false);
        Assert.assertEquals(testStat.olderThan(testZone9), true);
        Assert.assertEquals(testStat.olderThan(testZone10), false);
        Assert.assertEquals(testStat.olderThan(testZone11), true);
    }

    /**
     * Tests the sameAs methods for both GregorianCalendar and ZonedDateTime
     */
    @Test
    public void testSameAs()
    {
        // Tests the gregorianCalendars
        Assert.assertEquals(testStat.sameAs(testCal), true);
        Assert.assertEquals(testStat.sameAs(testCal2), false);

        // Tests the ZonedDateTimes
        Assert.assertEquals(testStat.sameAs(testZone), true);
        Assert.assertEquals(testStat.sameAs(testZone2), false);
    }

    /**
     * Tests the toString method
     */
    @Test
    public void testToString()
    {
        Assert.assertEquals(testStat.toString(), "Mesonet 10.0");
    }

}
