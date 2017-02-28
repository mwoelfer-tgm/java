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

public class SnakeViewStart extends JFrame{
	//Attributes
	private SnakeModel m;
	private SnakeController c;
	private JTextField name;
	private JButton start;
	private JButton options;
	private JButton exit;
	private JButton scores;
	private JButton help;
	private boolean isDisposed;
	
	public SnakeViewStart(SnakeModel m, SnakeController c) {
		//Initialize Model and Controller
		this.m = m;
		this.c = c;
		this.setDisposed(false);
		
		//GUI-Objekte erzeugen
		this.name = new JTextField();
		this.start = new JButton("Spiel Starten!");
		this.options = new JButton("Optionen");
		this.exit = new JButton("Beenden");
		this.scores = new JButton("Rangliste");
		this.help = new JButton("Hilfe");
		
		this.help.addActionListener(this.c);
		this.start.addActionListener(this.c);
		this.options.addActionListener(this.c);
		this.exit.addActionListener(this.c);
		this.scores.addActionListener(this.c);
		
		//Platzaufteilung
		this.setLayout(new GridLayout(6,1));
		this.add(this.name);
		this.add(this.start);
		this.add(this.options);
		this.add(this.scores);
		this.add(this.help);
		this.add(this.exit);
		
		//Fenstergestaltung
		this.setSize(400,400);
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
	public boolean isButtonStart(ActionEvent e){
		if(e.getSource() == this.start) return true;
		return false;
	}
	
	/**
	 * 
	 * @param e the Event that occured
	 * @return true or false 
	 */
	public boolean isButtonOptions(ActionEvent e){
		if(e.getSource() == this.options) return true;
		return false;
	}
	
	/**
	 * 
	 * @param e the Event that occured
	 * @return true or false 
	 */
	public boolean isButtonExit(ActionEvent e){
		if(e.getSource() == this.exit) return true;
		return false;
	}
	
	
	public boolean isButtonScore(ActionEvent e){
		if(e.getSource() == this.scores) return true;
		return false;
	}
	
	public boolean isButtonHelp(ActionEvent e){
		if(e.getSource() == this.help) return true;
		return false;
	}
	
	public String getName(){
		return this.name.getText();
	}

	/**
	 * @return the isDiposed
	 */
	public boolean isDisposed() {
		return isDisposed;
	}

	/**
	 * @param isDiposed the isDiposed to set
	 */
	public void setDisposed(boolean isDiposed) {
		this.isDisposed = isDiposed;
	}
}
