package PongGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.*;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class Ball extends JComponent{
	private Rectangle2D.Double ballDrawing;
	public static int BALL_WIDTH = 10;
	public static int BALL_HEIGHT = 10;
	public static int CENTRO_X = Panel.GAME_WIDTH/2-BALL_WIDTH/2;
	public static int CENTRO_Y = Panel.GAME_HEIGHT/2-BALL_HEIGHT/2;
	Ball(){
		this.setPreferredSize(new Dimension(BALL_WIDTH, BALL_HEIGHT));
	}
	
	public void drawBall(Graphics2D g2d) {
			ballDrawing = new Rectangle2D.Double(CENTRO_X, CENTRO_Y, BALL_WIDTH, BALL_WIDTH);

			g2d.setColor(new Color(208, 207, 207));
			g2d.fill(ballDrawing);		
	}
}
