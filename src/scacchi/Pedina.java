/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scacchi;

import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author studente
 */
public abstract class Pedina {
    protected boolean moved=false;
    protected Rectangle2D rect;
    protected int x,y,posX,posY;
    protected int startY;
    protected boolean side;
    protected BufferedImage pedina;
    protected boolean white;
    Pedina(int x,int y,boolean white){
        this.x=x;
        this.y=y;
        startY=y;
        this.white=white;
        setCoordinates(x,y);
        rect=new Rectangle2D.Double(x*100+10,y*100+10, 100, 100);
        path();
    }
    protected void path(){
        String path="/pedine/"+getType()+" ";
        if(white)
            path+="white";
        else
            path+="black";
        imageLoader(path);
    }
    protected boolean hasMoved(){
        return moved;
    }
    protected void moved(){
        moved=true;
    }
    protected void paint(Graphics g){
        g.drawImage(pedina, posX+10, posY+10, null);
    }
    private void imageLoader(String path){
        try {
            pedina=ImageIO.read(Scacchi.class.getResourceAsStream(path+".png"));
        } catch (IOException ex) {
            Logger.getLogger(Pedina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    protected void setSide(boolean side){
        this.side=side;
    }
    public boolean getSide(){
        return side;
    }
    public void setCoordinates(int x, int y){
        this.x=x;
        this.y=y;
        posX=x*100+10;
        posY=y*100+10;
        rect=new Rectangle2D.Double(posX, posY, 100, 100);
    }
    public boolean checkCoordinates(int x, int y){
        return this.x==x && this.y==y;
    }
    public Rectangle2D getBackRect(){
        return rect;
    }
    public boolean isTurn(boolean turn){
        return white==turn;
    }
    public int getPosX(){
        return posX;
    }
    public int getPosY(){
        return posY;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public BufferedImage getRect(){
        return pedina;
    }
    protected abstract boolean arrocco();
    protected abstract String getType();
    protected abstract void controlla(Square scacchiera[][],Pedina pedine[][],boolean enemy);
}
