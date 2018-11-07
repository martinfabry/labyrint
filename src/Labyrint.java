
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Gamer-PC
 */
public class Labyrint {

    private Field[][] labyrint;

    public Labyrint() {
        labyrint = new Field[25][25];
        createLabyrint();
    }

    public Labyrint(int rows, int cols) {
        labyrint = new Field[rows][cols];
        createLabyrint();
    }

    public void setLabyrint(Field[][] labyrint) {
        this.labyrint = labyrint;
    }

    public Field[][] getLabyrint() {
        return labyrint;
    }

    public void setTypeOfTargetField(Field actualField, Field targetField) {
        int x = actualField.getX();
        int y = actualField.getY();

    }
    
    public void createLabyrint()
    {
        for(int rows = 0; rows < labyrint.length; rows++)
        {
            for(int cols = 0; cols < labyrint[0].length; cols++)
            {
                labyrint[rows][cols] = new Field(rows, cols);
            }
        }
    }


    public Field getTypeOfClassByChar(Field field, char c) {
        switch (c) {
            case 'S':
                field = new Person(field);
                break;
            case 'C':
                field = new Exit(field);
                break;
            case '#':
                field = new Wall(field);
                break;
            default:
                field = new Field(field);
                break;
        }
        return field;
    }

    public boolean readLabyrintFromFile(File filename) {
        Scanner scan = null;
        try {
            scan = new Scanner(filename);
            int row = 0;
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                for (int index = 0; index < line.length(); index++) {
                    labyrint[row][index] = getTypeOfClassByChar(labyrint[row][index], line.charAt(index));
                }
                row++;
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "File " + filename.getPath() + "not found !", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "Labyrint is too small !", "Error", JOptionPane.ERROR_MESSAGE);
        }
        finally{
            if(!scan.hasNextLine())
            {
                scan.close();
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String print = "";
        for (Field[] rows : labyrint) {
                for(Field row: rows)
                {
                    print += row.toString();   
                }
                print += '\n';
            }        
        return print;
    }

}
