/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CreatePieces;

import Pieces.Bishop;
import Pieces.King;
import Pieces.Knight;
import Pieces.Pawn;
import Pieces.Piece;
import Pieces.Queen;
import Pieces.Rook;
import chessgame.ChessTeam;

/**
 *
 * @author jtdollarsign
 */
public enum PieceType {
    PAWN {
        @Override
        public Piece getPiece(char team, int[] location, ChessTeam myTeam) {
            return new Pawn(team, location, myTeam);
        }
    }, 
    KNIGHT {
        @Override
        public Piece getPiece(char team, int[] location, ChessTeam myTeam) {
            return new Knight(team, location, myTeam);
        }
    }, 
    BISHOP {
        @Override
        public Piece getPiece(char team, int[] location, ChessTeam myTeam) {
            return new Bishop(team, location, myTeam);
        }
    },
    ROOK {
        @Override
        public Piece getPiece(char team, int[] location, ChessTeam myTeam) {
            return new Rook(team, location, myTeam);
        }
    },
    QUEEN {
        @Override
        public Piece getPiece(char team, int[] location, ChessTeam myTeam) {
            return new Queen(team, location, myTeam);
        }
    },
    KING {
        @Override
        public Piece getPiece(char team, int[] location, ChessTeam myTeam) {
            return new King(team, location, myTeam);
        }
    };
    
     abstract Piece getPiece(char team, int[] location, ChessTeam myTeam);
}
