/*
 * A game of Snake with a Tail and Controls
 * @author Martin Wölfer
 * @version 2015-11-04
 */
package Woelfer;

public class SnakeModelTest {

	public static void main(String[] args){
		SnakeModel m = new SnakeModel();
		m.setLogging(true);
		
		m.moveLeft();
		m.moveLeft();
		m.moveLeft();
		m.moveRight();
		m.moveRight();
		m.moveRight();
		m.moveDown();
		m.moveDown();
		m.moveDown();
		m.moveUp();
		m.moveUp();
		m.moveUp();
		
	}
}
