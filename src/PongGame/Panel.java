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
	public static int paddleBottomX = (Panel.GAME_WIDTH/2 - Player.PADDLE_WIDTH/2);
	public static int paddleTopX = (Panel.GAME_WIDTH/2 - Player.PADDLE_WIDTH/2);
	
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
		
		Action moveTopToLeft = new MoveTopToLeft();
		Action moveTopToRight = new MoveTopToRight();
		Action moveBottomToLeft = new MoveBottomToLeft();
		Action moveBottomToRight = new MoveBottomToRight();
		
		this.getInputMap().put(KeyStroke.getKeyStroke('a'), "moveBottomToLeft");
		this.getActionMap().put("moveBottomToLeft", moveBottomToLeft);
		
		this.getInputMap().put(KeyStroke.getKeyStroke('d'), "moveBottomToRight");
		this.getActionMap().put("moveBottomToRight", moveBottomToRight);
		
		this.getInputMap().put(KeyStroke.getKeyStroke('j'), "moveTopToLeft");
		this.getActionMap().put("moveTopToLeft", moveTopToLeft);
		
		this.getInputMap().put(KeyStroke.getKeyStroke('l'), "moveTopToRight");
		this.getActionMap().put("moveTopToRight", moveTopToRight);
		
		
		 //#######################PLAYER2#############################
		
	
	}
	public class MoveBottomToLeft extends AbstractAction{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(isRunning == true && paddleBottomX > 0)
				paddleBottomX -= 10;
			}
	}
	public class MoveBottomToRight extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			if((isRunning == true && (paddleBottomX + Player.PADDLE_WIDTH) < GAME_WIDTH))
				paddleBottomX += 10;
			
		}
	}
	
	 //#######################PLAYER2##########################
	 
	public class MoveTopToLeft extends AbstractAction{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(isRunning == true && paddleTopX > 0)
			paddleTopX -= 10;
		}
	}
	

	public class MoveTopToRight extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(isRunning == true && paddleTopX + Player.PADDLE_WIDTH < GAME_WIDTH)
			paddleTopX += 10;
		}
	}
	
	
		
	public void paintComponent(Graphics g) { 
		Graphics2D g2d = (Graphics2D) g; 
		g2d.setColor(new Color(40,40,40));
		super.paintComponent(g2d);
		ball.drawBall(g2d);
		
	}
	static void Restart(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ball = new Ball();
		paddleBottomX = (Panel.GAME_WIDTH/2 - Player.PADDLE_WIDTH/2);
		paddleTopX = (Panel.GAME_WIDTH/2 - Player.PADDLE_WIDTH/2);
		Panel.isRunning = true;
	}


	@Override
	public void run() {
		double pastTime = System.nanoTime(); //salvando um instante de tempo
		double timePerFrame = 1000000000/60; //duracao em nano segundos de cada frame
		//System.out.println("60");
		while(true) {
			if(isRunning) {
			double currentTime = System.nanoTime();  //salvando outro instante de tempo
			if((currentTime- pastTime) >= timePerFrame){
				repaint();
				//System.out.println("novo frame");
				pastTime = currentTime;
			}
			}
		}
	}
}