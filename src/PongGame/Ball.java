package PongGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.*;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.math.*;
import java.util.Random;

public class Ball{
	public static Rectangle2D.Double ballDrawing;
	public static int BALL_WIDTH = 10;
	public static int BALL_HEIGHT = 10;
	public static int CENTRO_X = Panel.GAME_WIDTH/2-BALL_WIDTH/2;
	public static int CENTRO_Y = Panel.GAME_HEIGHT/2-BALL_HEIGHT/2;
	public static double tetha;
	public static double rad;
	static Color ballColor = new Color(208, 207, 207);
	static Random rand = new Random();
	public static double xIncrement;
	public static double yIncrement;
	public static boolean bottomColision;
	public static boolean sideColision;
	public static boolean clear;
	Ball(){
		clear = true;
		bottomColision = false;
		sideColision = false;
		tetha = 270;
		rad = Math.toRadians(tetha);
		ballDrawing = new Rectangle2D.Double(CENTRO_X, CENTRO_Y, BALL_WIDTH, BALL_HEIGHT);
		//this.setPreferredSize(new Dimension(BALL_WIDTH, BALL_HEIGHT));
	}
	
	public static void drawBall(Graphics2D ballG2d) {
			int colornumber = rand.nextInt(190, 200);
			
			AffineTransform resetRotation = ballG2d.getTransform();
			//System.out.println("y = " + Ball.ballDrawing.y);
			ballG2d.rotate(-rad, ballDrawing.x, ballDrawing.y);
			ballG2d.setColor(new Color(colornumber, colornumber, colornumber));   // trail color
			ballG2d.fill(ballDrawing);
			xIncrement = 8*Math.cos(rad);
			//System.out.println(xIncrement);
			yIncrement = 8*Math.sin(rad);
			ballDrawing.x += xIncrement;
			ballDrawing.y -= yIncrement;
			
			colisionsChecking();
			pointChecking();
			
			ballG2d.setTransform(resetRotation);
			ballG2d.rotate(-rad, ballDrawing.x, ballDrawing.y);
			ballG2d.setColor(Panel.randomColor);
			ballG2d.fill(ballDrawing);	
			ballG2d.setTransform(resetRotation);
			
			
			//System.out.println("x = " + Ball.ballDrawing.x);
			
	}
	static void colisionsChecking() {
	//top collision
		if(Player.paddleTopDrawing.intersects(ballDrawing)){ 
			
			tetha = rand.nextInt(100)+40+180;
			//Ball.ballDrawing.y = Player.paddleTopDrawing.y + Player.PADDLE_HEIGHT;
			rad = Math.toRadians(tetha);
			
			xIncrement = 8*Math.cos(rad);
			//System.out.println(xIncrement);
			yIncrement = 8*Math.sin(rad);
			ballDrawing.x += xIncrement;
			ballDrawing.y -= yIncrement;
			bottomColision = false;
			sideColision = false;
			clear = true;
			//System.out.println("x = " + Ball.ballDrawing.x);
			//System.out.println("y = " + Ball.ballDrawing.y);
			
		}
		//bottom collision
		if(Player.paddleBottomDrawing.intersects(ballDrawing)){
			
			//System.out.println("INTERCEPTOU");
			tetha = rand.nextInt(100)+40;

			//Ball.ballDrawing.y = Player.paddleBottomDrawing.y - Ball.BALL_HEIGHT;
			rad = Math.toRadians(tetha);
			xIncrement = 8*Math.cos(rad);
		//	System.out.println(xIncrement);
			yIncrement = 8*Math.sin(rad);
			ballDrawing.x += xIncrement;
			ballDrawing.y -= yIncrement;
			bottomColision = true;
			sideColision = false;
			clear = true;
			//System.out.println("x = " + Ball.ballDrawing.x);
			//System.out.println("y = " + Ball.ballDrawing.y);

		}
		//left wall collision
		if(ballDrawing.intersectsLine(0, 0, 0, Panel.GAME_HEIGHT)){
			tetha = 180 - tetha;
			rad = Math.toRadians(tetha);
			xIncrement = 8*Math.cos(rad);
		//	System.out.println(xIncrement);
			yIncrement = 8*Math.sin(rad);
			ballDrawing.x += xIncrement;
			ballDrawing.y -= yIncrement;
			sideColision = true;
			clear = true;
		}
		//right wall collision
		if(ballDrawing.intersectsLine(Panel.GAME_WIDTH, 0, Panel.GAME_WIDTH, Panel.GAME_HEIGHT)) {
			tetha = 180 - tetha;
			//Ball.ballDrawing.x--;
			rad = Math.toRadians(tetha);
			xIncrement = 8*Math.cos(rad);
			yIncrement = 8*Math.sin(rad);
			ballDrawing.x += xIncrement;
			ballDrawing.y -= yIncrement;
			sideColision = true;
			clear = true;
		}
	}
	static void pointChecking() {
		if(ballDrawing.y < -20) {  //se o y estiver negativo
			Panel.isRunning = false;
			Panel.bottomPoints++;
			clear = true;
			Panel.Restart();
			
		}
		if(ballDrawing.y > Panel.GAME_HEIGHT + Ball.BALL_HEIGHT) {
			Panel.isRunning = false;
			Panel.topPoints++;
			clear = true;
			Panel.Restart();
		}
	}
}