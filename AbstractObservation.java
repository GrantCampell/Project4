
public abstract class AbstractObservation
{
    protected boolean valid;

    public AbstractObservation()
    {
        isValid();
    }

    public boolean isValid()
    {
        return valid;
    }
}
