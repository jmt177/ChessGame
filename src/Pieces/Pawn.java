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
 * NEED TO IMPLEMENT:
 * En Passant
 * Promotion
 * NEED TO TEST:
 * First move can be one or two squares
 * Attack diagonally only
 */
public class Pawn extends Piece {
    private int dir;
    private int[] starting;
    public Pawn(char team, int[] location, ChessTeam myTeam) {
        super(team, location, myTeam);
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
            // not attacking, only moving forward. Must be an empty spot on the board
            if(piece.getColumn() == toMove[0] && board.onSquare(toMove[0], toMove[1]) == null){
                // If the piece has not moved, can move forward 2 OR
                // movement distance is 1
                // Returns true here if correct direction and the distance to move is 1
                return (starting[1] == piece.getRow() && Math.abs(toMove[1] - piece.getRow()) == 2)
                        || Math.abs(toMove[1] - piece.getRow()) == 1;
            // Diagonal movement, only for attacking. toMove already passed inBoard, no need to worry about that
            } else {
                // only allowed to move 1
                if(toMove[0] - piece.getColumn() != dir || toMove[1] - piece.getRow() != dir){
                    return false;
                }
                // If there is no piece or if the piece is on the saqme team, return false
                if(board.onSquare(toMove[0], toMove[1]) == null || 
                   board.onSquare(toMove[0], toMove[1]).getTeam() == this.getTeam()){
                    return false;
                }
                // Only may attack one square away
                if(Math.abs(toMove[0] - piece.getColumn()) == 1 && 
                   Math.abs(toMove[1] - piece.getRow()) == 1){
                    return true;
                }
            }
        }
        // Not in board
        return false;
    }

    @Override
    public boolean inBoard(int[] toMove) {
        return(toMove[0] <= board.getLength() && 
               toMove[1] <= board.getWidth());
    }

    @Override
    public boolean noAlly(Piece piece, int[] toMove) {
        // The unique movment of pawns makes this unnecessary for now
        // will likely need for En Passant
        return board.onSquare(toMove[0], toMove[1]) == null;
    }

}
