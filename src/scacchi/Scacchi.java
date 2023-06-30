/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scacchi;

import java.awt.Dimension;
import java.awt.Toolkit;
import static java.awt.Toolkit.getDefaultToolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author Megaport
 */
public class Scacchi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame=new JFrame("Scacchi");
        Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
        Scacchiera panel=new Scacchiera();
        frame.add(panel);
        int size=800;
        int l=(int)screenSize.getWidth();
        int h=(int)screenSize.getHeight();
        frame.setBounds(l/2-size/2,h/2-size/2-20,size+6,size+28);
        frame.setIconImage(new ImageIcon(getDefaultToolkit().getClass().getResource("/logo.png")).getImage());
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
