import java.awt.Graphics2D;
import java.awt.Rectangle;

class Ball{
    // initalize ball position and initial velocity
    int x = 0, y = 0, xVelocity = 1, yVelocity = 1;
    // create ball size
    private static final int DIAMETER = 30;
    private Game game;

    public Ball(Game game){
        this.game = game;
    }
    void moveBall(){
    // get the width of the window and change the velocity of the ball
    // depending on the game window, depends on where the ball is going to bounce from 
        // Hit right wall
        if (x + xVelocity > game.getWidth() - DIAMETER)
            xVelocity = -game.speed;
        // hit left wall
        if (x < 0)
            xVelocity = game.speed;
        // hit top wall
        if (y + yVelocity < 0)
            yVelocity = game.speed;
        if (y + yVelocity > game.getHeight() - DIAMETER)
            game.gameOver();
        // hit paddle
        if (collision()){
            yVelocity = -game.speed;
            game.speed++;
            y = game.paddle.getTopY() - DIAMETER;
        
        }
        
        // Move ball
        x = x + xVelocity;
        y = y + yVelocity;
    }
    public void paint(Graphics2D g){
        g.fillOval(x,y, DIAMETER, DIAMETER);
    }
    // tells if the paddle collides with the ball
    // access game class coneected to paddle then access gB and checks if it intersects with ball
    private boolean collision(){
        return game.paddle.getBounds().intersects(getBounds());
    }
    // tells where the ball is
    public Rectangle getBounds(){
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }
}