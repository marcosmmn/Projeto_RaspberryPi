package com.rasp.gpio.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import com.rasp.gpio.Control;

public class MainView extends JFrame implements Observer, ActionListener {

	private JPanel contentPane;
	private Control control;

	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	
	/**
	 * Create the frame.
	 */
	public MainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 493, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("GPIO Tester");

		JButton btnLigardesligar = new JButton("Ligar");
		btnLigardesligar.setBounds(283, 330, 70, 25);
		btnLigardesligar.setActionCommand("ligar");
		btnLigardesligar.addActionListener(this);
		contentPane.add(btnLigardesligar);

		JLabel lblLed = new JLabel("LED:");
		lblLed.setBounds(283, 310, 70, 15);
		contentPane.add(lblLed);

		JLabel lblNewLabel = new JLabel("Botão Cima: ");
		lblNewLabel.setBounds(12, 22, 145, 15);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel1 = new JLabel("Botão Esquerda: ");
		lblNewLabel1.setBounds(12, 42, 132, 15);
		contentPane.add(lblNewLabel1);

		JLabel lblNewLabel2 = new JLabel("Botão Baixo: ");
		lblNewLabel2.setBounds(12, 62, 145, 15);
		contentPane.add(lblNewLabel2);

		JLabel lblNewLabel3 = new JLabel("Botão Direita: ");
		lblNewLabel3.setBounds(12, 82, 145, 15);
		contentPane.add(lblNewLabel3);

		JLabel lblNewLabel5 = new JLabel("Botão A: ");
		lblNewLabel5.setBounds(12, 122, 70, 15);
		contentPane.add(lblNewLabel5);

		JLabel lblNewLabel6 = new JLabel("Botão B: ");
		lblNewLabel6.setBounds(12, 142, 70, 15);
		contentPane.add(lblNewLabel6);

		lblNewLabel_1 = new JLabel("Não Pressionado");
		lblNewLabel_1.setBounds(169, 22, 138, 15);
		lblNewLabel_1.setForeground(Color.RED);
		contentPane.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Não Pressionado");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(169, 42, 138, 15);
		contentPane.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Não Pressionado");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(169, 62, 138, 15);
		contentPane.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("Não Pressionado");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setBounds(169, 82, 138, 15);
		contentPane.add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("Não Pressionado");
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setBounds(169, 122, 132, 15);
		contentPane.add(lblNewLabel_5);

		lblNewLabel_6 = new JLabel("Não Pressionado");
		lblNewLabel_6.setForeground(Color.RED);
		lblNewLabel_6.setBounds(169, 142, 138, 15);
		contentPane.add(lblNewLabel_6);

		JButton btnDesligar = new JButton("Desligar");
		btnDesligar.setBounds(365, 330, 117, 25);
		btnDesligar.addActionListener(this);
		btnDesligar.setActionCommand("desligar");
		contentPane.add(btnDesligar);

		control = new Control();
		control.addListener(this);
	}

	public void update(Observable o, Object arg) {
		if(control.isBtnCima()){
			lblNewLabel_1.setText("Pressionado");
			lblNewLabel_1.setForeground(Color.GREEN);
		}else{
			lblNewLabel_1.setText("Não Pressionado");
			lblNewLabel_1.setForeground(Color.RED);
		}
		
		if(control.isBtnEsquerda()){
			lblNewLabel_2.setText("Pressionado");
			lblNewLabel_2.setForeground(Color.GREEN);
		}else{
			lblNewLabel_2.setText("Não Pressionado");
			lblNewLabel_2.setForeground(Color.RED);
		}
		
		if(control.isBtnBaixo()){
			lblNewLabel_3.setText("Pressionado");
			lblNewLabel_3.setForeground(Color.GREEN);
		}else{
			lblNewLabel_3.setText("Não Pressionado");
			lblNewLabel_3.setForeground(Color.RED);
		}
		
		if(control.isBtnDireita()){
			lblNewLabel_4.setText("Pressionado");
			lblNewLabel_4.setForeground(Color.GREEN);
		}else{
			lblNewLabel_4.setText("Não Pressionado");
			lblNewLabel_4.setForeground(Color.RED);
		}
		
		if(control.isBtnA()){
			lblNewLabel_5.setText("Pressionado");
			lblNewLabel_5.setForeground(Color.GREEN);
		}else{
			lblNewLabel_5.setText("Não Pressionado");
			lblNewLabel_5.setForeground(Color.RED);
		}
		
		if(control.isBtnB()){
			lblNewLabel_6.setText("Pressionado");
			lblNewLabel_6.setForeground(Color.GREEN);
		}else{
			lblNewLabel_6.setText("Não Pressionado");
			lblNewLabel_6.setForeground(Color.RED);
		}

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("ligar"))
			control.stateLed(true);
		else
			control.stateLed(false);
	}
}
