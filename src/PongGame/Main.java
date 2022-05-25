package PongGame;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JFrame;

public class Main {
	public static Panel panel = new Panel();
	static Thread t1 = new Thread(panel);
	
	
	public static void main(String[] args) {
	
	
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.setLayout(new GridBagLayout());
	frame.add(panel);
	t1.start();
	frame.setSize(Panel.GAME_WIDTH, Panel.GAME_HEIGHT);
	frame.setLocationRelativeTo(null);
	frame.setVisible(true);
	}
	

}
