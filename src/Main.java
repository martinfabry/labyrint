
import java.io.File;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gamer-PC
 */
public class Main {
    public static void main(String[] args) {
        File file = new File("input.txt");
        Labyrint labyrint = new Labyrint();
        labyrint.readLabyrintFromFile(file);
        Game game = new Game(labyrint);
        game.play();
    }
}
