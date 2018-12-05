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
}
