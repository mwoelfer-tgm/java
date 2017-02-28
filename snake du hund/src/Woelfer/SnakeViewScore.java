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
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SnakeViewScore extends JFrame{
	//Attributes
	private SnakeModel m;
	private SnakeController c;
	private JButton back;
	private TreeMap<String,Integer> scores;
	
	
	public SnakeViewScore(SnakeModel m, SnakeController c) {
		//Initialize Model and Controller and scoreMap
		this.m = m;
		this.c = c;
		this.scores = this.m.getHighScores();
		
		//GUI-Objekte erzeugen
		this.back = new JButton("Zurück");

		this.back.addActionListener(this.c);
		
		//Platzaufteilung
		this.setLayout(new GridLayout(scores.size()+1,2));
		//Create a set of the entries
		Set<Map.Entry<String, Integer>> entries = this.scores.entrySet();
		//Create an iterator of the set
		Iterator<Map.Entry<String, Integer>> i1 = entries.iterator();
		while(i1.hasNext()){
			Map.Entry<String, Integer> entry = i1.next();
			this.add(new JLabel(entry.getKey()));
			this.add(new JLabel(""+entry.getValue()));
		}
		this.add(this.back);
		
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
	public boolean isButtonBack(ActionEvent e){
		if(e.getSource() == this.back) return true;
		return false;
	}
}
