/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import jplay.GameImage;
import jplay.Keyboard;
import jplay.Scene;
import jplay.URL;
import jplay.Window;

public class Info extends JFrame {
    
    JLabel one;
    ImageIcon img;
    
    public Info(){
        one = new JLabel();
        img = new ImageIcon();
        img = new ImageIcon(URL.sprite("mario.png"));
        one = new JLabel(img);
        JPanel p = new JPanel(new GridLayout(1,1));
        p.add(one);
        add(p);
        setVisible(true);
        
    }
   

   
    
}
