package PongGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Action;
import javax.swing.AbstractAction;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;



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
	public static int paddle2x = (Panel.GAME_WIDTH/2 - Player.PADDLE_WIDTH/2);
	public static int paddle1x = (Panel.GAME_WIDTH/2 - Player.PADDLE_WIDTH/2);
	
	JLabel textPoints = new JLabel("Alo");
	Panel(){
		
		this.setBackground(new Color(40, 40, 40));
		this.setLayout(null);
		this.setMinimumSize(GAME_DIMENSION);
		this.setPreferredSize(GAME_DIMENSION);
		textPoints.setSize(20, 100);
		textPoints.setBounds(0, GAME_HEIGHT/2, 200, 100);
		textPoints.setVisible(true);
		//textPoints.setText(topPoints);
		textPoints.setForeground(Color.white);
		this.add(textPoints);
		
		Action leftAction = new LeftAction();
		Action rightAction = new RightAction();
		Action leftAction1 = new LeftAction1();
		Action rightAction1 = new RightAction1();
		
		this.getInputMap().put(KeyStroke.getKeyStroke('a'), "LeftKey");
		this.getActionMap().put("LeftKey", leftAction);
		
		this.getInputMap().put(KeyStroke.getKeyStroke('d'), "RightKey");
		this.getActionMap().put("RightKey", rightAction);
		
	
		 //#######################PLAYER2#############################
		this.getInputMap().put(KeyStroke.getKeyStroke('j'), "LeftKey1");
		this.getActionMap().put("LeftKey1", leftAction1);
		
		this.getInputMap().put(KeyStroke.getKeyStroke('l'), "RightKey1");
		this.getActionMap().put("RightKey1", rightAction1);
	
	}
	public class LeftAction extends AbstractAction{
		@Override
		public void actionPerformed(ActionEvent e) {
			paddle2x -= 10;
			//System.out.println(paddle2x);
			//System.out.println("esquerda");
			
			if(paddle2x < 0) 
				paddle2x = 0;
		}
	}
	public class RightAction extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			paddle2x += 10;
			//System.out.println(paddle2x);
			//System.out.println("direita");
			if(paddle2x > 335) 
				paddle2x = 335;
		}
	}
	
	 //#######################PLAYER2##########################
	 
	public class LeftAction1 extends AbstractAction{
		@Override
		public void actionPerformed(ActionEvent e) {
			paddle1x -= 10;
			//System.out.println(paddle1x);
			//System.out.println("esquerda");
			if(paddle1x < 0) 
				paddle1x = 0;
		}
	}
	

	public class RightAction1 extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			paddle1x += 10;
			//System.out.println(paddle1x);
			//System.out.println("direita");
			if(paddle1x > 335) 
				paddle1x = 335;
		}
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
		double timePerFrame = 1000000000/60; //duracao em nano segundos de cada frame
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
		paddle2x = (Panel.GAME_WIDTH/2 - Player.PADDLE_WIDTH/2);
		paddle1x = (Panel.GAME_WIDTH/2 - Player.PADDLE_WIDTH/2);
		ball = new Ball();
	}

}
