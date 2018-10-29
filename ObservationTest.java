import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * @author Grant Campbell
 * @version 10/28/2018
 * 
 *          Tests the methods and code from the Observation class
 */
public class ObservationTest
{

    /**
     * A Observation object called tester to be used for testing
     */
    Observation tester = new Observation(15.34, "test");

    /**
     * A Observation object called tester2 to be used for testing
     */
    Observation tester2 = new Observation(-999, "test2");

    /**
     * Tests to see if an Observations data was correctly stored
     */
    @Test
    public void testObservation()
    {
        assertEquals(tester.getValue(), 15.34, 1);
        assertEquals(tester.getStid(), "test");
    }

    /**
     * Tests to see if a value was correctly stored
     */
    @Test
    public void testGetValue()
    {
        assertEquals(tester.getValue(), 15.34, 1);
    }

    /**
     * Tests to see if a value is valid
     */
    @Test
    public void testIsValid()
    {
        assertEquals(tester.isValid(), true);
        assertEquals(tester2.isValid(), false);
    }

    /**
     * Tests to see if an Observation's station ID is correct
     */
    @Test
    public void testGetStid()
    {
        assertEquals(tester.getStid(), "test");
    }

    /**
     * Tests to see if the Observation method toString outputs the correct String
     */
    @Test
    public void testToString()
    {
        assertEquals(tester.toString(), "15.34 test");
    }

}
