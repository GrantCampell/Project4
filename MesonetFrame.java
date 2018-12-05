import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MesonetFrame extends JFrame
{
    public class FileMenuBar extends JMenuBar
    {
        /**
         * Default ID
         */
        private static final long serialVersionUID = 1L;
         
        JMenuBar menu = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem load = new JMenuItem("Open Data File");
        JMenuItem exitFile = new JMenuItem("Exit");
    }
}
