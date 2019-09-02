import java.awt.*;

// This is a example class for a moving entity in the game. it has two important mehtods. draw() draws the entity to the screen. it's call
// by the paintComponent() methode of GamePanel every time the window is repainted (at least once per frame). move() is called exactly once per
// frame by GamePanel.run(). It moves the entity.
public class Entity {
    //Position and Speed
    double x, y;
    double speed_x, speed_y ;

    //Appearance
    Color color = new Color(28, 174, 179);
    int size = 30;

    //Constructor
    public Entity(int x, int y, double speed_x, double speed_y){
        this.x = x;
        this.y = y;
        this.speed_x = speed_x;
        this.speed_y = speed_y;
    }


    //Movement
    void move(){
        //move entity
        x += speed_x;
        y += speed_y;

        //if Entity leaves the screen teleport it to the other site
        if(x < 0){ x = Main.screen_width; }
        if(y < 0){ y = Main.screen_height; }
        if(x > Main.screen_width){ x = 0; }
        if(y > Main.screen_height){ y = 0; }
    }

    //Render
    void draw(Graphics g){
        g.setColor(color);
        g.fillOval((int)x-size/2, (int)y-size/2, size, size);
    }

}
