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
public class Re extends Pedina{
    private Pedina torre1,torre2;
    private boolean arrocco;
    Re(int x, int y, boolean white, Pedina torre1, Pedina torre2){
        super(x,y,white);
        this.torre1=torre1;
        this.torre2=torre2;
    }
    @Override
    public boolean arrocco(){
        return arrocco;
    }
    private void arrocco(Square scacchiera[][],Pedina pedine[][]){
        arrocco=false;
        if(!this.hasMoved()){
            if(!torre1.hasMoved())
                if(!scacchiera[0][y].enemyReach()&&!scacchiera[4][y].enemyReach()&&
                   !scacchiera[1][y].enemyReach()&&pedine[1][y] instanceof Empty&&
                   !scacchiera[2][y].enemyReach()&&pedine[2][y] instanceof Empty&&
                   !scacchiera[3][y].enemyReach()&&pedine[3][y] instanceof Empty){
                    scacchiera[2][y].move(false, true);
                    arrocco=true;
                }
            if(!torre2.hasMoved())
                if(!scacchiera[4][y].enemyReach()&&!scacchiera[7][y].enemyReach()&&
                   !scacchiera[5][y].enemyReach()&&pedine[5][y] instanceof Empty&&
                   !scacchiera[6][y].enemyReach()&&pedine[6][y] instanceof Empty){
                    scacchiera[6][y].move(false, true);
                    arrocco=true;
                }
        }
    }
    @Override
    protected void controlla(Square scacchiera[][],Pedina pedine[][],boolean enemy) {
        int x,y;
        for(int i=-1;i<2;i++)
            for(int j=-1;j<2;j++){
                x=this.x+i;
                y=this.y+j;
                if(x<8&&x>-1&&y<8&&y>-1)
                    if((pedine[x][y] instanceof Empty||!pedine[x][y].isTurn(white))&&!scacchiera[x][y].enemyReach())
                       scacchiera[x][y].move(enemy,true);
            }
        arrocco(scacchiera,pedine);
    }

    @Override
    protected String getType() {
        return "re";
    }
}
