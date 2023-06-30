/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scacchi;

/**
 *
 * @author Megaport
 */
public class Pedone extends Pedina{
    public Pedone(int x, int y,boolean white) {
        super(x, y, white);
    }

    @Override
    protected void controlla(Square scacchiera[][],Pedina pedine[][],boolean enemy) {
        int n;
        if(white)
            n=-1;
        else
            n=1;
        if(pedine[x][y+n] instanceof Empty){
            scacchiera[x][y+n].move(enemy,true);
            if(y+2*n<7 && y+2*n>0)
                if(pedine[x][y+2*n] instanceof Empty && y==startY)
                    scacchiera[x][y+2*n].move(enemy,true);
        }
        if(x<7)
            if(!(pedine[x+1][y+n] instanceof Empty) && pedine[x+1][y+n].isTurn(!white))
                scacchiera[x+1][y+n].move(enemy,true);
        if(x>0)
            if(!(pedine[x-1][y+n] instanceof Empty) && pedine[x-1][y+n].isTurn(!white))
                scacchiera[x-1][y+n].move(enemy,true);
    }

    @Override
    protected String getType() {
        return "pedone";
    }

    @Override
    protected boolean arrocco() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
