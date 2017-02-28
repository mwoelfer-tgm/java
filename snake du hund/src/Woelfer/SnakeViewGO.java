/*
 * A game of Snake with a Tail and Controls
 * @author Martin Wölfer
 * @version 2015-11-04
 */
package Woelfer;


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class SnakeViewGO extends JFrame{
	//Attributes
	private SnakePanelGO pGO;
	private JButton exit;
	private SnakeController c;
	private SnakeModel m;
	private JLabel highScore;
	private JButton mainMenu;
	private boolean isDisposed;
	
	public SnakeViewGO(SnakeController c, SnakeModel m) {
		this.isDisposed = false;
		//GUI-Objekt erzeugen
		this.exit = new JButton("Exit");
		this.mainMenu = new JButton("Hauptmenü");
		
		this.c = c;
		this.c.setSnakeViewGO(this);
		this.m = m;
		this.pGO = new SnakePanelGO(this.m);
		this.highScore = new JLabel("Highscore: "+this.m.getScore());
		
		this.exit.addActionListener(this.c);
		this.mainMenu.addActionListener(this.c);
		
		
		//Platzaufteilung
		this.setLayout(new BorderLayout());
		this.add(this.pGO, BorderLayout.CENTER);
		this.add(this.exit, BorderLayout.SOUTH);
		this.add(this.highScore, BorderLayout.EAST);
		this.add(this.mainMenu, BorderLayout.NORTH);
		
		//Fenstergestaltung
		this.setSize(400,400);
		this.setTitle("Snake");
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public boolean isButtonExit(ActionEvent e){
		if(e.getSource() == this.exit) return true;
		return false;
	}
	
	public boolean isButtonMainMenu(ActionEvent e){
		if(e.getSource() == this.mainMenu) return true;
		return false;
	}

	/**
	 * @return the isDisposed
	 */
	public boolean isDisposed() {
		return isDisposed;
	}

	/**
	 * @param isDisposed the isDisposed to set
	 */
	public void setDisposed(boolean isDisposed) {
		this.isDisposed = isDisposed;
	}

}
