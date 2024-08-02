package g1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread{
	
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../image/gameInfo.png")).getImage();
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../image/judgementLine.png")).getImage();
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../image/noteRouteLine.png")).getImage();

	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();
	private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();
	private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();
	private Image blueFlareImage = new ImageIcon(Main.class.getResource("../image/blueflare.png")).getImage();
	private static Image JudgeImage = new ImageIcon(Main.class.getResource("../image/Early.png")).getImage();
	
	
	private String titleName;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;
	
	ArrayList<Note> noteList = new ArrayList<Note>();
	
	public Game(String titleName, String difficulty, String musicTitle) {
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false);
		
	}
	
	public void screenDraw(Graphics2D g) {
		g.drawImage(noteRouteSImage, 228, 30, null);
		g.drawImage(noteRouteDImage, 332, 30, null);
		g.drawImage(noteRouteFImage, 436, 30, null);
		g.drawImage(noteRouteSpace1Image, 540, 30, null);
		g.drawImage(noteRouteSpace2Image, 640, 30, null);
		g.drawImage(noteRouteJImage, 744, 30, null);
		g.drawImage(noteRouteKImage, 848, 30, null);
		g.drawImage(noteRouteLImage, 952, 30, null);
		g.drawImage(noteRouteLineImage, 224, 30, null);
		g.drawImage(noteRouteLineImage, 328, 30, null);
		g.drawImage(noteRouteLineImage, 432, 30, null);
		g.drawImage(noteRouteLineImage, 536, 30, null);
		g.drawImage(noteRouteLineImage, 740, 30, null);
		g.drawImage(noteRouteLineImage, 844, 30, null);
		g.drawImage(noteRouteLineImage, 948, 30, null);
		g.drawImage(noteRouteLineImage, 1052, 30, null);
		g.drawImage(gameInfoImage, 0, 660, null);
		g.drawImage(judgementLineImage, 0, 580, null);
		for(int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if(!note.isproceeded()) {
				noteList.remove(i);
				i--;
			}
			note.screenDraw(g);
		}
		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(titleName, 20, 702);
		g.drawString(difficulty, 1190, 702);
		g.setFont(new Font("Arial", Font.PLAIN, 26));
		g.setColor(Color.DARK_GRAY);
		g.drawString("S", 270, 609);
		g.drawString("D", 374, 609);
		g.drawString("F", 478, 609);
		g.drawString("Space Bar", 580, 609);
		g.drawString("J", 784, 609);
		g.drawString("K", 889, 609);
		g.drawString("L", 993, 609);
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font("Elephant", Font.BOLD, 30));
		g.drawString(Note.getScore(), 565, 702);
		g.drawImage(blueFlareImage, 320, 430, null);
		g.drawImage(JudgeImage, 460, 420, null);
	}
	
	public static void setJudgeImage(String s) {
		JudgeImage =  new ImageIcon(Main.class.getResource("../image/"+s+".png")).getImage();
	}
	
		public void PressS() {
			judge("S");
			noteRouteSImage = new ImageIcon(Main.class.getResource("../image/noteRoutePressed.png")).getImage();
		}
		public void ReleaseS() {
			noteRouteSImage = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();
		}
		public void PressD() {
			judge("D");
			noteRouteDImage = new ImageIcon(Main.class.getResource("../image/noteRoutePressed.png")).getImage();
		}
		public void ReleaseD() {
			noteRouteDImage = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();
		}
		public void PressF() {
			judge("F");
			noteRouteFImage = new ImageIcon(Main.class.getResource("../image/noteRoutePressed.png")).getImage();
		}
		public void ReleaseF() {
			noteRouteFImage = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();
		}
		public void PressSpace() {
			judge("Space");
			noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../image/noteRoutePressed.png")).getImage();
			noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../image/noteRoutePressed.png")).getImage();
		}
		public void ReleaseSpace() {
			noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();
			noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();
		}
		public void PressJ() {
			judge("J");
			noteRouteJImage = new ImageIcon(Main.class.getResource("../image/noteRoutePressed.png")).getImage();
		}
		public void ReleaseJ() {
			noteRouteJImage = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();
		}
		
		public void PressK() {
			judge("K");
			noteRouteKImage = new ImageIcon(Main.class.getResource("../image/noteRoutePressed.png")).getImage();
		}
		public void ReleaseK() {
			noteRouteKImage = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();
		}
		public void PressL() {
			judge("L");
			noteRouteLImage = new ImageIcon(Main.class.getResource("../image/noteRoutePressed.png")).getImage();
		}
		public void ReleaseL() {
			noteRouteLImage = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();
		}
	
		public void run() {
			dropNotes();
		}
		public void close() {
			gameMusic.close();
			this.interrupt();
		}
		
		public void dropNotes() {
			Beat[] beats = null;
			if(titleName.equals("cc#1 Pyrite") && difficulty.equals("Easy")) {
				int startTime = 1000 - Main.REACH_TIME * 1000;
				int gap = 100;
				Note.setScore();
				beats = new Beat[] {
						new Beat(startTime + gap *63, "D"),
						new Beat(startTime + gap *63, "J"),
						new Beat(startTime + gap *67, "D"),
						new Beat(startTime + gap *67, "J"),
						new Beat(startTime + gap *69, "S"),
						new Beat(startTime + gap *71, "K"),
						new Beat(startTime + gap *75, "D"),
						new Beat(startTime + gap *78, "J"),
						new Beat(startTime + gap *81, "K"),
						new Beat(startTime + gap *84, "L"),
						new Beat(startTime + gap *100, "Space"),
						new Beat(startTime + gap *108, "S"),
						new Beat(startTime + gap *112, "K"),
				};
			}
			else if(titleName.equals("cc#1 Pyrite") && difficulty.equals("Hard")) {
				int startTime = 1000;
				beats = new Beat[] {
						new Beat(startTime, "Space"),
				};
			}
			else if(titleName.equals("cc#2 Blade") && difficulty.equals("Easy")) {
				int startTime = 1000;
				beats = new Beat[] {
						new Beat(startTime, "Space"),
				};
			}
			else if(titleName.equals("cc#2 Blade") && difficulty.equals("Hard")) {
				int startTime = 1000;
				beats = new Beat[] {
						new Beat(startTime, "Space"),
				};
			}
			
			else if(titleName.equals("cc#4 LeadSeal") && difficulty.equals("Easy")) {
				int startTime = 1000;
				beats = new Beat[] {
						new Beat(startTime, "Space"),
				};
			}
			else if(titleName.equals("cc#4 LeadSeal") && difficulty.equals("Hard")) {
				int startTime = 1000;
				beats = new Beat[] {
						new Beat(startTime, "Space"),
				};
			}
				
			int i = 0;
			gameMusic.start();
			while(i < beats.length && !isInterrupted()) {
				boolean dropped = false;
				if(beats[i].getTime() <= gameMusic.getTime()) {
					Note note = new Note(beats[i].getNoteName());
					note.start();
					noteList.add(note);
					i++;
					dropped = true;
				}
				if(!dropped) {
					try {
						Thread.sleep(5);
					}catch (Exception e) {
						e.printStackTrace();
						
					}
				}
			}
		}
		
		public void judge(String input) {
			for(int i = 0; i < noteList.size(); i++) {
				Note note = noteList.get(i);
				if(input.equals(note.getNoteType())) {
					note.judge();
					break;
				}
			}
		}
}
