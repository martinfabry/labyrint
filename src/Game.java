
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gamer-PC
 */
public class Game implements KeyListener  {
    private Labyrint labyrint;
    private List<Person> playerPositions;

    public Game(Labyrint labyrint, List<Person> playerPositions) {
        this.labyrint = labyrint;
        this.playerPositions = playerPositions;
    }

    public Game(Labyrint labyrint) {
        this.labyrint = labyrint;
        playerPositions = new ArrayList<>();
    }
    
    public void cls()
    {
        try 
        {
            Runtime.getRuntime().exec("cmd /c cls");
        }
        catch(final Exception e)
        {
            System.out.print(e);
        }

    }

    
    public void play()
    {
        while(true)
        {
            try {
                char keyChar = (char)System.in.read();
                System.out.println(keyChar);
                //cls();
                //System.out.println(labyrint.toString());
            } catch (IOException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.println("Right key typed");
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("Left key typed");
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            System.out.println("Right key typed");
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            System.out.println("Left key typed");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    
    
}
