/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pieces;

/**
 *
 * @author jtdollarsign
 */
public class PieceFactory {
    public Piece getPiece(PieceType pieceType, char team, int[] location){
        return pieceType.getPiece(team, location);
    }
}
