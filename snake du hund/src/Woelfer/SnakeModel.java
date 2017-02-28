/*
 * A game of Snake with a Tail and Controls
 * @author Martin Wölfer
 * @version 2015-11-04
 */

package Woelfer;

//TODO fix bug when starting, that the tail is not correctly moving
import java.awt.Point;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class SnakeModel {
	
	//Attributes
	private SnakeView v;
	private Point head;
	private LinkedList<Point> snakeList;
	private Point food1;
	private Point food2;
	private Point food3;
	private boolean logging;
	private String direction;
	private int score;
	private SnakeController c;
	private String path;
	private String tailPanel;
	private String headPanel;
	private TreeMap<String,Integer> highScores;
	private SnakeViewStart vS;
	private SnakeViewGO vGO;
	private int speed;
	private boolean startCount;

	public SnakeModel(){
		this.setSpeed(150);
		this.highScores = new TreeMap<>();
		this.direction ="";
		this.tailPanel = "tail4";
		this.headPanel = "Head";
		//Request Path
		//this.setPath(requestPath());
		
		readScoreRAF();
		
		this.score = 0;
		//Initialize Head
		this.head = new Point(100,100);
		
		//Initialize LinkedList
		this.snakeList = new LinkedList<>();
//		for(int i = 0; i < 4; i++){
//			//this.snakeList.add(new Point(110+(i*10),110));
//			this.snakeList.add(new Point(110,110));
//		}
		
		//Initialize first food
		Point food1Point = createRandomFoodPoint();
		this.food1 = new Point(food1Point.x, food1Point.y);
		//Initialize second food
		Point food2Point = createRandomFoodPoint();
		this.setFood2(new Point(food2Point.x, food2Point.y));
		//Initialize third food
		Point food3Point = createRandomFoodPoint();
		this.food3 = new Point(food3Point.x, food3Point.y);
		//Initialize logging
		this.logging = false;
	}
	
	/**
	 * 
	 * @return Point
	 */
	public Point getHead(){
		Point out = new Point(this.head);
		return out;
	}
	
	/**
	 * 
	 * @return the snakelist
	 */
	public LinkedList<Point> getList(){
		return this.snakeList;
	}
	
	public Point getFood1(){
		return this.food1;
	}
	
	//Move snake left
	public void moveLeft(){
		this.head.translate(-10, 0);
		snakeTailMove();
		this.v.refresh();
		if(this.logging) this.showLog();
		this.direction = "left";
	}
	
	//Move snake up
	public void moveUp(){
		this.head.translate(0, -10);
		snakeTailMove();
		this.v.refresh();
		if(this.logging) this.showLog();
		this.direction = "up";
	}
	
	//Move snake down
	public void moveDown(){
		this.head.translate(0, 10);
		snakeTailMove();
		this.v.refresh();
		if(this.logging) this.showLog();
		this.direction = "down";
	}
	
	//Move snake right
	public void moveRight(){
		this.head.translate(10, 0);
		snakeTailMove();
		this.v.refresh();
		if(this.logging) this.showLog();
		this.direction = "right";
	}
	
	//Handles the moving of the Tail. It removes the very first element in the tail-list and adds a new one thats directly behind/in the head.
	private void snakeTailMove() {
		if(this.snakeList.size() != 0)this.snakeList.remove(); //removes the first element in the list
		switch(getDirection()){
		case "left": this.snakeList.add(new Point(this.head.x+10, this.head.y));
					 break;
		case "right":this.snakeList.add(new Point(this.head.x-10, this.head.y));
		 		     break;
		case "up":   this.snakeList.add(new Point(this.head.x, this.head.y+10));
					 break;
		case "down": this.snakeList.add(new Point(this.head.x, this.head.y-10));
	     			 break;
	    default:     this.snakeList.add(new Point(this.head.x, this.head.y));
		}
	}
	
	public void showLog(){
		System.out.println("Head: x=" + this.head.getX() +
							   "y=" + this.head.getY());
	}

	/**
	 * @return the logging
	 */
	public boolean getLogging() {
		return logging;
	}

	/**
	 * @param logging the logging to set
	 */
	public void setLogging(boolean logging) {
		this.logging = logging;
	}
	
	public static int createRandom(int og, int ug){
		return (int) ((Math.random() * og-ug+1)+ug);
	}
	
	public String getDirection() {
		return this.direction;
	}
	
	public void setDirection(String direction){
		this.direction = direction;
	}
	
	public boolean checkCollideFood1(){
		if(this.head.getLocation().equals(food1.getLocation())){
			handleCollideFood1();
			return true;
		}
		return false;
	}
	
	public boolean checkCollideFood2(){
		if(this.head.getLocation().equals(food2.getLocation())){
			handleCollideFood2();
			return true;
		}
		return false;
	}
	
	public boolean checkCollideFood3(){
		if(this.head.getLocation().equals(this.food3.getLocation())){
			handleCollideFood3();
			return true;
		}
		return false;
	}
	
	//TODO debuggen
	public boolean checkCollideList(LinkedList<Point> list){
		for(int i = 0; i < list.size(); i++){
			for(int j =0; j < list.size(); j++){
				if(this.head.getLocation().equals(list.get(i).getLocation())&& this.head.getLocation().equals(list.get(j).getLocation())){
					gameOver();
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean checkCollideWall(){
		if((this.head.x <= -10) || (this.head.x >= 370) || (this.head.y >= 350) || (this.head.y <= -10)){
			gameOver();
			return false;
		}
		return true;
	}
	
	public void handleCollideFood1(){
		Point r = createRandomFoodPoint();
		this.food1.setLocation(r.x, r.y);
		switch(getDirection()){
		case "left": this.snakeList.add(new Point(this.head.x+10, this.head.y));
					 break;
		case "right":this.snakeList.add(new Point(this.head.x-10, this.head.y));
		 		     break;
		case "up":   this.snakeList.add(new Point(this.head.x, this.head.y+10));
					 break;
		case "down": this.snakeList.add(new Point(this.head.x, this.head.y-10));
	     			 break;
	    default:     this.snakeList.add(new Point(this.head.x, this.head.y));
		}
		this.score++;
	}
	
	public void handleCollideFood2(){
		Point r = createRandomFoodPoint();
		this.food2.setLocation(r.x,r.y);
		switch(getDirection()){
		case "left": this.snakeList.add(new Point(this.head.x+10, this.head.y));
					 break;
		case "right":this.snakeList.add(new Point(this.head.x-10, this.head.y));
		 		     break;
		case "up":   this.snakeList.add(new Point(this.head.x, this.head.y+10));
					 break;
		case "down": this.snakeList.add(new Point(this.head.x, this.head.y-10));
	     			 break;
	    default:     this.snakeList.add(new Point(this.head.x, this.head.y));
		}
		this.score += 2;
	}
	
	public void handleCollideFood3(){
		Point r = createRandomFoodPoint();
		this.food3.setLocation(r.x,r.y);
		switch(getDirection()){
		case "left": this.snakeList.add(new Point(this.head.x+10, this.head.y));
					 break;
		case "right":this.snakeList.add(new Point(this.head.x-10, this.head.y));
		 		     break;
		case "up":   this.snakeList.add(new Point(this.head.x, this.head.y+10));
					 break;
		case "down": this.snakeList.add(new Point(this.head.x, this.head.y-10));
	     			 break;
	    default:     this.snakeList.add(new Point(this.head.x, this.head.y));
		}
		this.score++;
		this.setSpeed(50);
		this.setStartCount(true);
	}
	
	
	public Point createRandomFoodPoint(){
		int number1 = 0;
		int number2 = 0;
		boolean correct = true;
		for(int i = 0; i < 1; i++){
			correct = true;
			number1 = createRandom(20,15)*10;
			number2 = createRandom(20,15)*10;
			
			if((number1 == this.head.x) && (number2 == this.head.y)){
				i--;
				correct = false;
			}	
		}
		return new Point(number1,number2);
	}
	
	public void setView(SnakeView v){
		this.v = v;
	}

	/**
	 * @return the food2
	 */
	public Point getFood2() {
		return food2;
	}

	/**
	 * @param food2 the food2 to set
	 */
	public void setFood2(Point food2) {
		this.food2 = food2;
	}

	public String getScore() {
		return this.score+"";
	}
	
	public void gameOver(){
		String name = "";
		if(this.vS.getName().equals("")){
			name = "Unbekannt";
		} else{
			name = this.vS.getName();
		}
		this.highScores.put(name, this.score);
		writeScoreRAF();
		this.vGO = new SnakeViewGO(this.c, this);
		this.v.dispose();
		this.v.setDisposed(true);
	}

	public void setController(SnakeController c) {
		// TODO Auto-generated method stub
		this.c = c;
	}
	
	/**
	 * 
	 * @return a String of the path of the dictionary
	 */
	private String requestPath() {
		//Create a boolean variable which loops the request
		boolean loop;
		String eingabe;
		do{
			//Set it to false at the beginning
			loop = false;
			//Request an input
			System.out.println("Geben sie den Pfad an wo sie sich gerade befinden. Zum Beispiel:  C:/Users/USERNAME/OneDrive/Schule/SEW/Workspace/AU05C/src/Woelfer");
			Scanner s = new Scanner(System.in);
			eingabe = s.nextLine();
			
			//Check if the user typed a backslash instead of a slash
			if(eingabe.indexOf('/') == -1){
				//It loops again
				loop = true;
				System.out.println("Statt '\' => '/'");
			}
			
			//Check if the RandomAccesFile throws an exception if we test the path from the user
			//If it throws an error => loop
			try{
				RandomAccessFile f = new RandomAccessFile(eingabe + "test.txt", "rw");
				f.close();
			}catch(Exception e){
				loop = true;
				System.out.println("Pfad nicht gefunden");
			}
		}while(loop);
		return eingabe;
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}
	
	public void setHead(Point p){
		this.head = p;
	}

	public void setTailPanel(String tail) {
		this.tailPanel = tail;
	}
	
	public String getTailPanel(){
		return this.tailPanel;
	}

	/**
	 * @return the headPanel
	 */
	public String getHeadPanel() {
		return headPanel;
	}

	/**
	 * @param headPanel the headPanel to set
	 */
	public void setHeadPanel(String headPanel) {
		this.headPanel = headPanel;
	}
	
	private void readScoreRAF(){
		try{
			RandomAccessFile f = new RandomAccessFile("resource/Highscores.txt", "rw");
			while(true){
				//Create a string of the current line
				String datensatz = f.readLine();
				//Check if it is the last one
				if(datensatz==null) break;
				if(datensatz.equals("")) break;
				String[] datensatzArr = datensatz.split("\t");
				this.highScores.put(datensatzArr[0], Integer.parseInt(datensatzArr[1]));
			}
		} catch(IOException e){
			System.out.println("Error while reading RAF");
		}
	}
	public void writeScoreRAF(){
		try{
			RandomAccessFile f = new RandomAccessFile("resource/Highscores.txt", "rw");
			//Create a set of the entries
			Set<Map.Entry<String, Integer>> entries = this.highScores.entrySet();
			//Create an iterator of the set
			Iterator<Map.Entry<String, Integer>> i1 = entries.iterator();
			while(i1.hasNext()){
				Map.Entry<String, Integer> entry = i1.next();
				f.writeBytes(entry.getKey() + "\t" + entry.getValue() + "\r\n");
			}
			f.close();
		}catch(Exception e){
			System.out.println("Fatal Error while writing");
		}
	}
	
	public void putScore(String name, int score){
		this.highScores.put(name,score);
	}
	
	public void setViewStart(SnakeViewStart vS){
		this.vS = vS;
	}
	
	public TreeMap<String, Integer> getHighScores(){
		return this.highScores;
	}

	/**
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * @return the startCount
	 */
	public boolean isStartCount() {
		return startCount;
	}

	/**
	 * @param startCount the startCount to set
	 */
	public void setStartCount(boolean startCount) {
		this.startCount = startCount;
	}

	public Point getFood3() {
		return this.food3;
	}
}