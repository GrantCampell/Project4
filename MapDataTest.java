import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class MapDataTest
{

    //TODO: Add new tests for new classes
    
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
        String test = "data/201808010700.mdf";
        Assert.assertEquals(tester.createFileName(), test);
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
