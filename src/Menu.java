import java.awt.*;
import javax.swing.*;

public class Menu extends JFrame {
    public JPanel workSpace;

    public Menu() {
        super("Supply Chain Management System");

        // Initialize components
        JMenuBar menuBar = new MenuBar();
        JPanel navBar = new NavBar("Menu Item ", Color.DARK_GRAY);
        
        workSpace = new WorkSpace();

        setJMenuBar(menuBar);
        add(navBar);

        add(workSpace);
        add(new JPanel());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 1000);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}