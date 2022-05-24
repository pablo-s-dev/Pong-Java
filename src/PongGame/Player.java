package PongGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.*;
import javax.swing.JComponent;

public class Player extends JComponent{
	private int id = 0;
	private Rectangle2D.Double paddle1;
	private Rectangle2D.Double paddle2;
	public static int PADDLE_WIDTH = 50;
	public static int PADDLE_HEIGHT = 5;
	Player(int id){
		this.id = id;
		this.setPreferredSize(new Dimension(PADDLE_WIDTH, PADDLE_HEIGHT));
		if(id == 1) {
		}
		if(id == 2) {
		}
		this.repaint();
	}
	
	public void drawPlayer(Graphics2D g2d) {
		if(id == 1) {
			paddle1 = new Rectangle2D.Double(Panel.GAME_WIDTH/2 - PADDLE_WIDTH/2, Panel.GAME_HEIGHT - 60, PADDLE_WIDTH, PADDLE_HEIGHT);

			g2d.setColor(new Color(208, 207, 207));
			g2d.fill(paddle1);		
		}
		if(id == 2) {
			paddle2 = new Rectangle2D.Double(Panel.GAME_WIDTH/2 - PADDLE_WIDTH/2, 20, PADDLE_WIDTH, PADDLE_HEIGHT);

			g2d.setColor(new Color(208, 207, 207));
			g2d.fill(paddle2);		
		}
	}
}
