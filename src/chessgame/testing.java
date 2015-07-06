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

/**
 *
 * @author jtdollarsign
 */
public class testing {
    public static void main(String[] args){
        Board board = Board.createInstance();

        board.setLength(8);
        board.setWidth(8);
        board.setBoard(board.getLength(), board.getWidth());        
        PieceFactory pieceFactory = new PieceFactory();
        Piece testPiece = pieceFactory.getPiece(PieceType.KNIGHT, 'b', new int[]{1,2});
        Piece testPiece2 = pieceFactory.getPiece(PieceType.ROOK, 'b', new int[]{2,3});
 

    
        
        if(board.onSquare(testPiece2.getColumn(), testPiece2.getRow()) == null){
            board.setPiecePosition(testPiece2.getLocation(), testPiece);
        }
        System.out.println(testPiece2.getColumn() + ", " + testPiece2.getRow());
        int[] toMove = new int[]{2,3};
        if(testPiece2.legalMove(testPiece2, toMove)){
            System.out.println("legalMove didn't fail this time");
            board.setPiecePosition(toMove, testPiece2);
            board.nullifyPosition(testPiece2.getLocation());
            testPiece2.setLocation(toMove);
        }
        System.out.println(testPiece2.getColumn() + ", " + testPiece2.getRow());
        for(int i = 0; i < board.getLength(); i++){
            for(int j = 0; j < board.getWidth(); j++){
                System.out.print(board.onSquare(i, j) + " | ");
            }
            System.out.println();
        }
    }
}
