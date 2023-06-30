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
public class Cavallo extends Pedina{
    Cavallo(int x, int y, boolean white){
        super(x,y,white);
    }

    @Override
    protected void controlla(Square scacchiera[][],Pedina pedine[][],boolean enemy) {
        int moves[][]={{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};
        for(int i=0;i<8;i++){
            int x=this.x+moves[i][0];
            int y=this.y+moves[i][1];
            if(x<8&&x>-1&&y<8&&y>-1)
                if(pedine[x][y] instanceof Empty||!(pedine[x][y].isTurn(white)))
                    scacchiera[x][y].move(enemy,true);
        }
    }

    @Override
    protected String getType() {
        return "cavallo";
    }

    @Override
    protected boolean arrocco() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
