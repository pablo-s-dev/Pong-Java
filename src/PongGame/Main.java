package PongGame;
import java.awt.GridBagLayout;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

public class Main {
	public static Panel panel = new Panel();
	static Thread t1 = new Thread(panel);

	public static void main(String[] args) {
		
	JFrame frame = new JFrame("Pong");
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.setLayout(new GridBagLayout());
	frame.add(panel);
	t1.start();
	frame.setResizable(false);
	frame.setSize(Panel.GAME_WIDTH, Panel.GAME_HEIGHT);
	frame.setLocationRelativeTo(null);
	frame.setAlwaysOnTop(true);
	frame.pack();
	frame.setVisible(true);
	
	

	}
	
	

}
