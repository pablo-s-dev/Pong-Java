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
	

	Player(){
		
	}
	
	public static Rectangle2D.Double drawPlayer(Graphics2D g2d, int id) {
		if(id == 1) {
			Rectangle2D.Double paddleTopDrawing = new Rectangle2D.Double(Panel.paddleTopX, 20, PADDLE_WIDTH, PADDLE_HEIGHT);
			//System.out.println("paddle 1 criado");
			g2d.setColor(new Color(208, 207, 207));
			g2d.fill(paddleTopDrawing);	
			return paddleTopDrawing;
		}
		if(id == 2) {
			Rectangle2D.Double 	paddleBottomDrawing = new Rectangle2D.Double(Panel.paddleBottomX, Panel.GAME_HEIGHT - 60, PADDLE_WIDTH, PADDLE_HEIGHT);
			//System.out.println("paddle 2 criado");
			g2d.setColor(new Color(208, 207, 207));
			g2d.fill(paddleBottomDrawing);		
			return paddleBottomDrawing;
		}
		else{
			return null;
		}
	}
}
