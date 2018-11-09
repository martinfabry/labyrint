/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gamer-PC
 */
public class Exit extends Field {

    public Exit(int row, int col) {
        super(row, col);
    }

    public Exit(Field field) {
        super(field);
    }
    
    public Exit() {
        super();
    }
    
    @Override
    public String toString()
    {
        return "C";
    }
    
}
