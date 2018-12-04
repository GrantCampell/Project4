import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MapFrame extends JFrame
{
    private static final long serialVersionUID = 1L;

    JPanel sloganPanel = new JPanel();
    JPanel checkPanel = new JPanel();
    JPanel statsPanel = new JPanel();
    JPanel infoPanel = new JPanel();
    JPanel buttonsPanel = new JPanel();

    // TODO: This is where i'll deal with the menu bar
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

    JTextPane infoBox = new JTextPane();

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

        infoPanel.add(infoBox);

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
    }
}
