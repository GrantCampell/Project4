/**
 * 
 * @author Grant Campbell
 * @version 10/28/2018
 * 
 *          Stores the value and ID collected by a station for air temperature
 *          and solar radiation.
 */
public class Observation extends AbstractObservation
{
    /**
     * A double containing the value of an observation
     */
    private double value;

    /**
     * A String that contains the station ID for a given value
     */
    private String stid;

    /**
     * The default constructor for the Observation class. It takes in a value and ID
     * given by parseFile and turns it into an Observation object.
     * 
     * @param value
     *            the double value to be stored in the object
     * @param stid
     *            the station ID that corresponds to the value
     */
    public Observation(double value, String stid)
    {
        this.value = value;
        this.stid = stid;
        this.isValid();
    }

    /**
     * @return the value
     */
    public double getValue()
    {
        return value;
    }

    /**
     * Determines the validity of a value held by an observation.
     * 
     * @return validity
     */
    public boolean isValid()
    {
        if (getValue() == -999)
        {
            super.valid = false;
            return false;
        }
        else
        {
            super.valid = true;
            return true;
        }
    }

    /**
     * @return the stid
     */
    public String getStid()
    {
        return stid;
    }

    /**
     * Returns a string that contains the value and ID held by an Observation
     * seperated by a space
     * 
     * @return the output
     */
    public String toString()
    {
        String output = getValue() + " " + getStid();
        return output;
    }
}
