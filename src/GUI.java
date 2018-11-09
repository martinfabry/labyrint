import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import javax.swing.JFrame;
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
public class GUI extends JFrame {
    private File file;
    private Labyrint labyrint;
    private Game game;
    
    Thread paintThread;
    
    private DrawPanel panel;
    
    
    public GUI() {   
        panel = new DrawPanel();
        this.add(panel);
        
        setTitle("Labyrint");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setTitle("Rectangles");
        setLocationRelativeTo(null);
        this.setVisible(true);
        
    }
}
