import javax.swing.*;

// This class purpose is to start the program and also setup the window
public class Main {
    //window size
    static int screen_width = 800, screen_height = 600;

    public Main(){
        //setup window
        JFrame frame = new JFrame("Boids");
        frame.setSize(screen_width,screen_height);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //create and add canvas for the game (which is also the main game instance
        frame.add(new GamePanel(screen_width, screen_height));

        frame.setVisible(true);
    }

    public static void main(String args[]){
        new Main();
    }

}
