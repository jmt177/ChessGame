/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pieces;

import ChessBoard.Board;
import Movement.PieceMovement;
import chessgame.ChessTeam;

/**
 *
 * @author jtdollarsign
 */
public class Rook extends Piece{

    public Rook(char team, int[] location, ChessTeam myTeam) {
        super(team, location, myTeam);
    }
    
    Board board = Board.getInstance();
    
    @Override
    public boolean legalMove(Piece piece, int[] toMove) {
        // if it doesn't move return false, otherwise might take their turn 
        // doing nothing.
        // only a row or a column is affected for rook movement. If both are,
        // is a mistake
        if((piece.getColumn() == toMove[0] && piece.getRow() == toMove[1]) ||
           (piece.getColumn() != toMove[0] && piece.getRow() != toMove[1])){
            return false;
        }     
        
        // If in board AND (square is empty or occupied by an enemy) AND no pieces
        // blocking travel to that point. noAlly should probably be renamed to notBlocked
        // or something similar
        return(inBoard(toMove) && 
          ((board.onSquare(toMove[0], toMove[1]) == null || 
            board.onSquare(toMove[0], toMove[1]).getTeam() != piece.getTeam()) &&
            noAlly(piece, toMove)));

    }

    @Override
    public boolean inBoard(int[] toMove) {

        return(toMove[0] <= board.getLength() && 
               toMove[1] <= board.getWidth());
           
    }

    @Override
    public boolean noAlly(Piece piece, int[] toMove) {
        // if the location to move is in the board and not occupied by an allied piece
        if(inBoard(toMove) && board.onSquare(toMove[0], toMove[1]).getTeam() != piece.getTeam()){
            // if the column is correct, moving down the row
            if(piece.getColumn() == toMove[0]){
                if(piece.getRow() > toMove[1]){
                    return privNoAlly(piece, toMove, new int[]{-1, 0});
                } else {
                    return privNoAlly(piece, toMove, new int[]{1, 0});                 
                }
            // if the row is correct, moving down the column
            } else if(piece.getRow() == toMove[1]) {
                if(piece.getColumn() > toMove[0]){
                    return privNoAlly(piece, toMove, new int[]{0, -1});
                } else {
                    return privNoAlly(piece, toMove, new int[]{0, 1});                 
                }                
            }
        }
        return false;
    }
    // need to encapsulate logic for all these god damn if statements DRY
    // rowColumn is the row or column int, target is toMove int,
    // target holds a 1/-1 and a 0, representing the direction to move
    // need to be able to add the direction to itself, hence tRow tCol
    // *currently incorrect, does not account for ending on target while
    // *target is occupied with an enemy piece
    // *Should be fine, will take care of that issue outside of this class
    private boolean privNoAlly(Piece piece, int[] toMove, int[] dir){
        int tRow = dir[1];
        int tCol = dir[0];
        while(piece.getRow() + tRow != toMove[1] && piece.getColumn() + tCol != toMove[0]){
            if(board.onSquare(piece.getColumn() + tRow, piece.getRow() + tCol) != null){
                return false;
            }
            tRow += dir[1];
            tCol += dir[0];
        }
        return true;
    }
}
