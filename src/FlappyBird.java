
import java.awt.*;
import javax.swing.*;

public class FlappyBird extends JPanel {
    int boardWidth = 360;
    int boardHeight = 640;

    //image
    Image backgroundImg;
    Image birdImg;
    Image topPipeImg;
    Image bottomPipeImg;


    public FlappyBird() {
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        //setBackground(Color.blue); //test the panel

        //load image
        backgroundImg = new ImageIcon(getClass().getResource("./flappybirdbg.png")).getImage();
        birdImg = new ImageIcon(getClass().getResource("./flappybird.png")).getImage();
        topPipeImg = new ImageIcon(getClass().getResource("./toppipe.png")).getImage();
        bottomPipeImg = new ImageIcon(getClass().getResource("./bottompipe.png")).getImage();


    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    
    public void draw(Graphics g){
        //background
        g.drawImage(backgroundImg, 0, 0, boardWidth, boardHeight, null);
    }

    
}
