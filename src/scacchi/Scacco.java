/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scacchi;

/**
 *
 * @author leoto
 */
public class Scacco {
    private Pedina pedine[][];
    private Square scacchiera[][];
    Scacco(Pedina pedine[][], Square scacchiera[][]){
        this.pedine=pedine;
        this.scacchiera=scacchiera;
    }
    public void sottoScacco(int x, int y, boolean turn){
        
    }
    public void sottoScacco(boolean turn){
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                if(pedine[i][j] instanceof Empty||!pedine[i][j].isTurn(turn))
                    pedine[i][j].controlla(scacchiera,pedine,true);
    }
}
