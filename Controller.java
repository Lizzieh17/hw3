/*
 * Lizzie Howell
 * 2/12/2024
 * Assignment 3 - Map Editor
 */
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;

public class Controller implements ActionListener, MouseListener, KeyListener
{
	private View view;
	private Model model;
	// private boolean keyLeft;
	// private boolean keyRight;
	// private boolean keyUp;
	// private boolean keyDown;

	public Controller(Model m)
	{
		model = m;
	}

	public void actionPerformed(ActionEvent e)
	{
		//view.removeButton();
	}

	void setView(View v){
		view = v;
	}

	public void mousePressed(MouseEvent e)
	{
		//model.setDestination(e.getX(), e.getY());
	}

	public void mouseReleased(MouseEvent e) {    }
	public void mouseEntered(MouseEvent e) {    }
	public void mouseExited(MouseEvent e) {    }
	public void mouseClicked(MouseEvent e) {    }

	public void keyPressed(KeyEvent e)
	{
		// switch(e.getKeyCode())
		// {
		// 	case KeyEvent.VK_RIGHT: keyRight = true; break;
		// 	case KeyEvent.VK_LEFT: keyLeft = true; break;
		// 	case KeyEvent.VK_UP: keyUp = true; break;
		// 	case KeyEvent.VK_DOWN: keyDown = true; break;
		//}
	}

	public void keyReleased(KeyEvent e)
	{
		char exitChar = e.getKeyChar();
		String exit = exitChar + "";

		// switch(e.getKeyCode())
		// {
		// 	case KeyEvent.VK_RIGHT: keyRight = false; break;
		// 	case KeyEvent.VK_LEFT: keyLeft = false; break;
		// 	case KeyEvent.VK_UP: keyUp = false; break;
		// 	case KeyEvent.VK_DOWN: keyDown = false; break;
		// }

		switch(exit){
			case "Q": System.exit(0); break;
			case "q": System.exit(0); break;
			default: break;
		}
	}

	public void keyTyped(KeyEvent e){
	}

	public void update()
	{
		// if(keyRight){
		// 	model.moveRight();
		// }
		// if(keyLeft){
		// 	model.moveLeft();
		// }
		// if(keyDown){
		// 	model.moveDown();
		// }
		// if(keyUp){
		// 	model.moveUp();
		// }
	}
}
