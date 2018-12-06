import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * A Class that creates a JPanel that will hold a ButtonGroup of statistics to
 * choose from. The chosen statistic will be calculated for the desired
 * parameter.
 * 
 * @author Grant Campbell
 *
 */
public class StatisticsPanel extends JPanel
{
    /**
     * A ButtonGroup containing the stats that can be calculated for the data.
     */
    ButtonGroup stats = new ButtonGroup();

    /**
     * A JRadioButton that selects the maximum of the data to be calculated.
     */
    JRadioButton max = new JRadioButton("MAXIMUM");

    /**
     * A JRadioButton that selects the minimum of the data to be calculated.
     */
    JRadioButton min = new JRadioButton("MINIMUM");

    /**
     * A JRadioButton that selects the average of the data to be calculated.
     */
    JRadioButton avg = new JRadioButton("AVERAGE");

    /**
     * The constructor for the StatisticsPanel. It adds the stats buttons to the
     * panel, creates a border around itself, and sets maximum as the default
     * selected stat.
     */
    public StatisticsPanel()
    {
        stats.add(max);
        stats.add(min);
        stats.add(avg);
        add(max);
        add(min);
        add(avg);
        max.setSelected(true);
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Statisitcs"),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
    }
}
