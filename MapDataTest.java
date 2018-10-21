import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class MapDataTest
{

    /**
     * A MapData object called tested that is used in testing
     */
    MapData tester = new MapData(2018, 8, 1, 7, 00, "data");

    /**
     * Tests the createFileName method();
     */
    @Test
    public void testCreateFileName()
    {
        String test = "201808010700.mdf";
        Assert.assertEquals(tester.createFileName(), test);
    }

    /**
     * Tests the getTairMin method
     * 
     * @throws IOException
     *             Throws an exceptions if the input to parseFile() is invalid
     */
    @Test
    public void testGetTairMin() throws IOException
    {
        tester.parseFile();
        Assert.assertEquals(tester.getTairMin().getValue(), 13.8, 0.1);
        Assert.assertEquals(tester.getTairMin().getStid(), "EVAX");
    }

    /**
     * Tests the getTairMax method
     * 
     * @throws IOException
     *             Throws an exceptions if the input to parseFile() is invalid
     */
    @Test
    public void testGetTairMax() throws IOException
    {
        tester.parseFile();
        Assert.assertEquals(tester.getTairMax().getValue(), 21.7, 0.1);
        Assert.assertEquals(tester.getTairMax().getStid(), "MEDI");
    }

    /**
     * Tests the getTaiAverage method
     * 
     * @throws IOException
     *             Throws an exceptions if the input to parseFile() is invalid
     */
    @Test
    public void testGetTairAverage() throws IOException
    {
        tester.parseFile();
        Assert.assertEquals(tester.getTairAverage().getValue(), 17.98, 0.1);
        Assert.assertEquals(tester.getTairAverage().getStid(), "Mesonet");
    }

    /**
     * Tests the getTa9mMin method
     * 
     * @throws IOException
     *             Throws an exceptions if the input to parseFile() is invalid
     */
    @Test
    public void testGetTa9mMin() throws IOException
    {
        tester.parseFile();
        Assert.assertEquals(tester.getTa9mMin().getValue(), 15.8, 0.1);
        Assert.assertEquals(tester.getTa9mMin().getStid(), "COOK");
    }

    /**
     * tests the getTa9mMax method
     * 
     * @throws IOException
     *             Throws an exceptions if the input to parseFile() is invalid
     */
    @Test
    public void testGetTa9mMax() throws IOException
    {
        tester.parseFile();
        Assert.assertEquals(tester.getTa9mMax().getValue(), 23.3, 0.1);
        Assert.assertEquals(tester.getTa9mMax().getStid(), "MARE");
    }

    /**
     * Tests the getTa9mAverage method
     * 
     * @throws IOException
     *             Throws an exceptions if the input to parseFile() is invalid
     */
    @Test
    public void testGetTa9mAverage() throws IOException
    {
        tester.parseFile();
        Assert.assertEquals(tester.getTa9mAverage().getValue(), 19.69, 0.1);
        Assert.assertEquals(tester.getTa9mAverage().getStid(), "Mesonet");
    }

    /**
     * Tests the getSradMin method
     * 
     * @throws IOException
     *             Throws an exceptions if the input to parseFile() is invalid
     */
    @Test
    public void testGetSradMin() throws IOException
    {
        tester.parseFile();
        Assert.assertEquals(tester.getSradMin().getValue(), 0.0, 0.1);
        Assert.assertEquals(tester.getSradMin().getStid(), "YUKO");
    }

    /**
     * Tests the getSradMax method
     * 
     * @throws IOException
     *             Throws an exceptions if the input to parseFile() is invalid
     */
    @Test
    public void testGetSradMax() throws IOException
    {
        tester.parseFile();
        Assert.assertEquals(tester.getSradMax().getValue(), 0.0, 0.1);
        Assert.assertEquals(tester.getSradMax().getStid(), "YUKO");
    }

    /**
     * Tests the getSradAverage method
     * 
     * @throws IOException
     *             Throws an exceptions if the input to parseFile() is invalid
     */
    @Test
    public void testGetSradAverage() throws IOException
    {
        tester.parseFile();
        Assert.assertEquals(tester.getSradAverage().getValue(), 0.0, 0.1);
        Assert.assertEquals(tester.getSradAverage().getStid(), "Mesonet");
    }

    /**
     * Tests the getSradTotal method
     * 
     * @throws IOException
     *             Throws an exceptions if the input to parseFile() is invalid
     */
    @Test
    public void testGetSradTotal() throws IOException
    {
        tester.parseFile();
        Assert.assertEquals(tester.getSradTotal().getValue(), 0.0, 0.1);
        Assert.assertEquals(tester.getSradTotal().getStid(), "Mesonet");
    }

    /**
     * Tests the toString method
     * 
     * @throws IOException
     *             Throws an exceptions if the input to parseFile() is invalid
     */
    @Test
    public void testToString() throws IOException
    {
        tester.parseFile();
        assertEquals(tester.toString(),
                "==========================================================\n" + "=== 2018-08-01 07:00 ===\n"
                        + "==========================================================\n"
                        + "Maximum Air Temperature[1.5m] = 21.7 C at MEDI\n"
                        + "Minimum Air Temperature[1.5m] = 13.8 C at EVAX\n"
                        + "Average Air Temperature[1.5m] = 18.0 C at Mesonet\n"
                        + "==========================================================\n"
                        + "==========================================================\n"
                        + "Maximum Air Temperature[9.0m] = 23.3 C at MARE\n"
                        + "Minimum Air Temperature[9.0m] = 15.8 C at COOK\n"
                        + "Average Air Temperature[9.0m] = 19.7 C at Mesonet\n"
                        + "==========================================================\n"
                        + "==========================================================\n"
                        + "Maximum Solar Radiation[1.5m] = 0.0 W/m^2 at YUKO\n"
                        + "Minimum Solar Radiation[1.5m] = 0.0 W/m^2 at YUKO\n"
                        + "Average Solar Radiation[1.5m] = 0.0 W/m^2 at Mesonet\n"
                        + "==========================================================");
    }
}
