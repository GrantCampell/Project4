import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MapFrame extends JFrame
{
    private static final long serialVersionUID = 1L;

    MapData mapData;

    String statSelect;
    boolean tairSelect = false;
    boolean ta9mSelect = false;
    boolean sradSelect = false;
    boolean wspdSelect = false;
    boolean presSelect = false;

    JPanel sloganPanel = new JPanel();
    JPanel checkPanel = new JPanel();
    JPanel statsPanel = new JPanel();
    JPanel infoPanel = new JPanel();
    JPanel buttonsPanel = new JPanel();

    // The menu bar
    JMenuBar menu = new JMenuBar();
    JMenu file = new JMenu("File");
    JMenuItem load = new JMenuItem("Open Data File");
    JMenuItem exitFile = new JMenuItem("Exit");

    // The slogan text box
    JLabel slogan = new JLabel();

    // Check boxes for the parameters
    JCheckBox tair = new JCheckBox("TAIR");
    JCheckBox ta9m = new JCheckBox("TA9M");
    JCheckBox srad = new JCheckBox("SRAD");
    JCheckBox wspd = new JCheckBox("WSPD");
    JCheckBox pres = new JCheckBox("PRES");

    ButtonGroup stats = new ButtonGroup();

    JRadioButton max = new JRadioButton("MAXIMUM");
    JRadioButton min = new JRadioButton("MINIMUM");
    JRadioButton avg = new JRadioButton("AVERAGE");

    JButton calculate = new JButton("Calculate");
    JButton exit = new JButton("Exit");

    String[] columnNames = { "Station", "Parameter", "Statistics", "Value", "Reporting Stations", "Date" };
    Object[][] rowData = {};

    public MapFrame(String title)
    {
        super(title);

        // Set Alignment of the JTextField and Jlabel
        slogan.setHorizontalAlignment(JLabel.LEFT);

        slogan.setText("Mesonet - We don't set records, we report them!");

        // sets the layout grid for the GUI
        setLayout(new GridLayout(5, 0));

        // Buttons added to the stats button group
        stats.add(max);
        stats.add(min);
        stats.add(avg);

        // Adds menu items
        file.add(load);
        file.add(exitFile);
        menu.add(file);

        // Slogan added to sloganPanel
        sloganPanel.add(slogan);

        // Check boxes added to checkPanel
        checkPanel.add(tair);
        checkPanel.add(ta9m);
        checkPanel.add(srad);
        checkPanel.add(wspd);
        checkPanel.add(pres);
        checkPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Parameter"),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        // Buttons added to statsPanel
        statsPanel.add(max);
        statsPanel.add(min);
        statsPanel.add(avg);
        statsPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Statisitcs"),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        // Adds buttons to the buttonsPanel
        buttonsPanel.add(calculate);
        buttonsPanel.add(exit);

        // TODO: THIS IS THE TABLE REFRESHER
        JTable infoBox = new JTable(rowData, columnNames);
        JScrollPane tableScrollPane = new JScrollPane(infoBox);
        infoPanel.add(tableScrollPane);

        // Adds the panels to the frame
        setJMenuBar(menu);
        add(sloganPanel);
        add(checkPanel);
        add(statsPanel);
        add(infoPanel);
        add(buttonsPanel);

        // Configuring of the frame
        setSize(500, 500);
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

        exitFile.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.exit(DO_NOTHING_ON_CLOSE);
            }
        });

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

        max.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                statSelect = "max";
            }
        });

        min.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                statSelect = "min";
            }
        });

        avg.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                statSelect = "avg";
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

                mapData = new MapData(dataIn);
                try
                {
                    mapData.parseFile();
                }
                catch (IOException e1)
                {
                    // Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });

        calculate.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (statSelect.equalsIgnoreCase("max"))
                {
                    if (tairSelect)
                    {
                        Statistics tempStat = mapData.getTairMax();
                        Object[] tempTair = { tempStat.getStid(), "TAIR", "MAXIMUM", tempStat.getValue(),
                                "REPORING STATIONS", tempStat.getUTCDateTimeString() };
                        
                        Object[][] tempArray = new Object[rowData.length + 1][];
                        for(int i = 0; i < rowData.length; ++i)
                        {
                            tempArray[i] = rowData[i];
                        }
                        tempArray[tempArray.length] = tempTair;
                    }

                    if (ta9mSelect)
                    {
                        Statistics tempStat = mapData.getTa9mMax();
                        Object[] tempTa9m = { tempStat.getStid(), "TA9M", "MAXIMUM", tempStat.getValue(),
                                "REPORING STATIONS", tempStat.getUTCDateTimeString() };
                    }

                    if (sradSelect)
                    {
                        Statistics tempStat = mapData.getSradMax();
                        Object[] tempSrad = { tempStat.getStid(), "SRAD", "MAXIMUM", tempStat.getValue(),
                                "REPORING STATIONS", tempStat.getUTCDateTimeString() };
                    }

                    if (wspdSelect)
                    {
                        Statistics tempStat = mapData.getWspdMax();
                        Object[] tempWspd = { tempStat.getStid(), "WSPD", "MAXIMUM", tempStat.getValue(),
                                "REPORING STATIONS", tempStat.getUTCDateTimeString() };
                    }

                    if (presSelect)
                    {
                        Statistics tempStat = mapData.getPresMax();
                        Object[] tempPres = { tempStat.getStid(), "PRES", "MAXIMUM", tempStat.getValue(),
                                "REPORING STATIONS", tempStat.getUTCDateTimeString() };
                    }
                }
                else if (statSelect.equalsIgnoreCase("min"))
                {
                    if (tairSelect)
                    {
                        Statistics tempStat = mapData.getTairMin();
                        Object[] tempTair = { tempStat.getStid(), "TAIR", "MINIMUM", tempStat.getValue(),
                                "REPORING STATIONS", tempStat.getUTCDateTimeString() };
                    }

                    if (ta9mSelect)
                    {
                        Statistics tempStat = mapData.getTa9mMin();
                        Object[] tempTa9m = { tempStat.getStid(), "TA9M", "MINIMUM", tempStat.getValue(),
                                "REPORING STATIONS", tempStat.getUTCDateTimeString() };
                    }

                    if (sradSelect)
                    {
                        Statistics tempStat = mapData.getSradMin();
                        Object[] tempSrad = { tempStat.getStid(), "SRAD", "MINIMUM", tempStat.getValue(),
                                "REPORING STATIONS", tempStat.getUTCDateTimeString() };
                    }

                    if (wspdSelect)
                    {
                        Statistics tempStat = mapData.getWspdMin();
                        Object[] tempWspd = { tempStat.getStid(), "WSPD", "MINIMUM", tempStat.getValue(),
                                "REPORING STATIONS", tempStat.getUTCDateTimeString() };
                    }

                    if (presSelect)
                    {
                        Statistics tempStat = mapData.getPresMin();
                        Object[] tempPres = { tempStat.getStid(), "PRES", "MINIMUM", tempStat.getValue(),
                                "REPORING STATIONS", tempStat.getUTCDateTimeString() };
                    }
                }
                else
                {
                    if (tairSelect)
                    {
                        Statistics tempStat = mapData.getTairAvg();
                        Object[] tempTair = { tempStat.getStid(), "TAIR", "AVERAGE", tempStat.getValue(),
                                "REPORING STATIONS", tempStat.getUTCDateTimeString() };
                    }

                    if (ta9mSelect)
                    {
                        Statistics tempStat = mapData.getTa9mAvg();
                        Object[] tempTa9m = { tempStat.getStid(), "TA9M", "AVERAGE", tempStat.getValue(),
                                "REPORING STATIONS", tempStat.getUTCDateTimeString() };
                    }

                    if (sradSelect)
                    {
                        Statistics tempStat = mapData.getSradAvg();
                        Object[] tempSrad = { tempStat.getStid(), "SRAD", "AVERAGE", tempStat.getValue(),
                                "REPORING STATIONS", tempStat.getUTCDateTimeString() };
                    }

                    if (wspdSelect)
                    {
                        Statistics tempStat = mapData.getWspdAvg();
                        Object[] tempWspd = { tempStat.getStid(), "WSPD", "AVERAGE", tempStat.getValue(),
                                "REPORING STATIONS", tempStat.getUTCDateTimeString() };
                    }

                    if (presSelect)
                    {
                        Statistics tempStat = mapData.getPresAvg();
                        Object[] tempPres = { tempStat.getStid(), "PRES", "AVERAGE", tempStat.getValue(),
                                "REPORING STATIONS", tempStat.getUTCDateTimeString() };
                    }
                }
            }
        });
    }
}
