/*
 * Lizzie Howell
 * 2/21/2024
 * Assignment 3 - Map Editor
 */

import java.util.ArrayList;

public class Model
{
	ArrayList<Wall> walls;

	public Model()
	{
		walls = new ArrayList<Wall>();
		Wall wall = new Wall(250, 300, 200, 100);
		walls.add(wall);
	}
}