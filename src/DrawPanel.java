
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gamer-PC
 */
public class DrawPanel extends JPanel implements KeyListener{
    private File file;
    private Labyrint labyrint;
    private Game game;
    private Thread paintThread;
    
    
    public DrawPanel() {
        file = new File("input.txt");
        labyrint = new Labyrint();
        labyrint.readLabyrintFromFile(file);
        game = new Game(labyrint);
        //paintThread = new Thread(paint);
        //paintThread.start();
        
        this.addKeyListener(this);
    }
    
    public int getFieldWidth()
    {
       return (int)(this.getSize().getWidth() / labyrint.getNumberOfCols());
    }
    
    public int getFieldHeight()
    {
       return (int)(this.getSize().getHeight()/ labyrint.getNumberOfRows());
    }
    
    private void draw(Graphics g)
    {
        int x = 0;
        g.setColor(Color.red);
        for(int i = 0; i< getSize().getWidth();i++)
        {
            int width = 20;
            x += width;
            g.drawRect(x,20,width,20);
            
        }
    }
    
    private void drawLabyrint(Graphics g)
    {
        System.out.println("ide to");
        int x = 0, y = 0, width = 0, height = 0;
        width = getFieldWidth();
        height = getFieldHeight();
        
        System.out.println(width);
        System.out.println(height);
        //super.paintComponent(g);
        g.setColor(Color.darkGray);
        System.out.println("eheheh");
        for(int rows = 0; rows<labyrint.getNumberOfRows(); rows++)
        {
            for(int cols = 0; cols < labyrint.getNumberOfCols(); cols++)
            {
                Field temp = labyrint.getFieldOnIndexes(rows, cols);
                switch(temp.getClass().getName())
                {
                    case "Player":
                            System.out.println("ehehe");
                            g.setColor(Color.YELLOW);
                            break;
                    case "Exit":
                            g.setColor(Color.BLUE);
                            break;
                    case "Wall":
                            g.setColor(Color.BLACK);
                            break;
                    case "Field":
                            g.setColor(Color.WHITE);
                            break;
                }
                g.drawRect(x, y, width, height);
                g.fillRect(x, y, width, height);
                x += getFieldHeight();
            }
            x = 0;
            y += getFieldHeight();
        }
    }
    /*
    Runnable paint = new Runnable() {
        @Override
        public void run() {
          while(true)
          {
              repaint();
          }
    }};
    */
    

    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        drawLabyrint(g);
    }

        
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
        @Override
    public void keyPressed(KeyEvent e) {
        boolean result = false;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            result = labyrint.movePlayer(Direction.RIGHT);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            result = labyrint.movePlayer(Direction.LEFT);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            result = labyrint.movePlayer(Direction.UP);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            result = labyrint.movePlayer(Direction.DOWN);
        }
        if(result)
        {
            game.addPlayerPosition();
            repaint();
        }
    }
}
