/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pieces;

import Movement.PieceMovement;

/**
 *
 * @author jtdollarsign
 */
public class King extends Piece{

    public King(char team, int[] location) {
        super(team, location);
    }

    @Override
    public boolean legalMove(Piece piece, int[] toMove) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean inBoard(int[] toMove) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean noAlly(Piece piece, int[] toMove) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }  
}
