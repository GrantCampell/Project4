import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import org.junit.Test;

import junit.framework.Assert;

public class StatisticsTest
{
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
    Statistics testStat = new Statistics(10.0, "Mesonet", testCal, 100, StatsType.AVERAGE);

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
        Assert.assertEquals(testStat.newerThan(testCal), false);
        Assert.assertEquals(testStat.newerThan(testCal2), true);
        Assert.assertEquals(testStat.newerThan(testCal3), false);
        Assert.assertEquals(testStat.newerThan(testCal4), true);
        Assert.assertEquals(testStat.newerThan(testCal5), false);
        Assert.assertEquals(testStat.newerThan(testCal6), true);
        Assert.assertEquals(testStat.newerThan(testCal7), false);
        Assert.assertEquals(testStat.newerThan(testCal8), true);
        Assert.assertEquals(testStat.newerThan(testCal9), false);
        Assert.assertEquals(testStat.newerThan(testCal10), false);
        Assert.assertEquals(testStat.newerThan(testCal11), false);
    }

    @Test
    public void testOlderThan()
    {
        Assert.assertEquals(testStat.olderThan(testCal), false);
        Assert.assertEquals(testStat.olderThan(testCal2), false);
        Assert.assertEquals(testStat.olderThan(testCal3), true);
        Assert.assertEquals(testStat.olderThan(testCal4), false);
        Assert.assertEquals(testStat.olderThan(testCal5), true);
        Assert.assertEquals(testStat.olderThan(testCal6), false);
        Assert.assertEquals(testStat.olderThan(testCal7), true);
        Assert.assertEquals(testStat.olderThan(testCal8), false);
        Assert.assertEquals(testStat.olderThan(testCal9), true);
        Assert.assertEquals(testStat.olderThan(testCal10), true);
        Assert.assertEquals(testStat.olderThan(testCal11), true);
    }

    @Test
    public void testSameAs()
    {
        Assert.assertEquals(testStat.sameAs(testCal), true);
        Assert.assertEquals(testStat.sameAs(testCal2), false);
        Assert.assertEquals(testStat.sameAs(testCal3), false);
        Assert.assertEquals(testStat.sameAs(testCal4), false);
        Assert.assertEquals(testStat.sameAs(testCal5), false);
        Assert.assertEquals(testStat.sameAs(testCal6), false);
        Assert.assertEquals(testStat.sameAs(testCal7), false);
        Assert.assertEquals(testStat.sameAs(testCal8), false);
        Assert.assertEquals(testStat.sameAs(testCal9), false);
        Assert.assertEquals(testStat.sameAs(testCal10), false);
        Assert.assertEquals(testStat.sameAs(testCal11), false);
    }

    @Test
    public void testToString()
    {
        fail("Not yet implemented");
    }

}
