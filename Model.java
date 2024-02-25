/*
 * Lizzie Howell
 * 2/21/2024
 * Assignment 3 - Map Editor
 */

import java.util.ArrayList;

public class Model
{
	private ArrayList<Wall> walls;
	private int begX, begY;
	private View view;

	public Model()
	{
		walls = new ArrayList<Wall>();
	}

	public ArrayList<Wall> getWalls(){
		return walls;
	}

	public void startWalls(int x, int y)
	{
		begX = x;
		begY = y;
		//System.out.println("Starting wall...");
	}
	public void stopWalls(int newX, int newY)
	{
		//System.out.println("Stoping wall...");
		Wall wall = new Wall(begX, begY, (newX- begX), (newY - begY));
		walls.add(wall);
	}
	public void clearWalls(){
		System.out.println("Clearing wall...");
		for(int i = 0; i < walls.size(); i++)
		{
			walls.remove(i);
		}
	}
	// public void unmarshal(Json ob){

	// }
}