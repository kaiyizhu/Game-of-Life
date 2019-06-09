package dev.SeanZhang.gameOfLife.game;

import dev.SeanZhang.utils.Utils;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author seanz
 */
public class GameEngine {
    private int widthHeight;
    private int[][] placeholder;
    private int[][] gameBoard;
    
    public GameEngine(int widthHeight) {
        this.widthHeight=widthHeight;
        placeholder=new int[widthHeight][widthHeight];
        gameBoard=new int[widthHeight][widthHeight];
        
        for( int i = 0; i < gameBoard.length; i++ ) {
            Arrays.fill(gameBoard[i],-1);
        }
    }

    public int[][] getGameBoard() {
        return gameBoard;
    }
    
    public void setBoardSize(int widthHeight) {
        this.widthHeight=widthHeight;
        placeholder=new int[widthHeight][widthHeight];
        gameBoard=new int[widthHeight][widthHeight];
        clearScreen();
    }
    
    public void clearScreen() {
        for( int i = 0; i < gameBoard.length; i++ ) {
            Arrays.fill(gameBoard[i],-1);
        }
    }

    public void toggleValue(int x, int y) {
        gameBoard[y][x] *=-1;
    }
    
    public void setGameBoard(int[][] gameBoard) {
        this.gameBoard = gameBoard;
    }
    
    public void loadMap(int option) {
        switch(option) {
            case 0:
                break;
            case 1:
                break;
        }
    }
    
    
    
    public void tickBoard() {
        //copies the 2D array gameBoard to 2D array placeholder
        for( int i = 0; i < gameBoard.length; i++ ) {
            placeholder[i] = gameBoard[i].clone();
        }
        
        //goes through the entire 2d plane of tiles
        for(int i=0;i<gameBoard.length;i++) {
            for (int j=0;j<gameBoard[0].length;j++) {
                //counts number of neighbors
                int count=0;
                
                //goes through all the neighboring tiles of the current tile
                for(int y=-1;y<=1;y++) {
                    for(int x=-1;x<=1;x++) {
                        if(x==0 && y==0) { } else {
                            try {
                                if(gameBoard[y+i][x+j]>0) { count++;}
                            } catch(Exception e) {} //end of try-catch
                        } //end of if block
                    }}//end of nested for loop
                
                //checks rules for automation
                if(count<2 || count>=4) {
                    placeholder[i][j]=-1;
                } else if(count ==3) {
                    placeholder[i][j]=1;
                }

        } } //end of nested for loop
        
        //updates the gameBoard
        //gameBoard = placeholder.clone();
        
        
        
        for( int i = 0; i < gameBoard.length; i++ ) {
            gameBoard[i] = placeholder[i].clone();
        }
        
        
    } //end of method    
} //end of gameEngine class

/*
    PSEUDOCODE FOR METHOD TICKBOARD()
    Given two 2D arraylists: 1 is a placeholder, the other is the gameboard.
        upadtes placeholder to equal gameboard
        COUNTED 2D LOOP: Loops through the 2D array by row, then column.
            create a temporary count varaible
            
            COUNTED 2D LOOP: Loops through all the tiles (including itself) around the tile
                DECISION: if the index is itself, then ignore. Otherwise:
                    TRY-CATCH: catchs the error if it tries to access an index out of the range
                        DECISION: If the value at the tile next to the current tile is alive,
                                  add one to the count
                        END OF DECISION            
                    END OF TRY-CATCH    
                END OF DECISION
                
            DECISION: Checks rules for automation: (These updates are assigned to the placeholder)
                        - If the cell has less than 2 or more than 3 neighbors, it dies.
                        - If the cell has 3 neighbors, it lives or becomes existent.
                        - Otherwise, do not change the state of the cell
        END OF COUNTED 2D LOOP
        
        Assign gameBoard to the values of placeholder.    
    END OF UPDATE METHOD
        
*/ 
