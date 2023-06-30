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
public class Torre extends Pedina{
    Torre(int x, int y, boolean white){
        super(x,y,white);
    }

    @Override
    protected void controlla(Square scacchiera[][],Pedina pedine[][],boolean enemy) {
        for(int i=x+1;i<8;i++){
            if(pedine[i][y] instanceof Empty)
                scacchiera[i][y].move(enemy,true);
            else{
                if(!pedine[i][y].isTurn(white))
                    scacchiera[i][y].move(enemy,true);
                break;
            }
        }
        for(int i=x-1;i>-1;i--){
            if(pedine[i][y] instanceof Empty)
                scacchiera[i][y].move(enemy,true);
            else{
                if(!pedine[i][y].isTurn(white))
                    scacchiera[i][y].move(enemy,true);
                break;
            }
        }
        for(int i=y+1;i<8;i++){
            if(pedine[x][i] instanceof Empty)
                scacchiera[x][i].move(enemy,true);
            else{
                if(!pedine[x][i].isTurn(white))
                    scacchiera[x][i].move(enemy,true);
                break;
            }
                
        }
        for(int i=y-1;i>-1;i--){
            if(pedine[x][i] instanceof Empty)
                scacchiera[x][i].move(enemy,true);
            else{
                if(!pedine[x][i].isTurn(white))
                    scacchiera[x][i].move(enemy,true);
                break;
            }
        }
    }

    @Override
    protected String getType() {
        return "torre";
    }

    @Override
    protected boolean arrocco() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
