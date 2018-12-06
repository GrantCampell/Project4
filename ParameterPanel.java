import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class ParameterPanel extends JPanel
{
    /**
     * Default ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * A JCheckBox that toggles whether or not tair data should be calculated.
     */
    JCheckBox tair = new JCheckBox("TAIR");

    /**
     * A JCheckBox that toggles whether or not ta9m data should be calculated.
     */
    JCheckBox ta9m = new JCheckBox("TA9M");

    /**
     * A JCheckBox that toggles whether or not srad data should be calculated.
     */
    JCheckBox srad = new JCheckBox("SRAD");

    /**
     * A JCheckBox that toggles whether or not wspd data should be calculated.
     */
    JCheckBox wspd = new JCheckBox("WSPD");

    /**
     * A JCheckBox that toggles whether or not pres data should be calculated.
     */
    JCheckBox pres = new JCheckBox("PRES");

    /**
     * A boolean that stores whether or not tair data will be calculated.
     */
    boolean tairSelect;

    /**
     * A boolean that stores whether or not ta9m data will be calculated.
     */
    boolean ta9mSelect;

    /**
     * A boolean that stores whether or not srad data will be calculated.
     */
    boolean sradSelect;

    /**
     * A boolean that stores whether or not wspd data will be calculated.
     */
    boolean wspdSelect;

    /**
     * A boolean that stores whether or not pres data will be calculated.
     */
    boolean presSelect;

    /**
     * Returns whether or not tair data is being calculated.
     * 
     * @return tairSelect A boolean that states whether or not tair data is being
     *         calculated.
     */
    public boolean getTairSelect()
    {
        return tairSelect;
    }

    /**
     * Returns whether or not ta9m data is being calculated.
     * 
     * @return tairSelect A boolean that states whether or not ta9m data is being
     *         calculated.
     */
    public boolean getTa9mSelect()
    {
        return ta9mSelect;
    }

    /**
     * Returns whether or not srad data is being calculated.
     * 
     * @return tairSelect A boolean that states whether or not srad data is being
     *         calculated.
     */
    public boolean getSradSelect()
    {
        return sradSelect;
    }

    /**
     * Returns whether or not wspd data is being calculated.
     * 
     * @return tairSelect A boolean that states whether or not wspd data is being
     *         calculated.
     */
    public boolean getWspdSelect()
    {
        return wspdSelect;
    }

    /**
     * Returns whether or not pres data is being calculated.
     * 
     * @return tairSelect A boolean that states whether or not pres data is being
     *         calculated.
     */
    public boolean getPresSelect()
    {
        return presSelect;
    }

    /**
     * The constructor for the ParameterPanel. Adds the checkboxes to the panel,
     * builds a border around it, and toggles whether or not each parameters data is
     * being calculated with item listeners.
     */
    public ParameterPanel()
    {
        add(tair);
        add(ta9m);
        add(srad);
        add(wspd);
        add(pres);
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Parameter"),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        tair.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent e)
            {
                if (e.getStateChange() == ItemEvent.SELECTED)
                {
                    tairSelect = true;
                }
                else
                {
                    tairSelect = false;
                }
            }
        });

        ta9m.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent e)
            {
                if (e.getStateChange() == ItemEvent.SELECTED)
                {
                    ta9mSelect = true;
                }
                else
                {
                    ta9mSelect = false;
                }
            }
        });

        srad.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent e)
            {
                if (e.getStateChange() == ItemEvent.SELECTED)
                {
                    sradSelect = true;
                }
                else
                {
                    sradSelect = false;
                }
            }
        });

        wspd.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent e)
            {
                if (e.getStateChange() == ItemEvent.SELECTED)
                {
                    wspdSelect = true;
                }
                else
                {
                    wspdSelect = false;
                }
            }
        });

        pres.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent e)
            {
                if (e.getStateChange() == ItemEvent.SELECTED)
                {
                    presSelect = true;
                }
                else
                {
                    presSelect = false;
                }
            }
        });
    }
}
