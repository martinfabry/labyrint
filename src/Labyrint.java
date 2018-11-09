
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
    private Field player;
    private Field exit;

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
    
    public int getNumberOfRows()
    {
        return labyrint.length;
    }
    
    public int getNumberOfCols()
    {
        return labyrint[0].length;
    }

    public Field getFieldOnIndexes(int row, int col)
    {
        return labyrint[row][col];
    }
    
    public Field getPlayer() {
        return player;
    }

    public Field getExit() {
        return exit;
    }

    public boolean addPlayer(int row, int col) {
        if (player == null) {
            player = new Player(row, col);
            labyrint[row][col] = player;
            return true;
        }
        return false;
    }

    public boolean removePlayer() {
        if (player != null) {
            labyrint[player.getRow()][player.getCol()] = new Field(player.getRow(), player.getCol());
            player = null;
            return true;
        }
        return false;
    }

    public boolean addExit(int row, int col) {
        if (exit == null) {
            exit = new Exit(row, col);
            labyrint[row][col] = exit;
            return true;
        }
        return false;
    }

    public boolean removeExit() {
        if (exit != null) {
            labyrint[player.getRow()][exit.getCol()] = new Field(exit);
            exit = null;
            return true;
        }
        return false;
    }

    public boolean addWall(int row, int col) {
        try {
            labyrint[row][col] = new Wall(row, col);
            return true;
        } catch (Exception ex) {

        }
        return false;
    }

    public boolean addField(int row, int col) {
        try {
            labyrint[row][col] = new Field(row, col);
            return true;
        } catch (Exception ex) {
            //
        }
        return false;
    }

    public boolean removeField(int row, int col) {
        try {
            //if(labyrint[row][col].getClass().)
            {
                labyrint[row][col] = null;
                return true;
            }
        } catch (Exception ex) {
            //
        }
        return false;
    }

    public void createLabyrint() {
        for (int rows = 0; rows < labyrint.length; rows++) {
            for (int cols = 0; cols < labyrint[0].length; cols++) {
                labyrint[rows][cols] = new Field(rows, cols);
            }
        }
    }

    public void addFieldByChar(Field field, char c) {
        switch (c) {
            case 'S':
                addPlayer(field.getRow(), field.getCol());
                break;
            case 'C':
                addExit(field.getRow(), field.getCol());
                break;
            case '#':
                addWall(field.getRow(), field.getCol());
                break;
            default:
                addField(field.getRow(), field.getCol());
                break;
        }
    }

    public boolean readLabyrintFromFile(File filename) {
        Scanner scan = null;
        try {
            scan = new Scanner(filename);
            int row = 0;
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                for (int index = 0; index < line.length(); index++) {
                    addFieldByChar(labyrint[row][index], line.charAt(index));
                }
                row++;
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "File " + filename.getPath() + "not found !", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "Labyrint is too small !", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (!scan.hasNextLine()) {
                scan.close();
                return true;
            }
        }
        return false;
    }

    public boolean movePlayer(Direction direction) {
        if (player != null) {
            Field temp = new Player(player.getRow(), player.getCol());
            temp.move(direction);
            int row = temp.getRow();
            int col = temp.getCol();
            //System.out.println("player:"+player.getRow()+","+player.getCol());
            //System.out.println("Temp:"+temp.getRow()+","+temp.getCol());
            if(labyrint[row][col] instanceof Exit)
            {
                removeExit();
                removePlayer();
                addPlayer(row, col);
                return true;
            }
            else if ((labyrint[row][col] instanceof Wall) == false && row >= 0 && row < labyrint.length && col >= 0 && col < labyrint[0].length) {
                removePlayer();
                addPlayer(row, col);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String print = "";
        for (Field[] rows : labyrint) {
            for (Field row : rows) {
                print += row.toString();
            }
            print += '\n';
        }
        return print;
    }

}
