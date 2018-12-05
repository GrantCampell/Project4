import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class MesonetFrame extends JFrame
{
    public class FileMenuBar extends JMenuBar
    {
        /**
         * Default ID
         */
        private static final long serialVersionUID = 1L;

        JMenu file = new JMenu("File");
        JMenuItem load = new JMenuItem("Open Data File");
        JMenuItem exitFile = new JMenuItem("Exit");

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

    FileMenuBar menuBar = new FileMenuBar();
    StatisticsPanel statsPanel = new StatisticsPanel();
    ParameterPanel parmPanel = new ParameterPanel();
    TabelPanel tabelPanel = new TabelPanel();

    MapData mapData;

    String statSelect;
    boolean tairSelect = false;
    boolean ta9mSelect = false;
    boolean sradSelect = false;
    boolean wspdSelect = false;
    boolean presSelect = false;

    Statistics tairMin;
    Statistics tairMax;
    Statistics tairAvg;
    Statistics ta9mMin;
    Statistics ta9mMax;
    Statistics ta9mAvg;
    Statistics sradMin;
    Statistics sradMax;
    Statistics sradAvg;
    Statistics wspdMin;
    Statistics wspdMax;
    Statistics wspdAvg;
    Statistics presMin;
    Statistics presMax;
    Statistics presAvg;

    // The slogan text box
    JLabel slogan = new JLabel();
    JButton calculate = new JButton("Calculate");
    JButton exit = new JButton("Exit");

    public MesonetFrame(String title)
    {
        super(title);

        // Set Alignment of the JTextField and Jlabel
        slogan.setHorizontalAlignment(JLabel.CENTER);

        slogan.setText("Mesonet - We don't set records, we report them!");

        // sets the layout grid for the GUI
        setLayout(new GridLayout(6, 0));

        JScrollPane tableScrollPane = new JScrollPane(tabelPanel.table);

        // Adds the panels to the frame
        setJMenuBar(menuBar);
        add(slogan);
        add(parmPanel);
        add(statsPanel);
        add(tableScrollPane);
        add(calculate);
        add(exit);

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

        parmPanel.tair.addItemListener(new ItemListener()
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

        parmPanel.ta9m.addItemListener(new ItemListener()
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

        parmPanel.srad.addItemListener(new ItemListener()
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

        parmPanel.wspd.addItemListener(new ItemListener()
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

        parmPanel.pres.addItemListener(new ItemListener()
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

        calculate.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (statsPanel.max.isSelected())
                {
                    if (tairSelect)
                    {
                        Statistics tempStat = tairMax;

                        DefaultTableModel model = (DefaultTableModel) tabelPanel.table.getModel();
                        model.addRow(new Object[] { tempStat.getStid(), "TAIR", "MAXIMUM", tempStat.getValue(),
                                tairMax.getNumberOfReportingStations(), tempStat.getUTCDateTimeString() });
                    }

                    if (ta9mSelect)
                    {
                        Statistics tempStat = ta9mMax;

                        DefaultTableModel model = (DefaultTableModel) tabelPanel.table.getModel();
                        model.addRow(new Object[] { tempStat.getStid(), "TA9M", "MAXIMUM", tempStat.getValue(),
                                ta9mMax.getNumberOfReportingStations(), tempStat.getUTCDateTimeString() });
                    }

                    if (sradSelect)
                    {
                        Statistics tempStat = sradMax;

                        DefaultTableModel model = (DefaultTableModel) tabelPanel.table.getModel();
                        model.addRow(new Object[] { tempStat.getStid(), "SRAD", "MAXIMUM", tempStat.getValue(),
                                sradMax.getNumberOfReportingStations(), tempStat.getUTCDateTimeString() });
                    }

                    if (wspdSelect)
                    {
                        Statistics tempStat = wspdMax;

                        DefaultTableModel model = (DefaultTableModel) tabelPanel.table.getModel();
                        model.addRow(new Object[] { tempStat.getStid(), "WSPD", "MAXIMUM", tempStat.getValue(),
                                wspdMax.getNumberOfReportingStations(), tempStat.getUTCDateTimeString() });
                    }

                    if (presSelect)
                    {
                        Statistics tempStat = presMax;

                        DefaultTableModel model = (DefaultTableModel) tabelPanel.table.getModel();
                        model.addRow(new Object[] { tempStat.getStid(), "PRES", "MAXIMUM", tempStat.getValue(),
                                presMax.getNumberOfReportingStations(), tempStat.getUTCDateTimeString() });
                    }
                }
                else if (statsPanel.min.isSelected())
                {
                    if (tairSelect)
                    {
                        Statistics tempStat = tairMin;

                        DefaultTableModel model = (DefaultTableModel) tabelPanel.table.getModel();
                        model.addRow(new Object[] { tempStat.getStid(), "TAIR", "MINIMUM", tempStat.getValue(),
                                tairMin.getNumberOfReportingStations(), tempStat.getUTCDateTimeString() });
                    }

                    if (ta9mSelect)
                    {
                        Statistics tempStat = ta9mMin;

                        DefaultTableModel model = (DefaultTableModel) tabelPanel.table.getModel();
                        model.addRow(new Object[] { tempStat.getStid(), "TA9M", "MINIMUM", tempStat.getValue(),
                                ta9mMin.getNumberOfReportingStations(), tempStat.getUTCDateTimeString() });
                    }

                    if (sradSelect)
                    {
                        Statistics tempStat = sradMin;

                        DefaultTableModel model = (DefaultTableModel) tabelPanel.table.getModel();
                        model.addRow(new Object[] { tempStat.getStid(), "SRAD", "MINIMUM", tempStat.getValue(),
                                sradMin.getNumberOfReportingStations(), tempStat.getUTCDateTimeString() });
                    }

                    if (wspdSelect)
                    {
                        Statistics tempStat = wspdMin;

                        DefaultTableModel model = (DefaultTableModel) tabelPanel.table.getModel();
                        model.addRow(new Object[] { tempStat.getStid(), "WSPD", "MINIMUM", tempStat.getValue(),
                                wspdMin.getNumberOfReportingStations(), tempStat.getUTCDateTimeString() });
                    }

                    if (presSelect)
                    {
                        Statistics tempStat = presMin;

                        DefaultTableModel model = (DefaultTableModel) tabelPanel.table.getModel();
                        model.addRow(new Object[] { tempStat.getStid(), "PRES", "MINIMUM", tempStat.getValue(),
                                presMin.getNumberOfReportingStations(), tempStat.getUTCDateTimeString() });
                    }
                }
                else if (statsPanel.avg.isSelected())
                {
                    if (tairSelect)
                    {
                        Statistics tempStat = tairAvg;

                        DefaultTableModel model = (DefaultTableModel) tabelPanel.table.getModel();
                        model.addRow(new Object[] { tempStat.getStid(), "TAIR", "AVERAGE", tempStat.getValue(),
                                tairAvg.getNumberOfReportingStations(), tempStat.getUTCDateTimeString() });
                    }

                    if (ta9mSelect)
                    {
                        Statistics tempStat = ta9mAvg;

                        DefaultTableModel model = (DefaultTableModel) tabelPanel.table.getModel();
                        model.addRow(new Object[] { tempStat.getStid(), "TA9M", "AVGERAGE", tempStat.getValue(),
                                ta9mAvg.getNumberOfReportingStations(), tempStat.getUTCDateTimeString() });
                    }

                    if (sradSelect)
                    {
                        Statistics tempStat = sradAvg;

                        DefaultTableModel model = (DefaultTableModel) tabelPanel.table.getModel();
                        model.addRow(new Object[] { tempStat.getStid(), "SRAD", "AVERAGE", tempStat.getValue(),
                                sradAvg.getNumberOfReportingStations(), tempStat.getUTCDateTimeString() });
                    }

                    if (wspdSelect)
                    {
                        Statistics tempStat = wspdAvg;

                        DefaultTableModel model = (DefaultTableModel) tabelPanel.table.getModel();
                        model.addRow(new Object[] { tempStat.getStid(), "WSPD", "AVERAGE", tempStat.getValue(),
                                wspdAvg.getNumberOfReportingStations(), tempStat.getUTCDateTimeString() });
                    }

                    if (presSelect)
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
