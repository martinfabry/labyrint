
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import javax.swing.JOptionPane;
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
public class DrawPanel extends JPanel implements KeyListener {

    private final File file;
    private final Labyrint labyrint;
    private final Game game;
    private final Thread paintThread;
    private boolean play;

    public DrawPanel() {
        file = new File("input.txt");
        labyrint = new Labyrint();
        labyrint.readLabyrintFromFile(file);
        game = new Game(labyrint);

        paintThread = new Thread(paint);
        paintThread.start();
        play = true;
    }

    public int getFieldWidth() {
        return (int) (this.getSize().getWidth() / labyrint.getNumberOfCols());
    }

    public int getFieldHeight() {
        return (int) (this.getSize().getHeight() / labyrint.getNumberOfRows());
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        drawLabyrint(g);
    }

    private void drawLabyrint(Graphics g) {
        int x = 0, y = 0, width = 0, height = 0;
        width = getFieldWidth();
        height = getFieldHeight();

        g.setColor(Color.darkGray);
        for (int rows = 0; rows < labyrint.getNumberOfRows(); rows++) {
            for (int cols = 0; cols < labyrint.getNumberOfCols(); cols++) {
                Field temp = labyrint.getFieldOnIndexes(rows, cols);
                switch (temp.getClass().getName()) {
                    case "Player":
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
                x += getFieldWidth();
            }
            x = 0;
            y += getFieldHeight();
        }
    }

    Runnable paint = new Runnable() {
        @Override
        public void run() {
            while (play == true) {
                repaint();
            }
        }
    };

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
            game.play(Direction.RIGHT);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            game.play(Direction.LEFT);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            game.play(Direction.UP);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            game.play(Direction.DOWN);
        }
        if (game.isEndOfGame()) {
            JOptionPane.showMessageDialog(this, "YOU WON\nPLAYER POSITIONS:\n" + game.getPlayerPositions());
            this.setFocusable(false);
            play = false;
            System.exit(0);
        }
    }

}
