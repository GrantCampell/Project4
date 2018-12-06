import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TabelPanel extends JPanel
{
    /**
     * Default ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * String array containg the names of each column for the table.
     */
    String[] columnNames = { "Station", "Parameter", "Statistics", "Value", "Reporting Stations", "Date" };

    /**
     * An empty object array containing arrays. Used as the initial state of the
     * table.
     */
    Object[][] rowData = {};

    /**
     * A DefaultTableModel that allows the table to be edited when stats are
     * calculated.
     */
    private DefaultTableModel tableModel = new DefaultTableModel(rowData, columnNames);

    /**
     * A JTable that uses the DefaultTabelModel to create a table on the GUI.
     */
    JTable table = new JTable(tableModel);
}
