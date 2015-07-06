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
 * CHESSGAME
 * Built to demonstrate OO principles
 * Pieces will be objects
 * Teams will be Lists? Vectors? of pieces
 * Movement will be overridden for different piece objects
 * 
 * 
 * 
 * 
 * 
 *Piece location will now be set with the board rather than
 * indicated in the piece itself. I forsee no problems.
 *color is the team, w or b
 *
 * 
 *
 */
public abstract class Piece implements PieceMovement {

    private char team;
    private int[] location;
    
    //Sets the team and location
    public Piece(char team, int[] location) {
        this.team = team;
        this.location = location;
    }
    
    public int getRow(){
        return location[1];
    }
    
    public int getColumn(){
        return location[0];
    }
    
    public char getTeam(){
        return team;
    }
    
    public int[] getLocation(){
        return location;
    }
    
    public void setLocation(int[] loc){
        this.location[0] = loc[0];
        this.location[1] = loc[1];
    }

    @Override
    public abstract boolean legalMove(Piece piece, int[] toMove);

    @Override
    public abstract boolean inBoard(int[] toMove);

    @Override
    public abstract boolean noAlly(Piece piece, int[] toMove);

}
