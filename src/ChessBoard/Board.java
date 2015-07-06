/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessBoard;

import Pieces.Piece;

/**
 *Singleton pattern to create the single board for use
 * in the chess game. 
 */
public class Board {
    
    private static Board INSTANCE = null;

    private int width;
    private int length;
    private static Piece[][] board;
    
    private Board(){}

    
    public synchronized static Board createInstance(){
        if(INSTANCE == null){
            INSTANCE = new Board();
        }
        return INSTANCE;
    }
    
    public static Board getInstance(){
        return INSTANCE;
    }
    
    // set position of a piece
    public void setPiecePosition(int[] location, Piece piece){
        INSTANCE.board[location[0]][location[1]] = piece;
        // should change location of piece as well
    }
    
    // clear a position
    public void nullifyPosition(int[] location){
        INSTANCE.board[location[0]][location[1]] = null; 
        // remove pice also? maybe, maybe not
    }
    
           
    public Piece onSquare(int column, int row){
        return board[column][row];
    }

    
    // getters for length and width and setters
    public int getWidth(){
        return width;
    }
    
    public int getLength(){
        return length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public static void setBoard(int length, int width) {
        board = new Piece[length][width];
    }
    
    public void showBoard(){
        for(int i = 0; i < length; i++){
            for(int j = 0; j < width; j++){
                System.out.print(board[j][i]+ " | ");
            }
            System.out.println();
        }
    }
}
