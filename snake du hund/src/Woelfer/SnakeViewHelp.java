/*
 * A game of Snake with a Tail and Controls
 * @author Martin Wölfer
 * @version 2015-11-04
 */
package Woelfer;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;


import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SnakeViewHelp extends JFrame{
	//Attributes
	private SnakeController c;
	private JButton back;
	private JLabel text1;
	private JLabel text2;
	private JLabel text3;
	private JLabel text4;
	private JLabel text5;
	private JLabel text6;
	
	public SnakeViewHelp(SnakeController c) {
		//Initialize Model and Controller
		this.c = c;
		
		//GUI-Objekte erzeugen
		this.back = new JButton("Zurück");
		this.text1 = new JLabel("Die Schlange lässt sich mit den Tasten A,W,S und D bewegen!");
		this.text2 = new JLabel("Die Bananane gibt dir einen Score-Punkt!");
		this.text3 = new JLabel("Die Pizza gibt dir sogar 2 Score-Punkte!!");
		this.text4 = new JLabel("Vorsicht! Bei der Kirsche wirst du für einige Sekunden sehr schnell und bekommst einen Punkt!");
		this.text5 = new JLabel("Wenn du in deinen eigenen Schwanz oder aus dem Territorium fährst, hast du leider verloren");
		this.text6 = new JLabel("Tipp: Bevor du beginnst, gibt deinen Namen in den Textfeld ganz oben ein, um deinen Highscore zu speichern");
		
		this.back.addActionListener(this.c);
		//Platzaufteilung
		this.setLayout(new GridLayout(7,1));
		this.add(this.text1);
		this.add(this.text2);
		this.add(this.text3);
		this.add(this.text4);
		this.add(this.text5);
		this.add(this.text6);
		this.add(this.back);
		
		
		//Fenstergestaltung
		this.setSize(700,400);
		this.setTitle("Start");
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	/**
	 * 
	 * @param e the Event that occured
	 * @return true or false 
	 */
	public boolean isButtonBack(ActionEvent e){
		if(e.getSource() == this.back) return true;
		return false;
	}

}
