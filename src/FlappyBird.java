
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class FlappyBird extends JPanel implements ActionListener, KeyListener {
    int boardWidth = 360;
    int boardHeight = 640;

    //image
    Image backgroundImg;
    Image birdImg;
    Image topPipeImg;
    Image bottomPipeImg;

    //Bird
    int birdX = boardWidth/8;
    int birdY = boardHeight/2;
    int birdWidth = 34;
    int birdHeight = 24;

    class Bird {
        int x = birdX;
        int y = birdY;
        int width = birdWidth;
        int height = birdHeight;
        Image img;
        
        Bird(Image img){
            this.img = img;

        }

    }

    //game logic
    Bird bird;
    int velocityY = 0;
    int gravity = 1;

    Timer gameLoop;


    public FlappyBird() {
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        //setBackground(Color.blue); //test the panel
        setFocusable(true);
        addKeyListener(this);

        //load image
        backgroundImg = new ImageIcon(getClass().getResource("./flappybirdbg.png")).getImage();
        birdImg = new ImageIcon(getClass().getResource("./flappybird.png")).getImage();
        topPipeImg = new ImageIcon(getClass().getResource("./toppipe.png")).getImage();
        bottomPipeImg = new ImageIcon(getClass().getResource("./bottompipe.png")).getImage();

        bird = new Bird(birdImg);
        //game timer
        gameLoop = new Timer(1000/60, this);
        gameLoop.start();

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    
    public void draw(Graphics g){

        //background
        g.drawImage(backgroundImg, 0, 0, boardWidth, boardHeight, null);

        //bird
        g.drawImage(bird.img, bird.x, bird.y, bird.width, bird.height, null);
    }

    public void move(){
        //bird
        velocityY += gravity;
        bird.y += velocityY;
        bird.y = Math.max(bird.y, 0); //set the heightest where the bird could go is 0

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
        move();
        repaint(); //redo the paintComponent()
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            velocityY = -10;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }

    
}
