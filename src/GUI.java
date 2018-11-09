import javax.swing.JFrame;

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

    private DrawPanel drawingPanel;

    public GUI() {
        setTitle("Labyrint");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);     
        
        drawingPanel = new DrawPanel();
        drawingPanel.addKeyListener(drawingPanel);
        drawingPanel.setFocusable(true);
        add(drawingPanel);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
