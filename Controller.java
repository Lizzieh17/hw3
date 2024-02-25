/*
 * Lizzie Howell
 * 2/12/2024
 * Assignment 3 - Map Editor
 */
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;

public class Controller implements ActionListener, MouseListener, KeyListener, MouseMotionListener
{
	private View view;
	private Model model;
	private boolean addWalls;
	private boolean editMode;

	public Controller(Model m)
	{
		model = m;
		addWalls = false;
		editMode = false;
	}

	public void actionPerformed(ActionEvent e){
	}

	void setView(View v){
		view = v;
	}

	public void mousePressed(MouseEvent e)
	{
		if (editMode == true){
			if (addWalls == true){
				model.startWalls(e.getX(), e.getY());
			}
			for(int i = 0; i < model.getWalls().size(); i++){ 
				Wall wall = model.getWalls().get(i);
				if ((addWalls == false) && (wall.wallClicked(e.getX(), e.getY()) == true)){
					System.out.println("Wall Removed");
					model.getWalls().remove(wall);
				}
			}
		}
	}

	public void mouseReleased(MouseEvent e) { 
		if (addWalls == true && editMode == true){
			model.stopWalls(e.getX(), e.getY());
		}
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
		//scroll view
		switch(e.getKeyCode()){
			case KeyEvent.VK_UP: view.cameraUp();; break;
			case KeyEvent.VK_DOWN: view.cameraDown();; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		char key = Character.toLowerCase(e.getKeyChar());

		//save
		if(key == 's'){
			Json mapsave = model.marshal();
			mapsave.save("map.json");
			System.out.println("Your map have been saved.");
		}

		//load
		if(key == 'l'){
			// Json mapload = Json.newObject();
			Json mapload = Json.load("map.json");
			model.unmarshal(mapload);
			System.out.println("Your map have been loaded.");
		}

		//add walls or not
		if(key == 'a'){
			addWalls = !addWalls;
			System.out.println("Add walls is " + addWalls);
		}

		//enter editmode
		if(key == 'e'){
			editMode = !editMode;
			System.out.println("Edit mode is " + editMode);
			if (addWalls == false){
				addWalls = true;
				System.out.println("Add mode is " + addWalls);
			}
		}

		//clear all walls
		if(key == 'c'){
			//print list of walls 
			int size = model.getWalls().size();
			if (size > 0) {
				// System.out.println(size);
				// for(int i = 0; i < size; i++){ 
				// 	Wall wall = model.getWalls().get(i);
				// 	wall.print(i);
				// }
				for(int i = model.getWalls().size() - 1; i >= 0; i--){ 
					Wall wall = model.getWalls().get(i);
					wall.print(i);
					model.getWalls().remove(wall);
				}
				System.out.println("Cleared all walls.");
			}
			else {
				System.out.println("No Walls to clear.");
			}
		}
	}

	public void keyTyped(KeyEvent e){	}

	public void update(){	
	}
}
