
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
    private List<Field> playerPositions;

    public Game(Labyrint labyrint, List<Field> playerPositions) {
        this.labyrint = labyrint;
        this.playerPositions = playerPositions;
    }

    public Game(Labyrint labyrint) {
        this.labyrint = labyrint;
        playerPositions = new ArrayList<>();
    }

    public void play(Direction direction) {
        labyrint.movePlayer(direction);
        playerPositions.add(labyrint.getPlayer());
    }

    public boolean isEndOfGame() {
        if (labyrint.getExit() == null) {
            return true;
        }
        return false;
    }

    public String getPlayerPositions() {
        String temp = "";
        int positionsNumber = 0;
        for (int i = 0; i < playerPositions.size(); i++) {
            temp += "[" + playerPositions.get(i).getRow() + "," + playerPositions.get(i).getRow() + "]";
            positionsNumber++;
            if (positionsNumber % 20 == 0) {
                temp += '\n';
            }
        }
        return temp;
    }
}
