import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 * A JFrame that contains a interface that can display the different statistics
 * of weather data.
 * 
 * @author Grant Campbell
 *
 */
public class MesonetFrame extends JFrame
{
    /**
     * Default ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * A JMenuBar that contains a file button. This button will allow the user to
     * load in data, or exit the program.
     * 
     * @author Grant Campbell
     *
     */
    public class FileMenuBar extends JMenuBar
    {
        /**
         * Default ID
         */
        private static final long serialVersionUID = 1L;

        /**
         * A file tab for a menu bar
         */
        JMenu file = new JMenu("File");

        /**
         * A load button that opens a file of data
         */
        JMenuItem load = new JMenuItem("Open Data File");

        /**
         * An exit button that closes out of the program
         */
        JMenuItem exitFile = new JMenuItem("Exit");

        /**
         * The constructor for the FileMenuBar. Adds the file tab which contains the
         * load and exit buttons. It also adds the action listeners for botht he load
         * and exit buttons.
         */
        public FileMenuBar()
        {
            add(file);
            file.add(load);
            file.add(exitFile);
            exitFile.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    System.exit(DO_NOTHING_ON_CLOSE);
                }
            });

            load.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    JFileChooser chooser = new JFileChooser("data");
                    FileNameExtensionFilter filter = new FileNameExtensionFilter("MDF Text Files", "mdf");
                    chooser.setFileFilter(filter);
                    chooser.showOpenDialog(getParent());
                    String dataIn = chooser.getSelectedFile().toString();
                    MapData mapData = new MapData(dataIn);

                    try
                    {
                        mapData.parseFile();
                    }
                    catch (IOException e1)
                    {
                        // Auto-generated catch block
                        e1.printStackTrace();
                    }

                    tairMin = mapData.getTairMin();
                    tairMax = mapData.getTairMax();
                    tairAvg = mapData.getTairAvg();
                    ta9mMin = mapData.getTa9mMin();
                    ta9mMax = mapData.getTa9mMax();
                    ta9mAvg = mapData.getTa9mAvg();
                    sradMin = mapData.getSradMin();
                    sradMax = mapData.getSradMax();
                    sradAvg = mapData.getSradAvg();
                    wspdMin = mapData.getWspdMin();
                    wspdMax = mapData.getWspdMax();
                    wspdAvg = mapData.getWspdAvg();
                    presMin = mapData.getPresMin();
                    presMax = mapData.getPresMax();
                    presAvg = mapData.getPresAvg();
                }
            });
        }
    }

    /**
     * A FileMenuBar that appears in the frame.
     */
    FileMenuBar menuBar = new FileMenuBar();

    /**
     * A StatisticsPanel that appears in the frame.
     */
    StatisticsPanel statsPanel = new StatisticsPanel();

    /**
     * A ParameterPanel that appears in the frame.
     */
    ParameterPanel paramPanel = new ParameterPanel();

    /**
     * A TablePanel that appears in the frame.
     */
    TabelPanel tabelPanel = new TabelPanel();

    /**
     * The MapData to be used by user interface.
     */
    MapData mapData;

    /**
     * Statistics object containing the minimum tair value and related information.
     */
    Statistics tairMin;

    /**
     * Statistics object containing the maximum tair value and related information.
     */
    Statistics tairMax;

    /**
     * Statistics object containing the average tair value and related information.
     */
    Statistics tairAvg;

    /**
     * Statistics object containing the minimum ta9m value and related information.
     */
    Statistics ta9mMin;

    /**
     * Statistics object containing the maximum ta9m value and related information.
     */
    Statistics ta9mMax;

    /**
     * Statistics object containing the average ta9m value and related information.
     */
    Statistics ta9mAvg;

    /**
     * Statistics object containing the minimum srad value and related information.
     */
    Statistics sradMin;

    /**
     * Statistics object containing the maximum srad value and related information.
     */
    Statistics sradMax;

    /**
     * Statistics object containing the average srad value and related information.
     */
    Statistics sradAvg;

    /**
     * Statistics object containing the minimum wspd value and related information.
     */
    Statistics wspdMin;

    /**
     * Statistics object containing the maximum wspd value and related information.
     */
    Statistics wspdMax;

    /**
     * Statistics object containing the average wspd value and related information.
     */
    Statistics wspdAvg;

    /**
     * Statistics object containing the minimum pres value and related information.
     */
    Statistics presMin;

    /**
     * Statistics object containing the maximum pres value and related information.
     */
    Statistics presMax;

    /**
     * Statistics object containing the average pres value and related information.
     */
    Statistics presAvg;

    // The slogan text box
    /**
     * A JLabel containing the slogan for the frame.
     */
    JLabel slogan = new JLabel();

    /**
     * A JButton that says "Calculate". Will be used to calculate data statistics.
     */
    JButton calculate = new JButton("Calculate");

    /**
     * A JButton that says "Exit". Will be used to exit the program.
     */
    JButton exit = new JButton("Exit");

    /**
     * A JPanel containing the Calculate and Exit buttons.
     */
    JPanel buttonsPanel = new JPanel();

    /**
     * The constructor for the MesonetFrame class. It takes in the name of the
     * frame, and then adds the panels to the frame. It also contains the action
     * listeners for the calculate and exit buttons.
     * 
     * @param title
     *            The name of the window the frame appears in.
     */
    public MesonetFrame(String title)
    {
        super(title);

        // Set Alignment of the JTextField and Jlabel
        slogan.setHorizontalAlignment(JLabel.CENTER);

        slogan.setText("Mesonet - We don't set records, we report them!");

        // sets the layout grid for the GUI
        setLayout(new GridLayout(6, 0));

        JScrollPane tableScrollPane = new JScrollPane(tabelPanel.table);

        buttonsPanel.add(calculate);
        buttonsPanel.add(exit);

        // Adds the panels to the frame
        setJMenuBar(menuBar);
        add(slogan);
        add(paramPanel);
        add(statsPanel);
        add(tableScrollPane);
        add(buttonsPanel);

        // Configuring of the frame
        setSize(800, 500);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        exit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.exit(DO_NOTHING_ON_CLOSE);
            }
        });

        calculate.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (statsPanel.max.isSelected())
                {
                    if (paramPanel.getTairSelect())
                    {
                        Statistics tempStat = tairMax;

                        DefaultTableModel model = (DefaultTableModel) tabelPanel.table.getModel();
                        model.addRow(new Object[] { tempStat.getStid(), "TAIR", "MAXIMUM", tempStat.getValue(),
                                tairMax.getNumberOfReportingStations(), tempStat.getUTCDateTimeString() });
                    }

                    if (paramPanel.getTa9mSelect())
                    {
                        Statistics tempStat = ta9mMax;

                        DefaultTableModel model = (DefaultTableModel) tabelPanel.table.getModel();
                        model.addRow(new Object[] { tempStat.getStid(), "TA9M", "MAXIMUM", tempStat.getValue(),
                                ta9mMax.getNumberOfReportingStations(), tempStat.getUTCDateTimeString() });
                    }

                    if (paramPanel.getSradSelect())
                    {
                        Statistics tempStat = sradMax;

                        DefaultTableModel model = (DefaultTableModel) tabelPanel.table.getModel();
                        model.addRow(new Object[] { tempStat.getStid(), "SRAD", "MAXIMUM", tempStat.getValue(),
                                sradMax.getNumberOfReportingStations(), tempStat.getUTCDateTimeString() });
                    }

                    if (paramPanel.getWspdSelect())
                    {
                        Statistics tempStat = wspdMax;

                        DefaultTableModel model = (DefaultTableModel) tabelPanel.table.getModel();
                        model.addRow(new Object[] { tempStat.getStid(), "WSPD", "MAXIMUM", tempStat.getValue(),
                                wspdMax.getNumberOfReportingStations(), tempStat.getUTCDateTimeString() });
                    }

                    if (paramPanel.getPresSelect())
                    {
                        Statistics tempStat = presMax;

                        DefaultTableModel model = (DefaultTableModel) tabelPanel.table.getModel();
                        model.addRow(new Object[] { tempStat.getStid(), "PRES", "MAXIMUM", tempStat.getValue(),
                                presMax.getNumberOfReportingStations(), tempStat.getUTCDateTimeString() });
                    }
                }
                else if (statsPanel.min.isSelected())
                {
                    if (paramPanel.getTairSelect())
                    {
                        Statistics tempStat = tairMin;

                        DefaultTableModel model = (DefaultTableModel) tabelPanel.table.getModel();
                        model.addRow(new Object[] { tempStat.getStid(), "TAIR", "MINIMUM", tempStat.getValue(),
                                tairMin.getNumberOfReportingStations(), tempStat.getUTCDateTimeString() });
                    }

                    if (paramPanel.getTa9mSelect())
                    {
                        Statistics tempStat = ta9mMin;

                        DefaultTableModel model = (DefaultTableModel) tabelPanel.table.getModel();
                        model.addRow(new Object[] { tempStat.getStid(), "TA9M", "MINIMUM", tempStat.getValue(),
                                ta9mMin.getNumberOfReportingStations(), tempStat.getUTCDateTimeString() });
                    }

                    if (paramPanel.getSradSelect())
                    {
                        Statistics tempStat = sradMin;

                        DefaultTableModel model = (DefaultTableModel) tabelPanel.table.getModel();
                        model.addRow(new Object[] { tempStat.getStid(), "SRAD", "MINIMUM", tempStat.getValue(),
                                sradMin.getNumberOfReportingStations(), tempStat.getUTCDateTimeString() });
                    }

                    if (paramPanel.getWspdSelect())
                    {
                        Statistics tempStat = wspdMin;

                        DefaultTableModel model = (DefaultTableModel) tabelPanel.table.getModel();
                        model.addRow(new Object[] { tempStat.getStid(), "WSPD", "MINIMUM", tempStat.getValue(),
                                wspdMin.getNumberOfReportingStations(), tempStat.getUTCDateTimeString() });
                    }

                    if (paramPanel.getPresSelect())
                    {
                        Statistics tempStat = presMin;

                        DefaultTableModel model = (DefaultTableModel) tabelPanel.table.getModel();
                        model.addRow(new Object[] { tempStat.getStid(), "PRES", "MINIMUM", tempStat.getValue(),
                                presMin.getNumberOfReportingStations(), tempStat.getUTCDateTimeString() });
                    }
                }
                else if (statsPanel.avg.isSelected())
                {
                    if (paramPanel.getTairSelect())
                    {
                        Statistics tempStat = tairAvg;

                        DefaultTableModel model = (DefaultTableModel) tabelPanel.table.getModel();
                        model.addRow(new Object[] { tempStat.getStid(), "TAIR", "AVERAGE", tempStat.getValue(),
                                tairAvg.getNumberOfReportingStations(), tempStat.getUTCDateTimeString() });
                    }

                    if (paramPanel.getTa9mSelect())
                    {
                        Statistics tempStat = ta9mAvg;

                        DefaultTableModel model = (DefaultTableModel) tabelPanel.table.getModel();
                        model.addRow(new Object[] { tempStat.getStid(), "TA9M", "AVGERAGE", tempStat.getValue(),
                                ta9mAvg.getNumberOfReportingStations(), tempStat.getUTCDateTimeString() });
                    }

                    if (paramPanel.getSradSelect())
                    {
                        Statistics tempStat = sradAvg;

                        DefaultTableModel model = (DefaultTableModel) tabelPanel.table.getModel();
                        model.addRow(new Object[] { tempStat.getStid(), "SRAD", "AVERAGE", tempStat.getValue(),
                                sradAvg.getNumberOfReportingStations(), tempStat.getUTCDateTimeString() });
                    }

                    if (paramPanel.getWspdSelect())
                    {
                        Statistics tempStat = wspdAvg;

                        DefaultTableModel model = (DefaultTableModel) tabelPanel.table.getModel();
                        model.addRow(new Object[] { tempStat.getStid(), "WSPD", "AVERAGE", tempStat.getValue(),
                                wspdAvg.getNumberOfReportingStations(), tempStat.getUTCDateTimeString() });
                    }

                    if (paramPanel.getPresSelect())
                    {
                        Statistics tempStat = presAvg;

                        DefaultTableModel model = (DefaultTableModel) tabelPanel.table.getModel();
                        model.addRow(new Object[] { tempStat.getStid(), "PRES", "AVERAGE", tempStat.getValue(),
                                presAvg.getNumberOfReportingStations(), tempStat.getUTCDateTimeString() });
                    }
                }
            }
        });
    }
}
