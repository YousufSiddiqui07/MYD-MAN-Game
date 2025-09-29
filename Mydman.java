import javax.swing.JFrame;

/**
 * The Mydman class represents the main application window for the game.
 * It extends JFrame and initializes the game by adding an instance of the Model class.
 *
 * The class includes functionality for setting up the main frame, setting its properties,
 * and displaying the game window.
 *
 * @author Dhruv Choubey
 */

public class Mydman extends JFrame{

    public Mydman() {
        add(new Model());
    }
    
    
    public static void main(String[] args) {
        Mydman myd = new Mydman();
        myd.setVisible(true);
        myd.setTitle("Mydman");
        myd.setSize(380,420);
        myd.setDefaultCloseOperation(EXIT_ON_CLOSE);
        myd.setLocationRelativeTo(null);
        
    }

}
