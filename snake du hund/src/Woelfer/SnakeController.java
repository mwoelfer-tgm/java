/*
 * A game of Snake with a Tail and Controls
 * @author Martin Wölfer
 * @version 2015-11-04
 */
package Woelfer;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class SnakeController implements ActionListener, KeyListener{
	//Attributes
	private SnakeModel m;
	private SnakeView v;
	private SnakeViewStart vS;
	private SnakeViewGO vGO;
	private SnakeControllerTest cT;
	private SnakeRun sr;
	private SnakeViewOptions vO;
	private SnakeViewScore sVS;
	private SnakeViewHelp vH;
	
	public SnakeController(){
		
		//Initialize Model, View and set logging to true
		
		this.m = new SnakeModel();
		this.vS = new SnakeViewStart(this.m, this);
		this.m.setViewStart(this.vS);
		this.m.setController(this);
		//this.m.setLogging(true);
		if(this.v !=null)this.v.requestFocus();
		this.sr = new SnakeRun(this, this.m, this.v);
		this.sr.start();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.vS.isButtonStart(e)){
			this.vS.dispose();
			this.vS.setDisposed(true);
			this.m.setHead(new Point(100,100));
			this.v = new SnakeView(this.m,this);
			this.m.setView(this.v);
			this.sr.setView(this.v);
		}
		
		if(this.vS.isButtonHelp(e)){
			this.vH = new SnakeViewHelp(this);
			this.vS.dispose();
		}
		if(this.vS.isButtonExit(e)) System.exit(0);
		if(this.vS.isButtonOptions(e)){
			this.vO = new SnakeViewOptions(this.m, this);
			this.vS.dispose();
			this.vS.setDisposed(true);
		}
		if(this.vS != null) if(this.vS.isButtonScore(e)){
			this.sVS = new SnakeViewScore(this.m,this);
			this.vS.dispose();
			this.vS.setDisposed(true);
		}
		
		if(this.vGO != null && this.vGO.isButtonExit(e)) System.exit(0);
		
		//TODO try to make it work
		if(this.vGO != null && this.vGO.isButtonMainMenu(e)) {
			this.vGO.dispose();
			this.m.setHead(new Point(100,100));
			new SnakeController();
			this.vGO.setDisposed(true);
		}
		
		if(this.vO != null) if(this.vO.isButtonBack(e)){
			this.vS = new SnakeViewStart(this.m,this);
			this.vO.dispose();
		}
		
		if(this.vO != null) if(this.vO.isButtonTail1(e)){
			this.m.setTailPanel("tail");
			this.vO.refresh();
		}
		if(this.vO != null) if(this.vO.isButtonTail2(e)){
			this.m.setTailPanel("tail2");
			this.vO.refresh();
		}
		if(this.vO != null) if(this.vO.isButtonTail3(e)){ 
			this.m.setTailPanel("tail3");
			this.vO.refresh();
		}
		if(this.vO != null) if(this.vO.isButtonTail4(e)){ 
			this.m.setTailPanel("tail4");
			this.vO.refresh();
		}
		if(this.vO != null) if(this.vO.isButtonHead1(e)){ 
			this.m.setHeadPanel("Head");
			this.vO.refresh();
		}
		if(this.vO != null) if(this.vO.isButtonHead2(e)){
			this.m.setHeadPanel("Head2");
			this.vO.refresh();
		}
		if(this.vO != null) if(this.vO.isButtonHead3(e)){ 
			this.m.setHeadPanel("Head3");
			this.vO.refresh();
		}
		if(this.v != null) this.v.refresh(); //Calls repaint in the View
	
		if(this.sVS!= null) if(this.sVS.isButtonBack(e)){
			this.vS = new SnakeViewStart(this.m,this);
			this.sVS.dispose();
		}
		
		if(this.vH != null) if(this.vH.isButtonBack(e)){
			this.vS = new SnakeViewStart(this.m,this);
			this.vH.dispose();
		}
	}


	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 65 && this.m.getDirection() != "right") {
			this.m.setDirection("left");
		}
		if (e.getKeyCode() == 87 && this.m.getDirection() != "down") {
			this.m.setDirection("up");
		}
		if (e.getKeyCode() == 68 && this.m.getDirection() != "left") {
			this.m.setDirection("right");
		}
		if (e.getKeyCode() == 83 && this.m.getDirection() != "up") {
			this.m.setDirection("down");
		}
		this.v.refresh();
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void setSnakeViewGO(SnakeViewGO vGO){
		this.vGO = vGO;
	}
}
