import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

public class WorkSpace extends JPanel{

    public WorkSpace(){
        setLayout(null);
        setBackground(Color.CYAN);
        setBounds(240,0,1200,765);
        JButton button = new JButton("Button");
        button.setBounds(50, 50, 100, 20);
        add(button);
    }
    
}
