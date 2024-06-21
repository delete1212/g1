package g1;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainGame extends JFrame {
	
	private Image screenImage;
	private Graphics screenGraphic;
	
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../image/261420-300.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../image/261420-200.png"));
	
	private Image introBackground = new ImageIcon(Main.class.getResource("../image/2109679.jpg")).getImage();
	private JLabel menuBar  = new JLabel(new ImageIcon(Main.class.getResource("../image/menuBar.png")));
	private JButton exitButton = new JButton(exitButtonBasicImage);
	
	
	private int mouseX, mouseY;
	
	public MainGame() {
		setUndecorated(true);
		setTitle("M Game");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0,0,0,0));
		setLayout(null);
		
		Music introMusic = new Music("Pyrite.mp3", true);
		introMusic.start();
		
		exitButton.setBounds(1245, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("Blade.mp3", false);
				buttonEnteredMusic.start();
			}
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("LeadSeal.mp3", false);
				buttonEnteredMusic.start();
				try {
					Thread.sleep(1000);
				}	catch(InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		
		add(exitButton);
		
		menuBar.setBounds(0,0,1280,30);
		menuBar.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent e) {
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menuBar);
		

	}
	
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage,  0 ,  0, null);
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null);
		paintComponents(g);
		this.repaint();
	}
}
