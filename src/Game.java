
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gamer-PC
 */
public class Game {
    private Labyrint labyrint;
    private List<Object> playerPositions;

    public Game(Labyrint labyrint, List<Object> playerPositions) {
        this.labyrint = labyrint;
        this.playerPositions = playerPositions;
    }

    public Game(Labyrint labyrint) {
        this.labyrint = labyrint;
        playerPositions = new ArrayList<>();
    }
    
    public boolean addPlayerPosition() {
        if(playerPositions.add(labyrint.getPlayer()))
        {
            return true;
        }
        return false;
    }
    
    
    public boolean isEndOfGame()
    {
        if(labyrint.getExit() == null)
        {
            return true;
        }
        return false;
    }
}
