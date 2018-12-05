import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TabelPanel extends JPanel
{
    /**
     * Default ID
     */
    private static final long serialVersionUID = 1L;
    String[] columnNames = { "Station", "Parameter", "Statistics", "Value", "Reporting Stations", "Date" };
    Object[][] rowData = {};

    private DefaultTableModel tableModel = new DefaultTableModel(rowData, columnNames);
    JTable table = new JTable(tableModel);
}
