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
public class Knight extends Piece{
    
    public Knight(char team, int[] location) {
        super(team, location);
     }


//    public boolean movement(int[] loc1, int[] loc2){
//        //noAlly returns true if allied piece is not in loc2
//        //noAlly is special for knights as they don't care 
//        //about what is in the way
//        return (noAlly(loc2) && (((loc2[0] == loc1[0] + 2 || 
//                                  loc2[0] == loc1[0] - 2) &&
//                                 (loc2[1] == loc1[1] + 1 ||
//                                  loc2[1] == loc1[1] - 1)) ||
//                                ((loc2[0] == loc1[0] + 1 ||
//                                  loc2[0] == loc1[0] - 1) &&
//                                 (loc2[1] == loc1[1] + 2 ||
//                                  loc2[1] == loc1[1] -2))));
//    }

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
