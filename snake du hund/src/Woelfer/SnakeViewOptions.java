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

public class SnakeViewOptions extends JFrame{
	//Attributes
	private SnakeModel m;
	private SnakeController c;
	
	private JButton back;
	private JButton bTail1;
	private JButton bTail2;
	private JButton bTail3;
	private JButton bTail4;
	private JButton bHead1;
	private JButton bHead2;
	private JButton bHead3;
	private JButton exit;
	
	private JPanel pTail1;
	private JPanel pTail2;
	private JPanel pTail3;
	private JPanel pTail4;
	private JPanel pHead1;
	private JPanel pHead2;
	private JPanel pHead3;
	
	private JPanel pShowCase;
	public SnakeViewOptions(SnakeModel m, SnakeController c) {
		//Initialize Model and Controller
		this.m = m;
		this.c = c;
		
		//GUI-Objekte erzeugen
		this.back = new JButton("Zurück");
		this.bTail1 = new JButton("Auswählen");
		this.bTail2 = new JButton("Auswählen");
		this.bTail3 = new JButton("Auswählen");
		this.bTail4 = new JButton("Auswählen");
		this.bHead1 = new JButton("Auswählen");
		this.bHead2 = new JButton("Auswählen");
		this.bHead3 = new JButton("Auswählen");
		
		this.pTail1 = new pTail1(this.m);
		this.pTail2 = new pTail2(this.m);
		this.pTail3 = new pTail3(this.m);
		this.pTail4 = new pTail4(this.m);
		this.pHead1 = new pHead1(this.m);
		this.pHead2 = new pHead2(this.m);
		this.pHead3 = new pHead3(this.m);
		
		this.pShowCase = new pShowCase(this.m);
		
		this.back.addActionListener(this.c);
		this.bTail1.addActionListener(this.c);
		this.bTail2.addActionListener(this.c);
		this.bTail3.addActionListener(this.c);
		this.bTail4.addActionListener(this.c);
		this.bHead1.addActionListener(this.c);
		this.bHead2.addActionListener(this.c);
		this.bHead3.addActionListener(this.c);
		
		//Platzaufteilung
		this.setLayout(new GridLayout(8,2));
		this.add(this.pTail1);
		this.add(this.bTail1);
		
		this.add(this.pTail2);
		this.add(this.bTail2);
		
		this.add(this.pTail3);
		this.add(this.bTail3);
		
		this.add(this.pTail4);
		this.add(this.bTail4);
		
		this.add(this.pHead1);
		this.add(this.bHead1);
		
		this.add(this.pHead2);
		this.add(this.bHead2);
		
		this.add(this.pHead3);
		this.add(this.bHead3);
		
		this.add(this.back);
		
		this.add(this.pShowCase);
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
	public boolean isButtonTail1(ActionEvent e){
		if(e.getSource() == this.bTail1) return true;
		return false;
	}
	
	/**
	 * 
	 * @param e the Event that occured
	 * @return true or false 
	 */
	public boolean isButtonTail2(ActionEvent e){
		if(e.getSource() == this.bTail2) return true;
		return false;
	}
	
	/**
	 * 
	 * @param e the Event that occured
	 * @return true or false 
	 */
	public boolean isButtonTail3(ActionEvent e){
		if(e.getSource() == this.bTail3) return true;
		return false;
	}
	
	/**
	 * 
	 * @param e the Event that occured
	 * @return true or false 
	 */
	public boolean isButtonTail4(ActionEvent e){
		if(e.getSource() == this.bTail4) return true;
		return false;
	}
	
	/**
	 * 
	 * @param e the Event that occured
	 * @return true or false 
	 */
	public boolean isButtonHead1(ActionEvent e){
		if(e.getSource() == this.bHead1) return true;
		return false;
	}
	
	/**
	 * 
	 * @param e the Event that occured
	 * @return true or false 
	 */
	public boolean isButtonHead2(ActionEvent e){
		if(e.getSource() == this.bHead2) return true;
		return false;
	}
	
	/**
	 * 
	 * @param e the Event that occured
	 * @return true or false 
	 */
	public boolean isButtonHead3(ActionEvent e){
		if(e.getSource() == this.bHead3) return true;
		return false;
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
	
	public void refresh(){
		this.pShowCase.repaint();
		this.repaint();
	}
}
