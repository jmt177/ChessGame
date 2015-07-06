/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

import ChessBoard.Board;
import Pieces.Piece;
import Pieces.PieceFactory;
import Pieces.PieceType;
import Pieces.Rook;
import java.util.ArrayList;

/**
 *
 * @author jtdollarsign
 */
public class TestingTeam {
    public static void main(String[] args){
        Board board = Board.createInstance();

        board.setLength(8);
        board.setWidth(8);
        board.setBoard(board.getLength(), board.getWidth());   
        
        PieceFactory pieceFactory = new PieceFactory();
        ChessTeam whiteTeam = new ChessTeam('w', new ArrayList<Piece>());
        ChessTeam blackTeam = new ChessTeam('b', new ArrayList<Piece>());
        ArrayList<Piece> allPieces = new ArrayList<Piece>();
        allPieces.add(pieceFactory.getPiece(PieceType.PAWN, 'w', new int[]{0,1}));
        allPieces.add(pieceFactory.getPiece(PieceType.PAWN, 'w', new int[]{1,1}));
        allPieces.add(pieceFactory.getPiece(PieceType.PAWN, 'w', new int[]{2,1}));
        allPieces.add(pieceFactory.getPiece(PieceType.PAWN, 'w', new int[]{3,1}));
        allPieces.add(pieceFactory.getPiece(PieceType.PAWN, 'w', new int[]{4,1}));
        allPieces.add(pieceFactory.getPiece(PieceType.PAWN, 'w', new int[]{5,1}));
        allPieces.add(pieceFactory.getPiece(PieceType.PAWN, 'w', new int[]{6,1}));
        allPieces.add(pieceFactory.getPiece(PieceType.PAWN, 'w', new int[]{7,1}));
        allPieces.add(pieceFactory.getPiece(PieceType.ROOK, 'w', new int[]{0,0}));
        allPieces.add(pieceFactory.getPiece(PieceType.ROOK, 'w', new int[]{7,0}));
        
        allPieces.add(pieceFactory.getPiece(PieceType.KNIGHT, 'b', new int[]{1,2}));
        allPieces.add(pieceFactory.getPiece(PieceType.ROOK, 'b', new int[]{2,3}));

        for(int i = 0; i < allPieces.size(); i++){
            Piece currentPiece = allPieces.get(i);
            if(currentPiece.getTeam() == whiteTeam.getTeamName()){
                whiteTeam.addPiece(currentPiece);
            }
            if(currentPiece.getTeam() == blackTeam.getTeamName()){
                blackTeam.addPiece(currentPiece);
            }
        
        }
        blackTeam.showTeam();
        whiteTeam.showTeam();
        whiteTeam.setOnBoard(board);
        blackTeam.setOnBoard(board);
        
        board.showBoard();
    }
}
