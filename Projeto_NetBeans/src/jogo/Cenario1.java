/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

import jplay.Keyboard;
import jplay.Window;
import jplay.Scene;
import jplay.URL;
/**
 *
 * @author Marcos
 */
public class Cenario1 {
    
    private Window janela;
    private Scene cena;
    private Jogador jogador;
    private Keyboard teclado;
    
    public Cenario1(Window window){
        janela = window;
        cena = new Scene();
        cena.loadFromFile(URL.scenario("Cenario1.scn"));
        jogador = new Jogador(970,750);
        teclado = janela.getKeyboard();
        Som.play("mus.wav");
        
        run();
    }
    
    private void run(){
        while(true){
            //cena.draw();
            jogador.controle(janela,teclado);   
            jogador.caminho(cena);
            cena.moveScene(jogador);
            
            jogador.x +=cena.getXOffset();
            jogador.y +=cena.getYOffset();
            jogador.draw();
            
            janela.update();
            
        }
    }
    
}
