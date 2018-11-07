/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gamer-PC
 */
public class Person extends Field {

    public Person(int x, int y) {
        super(x, y);
    }
    
    
    public Person(Field field) {
        super(field);
    }

    public Person() {
        super();
    }
    
    @Override
    public String toString() {
        return "S";
    }
}
