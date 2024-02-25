/*
 * Lizzie Howell
 * 2/12/2024
 * Assignment 3 - Map Editor
 */
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;

public class Controller implements ActionListener, MouseListener, KeyListener, MouseMotionListener
{
	private View view;
	private Model model;
	private int x,y; 
	private boolean addWalls;

	public Controller(Model m)
	{
		model = m;
		addWalls = true;
	}

	public void actionPerformed(ActionEvent e)
	{
	}

	void setView(View v){
		view = v;
	}

	public void mousePressed(MouseEvent e)
	{
		model.startWalls(e.getX(), e.getY());
	}

	public void mouseReleased(MouseEvent e) { 
		model.stopWalls(e.getX(), e.getY());
	}
	public void mouseEntered(MouseEvent e) {    }
	public void mouseExited(MouseEvent e) {    }
	public void mouseClicked(MouseEvent e) {  	}
	public void mouseDragged(MouseEvent e) {	}
	public void mouseMoved(MouseEvent e) { 	  }

	public void keyPressed(KeyEvent e)
	{
		char key = Character.toLowerCase(e.getKeyChar());
		//quit
		if(key == 'q'){
			System.exit(0);
		}
	}

	public void keyReleased(KeyEvent e)
	{
		char key = Character.toLowerCase(e.getKeyChar());
		//save
		if(key == 's'){
			// Json mapsave = model.marshal();
			// mapsave.save("map.json");
			System.out.println("Your map have been saved.");
		}
		//load
		if(key == 'l'){
			// Json mapload = model.load("map.json");
			// mapsave.unmarshal(mapload);
			System.out.println("Your map have been loaded.");
		}
		//add walls or not
		if(key == 'a' || key == 'r'){
			//addWalls = !addWalls;
			System.out.println("add walls");
		}
		//clear all walls
		if(key == 'c'){
			System.out.println("Cleared all walls.");
			
		}
	}

	public void keyTyped(KeyEvent e){
	}

	public void update()
	{
	}
}
