import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import org.junit.Test;

public class StatisticsTest
{
    /**
     * A StatsType reference for the type Average
     */
    StatsType avg = StatsType.AVERAGE;

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
    GregorianCalendar testCal10 = new GregorianCalendar(2018, 8, 31, 16, 45);
    
    /**
     * A GregorianCalendar to be used in tests
     */
    GregorianCalendar testCal11 = new GregorianCalendar(2018, 8, 31, 18, 45);

    /**
     * A Statistics object to be used in tests
     */
    Statistics testStat = new Statistics(10.0, "Mesonet", testCal, 100, avg);

    @Test
    public void testStatisticsDoubleStringStringIntStatsType()
    {
        fail("Not yet implemented");
    }

    @Test
    public void testStatisticsDoubleStringGregorianCalendarIntStatsType()
    {
        fail("Not yet implemented");
    }

    @Test
    public void testCreateDateFromString()
    {
        fail("Not yet implemented");
    }

    @Test
    public void testCreateStringFromDate()
    {
        fail("Not yet implemented");
    }

    @Test
    public void testGetNumberOfReportingStations()
    {
        fail("Not yet implemented");
    }

    @Test
    public void testGetUTCDateTime()
    {
        fail("Not yet implemented");
    }

    @Test
    public void testNewerThan()
    {
        fail("Not yet implemented");
    }

    @Test
    public void testOlderThan()
    {
        fail("Not yet implemented");
    }

    @Test
    public void testSameAs()
    {
        fail("Not yet implemented");
    }

    @Test
    public void testToString()
    {
        fail("Not yet implemented");
    }

}
