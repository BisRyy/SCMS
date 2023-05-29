import javax.swing.SwingUtilities;

public class Main{
    public static void main(String[] args) {
        // Create and show the menu
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Menu();
            }
        });
    }
}