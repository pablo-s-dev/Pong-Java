package PongGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Desktop.Action;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.*;

import javax.swing.AbstractAction;
import javax.swing.JComponent;

public class Player{
	public static int PADDLE_WIDTH = 50;
	public static int PADDLE_HEIGHT = 5;
	public static Rectangle2D.Double paddleTopDrawing;
	public static Rectangle2D.Double paddleBottomDrawing;
	public static final int PADDLE_CENTER_X = (Panel.GAME_WIDTH/2 - Player.PADDLE_WIDTH/2);

	Player(){
		paddleTopDrawing = new Rectangle2D.Double(PADDLE_CENTER_X, 20, PADDLE_WIDTH, PADDLE_HEIGHT);
		paddleBottomDrawing = new Rectangle2D.Double(PADDLE_CENTER_X, Panel.GAME_HEIGHT - 60, PADDLE_WIDTH, PADDLE_HEIGHT);

	}
	
	public static void drawPlayers(Graphics2D g2d) {
		g2d.setColor(new Color(208, 207, 207));
		g2d.fill(paddleTopDrawing);
		g2d.fill(paddleBottomDrawing);
	}
}
