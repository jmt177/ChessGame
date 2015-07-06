/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Movement;

import Pieces.Piece;

/**
 *
 * @author jtdollarsign
 */
public interface PieceMovement {
    public boolean legalMove(Piece piece, int[] toMove);
    
    public boolean inBoard(int[] toMove);
    
    public boolean noAlly(Piece piece, int[] toMove);
}
