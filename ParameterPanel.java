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
    JCheckBox tair = new JCheckBox("TAIR");
    JCheckBox ta9m = new JCheckBox("TA9M");
    JCheckBox srad = new JCheckBox("SRAD");
    JCheckBox wspd = new JCheckBox("WSPD");
    JCheckBox pres = new JCheckBox("PRES");
    
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
