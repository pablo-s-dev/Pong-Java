package PongGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Panel extends JPanel implements Runnable{
	Player player1 = new Player();
	Player player2 = new Player();
	public static final int GAME_WIDTH = 400;
	public static final int GAME_HEIGHT = 700;
	public static final Dimension GAME_DIMENSION = new Dimension(GAME_WIDTH, GAME_HEIGHT);
	Ball ball = new Ball();
	Thread t1 = new Thread();
	
	Panel(){
	
		this.setBackground(new Color(40, 40, 40));
		this.setMinimumSize(GAME_DIMENSION);
		this.setPreferredSize(GAME_DIMENSION);
		this.add(player1);
		this.add(player2);
		this.add(ball);
		t1.start();
	}
	
	public void paintComponent(Graphics g) { 
		Graphics2D g2d = (Graphics2D) g; 
		g2d.setColor(new Color(40,40,40));
		super.paintComponent(g2d);
		ball.drawBall(g2d);
	}

	@Override
	public void run() {
		double pastTime = System.nanoTime();
		double timePerFrame = 1000000000/60.0;
		System.out.println("60");
		while(true) {
			double currentTime = System.nanoTime();
			if((currentTime- pastTime) / timePerFrame >= 1.0){
				repaint();
				System.out.println("60");
			}
		}
		
		
		
	}

}
