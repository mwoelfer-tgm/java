package Woelfer;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class pTail4 extends JPanel{
	private BufferedImage image;
	private SnakeModel m;
	public pTail4(SnakeModel m){
		this.m = m;
		try {                
			image = ImageIO.read(new File("resource/Woelfer_Snake_tail4_b.png"));
		} catch (IOException e) {
            // handle exception...
        }
	}
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawImage(image, 0, 0, null);
	}
}
