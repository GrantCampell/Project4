import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MapFrame extends JFrame
{
    private static final long serialVersionUID = 1L;

    JPanel menuPanel = new JPanel();
    JPanel sloganPanel = new JPanel();
    JPanel checkPanel = new JPanel();
    JPanel statsPanel = new JPanel();
    JPanel infoPanel = new JPanel();
    JPanel buttonsPanel = new JPanel();

    // TODO: This is where i'll deal with the menu bar
    JMenuBar menu = new JMenuBar();

    // The slogan text box
    JLabel slogan = new JLabel();

    JCheckBox paramSelect = new JCheckBox("Parameter");
    
    ButtonGroup paramCheck = new ButtonGroup();
    
    JRadioButton tair = new JRadioButton("TAIR");
    JRadioButton ta9m = new JRadioButton("TA9M");
    JRadioButton srad = new JRadioButton("SRAD");
    JRadioButton wspd = new JRadioButton("WSPD");
    JRadioButton pres = new JRadioButton("PRES");

    ButtonGroup stats = new ButtonGroup();

    JRadioButton max = new JRadioButton("MAXIMUM");
    JRadioButton min = new JRadioButton("MINIMUM");
    JRadioButton avg = new JRadioButton("AVERAGE");

    JButton calculate = new JButton("Calculate");
    JButton exit = new JButton("Exit");

    public MapFrame(String title)
    {
        super(title);

        // Set Alignment of the JTextField and Jlabel
        slogan.setHorizontalAlignment(JLabel.LEFT);
        
        slogan.setText("Mesonet - We don't set records, we report them!");

        // sets the layout grid for the GUI of dimension 4*5
        setLayout(new GridLayout(6, 0));
        
        paramCheck.add(tair);
        paramCheck.add(ta9m);
        paramCheck.add(srad);
        paramCheck.add(wspd);
        paramCheck.add(pres);
        

        // Here we are adding elements into panels. The first panel has all elements
        // added into it.
        menuPanel.add(menu);
        sloganPanel.add(slogan);
        checkPanel.add(tair);
        checkPanel.add(ta9m);
        checkPanel.add(srad);
        checkPanel.add(wspd);
        checkPanel.add(pres);

        // Adds elements to the 2nd 3rd and 4th panel

        // Adds the slider to the 0th panel

        // Adds the panels to the frame
        add(menuPanel);
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
    }
}
