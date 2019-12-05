import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JPanel{
    Ball ball = new Ball(this);

    @Override
    public void paint(Graphics g){
        // this clears the screen before reprinting circe at new position
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        //Antialiasing makes the figure smoother
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        ball.paint(g2d);      
    }
    private void move(){
        ball.moveBall();
    }

    public static void main(String[] args) throws InterruptedException{
        // name of the window
        JFrame frame = new JFrame("Mini Tennis");
        Game game = new Game();
        frame.add(game);
        frame.setSize(300, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true){
            game.move();
            game.repaint();
            // tells the processor that the thread which is being
            // run must sleep for 10 milliseconds. bigger the number the slower
            // the game moves
            Thread.sleep(10);
        }
    }
}
