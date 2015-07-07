/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pieces;

import ChessBoard.Board;
import Movement.PieceMovement;

/**
 *
 * NEED TO IMPLEMENT:
 * En Passant
 * First move can be one or two squares
 * Attack diagonally only
 * Promotion
 */
public class Pawn extends Piece {
    private int dir;
    private int[] starting;
    public Pawn(char team, int[] location) {
        super(team, location);
        starting = location;
        if(team == 'w'){
            dir = 1;
        } else if(team == 'b'){
            dir = -1;
        }
    }
      
    Board board = Board.getInstance();
    
    @Override
    public boolean legalMove(Piece piece, int[] toMove) {
        // Same position, not a valid move
        if((piece.getColumn() == toMove[0] && piece.getRow() == toMove[1])){
            return false;
        }  
        // Not moving in the allowed direction              
        if(Math.signum(toMove[1] - piece.getRow()) != Math.signum(dir)){
            return false;
        }
  
        if(inBoard(toMove)){
            // not attacking, only moving forward
            if(piece.getColumn() == toMove[0]){
                // If the piece has not moved, can move forward 2
                if(starting[1] == piece.getRow() && Math.abs(toMove[1] - piece.getRow()) == 2){
                    return true;
                // Otherwise can only move forward one
                } else if(Math.abs(toMove[1] - piece.getRow()) != 1){
                    return false;
                }
                // Returns true here if correct direction and the distance to move is 1
                return true;
                
            // Diagonal movement, only for attacking. toMove already passed inBoard, no need to worry about that
            } else {
  
                // If there is no piece or if the piece is on the same team, return false
                if(board.onSquare(toMove[0], toMove[1]) == null || 
                   board.onSquare(toMove[0], toMove[1]).getTeam() == this.getTeam()){
                    return false;
                }
                // only allowed to move 1
                if(toMove[0] - piece.getColumn() != dir || toMove[1] - piece.getRow() != dir){
                    return false;
                }
                // Have not yet implemented taking a piece, when I do it will be as follows:
                // board.nullifyPosition(PieceTaking.position)
                // pieceTaking.setLocation(pieceTaken.getLocation)
                // pieceTakenTeam.remove(pieceTaken)
                // board.setPiecePosition(pieceTaking.getLocation, pieceTaking)
                if(Math.abs(toMove[0] - piece.getColumn()) == 1 && 
                   Math.abs(toMove[1] - piece.getRow()) == 1){
                    return true;
                }
            }
        }
    }

    @Override
    public boolean inBoard(int[] toMove) {
        return(toMove[0] <= board.getLength() && 
               toMove[1] <= board.getWidth());
    }

    @Override
    public boolean noAlly(Piece piece, int[] toMove) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
