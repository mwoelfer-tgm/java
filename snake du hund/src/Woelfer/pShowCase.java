package Woelfer;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class pShowCase extends JPanel{
	private BufferedImage snakeHead;
	private BufferedImage snakeTail;
	private SnakeModel m;
	public pShowCase(SnakeModel m){
		this.m = m;
		try {                
			this.snakeHead = ImageIO.read(new File("resource/Woelfer_Snake_"+this.m.getHeadPanel()+"_r.png"));
			this.snakeTail = ImageIO.read(new File("resource/Woelfer_Snake_"+this.m.getTailPanel()+".png"));
		} catch (IOException e) {
            // handle exception...
        }
	}
	
	@Override
	protected void paintComponent(Graphics g){
		try {                
			this.snakeHead = ImageIO.read(new File("resource/Woelfer_Snake_"+this.m.getHeadPanel()+"_r.png"));
			this.snakeTail = ImageIO.read(new File("resource/Woelfer_Snake_"+this.m.getTailPanel()+".png"));
		} catch (IOException e) {
            // handle exception...
        }
		super.paintComponent(g);
		
		g.drawImage(this.snakeTail, 0+50, 25, null);
		g.drawImage(this.snakeTail, 10+50, 25, null);
		g.drawImage(this.snakeTail, 20+50, 25, null);
		g.drawImage(this.snakeTail, 30+50, 25, null);
		g.drawImage(this.snakeTail, 40+50, 25, null);
		g.drawImage(this.snakeTail, 50+50, 25, null);
		g.drawImage(this.snakeTail, 60+50, 25, null);
		g.drawImage(this.snakeTail, 70+50, 25, null);
		g.drawImage(this.snakeTail, 80+50, 25, null);
		g.drawImage(this.snakeTail, 90+50, 25, null);
		g.drawImage(this.snakeHead, 100+50, 25, null);
	}
}
