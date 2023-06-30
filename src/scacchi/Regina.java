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
public class Regina extends Pedina{
    
    Regina(int x, int y, boolean white){
        super(x,y, white);
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
        //diagonali
        for(int x=this.x+1,y=this.y+1;x<8&&y<8;x++,y++){
            if(pedine[x][y] instanceof Empty)
                scacchiera[x][y].move(enemy,true);
            else{
                if(!pedine[x][y].isTurn(white))
                    scacchiera[x][y].move(enemy,true);
                break;
            }
        }
        for(int x=this.x+1,y=this.y-1;x<8&&y>-1;x++,y--){
            if(pedine[x][y] instanceof Empty)
                scacchiera[x][y].move(enemy,true);
            else{
                if(!pedine[x][y].isTurn(white))
                    scacchiera[x][y].move(enemy,true);
                break;
            }
        }
        for(int x=this.x-1,y=this.y+1;x>-1&&y<8;x--,y++){
            if(pedine[x][y] instanceof Empty)
                scacchiera[x][y].move(enemy,true);
            else{
                if(!pedine[x][y].isTurn(white))
                    scacchiera[x][y].move(enemy,true);
                break;
            }
        }
        for(int x=this.x-1,y=this.y-1;x>-1&&y>-1;x--,y--){
            if(pedine[x][y] instanceof Empty)
                scacchiera[x][y].move(enemy,true);
            else{
                if(!pedine[x][y].isTurn(white))
                    scacchiera[x][y].move(enemy,true);
                break;
            }
        }
    }
    
    @Override
    protected String getType() {
        return "regina";
    }

    @Override
    protected boolean arrocco() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}