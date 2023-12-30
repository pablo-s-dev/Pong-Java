package PongGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Desktop.Action;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.*;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.JComponent;

public class Player{
	public static int PADDLE_WIDTH = 50;
	public static int PADDLE_HEIGHT = 5;
	public static Rectangle2D.Double paddleTopDrawing;
	public static Rectangle2D.Double paddleBottomDrawing;
	public static final int PADDLE_CENTER_X = (Panel.GAME_WIDTH/2 - Player.PADDLE_WIDTH/2);
	static double Xpected;
	static boolean goingPerfect = true;
	static double perfectPositionX;
	static boolean runOnce = true;
	static Random rand = new Random();
	static Color normalPaddleColor = new Color(100, 100, 100);
	static Color CleaningPaddleColor = Panel.backgroundColor;

	Player(){
		paddleTopDrawing = new Rectangle2D.Double(PADDLE_CENTER_X, 20, PADDLE_WIDTH, PADDLE_HEIGHT);
		paddleBottomDrawing = new Rectangle2D.Double(PADDLE_CENTER_X, Panel.GAME_HEIGHT - 50, PADDLE_WIDTH, PADDLE_HEIGHT);

	}
	
	public static void drawPlayers(Graphics2D g2d) {
		if(Ball.bottomColision == true) {
			IA_topPlayer();
		}	
			
		else{ 
			goingPerfect = false;
			runOnce = true;
		}
		g2d.setColor(Player.normalPaddleColor); 
		g2d.fill(paddleTopDrawing);
		g2d.fill(paddleBottomDrawing);
		
	}
	static void IA_topPlayer(){  //only called when ball hits bottom player
		if(runOnce) {  //will run when the ball hits the bottom player
			runOnce = false;
			perfectPositionX = Ball.ballDrawing.x + Ball.xIncrement * ((Ball.ballDrawing.y-20)/Ball.yIncrement) - PADDLE_WIDTH/2;
		}
		if(Ball.sideColision) {  //if the ball hits the wall before hitting the top player, then the perfect position will be updated
			Ball.sideColision = false;
			perfectPositionX = Ball.ballDrawing.x + Ball.xIncrement * ((Ball.ballDrawing.y-20)/Ball.yIncrement) - PADDLE_WIDTH/2;
		}
		if(paddleTopDrawing.x > perfectPositionX) { //only called when ball hits bottom player
			paddleTopDrawing.x -= 4;
		}
		else if(paddleTopDrawing.x < perfectPositionX){ //only called when ball hits bottom player
			paddleTopDrawing.x += 4;
		}
		//not letting the top player go off bounds
		if(paddleTopDrawing.x < 0) { //only called when ball hits bottom player (top player won't move when it's not his turn, so he is never off bounds at this point)
			paddleTopDrawing.x = 0;
		}
		else if(paddleTopDrawing.x + PADDLE_WIDTH > Panel.GAME_WIDTH) { //only called when ball hits bottom player (top player won't move when it's not his turn, so he is never off bounds at this point)
			paddleTopDrawing.x = Panel.GAME_WIDTH - PADDLE_WIDTH;
		}
		
	}
}
