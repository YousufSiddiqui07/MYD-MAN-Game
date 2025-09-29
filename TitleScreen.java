import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.File;

/**
* The TitleScreen class represents the title screen of the game.
* It extends JPanel and provides a button to start the game.
*
* The class includes functionality for displaying the title text
* and handling the start button click event to initiate the game.
*
* @author Dhruv Choubey
*/


public class TitleScreen extends JPanel {

    private boolean showTitle = true;
    Font crackman;
    public TitleScreen() {
        setBackground(Color.BLACK);
        
        try{
        
            crackman = Font.createFont(Font.TRUETYPE_FONT, new File("Crackman.ttf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT,new File("Crackman.ttf")));
        
        }
        
        catch(IOException | FontFormatException e){
        
        }
        
        JButton startButton = new JButton("Start Game");
        startButton.setFont(new Font("Crackman", Font.PLAIN, 20));
        startButton.setFocusable(false);
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showTitle = false;
                startGame();
            }
        });

        setLayout(new BorderLayout());
        add(startButton, BorderLayout.SOUTH);
    }

    private void startGame() {
        // Create a JFrame to contain the game
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.getContentPane().removeAll(); // Clear the frame
        Model model = new Model(); // Create an instance of the Model class
        frame.add(model); // Add the Model instance to the frame
        frame.pack(); // Adjust frame size
        frame.repaint(); // Redraw frame
        model.setFocusable(true); // Set the Model focusable
        model.requestFocusInWindow(); // Request focus for the Model
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (showTitle) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.YELLOW);
            g2d.setFont(new Font("Crackman", Font.BOLD, 30));
            g2d.drawString("Mydman!", 100, 100);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Title Screen Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.add(new TitleScreen());
        frame.setVisible(true);
    }
}
