/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scacchi;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 *
 * @author Megaport
 */
public class Scacchiera extends JPanel implements MouseListener{
    private Pedina[][] scacchiera = new Pedina[8][8];
    private Square[][] quadrato = new Square[8][8];
    private boolean select=false;
    private Pedina selected;
    private int posx,posy;
    private boolean turn=true;
    private Scacco scacco=new Scacco(scacchiera,quadrato);
    Scacchiera(){
        creaScacchiera();
        this.addMouseListener(this);
        boolean c = true;
        for (int i = 0; i < 8; i++) {
            c=!c;
            for (int j = 0; j < 8; j++) {
                c=!c;
                quadrato[i][j] = new Square(i * 100,j * 100, c);
            }
        }
    }
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        disegnaScacchiera(g2);
        disegnaPedine(g2);
    }
    private void creaScacchiera(){
        for(int i=0;i<8;i++){
            scacchiera[i][1]=new Pedone(i,1,false);
            scacchiera[i][6]=new Pedone(i,6,true);
        }
        for(int i=0;i<8;i++){
            for(int j=2;j<6;j++){
                scacchiera[i][j]=new Empty(i,j,true);
            }
        }
        scacchiera[3][0]=new Regina(3,0,false);
        scacchiera[3][7]=new Regina(3,7,true);
        scacchiera[0][0]=new Torre(0,0,false);
        scacchiera[7][0]=new Torre(7,0,false);
        scacchiera[0][7]=new Torre(0,7,true);
        scacchiera[7][7]=new Torre(7,7,true);
        scacchiera[1][0]=new Cavallo(1,0,false);
        scacchiera[6][0]=new Cavallo(6,0,false);
        scacchiera[1][7]=new Cavallo(1,7,true);
        scacchiera[6][7]=new Cavallo(6,7,true);
        scacchiera[2][0]=new Alfiere(2,0,false);
        scacchiera[5][0]=new Alfiere(5,0,false);
        scacchiera[2][7]=new Alfiere(2,7,true);
        scacchiera[5][7]=new Alfiere(5,7,true);
        scacchiera[4][0]=new Re(4,0,false,scacchiera[0][0],scacchiera[7][0]);
        scacchiera[4][7]=new Re(4,7,true,scacchiera[0][7],scacchiera[7][7]);
    }
    private void disegnaScacchiera(Graphics g) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                quadrato[i][j].paint(g);
            }
        }
    }

    private void disegnaPedine(Graphics g) {
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                scacchiera[i][j].paint(g);
            }
        }
    }
    
    private void reset(){
        for (int i = 0; i < 8; i++) 
            for (int j = 0; j < 8; j++){
                quadrato[i][j].move(false,false);
                quadrato[i][j].move(true,false);
            }
    }
    private void killEnemies(int x, int y){
        scacchiera[x][y]=new Empty(x,y,true);
    }
    private void checkQueen(int i, int j){
        if(selected.getY()==7||selected.getY()==0)
            scacchiera[i][j]=new Regina(selected.getX(),selected.getY(),turn);
    }
    @Override
    public void mouseClicked(MouseEvent me) {
        boolean next=true;
        if(select)
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (quadrato[i][j].getRect().contains(me.getX(), me.getY())){
                        if(quadrato[i][j].canMove()){
                            scacco.sottoScacco(turn);
                            killEnemies(i,j);
                            scacchiera[i][j]=scacchiera[posx][posy];
                            scacchiera[i][j].setCoordinates(i, j);
                            scacchiera[posx][posy]=new Empty(posx,posy,true);
                            selected.moved();
                            if(selected instanceof Pedone)
                                checkQueen(i,j);
                            if((selected instanceof Re)&&selected.arrocco()){
                                if(i==2){
                                    scacchiera[3][posy]=scacchiera[0][posy];
                                    scacchiera[3][posy].setCoordinates(3, posy);
                                    scacchiera[0][posy]=new Empty(0,posy,true);
                                }
                                if(i==6){
                                    scacchiera[5][posy]=scacchiera[7][posy];
                                    scacchiera[5][posy].setCoordinates(5, posy);
                                    scacchiera[7][posy]=new Empty(7,posy,true);
                                }
                            }
                            reset();
                            select=false;
                            next=false;
                            turn=!turn;
                        }
                    }
                }
            }
        if(next){
             for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(scacchiera[i][j].getBackRect().contains(me.getX(),me.getY()) && scacchiera[i][j].isTurn(turn)){
                        reset();
                        scacco.sottoScacco(turn);
                        this.posx=i;
                        this.posy=j;
                        selected=scacchiera[i][j];
                        selected.controlla(quadrato,scacchiera,false);
                        select=true;
                    }
                }
             }
        }
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
}
