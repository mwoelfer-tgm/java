/*
 * A game of Snake with a Tail and Controls
 * @author Martin Wölfer
 * @version 2015-11-04
 */
package Woelfer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class SnakePanel extends JPanel{
	//Attributes
	private SnakeModel m;
	private LinkedList<Point> list;
	private Point food1;
	private Point food2;
	private Point food3;
	private BufferedImage snakeHead_l;
	private BufferedImage snakeHead_r;
	private BufferedImage snakeHead_u;
	private BufferedImage snakeHead_d;
	private BufferedImage snakeTail;
	private BufferedImage picFood1;
	private BufferedImage picFood2;
	private BufferedImage picFood3;
	
	public SnakePanel(SnakeModel m){
		//Initialize model and list
		this.m = m;
		this.list = this.m.getList();
		
		this.food1 = this.m.getFood1();
		this.food2 = this.m.getFood2();
		this.food3 = this.m.getFood3();
		try {                
			this.snakeHead_r = ImageIO.read(new File("resource/Woelfer_Snake_"+this.m.getHeadPanel()+"_r.png"));
			this.snakeHead_l = ImageIO.read(new File("resource/Woelfer_Snake_"+this.m.getHeadPanel()+"_l.png"));
			this.snakeHead_u = ImageIO.read(new File("resource/Woelfer_Snake_"+this.m.getHeadPanel()+"_u.png"));
			this.snakeHead_d = ImageIO.read(new File("resource/Woelfer_Snake_"+this.m.getHeadPanel()+"_d.png"));
			this.snakeTail = ImageIO.read(new File("resource/Woelfer_Snake_"+this.m.getTailPanel()+".png"));
			this.picFood1 = ImageIO.read(new File("resource/Woelfer_Snake_food1.png"));
			this.picFood2 = ImageIO.read(new File("resource/Woelfer_Snake_food2.png"));
			this.picFood3 = ImageIO.read(new File("resource/Woelfer_Snake_food3.png"));
		} catch (IOException e) {
            System.out.println("Fatal Error while reading files");
		}
	}
	@Override
	/*
	 * In PaintComponent the tail and the head are getting drawn.
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		ListIterator<Point> ti = this.list.listIterator();
		
		//Drawing the tail
		while(ti.hasNext()){
			Point currPoint = (Point)ti.next(); //Create a Point of the current element in the LinkedList
			g.drawImage(this.snakeTail, currPoint.x, currPoint.y, null);
		}
		//Drawing the head
		switch(this.m.getDirection()){
		case "left": g.drawImage(this.snakeHead_l,this.m.getHead().x,this.m.getHead().y,null);
					 break;
		case "right":g.drawImage(this.snakeHead_r,this.m.getHead().x,this.m.getHead().y,null);
		 		     break;
		case "up":   g.drawImage(this.snakeHead_u,this.m.getHead().x,this.m.getHead().y,null);
					 break;
		case "down": g.drawImage(this.snakeHead_d,this.m.getHead().x,this.m.getHead().y,null);
	     			 break;
	    default:     g.drawImage(this.snakeHead_l,this.m.getHead().x,this.m.getHead().y,null);
		}
		//Drawing the first food
		g.drawImage(this.picFood1,this.food1.x, this.food1.y,null);
		
		//Drawing the second food
		g.drawImage(this.picFood2,this.food2.x, this.food2.y,null);
		
		//Drawing the third food
		g.drawImage(this.picFood3, this.food3.x, this.food3.y, null);
	}
}