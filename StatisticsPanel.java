import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class StatisticsPanel extends JPanel
{
    public static ButtonGroup stats = new ButtonGroup();

    JRadioButton max = new JRadioButton("MAXIMUM");
    JRadioButton min = new JRadioButton("MINIMUM");
    JRadioButton avg = new JRadioButton("AVERAGE");
    
    public StatisticsPanel()
    {
        add(max);
        add(min);
        add(avg);
        max.setSelected(true);
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Statisitcs"),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
    }
}
