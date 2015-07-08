/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

import ChessBoard.Board;
import Pieces.Piece;
import java.util.ArrayList;

/**
 *
 * @author jtdollarsign
 */
public class ChessTeam {
    private char teamName;
    private ArrayList<Piece> team;
    
    public ChessTeam(char teamName, ArrayList<Piece> team){
        this.teamName = teamName;
        this.team = team;
    }
    
    public void addPiece(Piece piece){
        team.add(piece);
    }
    
    public void removePiece(Piece piece){
        this.team.remove(piece);
    }
    public void showTeam(){
        for(int i = 0; i < team.size(); i++){
            System.out.println(getClass(team.get(i)));
        }
    }
    
    public void setOnBoard(Board board){
        for(int i = 0; i < team.size(); i++){
            board.setPiecePosition(team.get(i).getLocation(), team.get(i));
        }
    }
    
    private Class getClass(Object obj){
        Class cls = obj.getClass();
        return cls;
    }

    public char getTeamName(){
        return teamName;
    }
}
