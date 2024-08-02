package g1;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread{
	
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../image/node.png")).getImage();
	private int x, y = 580 - (1000 / Main.SLEEP_TIME * Main.NOTE_SPEED) * Main.REACH_TIME;
	private String noteType;
	private boolean proceeded = true;
	private static int score;
	
	public String getNoteType() {
		return noteType;
	}
	
	public boolean isproceeded() {
		return proceeded;
	}
	
	public void close() {
		proceeded = false;
	}
	
	public Note(String noteType) {
		if(noteType.equals("S")) {
			x = 228;
		}
		else if(noteType.equals("D")) {
			x = 332;
		}
		else if(noteType.equals("F")) {
			x = 436;
		}
		else if(noteType.equals("Space")) {
			x = 540;
		}
		else if(noteType.equals("J")) {
			x = 744;
		}
		else if(noteType.equals("K")) {
			x = 848;
		}
		else if(noteType.equals("L")) {
			x = 952;
		}
		this.noteType = noteType;
	}
	
	public void screenDraw(Graphics2D g) {
		if(!noteType.equals("Space")) {
			g.drawImage(noteBasicImage, x, y, null);
		}
		else {
			g.drawImage(noteBasicImage, x, y, null);
			g.drawImage(noteBasicImage, x+100, y, null);
		}
	}
	public void drop() {
		y += Main.NOTE_SPEED;
		if(y > 620) {
			System.out.println("Miss");
			close();
		}
	}
	
	
	public void run() {
		try {
			while(true) {
				drop();
				if(proceeded) {
					Thread.sleep(Main.SLEEP_TIME);
				}
				else {
					interrupt();
					break;
				}
			}
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public static void setScore() {
		score = 0;
	}
	public static String getScore() {
		String Sscore = String.valueOf(score);
		return Sscore;
	}
	
	public void judge() {
		if(y >= 613) {
			System.out.println("Late");
			Game.setJudgeImage("Late");
			score += 1;
			close();
		}
		else if(y >= 600) {
			System.out.println("Good");
			Game.setJudgeImage("Good");
			score += 10;
			close();
		}
		else if(y >= 587) {
			System.out.println("Great");
			Game.setJudgeImage("Great");
			score += 30;
			close();
		}
		else if(y >= 573) {
			System.out.println("Perfect");
			Game.setJudgeImage("Perfect");
			score += 50;
			close();
		}
		else if(y >= 565) {
			System.out.println("Great");
			Game.setJudgeImage("Great");
			score += 30;
			close();
		}
		else if(y >= 550) {
			System.out.println("Good");
			Game.setJudgeImage("Good");
			score += 10;
			close();
		}
		else if(y >= 535) {
			System.out.println("Early");
			Game.setJudgeImage("Early");
			score += 1;
			close();
		}
		else {
			System.out.println("Miss");
			Game.setJudgeImage("Miss");
			close();
		}
	}
	
	
}
