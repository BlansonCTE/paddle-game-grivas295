import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Paddle {
    // 1. Create a variable that will hold the Y axis of the paddle
    //    remember the paddle needs to have a constant Y axis because it shouldnt move vertically
    int y = 300;
    // 2. Create a variable to hold the width of the paddle.
    int WIDTH = 30;
    // 3. Create a variable to hold the height of the paddle.
    int HEIGHT = 80;
    // create a variable for current speed
    int x = 0;
    // create a variable for change in paddle velocity
    int xa = 0;
    private Game game;

    public Paddle(Game game){
        this.game = game;
    }

    public void move() {
        if (y + ya > 0 && x + ya < game.getWidth() - WIDTH)
            y = y + ya;
    }

    public void paint(Graphics2D g) {
        g.fillRect(x, y, WIDTH, HEIGHT);
    }
// gets the key pressed information and changes the position of the paddle
    public void keyReleased(KeyEvent e) {
        ya = 0;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            ya = -game.speed;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            ya = game.speed;
    }
    // gets the location of the paddle
    public Rectangle getBounds(){
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }
    // tells you where the top of the paddle is
    public int getTopY(){
        return y;
    }
} 



