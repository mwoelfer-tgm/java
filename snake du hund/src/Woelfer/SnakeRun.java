package Woelfer;

public class SnakeRun extends Thread{
	private SnakeController c;
	private SnakeModel m;
	private SnakeView v;
	private int count;
	public SnakeRun(SnakeController c, SnakeModel m, SnakeView v){
		this.c = c;
		this.m = m;
		this.v = v;
		this.count = 0;
	}
	public void run(){
		while(true){
			if(this.m.isStartCount()){
				this.count++;
				if(this.count > 50){
					this.m.setStartCount(false);
					this.m.setSpeed(150);
					this.count = 0;
				}
			}
			if(this.m.getDirection().equals("left")) this.m.moveLeft();
			if(this.m.getDirection().equals("right")) this.m.moveRight();
			if(this.m.getDirection().equals("up")) this.m.moveUp();
			if(this.m.getDirection().equals("down")) this.m.moveDown();
			try {
				Thread.sleep(this.m.getSpeed());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(this.v !=null) if(this.v.isDisposed()) break;
		}
	}
	public void setView(SnakeView v){
		this.v = v;
	}
}
