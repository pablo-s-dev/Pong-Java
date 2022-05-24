package PongGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.*;
import javax.swing.JComponent;

public class Player extends JComponent{
	public static int PADDLE_WIDTH = 50;
	public static int PADDLE_HEIGHT = 5;
	Player(){
		
		this.setPreferredSize(Panel.GAME_DIMENSION);
	}
	
	public static Rectangle2D.Double drawPlayer(Graphics2D g2d, int id) {
		if(id == 1) {
			Rectangle2D.Double paddle1Drawing = new Rectangle2D.Double(Panel.GAME_WIDTH/2 - PADDLE_WIDTH/2, 20, PADDLE_WIDTH, PADDLE_HEIGHT);
			//System.out.println("paddle 1 criado");
			g2d.setColor(new Color(208, 207, 207));
			g2d.fill(paddle1Drawing);	
			return paddle1Drawing;
		}
		if(id == 2) {
			Rectangle2D.Double 	paddle2Drawing = new Rectangle2D.Double(Panel.GAME_WIDTH/2 - PADDLE_WIDTH/2, Panel.GAME_HEIGHT - 60, PADDLE_WIDTH, PADDLE_HEIGHT);
			//System.out.println("paddle 2 criado");
			g2d.setColor(new Color(208, 207, 207));
			g2d.fill(paddle2Drawing);		
			return paddle2Drawing;
		}
		else{
			return null;
		}
	}

}
