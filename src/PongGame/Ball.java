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
	private static double tetha;
	private static double rad;
	
	static Random rand = new Random();
	Ball(){
		tetha = 270;
		rad = 3*Math.PI/2;
		ballDrawing = new Rectangle2D.Double(CENTRO_X, CENTRO_Y, BALL_WIDTH, BALL_HEIGHT);
		//this.setPreferredSize(new Dimension(BALL_WIDTH, BALL_HEIGHT));
	}
	
	public static void drawBall(Graphics2D g2d) {
			
			colisionsChecking();
			pointChecking();
			ballDrawing.x +=  5*Math.cos(rad);
			ballDrawing.y -=  5*Math.sin(rad);
			

			g2d.setColor(new Color(208, 207, 207));
			g2d.fill(ballDrawing);		
	}
	static void colisionsChecking() {
	//top collision
		if(Player.paddleTopDrawing.intersects(ballDrawing)){ 
			System.out.println("INTERCEPTOU");
			tetha = rand.nextInt(100)+40+180;
			Ball.ballDrawing.y++;
			rad = Math.toRadians(tetha);
		}
		//bottom collision
		if(Player.paddleBottomDrawing.intersects(ballDrawing)){
			tetha = rand.nextInt(100)+40;
			Ball.ballDrawing.y--;
			rad = Math.toRadians(tetha);
		}
		//left wall collision
		if(ballDrawing.intersectsLine(0, 0, 0, Panel.GAME_HEIGHT)){
			tetha = 180 - tetha;
			Ball.ballDrawing.x++;
			rad = Math.toRadians(tetha);
		}
		//right wall collision
		if(ballDrawing.intersectsLine(Panel.GAME_WIDTH - Ball.BALL_WIDTH, 0, Panel.GAME_WIDTH - Ball.BALL_WIDTH, Panel.GAME_HEIGHT)) {
			tetha = 180 - tetha;
			Ball.ballDrawing.x--;
			rad = Math.toRadians(tetha);
		}
	}
	static void pointChecking() {
		if(ballDrawing.y < -20) {  //se o y estiver negativo
			Panel.isRunning = false;
			System.out.println("Ponto do player de baixo");
			Panel.bottomPoints++;
			System.out.println(Panel.bottomPoints);
			Panel.Restart();
		}
		if(ballDrawing.y > Panel.GAME_HEIGHT + Ball.BALL_HEIGHT) {
			Panel.isRunning = false;
			System.out.println("Ponto do player de cima");
			Panel.topPoints++;
			System.out.println(Panel.topPoints);
			Panel.Restart();
		}
	}
}