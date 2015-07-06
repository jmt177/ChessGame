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
public enum PieceType {
    PAWN {
        @Override
        public Piece getPiece(char team, int[] location) {
            return new Pawn(team, location);
        }
    }, 
    KNIGHT {
        @Override
        public Piece getPiece(char team, int[] location) {
            return new Knight(team, location);
        }
    }, 
    BISHOP {
        @Override
        public Piece getPiece(char team, int[] location) {
            return new Bishop(team, location);
        }
    },
    ROOK {
        @Override
        public Piece getPiece(char team, int[] location) {
            return new Rook(team, location);
            
        }
    },
    QUEEN {
        @Override
        public Piece getPiece(char team, int[] location) {
            return new Queen(team, location);
        }
    },
    KING {
        @Override
        public Piece getPiece(char team, int[] location) {
            return new King(team, location);
        }
    };
    
     abstract Piece getPiece(char team, int[] location);
}
