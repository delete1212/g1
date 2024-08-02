package g1;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter{

	public void keyPressed(KeyEvent e) {
		if(MainGame.game == null) {
			return;
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			MainGame.game.PressS();
		}
		else if(e.getKeyCode() == KeyEvent.VK_D) {
			MainGame.game.PressD();
		}
		else if(e.getKeyCode() == KeyEvent.VK_F) {
			MainGame.game.PressF();
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			MainGame.game.PressSpace();
		}
		else if(e.getKeyCode() == KeyEvent.VK_J) {
			MainGame.game.PressJ();
		}
		else if(e.getKeyCode() == KeyEvent.VK_K) {
			MainGame.game.PressK();
		}
		else if(e.getKeyCode() == KeyEvent.VK_L) {
			MainGame.game.PressL();
		}
	}
	public void keyReleased(KeyEvent e) {
		if(MainGame.game == null) {
			return;
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			MainGame.game.ReleaseS();
		}
		else if(e.getKeyCode() == KeyEvent.VK_D) {
			MainGame.game.ReleaseD();
		}
		else if(e.getKeyCode() == KeyEvent.VK_F) {
			MainGame.game.ReleaseF();
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			MainGame.game.ReleaseSpace();
		}
		else if(e.getKeyCode() == KeyEvent.VK_J) {
			MainGame.game.ReleaseJ();
		}
		else if(e.getKeyCode() == KeyEvent.VK_K) {
			MainGame.game.ReleaseK();
		}
		else if(e.getKeyCode() == KeyEvent.VK_L) {
			MainGame.game.ReleaseL();
		}
	}
}
