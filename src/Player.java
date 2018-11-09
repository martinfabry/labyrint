/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gamer-PC
 */
public class Player extends Field {

    public Player(int row, int col) {
        super(row, col);
    }

    public Player(Field field) {
        super(field);
    }

    public Player() {
        super();
    }

    @Override
    public void move(Direction direction) {
        switch (direction) {
            case LEFT:
                setCol(getCol() - 1);
                break;
            case RIGHT:
                setCol(getCol() + 1);
                break;
            case UP:
                setRow(getRow() - 1);
                break;
            case DOWN:
                setRow(getRow() + 1);
                break;
        }
    }

    @Override
    public String toString() {
        return "S";
    }
}
