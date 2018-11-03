import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Point;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Pojeto extends JFrame implements MouseMotionListener, Observer{

	private JPanel contentPane;
	private Control control;
	private JLabel Info;
	private JLabel moeda;
	private JLabel moeda1;
	private JLabel moeda2;
	private JLabel moeda3;
	private JLabel moeda4;
	private JLabel moeda5;
	private JLabel moeda6;
	private JLabel moeda7;
	private JLabel moeda8;
	private JLabel moeda9;
	private JLabel moeda10;
	private JLabel bau;
	private JLabel cameraV;
	
	
	
	URL som = Pojeto.class.getResource("mus.wav"); //implementação do som do jogo, coloquei uma musica
	AudioClip Som = Applet.newAudioClip(som);	   //do metallica em 8bits, não sei se é adequado para a apresentação
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pojeto frame = new Pojeto();
					frame.setVisible(true);	
					Robot robo = new Robot();
					robo.mouseMove(333, 511);
					
					frame.Som.play();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	int entrada = 0; // variavel para identificação das salas e exibição de imagem
	int baixo = 1;
	int esq =1;
	int cima = 1; 
	int dir =1;
	int conta = 0;
	
	int moedas = 0;
		
	int x = 333; //coordenadas iniciais em relação ao screen
	int y = 511;
	boolean fimdejogo=false;
	Toolkit TK = Toolkit.getDefaultToolkit();
	Image dir1 = TK.getImage(Pojeto.class.getResource("/persona/d1.png"));
	Cursor d1 = TK.createCustomCursor(dir1, new Point(0,0), "d2");
	Image dir2 = TK.getImage(Pojeto.class.getResource("/persona/d2.png"));
	Cursor d2 = TK.createCustomCursor(dir2, new Point(0,0), "d2");
	Image dir3 = TK.getImage(Pojeto.class.getResource("/persona/d3.png"));
	Cursor d3 = TK.createCustomCursor(dir3, new Point(0,0), "d3");
	Image dir4 = TK.getImage(Pojeto.class.getResource("/persona/d4.png"));
	Cursor d4 = TK.createCustomCursor(dir4, new Point(0,0), "d4");
	
	/*ImageIcon dir2 = new ImageIcon(Pojeto.class.getResource("/persona/d2.png"));
	Cursor d2 = TK.createCustomCursor(dir2.getImage(), new Point(0,0), "d2");
	ImageIcon dir3 = new ImageIcon(Pojeto.class.getResource("/persona/d3.png"));
	Cursor d3 = TK.createCustomCursor(dir3.getImage(), new Point(0,0), "d3");
	ImageIcon dir4 = new ImageIcon(Pojeto.class.getResource("/persona/d4.png"));
	Cursor d4 = TK.createCustomCursor(dir4.getImage(), new Point(0,0), "d4");*/
	
	ImageIcon esq1 = new ImageIcon(Pojeto.class.getResource("/persona/e1.png"));
	Cursor e1 = TK.createCustomCursor(esq1.getImage(), new Point(1,1), "e1");
	ImageIcon esq2 = new ImageIcon(Pojeto.class.getResource("/persona/e2.png"));
	Cursor e2 = TK.createCustomCursor(esq2.getImage(), new Point(1,1), "e2");
	ImageIcon esq3 = new ImageIcon(Pojeto.class.getResource("/persona/e3.png"));
	Cursor e3 = TK.createCustomCursor(esq3.getImage(), new Point(1,1), "e3");
	ImageIcon esq4 = new ImageIcon(Pojeto.class.getResource("/persona/e4.png"));
	Cursor e4 = TK.createCustomCursor(esq4.getImage(), new Point(1,1), "e4");
	
	ImageIcon baixo1 = new ImageIcon(Pojeto.class.getResource("/persona/b1.png")); //não roda gif no cursor do mouse, seria uma boa opção para criar movimento
	Cursor cursor1 = TK.createCustomCursor(baixo1.getImage(), new Point(0,0), "b1");
	ImageIcon baixo2 = new ImageIcon(Pojeto.class.getResource("/persona/b2.png"));//tentei fazer um loop com for, porem nao deu certo
	Cursor cursor2 = TK.createCustomCursor(baixo2.getImage(), new Point(0,0), "b2");
	ImageIcon baixo3 = new ImageIcon(Pojeto.class.getResource("/persona/b3.png"));
	Cursor cursor3 = TK.createCustomCursor(baixo3.getImage(), new Point(0,0), "b3");
	ImageIcon Imagem4 = new ImageIcon(Pojeto.class.getResource("/persona/b4.png"));
	Cursor cursor4 = TK.createCustomCursor(Imagem4.getImage(), new Point(0,0), "b4");
	
	ImageIcon cima1 = new ImageIcon(Pojeto.class.getResource("/persona/c1.png"));
	Cursor c1 = TK.createCustomCursor(cima1.getImage(), new Point(0,0), "c1");
	ImageIcon cima2 = new ImageIcon(Pojeto.class.getResource("/persona/c2.png"));
	Cursor c2 = TK.createCustomCursor(cima2.getImage(), new Point(0,0), "c2");
	ImageIcon cima3 = new ImageIcon(Pojeto.class.getResource("/persona/c3.png"));
	Cursor c3= TK.createCustomCursor(cima3.getImage(), new Point(0,0), "c3");
	ImageIcon cima4 = new ImageIcon(Pojeto.class.getResource("/persona/c4.png"));
	Cursor c4 = TK.createCustomCursor(cima4.getImage(), new Point(0,0), "c4");
	ImageIcon cima5 = new ImageIcon(Pojeto.class.getResource("/persona/c5.png"));
	Cursor c5 = TK.createCustomCursor(cima5.getImage(), new Point(0,0), "c5");
	ImageIcon cima6 = new ImageIcon(Pojeto.class.getResource("/persona/c6.png"));
	Cursor c6 = TK.createCustomCursor(cima6.getImage(), new Point(0,0), "c6");
	
	
	
	
	
	public Pojeto() {
		
	setCursor(d1);
		
		
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE ) {
					setVisible(false);				
					//Som.stop();
					System.exit(0);
				}
				if(e.getKeyCode() == KeyEvent.VK_M) {
					if(entrada==1) {
						Info.setIcon(new ImageIcon(Pojeto.class.getResource("/infos/InfoRasp.png")));
						Info.setVisible(true);
					}else if(entrada==2) {
						Info.setIcon(new ImageIcon(Pojeto.class.getResource("/infos/Info2.png")));
						Info.setVisible(true);
					}else if(entrada==3) {
						Info.setIcon(new ImageIcon(Pojeto.class.getResource("/infos/infojava.fw.png")));
						Info.setVisible(true);
					}else if(entrada==4) {
						Info.setIcon(new ImageIcon(Pojeto.class.getResource("/infos/infomat.fw.png")));
						Info.setVisible(true);
					}else if(entrada==6) {
						Info.setIcon(new ImageIcon(Pojeto.class.getResource("/infos/InfoJogos.fw.png")));
						Info.setVisible(true);
					}else if(entrada==7) {
						Info.setIcon(new ImageIcon(Pojeto.class.getResource("/infos/infocursos.fw.png")));
						Info.setVisible(true);
					}else if(entrada==9) {
						Info.setIcon(new ImageIcon(Pojeto.class.getResource("/infos/infosoc.fw.png")));
						Info.setVisible(true);
					}else if(entrada==10) {
						Info.setIcon(new ImageIcon(Pojeto.class.getResource("/infos/infoconin.fw.png")));
						Info.setVisible(true);
					}
					}
				if(e.getKeyCode() == KeyEvent.VK_S) {
					
					
						
						Info.setVisible(false);
						if(fimdejogo) {
							moeda.setVisible(true);
							moeda1.setVisible(true);
							moeda2.setVisible(true);
							moeda3.setVisible(true);
							moeda4.setVisible(true);
							moeda5.setVisible(true);
							moeda6.setVisible(true);
							moeda7.setVisible(true);
							moeda8.setVisible(true);
							moeda9.setVisible(true);
							moeda10.setVisible(true);
							bau.setVisible(true);
							Info.setVisible(false);
							cameraV.setVisible(true);
							x=333;
							y=511;
							moedas=0;
							fimdejogo=false;
							
						}
				}
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) { //DIREITA
					
					if(
						(y>53 && y<145 && (x==5||x==119||x==233))||
						(y>256 && y<311 && (x==119||x==233))||
						(x==337 && y>=0 && y<159)||
						(x==359 && y>192 && y<280)||
						(y>209 && y<260 && (x==75||x==187))||
						(x==477 && ((y>=0 && y<28)||(y>192 && y<280)||(y>51 && y<157)||(y>296 && y<345)))||
						(x==545 && y>=0 && y<65)||
						(x==523 && ((y>328 && y<368)||(y>409 && y<434)||(y>457 && y<501)))||
						(x==749 && y>=0 && y<554)||
						(x==637 && ((y>0 && y<126)||(y>148 && y<308)||(y>329 && y<423)||(y>443 && y<537)))	||
						(x==385 && y>296 && y<600)||
						(x==405 && y>2 && y<63)
							
													
							) {}
					else {
					x+=2;
					
					if(dir<4) {
						setCursor(d1);
						dir++;	}
						else if(dir<7) {
							setCursor(d2);
							dir++;	}
								else if(dir<10)	{
									setCursor(d3);
									dir++;
						}else if(dir<13)	{
							setCursor(d4);
							dir++;
							dir=1;
							}
					try {									
						Robot robo = new Robot();
						robo.mouseMove(x, y);
					}catch(AWTException w) {
						w.printStackTrace();
					}
					}
				}
				if(e.getKeyCode() == KeyEvent.VK_LEFT) { //ESQUERDA
					
					if(
						(x==285 && ((y<463 &&  y>205)||(y<143 &&  y>-1)) )||
						(x==171 && ((y<297 &&  y>209)||(y<93 &&  y>51)) )||
						(x==57 && ((y<93 &&  y>51)||(y<301 &&  y>207)) )||
						(x==451 && y<277 && y>191 )||
						(x==455 && y<159 && y>=6 )||						
						(x==529 && y>=0 && y<26)||
						(x==599 && y<159 && y>=0 )||
						(x==571 && y<279 && y>191 )||
						(x==689 && ((y<123 &&  y>55)||(y<165 &&  y>145)||(y<307 &&  y>219)||(y<347 &&  y>327)||(y<423 &&  y>401)||(y<537 &&  y>453)))||
						(x==597 && ((y<433 &&  y>293)||(y<529 &&  y>453)) )||
						(x==459 && y<344 && y>291 )||
						(x==435 && ((y<377 &&  y>334)||(y<466 &&  y>411)))||
						(x==99 && y>91 && y<145)||
						(x==211 && y>91 && y<145)||
						(x==389 && y>=0 && y<55)||
						(x==99 && y>453 && y<536)||
						(x==41 && y>528 && y<600)||
						(x==305 && y>38 && y<129)
																										
							) {
						
					}
					else {
					x-=2;
					
					if(esq<4) {
						setCursor(e1);
						esq++;	}
						else if(esq<7) {
							setCursor(e2);
							esq++;	}
								else if(esq<10)	{
									setCursor(e3);
									esq++;
						}else if(esq<13)	{
							setCursor(e4);
							esq++;
							esq=1;
						}
					
					try {
						Robot robo = new Robot();
						robo.mouseMove(x, y);
					}catch(AWTException w) {
						w.printStackTrace();
					}
					}
					
				}
				if(e.getKeyCode() == KeyEvent.VK_DOWN) { //BAIXO
					
					if((y==295  && x>43 && x<247)||
					   (y==205  && ((x>=0 && x<53)||(x>74 && x<165)||(x>195 && x<279)))||
					   (y==91 && ((x>40 && x<97)||(x>152 && x<207)))||
					   (y==7 && x>0 && x<278)||
					   (y==41 && ((x>374 && x<421)||(x>485 && x<567)))||
					   (y==185 && ((x>363 && x<449)||(x>486 && x<562)))||
					   (y==291 && ((x>387 && x<455)||(x>482 && x<592)))||
					   (y==359  && x>423 && x<543)||
					   (y==451  && x>529 && x<590)||
					   (y==5  && x>641 && x<767)||
					   (y==531  && x>581 && x<654)||
					   (x>639 && x<685 && (y==141 || y==325 || y==439))||
					   (x>667 && x<771 && (y==163 || y==345 || y==531))||
					   (y==35 && x>273 && x<303)
							
							) {}
					else {
					y+=2;
					
					if(baixo<3) {
						setCursor(cursor1);
						baixo++;	}
						else if(baixo<5) {
							setCursor(cursor2);
							baixo++;	}
								else if(baixo<7)	{
									setCursor(cursor3);
									baixo++;
						}else if(baixo<9)	{
							setCursor(cursor4);
							baixo++;
							baixo=1;
							}
					}
					//fireworks
					
					try {
						Robot robo = new Robot();
						robo.mouseMove(x, y);
					}catch(AWTException w) {
						w.printStackTrace();
					}
					
				}
				if(e.getKeyCode() == KeyEvent.VK_UP) { //CIMA
					
					if(
							(x>=0 && x<283 && y==57)||
							(x>338 && x<454 && y==161)||
							(x>478 && x<598 && y==161)|| 
							(x>8 && x<96 && y==149)||
							(x>478 && x<598 && y==161)||
							(x>0 && x<283 && y==465)||
							(x>122 && x<212 && y==149)||
							(x>478 && x<598 && y==161)||
							(x>236 && x<280 && y==149)||
							(x>76 && x<118 && y==263)||
							(x>188 && x<238 && y==263)||
							(x>364 && x<450 && y==285)||
							(x>480 && x<568 && y==285)||
							(x>430 && x<456 && y==349)||
							(x>480 && x<524 && y==349)||
							(x>638 && x<684 && (y==129 || y==313 || y==427 ))||
							(x>684 && x<750 && (y==61||y==221||y==403))||
							(x>423 && x<524 && y==415)||
							(x>526 && x<594 && y==439)||
							(y==1 && x>0 && x<800)||
							(x>20 && x<95 && y==541)||
							(y==131 && x>267 && x<304)
							
					
					
					
					){	//implementação da barreira das paredes
								
						/*Essa parte esta se movendo em relação ao screen, ou seja, pela resolução do quadro
						 * como vams usar 800x600 estou mudando a resolução do notebook para testar, não sei se tem outro meio
						 * porem assim esta funcionando*/
						
						
						
						
						
					}else {
					y-=2;
					if(cima<3) {
						setCursor(c1);
						cima++;	}
						else if(cima<5) {
							setCursor(c2);
							cima++;	}
								else if(cima<7)	{
									setCursor(c3);
									cima++;
						}else if(cima<9)	{
							setCursor(c4);
							cima++;
							}else if(cima<11)	{
								setCursor(c5);
								cima++;
								}else if(cima<13)	{
									setCursor(c6);
									cima=1;
									}
					}
					try {
						Robot robo = new Robot();
						robo.mouseMove(x, y);
					}catch(AWTException w) {
						w.printStackTrace();				//aqui termina a implementação da movimentação
					}
				}
							
			}
		});
		
		
		setUndecorated(true);
		setResizable(false);
		setSize(800,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Info = new JLabel("");		
		Info.setVisible(false);		
		Info.setBounds(152, 152, 500, 252);
		contentPane.add(Info);
		
		JLabel canteiro2 = new JLabel("");
		canteiro2.setIcon(new ImageIcon(Pojeto.class.getResource("/imagens/canteirinho.png")));
		canteiro2.setBounds(507, 220, 66, 64);
		contentPane.add(canteiro2);
		
		JLabel canteiro3_1 = new JLabel("");
		canteiro3_1.setIcon(new ImageIcon(Pojeto.class.getResource("/imagens/canteirinho.png")));
		canteiro3_1.setBounds(390, 220, 66, 64);
		contentPane.add(canteiro3_1);
		
		JLabel bird = new JLabel("");
		bird.setIcon(new ImageIcon(Pojeto.class.getResource("/imagens/teste.gif")));
		bird.setBounds(247, 415, 94, 64);
		contentPane.add(bird);
		
		
		JLabel canteiroMaior = new JLabel("");
		canteiroMaior.setIcon(new ImageIcon(Pojeto.class.getResource("/imagens/Teste.png")));
		canteiroMaior.setBounds(0, 342, 286, 123);
		contentPane.add(canteiroMaior);
		
		JLabel canteiro3 = new JLabel("");
		canteiro3.setIcon(new ImageIcon(Pojeto.class.getResource("/imagens/Grama1.png")));
		canteiro3.setBounds(364, 97, 94, 64);
		contentPane.add(canteiro3);
		
		JLabel canteiro1 = new JLabel("");
		canteiro1.setIcon(new ImageIcon(Pojeto.class.getResource("/imagens/Grama1.png")));
		canteiro1.setBounds(506, 81, 120, 96);
		contentPane.add(canteiro1);
		
		moeda5 = new JLabel("");
		moeda5.setHorizontalAlignment(SwingConstants.CENTER);
		moeda5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				moeda5.setVisible(false);
				moedas+=100;
			}
		});
		moeda5.setIcon(new ImageIcon(Pojeto.class.getResource("/imagens/moeda1.fw.png")));
		moeda5.setBounds(517, 26, 56, 44);
		contentPane.add(moeda5);
		
		JLabel salas4 = new JLabel("");
		salas4.setIcon(new ImageIcon(Pojeto.class.getResource("/imagens/salas4.png")));
		salas4.setBounds(507, -75, 91, 187);
		contentPane.add(salas4);
		
		JLabel setacima2 = new JLabel("");
		setacima2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
								entrada=10;
							}
			@Override
			public void mouseExited(MouseEvent e) {
				entrada=0;
			}
		});
		setacima2.setIcon(new ImageIcon(Pojeto.class.getResource("/imagens/set_cima.fw.png")));
		setacima2.setBounds(614, 11, 38, 38);
		contentPane.add(setacima2);
		
		moeda7 = new JLabel("");
		moeda7.setVerticalAlignment(SwingConstants.BOTTOM);
		moeda7.setHorizontalAlignment(SwingConstants.CENTER);
		moeda7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				moeda7.setVisible(false);
				moedas+=100;
			}
		});
		moeda7.setIcon(new ImageIcon(Pojeto.class.getResource("/imagens/moeda1.fw.png")));
		moeda7.setBounds(501, 461, 46, 48);
		contentPane.add(moeda7);
		
		JLabel acesso = new JLabel("");
		acesso.setIcon(new ImageIcon(Pojeto.class.getResource("/imagens/acesso.fw.png")));
		acesso.setBounds(415, 481, 199, 108);
		contentPane.add(acesso);
		
		JLabel setacima3 = new JLabel("");
		setacima3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
								entrada=10;
							}
			@Override
			public void mouseExited(MouseEvent e) {
				entrada=0;
			}
		});
		setacima3.setIcon(new ImageIcon(Pojeto.class.getResource("/imagens/set_cima.fw.png")));
		setacima3.setBounds(469, 11, 38, 38);
		contentPane.add(setacima3);
		
		moeda6 = new JLabel("");
		moeda6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				moeda6.setVisible(false);
				moedas+=100;
			}
		});
		moeda6.setVerticalAlignment(SwingConstants.BOTTOM);
		moeda6.setHorizontalAlignment(SwingConstants.RIGHT);
		
		moeda6.setIcon(new ImageIcon(Pojeto.class.getResource("/imagens/moeda1.fw.png")));
		moeda6.setBounds(489, 348, 46, 38);
		contentPane.add(moeda6);
		
		moeda8 = new JLabel("");
		moeda8.setVerticalAlignment(SwingConstants.BOTTOM);
		moeda8.setHorizontalAlignment(SwingConstants.RIGHT);
		moeda8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				moeda8.setVisible(false);
				moedas+=100;
			}
		});
		moeda8.setIcon(new ImageIcon(Pojeto.class.getResource("/imagens/moeda1.fw.png")));
		moeda8.setBounds(724, 497, 46, 47);
		contentPane.add(moeda8);
		
		moeda9 = new JLabel("");
		moeda9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			moeda9.setVisible(false);
			moedas+=100;
			}
		});
		
		JLabel eduvale = new JLabel("");
		eduvale.setIcon(new ImageIcon(Pojeto.class.getResource("/imagens/eduvale.fw.png")));
		eduvale.setBounds(308, 360, 92, 75);
		contentPane.add(eduvale);
		moeda9.setHorizontalAlignment(SwingConstants.RIGHT);
		moeda9.setVerticalAlignment(SwingConstants.BOTTOM);
		moeda9.setIcon(new ImageIcon(Pojeto.class.getResource("/imagens/moeda1.fw.png")));
		moeda9.setBounds(724, 325, 46, 44);
		contentPane.add(moeda9);
		
		moeda10 = new JLabel("");
		moeda10.setVerticalAlignment(SwingConstants.BOTTOM);
		moeda10.setHorizontalAlignment(SwingConstants.RIGHT);
		moeda10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				moeda10.setVisible(false);
				moedas+=100;
			}
		});
		
		bau = new JLabel("");
		bau.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				moedas+=500;
				bau.setVisible(false);
				entrada=5;
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				entrada=0;
			}
		});
		bau.setHorizontalAlignment(SwingConstants.RIGHT);
		bau.setVerticalAlignment(SwingConstants.BOTTOM);
		bau.setIcon(new ImageIcon(Pojeto.class.getResource("/imagens/montemoeda.fw.png")));
		bau.setBounds(174, 282, 46, 44);
		contentPane.add(bau);
		moeda10.setIcon(new ImageIcon(Pojeto.class.getResource("/imagens/moeda1.fw.png")));
		moeda10.setBounds(732, 143, 38, 38);
		contentPane.add(moeda10);
		
		JLabel videogame = new JLabel("");
		videogame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				entrada=6;
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				entrada=0;
			}
		});
		videogame.setHorizontalAlignment(SwingConstants.RIGHT);
		videogame.setIcon(new ImageIcon(Pojeto.class.getResource("/imagens/videogame.fw.png")));
		videogame.setBounds(707, 244, 46, 40);
		contentPane.add(videogame);
		
		JLabel botoes = new JLabel("");
		botoes.setIcon(new ImageIcon(Pojeto.class.getResource("/imagens/botoes.fw.png")));
		botoes.setBounds(133, 0, 161, 38);
		contentPane.add(botoes);
		
		JLabel moto2 = new JLabel("");
		moto2.setIcon(new ImageIcon(Pojeto.class.getResource("/imagens/motoy.png")));
		moto2.setBounds(31, 463, 46, 83);
		contentPane.add(moto2);
		
		JLabel moto = new JLabel("");
		moto.setIcon(new ImageIcon(Pojeto.class.getResource("/imagens/motox.png")));
		moto.setBounds(0, 453, 38, 102);
		contentPane.add(moto);
		
		moeda1 = new JLabel("");
		moeda1.setVerticalAlignment(SwingConstants.BOTTOM);
		moeda1.setHorizontalAlignment(SwingConstants.CENTER);
		moeda1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				moeda1.setVisible(false);
				moedas+=100;
			}
		});
		moeda1.setIcon(new ImageIcon(Pojeto.class.getResource("/imagens/moeda1.fw.png")));
		moeda1.setBounds(100, 51, 46, 38);
		contentPane.add(moeda1);
		
		moeda4 = new JLabel("");
		moeda4.setVerticalAlignment(SwingConstants.BOTTOM);
		moeda4.setHorizontalAlignment(SwingConstants.CENTER);
		moeda4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				moeda4.setVisible(false);
				moedas+=100;
			}
		});
		
		JLabel livros = new JLabel("");
		livros.setHorizontalAlignment(SwingConstants.RIGHT);
		livros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				entrada=4;
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				entrada=0;
			}
		});
		livros.setVerticalAlignment(SwingConstants.BOTTOM);
		livros.setIcon(new ImageIcon(Pojeto.class.getResource("/imagens/Livros.fw.png")));
		livros.setBounds(724, 65, 46, 52);
		contentPane.add(livros);
		moeda4.setIcon(new ImageIcon(Pojeto.class.getResource("/imagens/moeda1.fw.png")));
		moeda4.setBounds(207, 51, 57, 38);
		contentPane.add(moeda4);
		
		moeda3 = new JLabel("");
		moeda3.setHorizontalAlignment(SwingConstants.RIGHT);
		moeda3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				moeda3.setVisible(false);
				moedas+=100;
			}
		});
		moeda3.setIcon(new ImageIcon(Pojeto.class.getResource("/imagens/moeda1.fw.png")));
		moeda3.setBounds(390, 11, 30, 54);
		contentPane.add(moeda3);
		
		moeda = new JLabel("");
		moeda.setVerticalAlignment(SwingConstants.BOTTOM);
		moeda.setHorizontalAlignment(SwingConstants.CENTER);
		moeda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
			moeda.setVisible(false);
			moedas+=100;
			}
		});
		moeda.setIcon(new ImageIcon(Pojeto.class.getResource("/imagens/moeda1.fw.png")));
		moeda.setBounds(100, 265, 46, 38);
		contentPane.add(moeda);
		
		moeda2 = new JLabel("");
		moeda2.setVerticalAlignment(SwingConstants.BOTTOM);
		moeda2.setHorizontalAlignment(SwingConstants.CENTER);
		moeda2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				moeda2.setVisible(false);
				moedas+=100;
			}
		});
		moeda2.setIcon(new ImageIcon(Pojeto.class.getResource("/imagens/moeda1.fw.png")));
		moeda2.setBounds(210, 244, 54, 38);
		contentPane.add(moeda2);
		
		JLabel moto3 = new JLabel("");
		moto3.setIcon(new ImageIcon(Pojeto.class.getResource("/imagens/motok.png")));
		moto3.setBounds(62, 468, 46, 64);
		contentPane.add(moto3);
		
		JLabel diploma = new JLabel("");
		diploma.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				entrada=7;
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				entrada=0;
			}
		});
		diploma.setHorizontalAlignment(SwingConstants.RIGHT);
		diploma.setVerticalAlignment(SwingConstants.TOP);
		diploma.setIcon(new ImageIcon(Pojeto.class.getResource("/imagens/diploma.fw.png")));
		diploma.setBounds(724, 415, 46, 38);
		contentPane.add(diploma);
		
		JLabel logo = new JLabel("");
		logo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				entrada=3;
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				entrada=0;
			}
		});
		logo.setIcon(new ImageIcon(Pojeto.class.getResource("/imagens/java.fw.png")));
		logo.setBounds(174, 65, 46, 47);
		contentPane.add(logo);
		
		JLabel estacionamento = new JLabel("New label");
		estacionamento.setIcon(new ImageIcon(Pojeto.class.getResource("/imagens/estacionamento.png")));
		estacionamento.setBounds(0, 453, 286, 102);
		contentPane.add(estacionamento);
		
		JLabel seta = new JLabel("");
		seta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
								entrada=10;
							}
			@Override
			public void mouseExited(MouseEvent e) {
				entrada=0;
			}
		});
		seta.setIcon(new ImageIcon(Pojeto.class.getResource("/imagens/set_esq.fw.png")));
		seta.setBounds(62, 180, 38, 32);
		contentPane.add(seta);
		
		JLabel salas2 = new JLabel("");
		salas2.setIcon(new ImageIcon(Pojeto.class.getResource("/imagens/salas2.png")));
		salas2.setBounds(-11, 41, 305, 304);
		contentPane.add(salas2);
		
		JLabel salas3 = new JLabel("");
		salas3.setIcon(new ImageIcon(Pojeto.class.getResource("/imagens/salas3.png")));
		salas3.setBounds(367, -64, 91, 160);
		contentPane.add(salas3);
		
		JLabel dog = new JLabel("");
		dog.setIcon(new ImageIcon(Pojeto.class.getResource("/imagens/dog2.gif")));
		dog.setBounds(10, 545, 38, 44);
		contentPane.add(dog);
		
		JLabel pias = new JLabel("");
		pias.setIcon(new ImageIcon(Pojeto.class.getResource("/imagens/pias.png")));
		pias.setBounds(283, 65, 46, 64);
		contentPane.add(pias);
		
		JLabel setacima = new JLabel("");
		setacima.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
								entrada=10;
							}
			@Override
			public void mouseExited(MouseEvent e) {
				entrada=0;
			}
		});
		setacima.setIcon(new ImageIcon(Pojeto.class.getResource("/imagens/set_cima.fw.png")));
		setacima.setBounds(319, 11, 38, 38);
		contentPane.add(setacima);
		
		JLabel chao = new JLabel("");
		
		
		//JInternalFrame
		
		chao.setIcon(new ImageIcon(Pojeto.class.getResource("/imagens/aslfalto.png")));
		chao.addMouseMotionListener(this);
		
		cameraV = new JLabel("");
		cameraV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				cameraV.setVisible(false);
				moedas+=500;
				
			}
					});
		cameraV.setIcon(new ImageIcon(Pojeto.class.getResource("/imagens/montemoeda.fw.png")));
		cameraV.setBounds(438, 342, 46, 44);
		contentPane.add(cameraV);
		
		JLabel cam = new JLabel("");
		cam.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				entrada=9;
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				entrada=0;
			}
		});
		cam.setIcon(new ImageIcon(Pojeto.class.getResource("/imagens/camera.fw.png")));
		cam.setBounds(438, 421, 38, 44);
		contentPane.add(cam);
		
		JLabel ads = new JLabel("");
		ads.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				entrada=2;
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				entrada=0;
			}
		});
		ads.setVerticalAlignment(SwingConstants.BOTTOM);
		ads.setIcon(new ImageIcon(Pojeto.class.getResource("/imagens/ads.fw.png")));
		ads.setBounds(62, 284, 38, 38);
		contentPane.add(ads);
		
		JLabel salas = new JLabel("");
		salas.setIcon(new ImageIcon(Pojeto.class.getResource("/imagens/paredin.png")));
		salas.setBounds(415, 0, 385, 600);
		contentPane.add(salas);
		
		JLabel rasp = new JLabel("");
		rasp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				entrada=1;
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				entrada=0;
			}
		});
		rasp.setIcon(new ImageIcon(Pojeto.class.getResource("/imagens/rasp.fw.png")));
		rasp.setBounds(62, 65, 30, 32);
		contentPane.add(rasp);
		
		JLabel qtdmoeda = new JLabel("");
		qtdmoeda.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				qtdmoeda.setText(String.valueOf(moedas));
				if(moedas==2100) {
					
					Info.setVisible(true);
					Info.setIcon(new ImageIcon(Pojeto.class.getResource("/infos/Fimdejogo.fw.png")));
					fimdejogo=true;
					try {
						Robot robo = new Robot();
						robo.mouseMove(x, y);
					}catch(AWTException w) {
						w.printStackTrace();
					}
				}
				
			}
		});
		qtdmoeda.setVerticalAlignment(SwingConstants.TOP);
		qtdmoeda.setHorizontalAlignment(SwingConstants.LEFT);
		qtdmoeda.setIcon(new ImageIcon(Pojeto.class.getResource("/imagens/moeda1.fw.png")));
		qtdmoeda.setBounds(10, 11, 780, 558);
		contentPane.add(qtdmoeda);
		
		chao.setBounds(0, 0, 800, 600);
		contentPane.add(chao);
		addMouseMotionListener(this);
		
		//control = new Control();
		//control.addListener(this);
		
	}
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent arg0) {
		System.out.println("X: " + arg0.getX() + " Y:" + arg0.getY()+"  Moedas:"+moedas);
		
		
		
				
		
	}
	public void update(Observable o, Object arg) {
		if(control.isBtnCima()){
			//lblNewLabel_1.setText("Pressionado");
			//lblNewLabel_1.setForeground(Color.GREEN);
			if(
					(x>=0 && x<283 && y==57)||
					(x>338 && x<454 && y==161)||
					(x>478 && x<598 && y==161)|| 
					(x>8 && x<96 && y==149)||
					(x>478 && x<598 && y==161)||
					(x>0 && x<283 && y==465)||
					(x>122 && x<212 && y==149)||
					(x>478 && x<598 && y==161)||
					(x>236 && x<280 && y==149)||
					(x>76 && x<118 && y==263)||
					(x>188 && x<238 && y==263)||
					(x>364 && x<450 && y==285)||
					(x>480 && x<568 && y==285)||
					(x>430 && x<456 && y==349)||
					(x>480 && x<524 && y==349)||
					(x>638 && x<684 && (y==129 || y==313 || y==427 ))||
					(x>684 && x<750 && (y==61||y==221||y==403))||
					(x>423 && x<524 && y==415)||
					(x>526 && x<594 && y==439)||
					(y==1 && x>0 && x<800)||
					(x>20 && x<95 && y==541)||
					(y==131 && x>267 && x<304)
					
			
			
			
			){	//implementação da barreira das paredes
						
				/*Essa parte esta se movendo em relação ao screen, ou seja, pela resolução do quadro
				 * como vams usar 800x600 estou mudando a resolução do notebook para testar, não sei se tem outro meio
				 * porem assim esta funcionando*/
				
				
				
				
				
			}else {
			y-=2;
			if(cima<3) {
				setCursor(c1);
				cima++;	}
				else if(cima<5) {
					setCursor(c2);
					cima++;	}
						else if(cima<7)	{
							setCursor(c3);
							cima++;
				}else if(cima<9)	{
					setCursor(c4);
					cima++;
					}else if(cima<11)	{
						setCursor(c5);
						cima++;
						}else if(cima<13)	{
							setCursor(c6);
							cima=1;
							}
			}
			try {
				Robot robo = new Robot();
				robo.mouseMove(x, y);
			}catch(AWTException w) {
				w.printStackTrace();				//aqui termina a implementação da movimentação
			}
			
		}else{
			
		}
		
		if(control.isBtnEsquerda()){
			//lblNewLabel_2.setText("Pressionado");
			//lblNewLabel_2.setForeground(Color.GREEN);
			if(
					(x==285 && ((y<463 &&  y>205)||(y<143 &&  y>-1)) )||
					(x==171 && ((y<297 &&  y>209)||(y<93 &&  y>51)) )||
					(x==57 && ((y<93 &&  y>51)||(y<301 &&  y>207)) )||
					(x==451 && y<277 && y>191 )||
					(x==455 && y<159 && y>=6 )||						
					(x==529 && y>=0 && y<26)||
					(x==599 && y<159 && y>=0 )||
					(x==571 && y<279 && y>191 )||
					(x==689 && ((y<123 &&  y>55)||(y<165 &&  y>145)||(y<307 &&  y>219)||(y<347 &&  y>327)||(y<423 &&  y>401)||(y<537 &&  y>453)))||
					(x==597 && ((y<433 &&  y>293)||(y<529 &&  y>453)) )||
					(x==459 && y<344 && y>291 )||
					(x==435 && ((y<377 &&  y>334)||(y<466 &&  y>411)))||
					(x==99 && y>91 && y<145)||
					(x==211 && y>91 && y<145)||
					(x==389 && y>=0 && y<55)||
					(x==99 && y>453 && y<536)||
					(x==41 && y>528 && y<600)||
					(x==305 && y>38 && y<129)
																									
						) {
					
				}
				else {
				x-=2;
				
				if(esq<4) {
					setCursor(e1);
					esq++;	}
					else if(esq<7) {
						setCursor(e2);
						esq++;	}
							else if(esq<10)	{
								setCursor(e3);
								esq++;
					}else if(esq<13)	{
						setCursor(e4);
						esq++;
						esq=1;
					}
				
				try {
					Robot robo = new Robot();
					robo.mouseMove(x, y);
				}catch(AWTException w) {
					w.printStackTrace();
				}
				}
			
		}else{
			//lblNewLabel_2.setText("NÃ£o Pressionado");
			//lblNewLabel_2.setForeground(Color.RED);
			
		}
		
		if(control.isBtnBaixo()){
			//lblNewLabel_3.setText("Pressionado");
			//lblNewLabel_3.setForeground(Color.GREEN);
			if((y==295  && x>43 && x<247)||
					   (y==205  && ((x>=0 && x<53)||(x>74 && x<165)||(x>195 && x<279)))||
					   (y==91 && ((x>40 && x<97)||(x>152 && x<207)))||
					   (y==7 && x>0 && x<278)||
					   (y==41 && ((x>374 && x<421)||(x>485 && x<567)))||
					   (y==185 && ((x>363 && x<449)||(x>486 && x<562)))||
					   (y==291 && ((x>387 && x<455)||(x>482 && x<592)))||
					   (y==359  && x>423 && x<543)||
					   (y==451  && x>529 && x<590)||
					   (y==5  && x>641 && x<767)||
					   (y==531  && x>581 && x<654)||
					   (x>639 && x<685 && (y==141 || y==325 || y==439))||
					   (x>667 && x<771 && (y==163 || y==345 || y==531))||
					   (y==35 && x>273 && x<303)||
					   (y==580 && x>0 && x<800)
							
							) {}
					else {
					y+=2;
					
					if(baixo<3) {
						setCursor(cursor1);
						baixo++;	}
						else if(baixo<5) {
							setCursor(cursor2);
							baixo++;	}
								else if(baixo<7)	{
									setCursor(cursor3);
									baixo++;
						}else if(baixo<9)	{
							setCursor(cursor4);
							baixo++;
							baixo=1;
							}
					}
					//fireworks
					
					try {
						Robot robo = new Robot();
						robo.mouseMove(x, y);
					}catch(AWTException w) {
						w.printStackTrace();
					}
		}else{
			//lblNewLabel_4.setText("NÃ£o Pressionado");
			//lblNewLabel_4.setForeground(Color.RED);
			
			
		}
		if(control.isBtnDireita()){
			//lblNewLabel_4.setText("Pressionado");
			//lblNewLabel_4.setForeground(Color.GREEN);
			if(
					(y>53 && y<145 && (x==5||x==119||x==233))||
					(y>256 && y<311 && (x==119||x==233))||
					(x==337 && y>=0 && y<159)||
					(x==359 && y>192 && y<280)||
					(y>209 && y<260 && (x==75||x==187))||
					(x==477 && ((y>=0 && y<28)||(y>192 && y<280)||(y>51 && y<157)||(y>296 && y<345)))||
					(x==545 && y>=0 && y<65)||
					(x==523 && ((y>328 && y<368)||(y>409 && y<434)||(y>457 && y<501)))||
					(x==749 && y>=0 && y<554)||
					(x==637 && ((y>0 && y<126)||(y>148 && y<308)||(y>329 && y<423)||(y>443 && y<537)))	||
					(x==385 && y>296 && y<600)||
					(x==405 && y>2 && y<63)
						
												
						) {}
				else {
				x+=2;
				
				if(dir<4) {
					setCursor(d1);
					dir++;	}
					else if(dir<7) {
						setCursor(d2);
						dir++;	}
							else if(dir<10)	{
								setCursor(d3);
								dir++;
					}else if(dir<13)	{
						setCursor(d4);
						dir++;
						dir=1;
						}
				try {									
					Robot robo = new Robot();
					robo.mouseMove(x, y);
				}catch(AWTException w) {
					w.printStackTrace();
				}
				}
			
		}else{
			
		}
		
		if(control.isBtnA()){
			//lblNewLabel_5.setText("Pressionado");
			//lblNewLabel_5.setForeground(Color.GREEN);
			
			if(entrada==1) {
				Info.setIcon(new ImageIcon(Pojeto.class.getResource("/infos/InfoRasp.png")));
				Info.setVisible(true);
			}else if(entrada==2) {
				Info.setIcon(new ImageIcon(Pojeto.class.getResource("/infos/Info2.png")));
				Info.setVisible(true);
			}else if(entrada==3) {
				Info.setIcon(new ImageIcon(Pojeto.class.getResource("/infos/infojava.fw.png")));
				Info.setVisible(true);
			}else if(entrada==4) {
				Info.setIcon(new ImageIcon(Pojeto.class.getResource("/infos/infomat.fw.png")));
				Info.setVisible(true);
			}else if(entrada==6) {
				Info.setIcon(new ImageIcon(Pojeto.class.getResource("/infos/InfoJogos.fw.png")));
				Info.setVisible(true);
			}else if(entrada==7) {
				Info.setIcon(new ImageIcon(Pojeto.class.getResource("/infos/infocursos.fw.png")));
				Info.setVisible(true);
			}else if(entrada==9) {
				Info.setIcon(new ImageIcon(Pojeto.class.getResource("/infos/infosoc.fw.png")));
				Info.setVisible(true);
			}else if(entrada==10) {
				Info.setIcon(new ImageIcon(Pojeto.class.getResource("/infos/infoconin.fw.png")));
				Info.setVisible(true);
			}
			
			
		}else{
			//lblNewLabel_5.setText("NÃ£o Pressionado");
			//lblNewLabel_5.setForeground(Color.RED);
			
		}
		
		if(control.isBtnB()){
			//lblNewLabel_6.setText("Pressionado");
			//lblNewLabel_6.setForeground(Color.GREEN);
			
			Info.setVisible(false);
			if(fimdejogo) {
				moeda.setVisible(true);
				moeda1.setVisible(true);
				moeda2.setVisible(true);
				moeda3.setVisible(true);
				moeda4.setVisible(true);
				moeda5.setVisible(true);
				moeda6.setVisible(true);
				moeda7.setVisible(true);
				moeda8.setVisible(true);
				moeda9.setVisible(true);
				moeda10.setVisible(true);
				bau.setVisible(true);
				Info.setVisible(false);
				cameraV.setVisible(true);
				x=333;
				y=511;
				moedas=0;
				fimdejogo=false;
			}
		}else{
			//lblNewLabel_6.setText("NÃ£o Pressionado");
			//lblNewLabel_6.setForeground(Color.RED);
			
		}

	}
}

	
