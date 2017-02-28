/*
 * A game of Snake with a Tail and Controls
 * @author Martin Wölfer
 * @version 2015-11-04
 */
package Woelfer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;


import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SnakeView extends JFrame{
	//Attributes
	private SnakeModel m;
	private SnakeController c;
	private SnakePanel p;
	private JLabel score;
	private boolean disposed;
	
	
	public SnakeView(SnakeModel m, SnakeController c) {
		this.disposed = false;
		//Initialize Model and Controller
		this.m = m;
		this.c = c;
		
		//GUI-Objekte erzeugen
		this.p = new SnakePanel(this.m);
		//this.p.setBackground(Color.LIGHT_GRAY);
		this.score = new JLabel("Score: 0");
		
		this.addKeyListener(this.c);
		
		//Platzaufteilung
		this.setLayout(new BorderLayout());
		this.add(this.p, BorderLayout.CENTER);
		this.add(this.score, BorderLayout.NORTH);
		
		//Fenstergestaltung
		this.setSize(400,400);
		this.setTitle("Snake");
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public boolean isDisposed() {
		return disposed;
	}

	public void setDisposed(boolean disposed) {
		this.disposed = disposed;
	}

	
	public void refresh(){
		this.repaint();
		this.requestFocus();
		this.m.checkCollideFood1();
		this.m.checkCollideFood2();
		this.m.checkCollideFood3();
		this.m.checkCollideWall();
		this.m.checkCollideList(this.m.getList());
		this.score.setText("Score: " +  this.m.getScore());
	}
}
