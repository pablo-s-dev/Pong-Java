package PongGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class Panel extends JPanel implements Runnable, KeyListener{
	Player player1 = new Player();
	Player player2 = new Player();
	public static final int GAME_WIDTH = 400;
	public static final int GAME_HEIGHT = 700;
	//public static final int SCALE = 3;
	public static final Dimension GAME_DIMENSION = new Dimension(GAME_WIDTH, GAME_HEIGHT);
	Ball ball = new Ball();
	
	
	Panel(){
		this.addKeyListener(this);
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
		ball.drawBall(g2d);
	}

	@Override
	public void run() {
		double pastTime = System.nanoTime(); //salvando um instante de tempo
		double timePerFrame = 1000000000/60.0; //duracao em nano segundos de cada frame
		//System.out.println("60");
		while(true) {
			double currentTime = System.nanoTime();  //salvando outro instante de tempo
			if((currentTime- pastTime) >= timePerFrame){
				repaint();
				//System.out.println("novo frame");
				pastTime = currentTime;
			}
		}
		
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("PAOZINHO");
		
	}

}
