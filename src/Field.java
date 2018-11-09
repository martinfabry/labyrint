/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gamer-PC
 */
public class Field {

    private int row, col;

    public Field(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Field(Field field) {
        this.row = field.row;
        this.col = field.col;
    }

    public Field() {
        this.row = this.col = 0;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void move(Direction direction) {
    }

    ;
    
    @Override
    public String toString() {
        return " ";
    }
}
