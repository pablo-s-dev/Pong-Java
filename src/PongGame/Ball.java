package PongGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.*;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.math.*;
import java.util.Random;

public class Ball extends JComponent{
	public Rectangle2D.Double ballDrawing;
	public static int BALL_WIDTH = 10;
	public static int BALL_HEIGHT = 10;
	public static int CENTRO_X = Panel.GAME_WIDTH/2-BALL_WIDTH/2;
	public static int CENTRO_Y = Panel.GAME_HEIGHT/2-BALL_HEIGHT/2;
	private int tetha = (int) Math.toRadians(270);
	private double xIncrement;
	private double yIncrement;
	Random rand = new Random();
	Ball(){
		this.setPreferredSize(new Dimension(BALL_WIDTH, BALL_HEIGHT));
	}
	
	public void drawBall(Graphics2D g2d) {
			xIncrement = Math.cos(tetha);
			yIncrement = Math.sin(tetha);
			ballDrawing = new Rectangle2D.Double(CENTRO_X + xIncrement, CENTRO_Y + yIncrement, BALL_WIDTH, BALL_WIDTH);
		
			if(ballDrawing.contains((Player.drawPlayer(g2d, 1)))){
				tetha = rand.nextInt(120)+30;
			}
			if(ballDrawing.contains((Player.drawPlayer(g2d, 2)))){
				tetha = rand.nextInt(120)+30+180;
			}
			
			

			g2d.setColor(new Color(208, 207, 207));
			g2d.fill(ballDrawing);		
	}
}
