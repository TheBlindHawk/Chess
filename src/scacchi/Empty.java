/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scacchi;

import java.awt.Graphics;

/**
 *
 * @author Studente
 */
public class Empty extends Pedina{
    Empty(int x,int y,boolean white){
        super(x,y,white);
    }

    @Override
    protected void paint(Graphics g) {
    }
    
    @Override
    protected void path() {
    }

    @Override
    protected String getType() {
        return "empty";
    }
    
    @Override
    protected void controlla(Square[][] scacchiera,Pedina[][] pedine,boolean enemy) {
    }

    @Override
    protected boolean arrocco() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
