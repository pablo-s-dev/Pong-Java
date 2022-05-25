package PongGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel extends JPanel implements Runnable{
	static Player player1 = new Player();
	static Player player2 = new Player();
	public static final int GAME_WIDTH = 400;
	public static final int GAME_HEIGHT = 700;
	//public static final int SCALE = 3;
	public static final Dimension GAME_DIMENSION = new Dimension(GAME_WIDTH, GAME_HEIGHT);
	static Ball ball = new Ball();
	public static boolean isRunning = true;
	public static int bottomPoints;
	public static int topPoints;
	JLabel textPoints = new JLabel("Alo");
	Panel(){
		
		this.setBackground(new Color(40, 40, 40));
		this.setLayout(null);
		this.setMinimumSize(GAME_DIMENSION);
		this.setPreferredSize(GAME_DIMENSION);
		this.add(player1);
		this.add(player2);
		this.add(ball);
		textPoints.setSize(20, 100);
		textPoints.setBounds(0, GAME_HEIGHT/2, 200, 100);
		textPoints.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		textPoints.setAlignmentY(JLabel.CENTER_ALIGNMENT);
		textPoints.setVisible(true);
		textPoints.setText("ALO");
		textPoints.setForeground(Color.white);
		this.add(textPoints);
		
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
		double timePerFrame = 1000000000/100; //duracao em nano segundos de cada frame
		//System.out.println("60");
		while(Panel.isRunning) {
			double currentTime = System.nanoTime();  //salvando outro instante de tempo
			if((currentTime- pastTime) >= timePerFrame){
				repaint();
				//System.out.println("novo frame");
				pastTime = currentTime;
				
			}
		}
		
		
		
	}
	static void Restart(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ball = new Ball();
	}

}
