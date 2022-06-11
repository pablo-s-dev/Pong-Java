package PongGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.Random;

import javax.swing.Action;
import javax.swing.AbstractAction;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;



public class Panel extends JPanel implements Runnable{
	static Player player;
	public static final int GAME_WIDTH = 400;
	public static final int GAME_HEIGHT = 700;
	//public static final int SCALE = 3;
	public static final Dimension GAME_DIMENSION = new Dimension(GAME_WIDTH, GAME_HEIGHT);
	static Ball ball;
	public static boolean isRunning = true;
	public static int bottomPoints;
	public static int topPoints;
	static int i =0;
	static boolean moveBottomToLeft;
	static boolean moveBottomToRight;
	static Color backgroundColor = new Color(40,40,40);
	Random rand = new Random();
	public static Color randomColor;
	static JLabel textPoints = new JLabel();
	static Rectangle rect = new Rectangle(0, 0, 400, 25);
	static Rectangle rect2 = new Rectangle(0, 640, 400, 200);
	static Rectangle background = new Rectangle(0, 0, 400, 700);
	static boolean justStarted = true;
	Panel(){
		randomColor = new Color(rand.nextInt(0, 255), rand.nextInt(0, 255), rand.nextInt(0, 255));
		ball = new Ball();
		player = new Player();
		
		String s = "<html>0 <br> 0</html>";
		textPoints.setText(s);
		textPoints.setBounds(0, GAME_HEIGHT/2-50, 10, 50);
		textPoints.setFont(new Font("Comic Sans MS", Font.ITALIC, 12));
		textPoints.setVisible(true);
		textPoints.setForeground(Color.black);
		this.add(textPoints);
		
		this.setLayout(null);
		this.setMinimumSize(GAME_DIMENSION);
		this.setPreferredSize(GAME_DIMENSION);

		
		
		MoveBottomToLeft holdingA = new MoveBottomToLeft(true);
		MoveBottomToLeft realeasingA = new MoveBottomToLeft(false);
		
		MoveBottomToRight holdingD = new MoveBottomToRight(true);
		MoveBottomToRight realeasingD = new MoveBottomToRight(false);
		
		this.getInputMap().put(KeyStroke.getKeyStroke("pressed A"), "moveBottomToLeft");
		this.getActionMap().put("moveBottomToLeft",  holdingA);
		
		this.getInputMap().put(KeyStroke.getKeyStroke("pressed D"), "moveBottomToRight");
		this.getActionMap().put("moveBottomToRight", holdingD);
		
		/*
		this.getInputMap().put(KeyStroke.getKeyStroke("pressed J"), "moveTopToLeft");
		this.getActionMap().put("moveTopToLeft", moveTopToLeft);
		
		this.getInputMap().put(KeyStroke.getKeyStroke("pressed K"), "moveTopToRight");
		this.getActionMap().put("moveTopToRight", moveTopToRight);
		*/
		
		
		//releasing 
		this.getInputMap().put(KeyStroke.getKeyStroke("released A"), "stoppingBottomLeft");
		this.getActionMap().put("stoppingBottomLeft", realeasingA);
		
		this.getInputMap().put(KeyStroke.getKeyStroke("released D"), "stoppingBottomRight");
		this.getActionMap().put("stoppingBottomRight", realeasingD);
		
		
		/*
		this.getInputMap().put(KeyStroke.getKeyStroke("released J"), "moveTopToLeft");
		this.getActionMap().put("moveTopToLeft", moveTopToLeft);
		
		this.getInputMap().put(KeyStroke.getKeyStroke("released K"), "moveTopToRight");
		this.getActionMap().put("moveTopToRight", moveTopToRight);
		*/
	
	}
	public class MoveBottomToLeft extends AbstractAction{
		private boolean holding;
		MoveBottomToLeft(boolean holding){
			this.holding = holding;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(holding == true) 
				moveBottomToLeft = true;
			else
			moveBottomToLeft = false;

		}
	}
	public class MoveBottomToRight extends AbstractAction{
		private boolean holding;
		MoveBottomToRight(boolean holding){
			this.holding = holding;
			
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			//System.out.println(holding);
			if(holding == true) 
					moveBottomToRight = true;
			else
				moveBottomToRight = false;

		}
	}
	
	 /*
	public class MoveTopToLeft extends AbstractAction{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(isRunning == true && Player.paddleTopDrawing.x > 0)
			Player.paddleTopDrawing.x -= 10;
		}
	}
	

	public class MoveTopToRight extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(isRunning == true && Player.paddleTopDrawing.x + Player.PADDLE_WIDTH < GAME_WIDTH)
			Player.paddleTopDrawing.x += 10;
		}
	}
	*/
	
		
	public void paintComponent(Graphics g) { 
		Graphics2D g2d = (Graphics2D) g; 
		Graphics2D ballG2d = (Graphics2D) g; 
		
	//	System.out.println("frame " + ++i);
		if(i==5) {
			//System.out.println("\t\tANDOU 1 PIXEL AQUI????");
		}
		if((moveBottomToRight == true) && isRunning == true) {
			if(Player.paddleBottomDrawing.x + Player.PADDLE_WIDTH + 5 > GAME_WIDTH)
				Player.paddleBottomDrawing.x += Player.paddleBottomDrawing.x + Player.PADDLE_WIDTH - GAME_WIDTH;
			else
			Player.paddleBottomDrawing.x += 5;
		}
		if((moveBottomToLeft == true) && isRunning == true){
			if(Player.paddleBottomDrawing.x - 5 < 0)
				Player.paddleBottomDrawing.x -= Player.paddleBottomDrawing.x;
			else
			Player.paddleBottomDrawing.x -= 5;
		}
		
		//this.setBackground(backgroundColor);
		//g2d.setColor(backgroundColor);
		//super.paintComponent(g2d);
		g2d.setColor(backgroundColor);
		super.paintComponent(g2d);
		
		Player.drawPlayers(g2d);
		Ball.drawBall(ballG2d);
	}
	static void Restart(){
		Ball.clear = true;
		String s = "<html>";
		s+= topPoints;
		s+= "<br>";
		s+= bottomPoints;
		s+= "</html>";
		textPoints.setText(s);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Panel.isRunning = true;
		player = new Player();
		ball = new Ball();
		justStarted = true;
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
				pastTime = currentTime;
				randomColor = new Color(rand.nextInt(0, 255), rand.nextInt(0, 255), rand.nextInt(0, 255));
				repaint();
				
			}
			}
		}
	}

}