/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scacchi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Guest
 */
public class Square {
    private int x,y;
    private Rectangle2D rect;
    private Color c,c1,c2;
    private Pedina pawn;
    private boolean move,enemyMove;
    Square(int x, int y,boolean white){
        if (white){
            c1= new Color(235, 230, 200);
            c2= new Color(255, 250, 250);
        }
        else{
            c1=new Color(139, 69, 19);
            c2=new Color(190, 110, 50);
        }
        c=c1;
        rect=new Rectangle2D.Double(x, y, 100, 100);
    }
    public void move(boolean enemy,boolean move){
        if(enemy)
            enemyMove=move;
        else{
            this.move=move;
            if(move)
                c=c2;
            else
                c=c1;
        }
    }
    public boolean enemyReach(){
        return enemyMove;
    }
    public boolean canMove(){
        return move;
    }
    public void paint(Graphics g){
        Graphics2D g2=(Graphics2D)g;
        g2.setColor(c);
        g2.fill(rect);
    }
    public Rectangle2D getRect(){
        return rect;
    }
    public void setPawn(Pedina pawn){
        this.pawn=pawn;
    }
    public Pedina getPawn(){
        return pawn;
    }
}
