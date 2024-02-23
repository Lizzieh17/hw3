/*
 * Lizzie Howell
 * 2/21/2024
 * Assignment 3 - Map Editor
 */

import java.util.ArrayList;

public class Model
{
	private ArrayList<Wall> walls;

	public Model()
	{
		//Wall wall = new Wall(250, 300, 200, 100);
		walls = new ArrayList<Wall>();
		//walls.add(wall);
	}

	public ArrayList<Wall> getWalls(){
		return walls;
	}

	public void hello()
	{
		System.out.println("Hello");
	}
	// public void unmarshal(Json ob){

	// }
}