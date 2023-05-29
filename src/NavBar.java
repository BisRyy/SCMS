import java.awt.*;
import javax.swing.*;


public class NavBar extends JPanel {
    // Create a Dashboard NavBar
    public NavBar(String button, Color color){
        setBounds(0,0,240,760);
        setLayout(null);
        setBackground(color);
        // Add Menu Buttons
        for(int i=0; i<10; i++){
            JButton newButton = new JButton(button + i);
            newButton.setBounds(20 , 20 + (i * 60), 200, 50);
            add(newButton);
        }
    }
}
