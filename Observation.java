
public class Observation
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
        // Mesonet reports missing data as -999
        // If the value in an Observation is -999, it's invalid and is added to a
        // invalid counter
        if (getValue() == -999)
        {
            return false;
        }
        else
        {
            // If the value is literally anything else, it is valid
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
