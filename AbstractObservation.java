/**
 * 
 * @author Grant Campbell
 * @version 10/28/2018
 * 
 *          AbstractObservation is used to hold information taken in from the
 *          data.
 */
public abstract class AbstractObservation
{
    /**
     * Stores whether or not the Observation contains valid data.
     */
    protected boolean valid;

    /**
     * Constructor for AbstractObservation. Checks the Observation class to find
     * Observation validity.
     */
    public AbstractObservation()
    {
        isValid();
    }

    /**
     * Works with the Observation class to decide if an Observation is valid.
     * 
     * @return Validity of the Observation.
     */
    public boolean isValid()
    {
        return valid;
    }
}
