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
	private double tetha;
	private double rad;
	private double xIncrement;
	private double yIncrement;
	private static boolean wasGoingDown;
	private static  boolean rebouncedByWall;
	Random rand = new Random();
	Ball(){
		tetha = 270;
		rad = 3*Math.PI/2;
		xIncrement = 0;
		yIncrement = 0;
		wasGoingDown = true;
		rebouncedByWall = false;
		//this.setPreferredSize(new Dimension(BALL_WIDTH, BALL_HEIGHT));
	}
	
	public void drawBall(Graphics2D g2d) {
			
			xIncrement +=  3* Math.cos(rad);
			yIncrement -=  3*Math.sin(rad);
			ballDrawing = new Rectangle2D.Double(CENTRO_X + xIncrement, CENTRO_Y + yIncrement, BALL_WIDTH, BALL_HEIGHT);

			
			Rectangle2D.Double desenhoDoPlayer1 = (Player.drawPlayer(g2d, 1));
			Rectangle2D.Double desenhoDoPlayer2 = (Player.drawPlayer(g2d, 2));
			
			//top collision
			if(desenhoDoPlayer1.intersects(ballDrawing) && wasGoingDown == false){ 
				tetha = rand.nextInt(100)+40+180;
				rad = Math.toRadians(tetha);
				wasGoingDown = true;
				rebouncedByWall = false;
			}
			//bottom collision
			if(desenhoDoPlayer2.intersects(ballDrawing) && wasGoingDown == true){
				tetha = rand.nextInt(100)+40;
				rad = Math.toRadians(tetha);
				wasGoingDown = false;
				rebouncedByWall = false;
			}
			//left wall collision
			if(ballDrawing.intersectsLine(0, 0, 0, Panel.GAME_HEIGHT) && rebouncedByWall == false){
				rebouncedByWall = true;
				tetha = 180 - tetha;
				rad = Math.toRadians(tetha);
			}
			//right wall collision
			if(ballDrawing.intersectsLine(Panel.GAME_WIDTH - Ball.BALL_WIDTH, 0, Panel.GAME_WIDTH - Ball.BALL_WIDTH, Panel.GAME_HEIGHT) 
					&& rebouncedByWall == false){
				rebouncedByWall = true;
				tetha = 180 - tetha;
				rad = Math.toRadians(tetha);
			}
			
			///////////// PONTOS //////////////////
			if(ballDrawing.y < - Ball.BALL_HEIGHT - 10) {
				System.out.println("Ponto do player de baixo");
				Panel.bottomPoints++;
				System.out.println(Panel.bottomPoints);
				Panel.Restart();
			}
			if(ballDrawing.y > Panel.GAME_HEIGHT + Ball.BALL_HEIGHT) {
				System.out.println("Ponto do player de cima");
				Panel.topPoints++;
				System.out.println(Panel.topPoints);
				Panel.Restart();
			}
			g2d.setColor(new Color(208, 207, 207));
			g2d.fill(ballDrawing);		
	}
}