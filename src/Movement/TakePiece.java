/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Movement;

import ChessBoard.Board;
import Pieces.Piece;

/**
 *
 * @author jtdollarsign
 */
public class TakePiece {
    // Have not yet implemented taking a piece, when I do it will be as follows:
    // board.nullifyPosition(PieceTaking.position)
    // pieceTaking.setLocation(pieceTaken.getLocation)
    // pieceTakenTeam.remove(pieceTaken)
    // board.setPiecePosition(pieceTaking.getLocation, pieceTaking)
    Board board = Board.getInstance();
    public void takePiece(Piece taking, Piece taken) {
        board.nullifyPosition(taking.getLocation());
        taking.setLocation(taken.getLocation());
        
    }
   
}
