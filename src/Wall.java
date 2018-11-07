/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gamer-PC
 */
public class Wall extends Field{

    public Wall(int x, int y) {
        super(x, y);
    }

    public Wall(Field field) {
        super(field);
    }
    
    public Wall() {
        super();
    }

    @Override
    public String toString() {
        return "#";
    }
    
    
    
}
