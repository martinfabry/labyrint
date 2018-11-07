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
    private int x, y;

    public Field(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public Field(Field field) {
        this.x = field.x;
        this.y = field.y;
    }

    public Field() {
        this.x = this. y = 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public String getTypeOfClass()
    {
        return this.getClass().getName();
    }
    
    public boolean isTypeExit()
    {
        return this instanceof Exit;
    }
    
    public boolean isTypeWall()
    {
        return this instanceof Wall;
    }
    
    public boolean isTypePerson()
    {
        return this instanceof Person;
    }
    
    @Override
    public String toString()
    {
        return " ";
    }
}
