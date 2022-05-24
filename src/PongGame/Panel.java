package PongGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Panel extends JPanel {
	Player player1 = new Player(1);
	Player player2 = new Player(2);
	public static final int GAME_WIDTH = 400;
	public static final int GAME_HEIGHT = 700;
	public static final Dimension GAME_DIMENSION = new Dimension(GAME_WIDTH, GAME_HEIGHT);
	Ball ball = new Ball();
	
	Panel(){
	
		this.setBackground(new Color(40, 40, 40));
		this.setMinimumSize(GAME_DIMENSION);
		this.setPreferredSize(GAME_DIMENSION);
		this.add(player1);
		this.add(player2);
		this.add(ball);
	}
	
	public void paintComponent(Graphics g) { 
		Graphics2D g2d = (Graphics2D) g; 
		g2d.setColor(new Color(40,40,40));
		super.paintComponent(g2d);
		player1.drawPlayer(g2d);
		player2.drawPlayer(g2d);
		ball.drawBall(g2d);
	}

}
