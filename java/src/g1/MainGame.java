package g1;

import javax.swing.JFrame;

public class MainGame extends JFrame {
	
	public MainGame() {
		setTitle("Battle Game");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
