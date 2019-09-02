import javax.swing.*;
import java.awt.*;

// This class has two functions. One is to act as canvas for the game on which all game elements can be drawn. This is
// done via the paintComponent() methode. The other function is to run the game logic in a constant loop. This is done
// via the run() methode. In this simple case it only updates the entitys position.
public class GamePanel extends JPanel implements Runnable{
    //dimensions of the panel
    int width, height;

    //a simple moving game entity
    Entity entity;

    public GamePanel(int width, int height){
        super();

        this.width = width;
        this.height = height;

        //set canvas (JPanel) parameters
        setSize(width, height);
        setBackground(new Color(150, 145, 127));
        setLayout(null);

        //setup game
        setup();

        //start game loop ( run() )
        new Thread(this).start();
    }

    //setup the game
    void setup(){
        entity = new Entity(10,30,1, 2);
    }

    //game loop
    public void run(){
        while(true) {
            //move entity
            entity.move();

            //render
            repaint();

            try{Thread.sleep(30);}catch(Exception e){}
        }
    }

    //redraws all game elements
    public void paintComponent( Graphics g ) {
        super.paintComponent( g );
        //if(!running){ return; }

        entity.draw(g);

        g.setColor(new Color(62, 116, 78));
        g.fillRect(10,height-100, width-20, 20);
    }

}
