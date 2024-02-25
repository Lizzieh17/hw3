/*
 * Lizzie Howell
 * 2/25/2024
 * Assignment 3 - Map Editor
 */

import java.util.ArrayList;

public class Model
{
	private ArrayList<Wall> walls;
	private int begX, begY;

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
		int width = 0;
		int height = 0;
		if(newX < begX){
			width = begX - newX;
			begX = newX;
		}
		if(newY < begY){
			height = begY - newY;
			begY = newY;
		}
		if(newX > begX){
			width = newX - begX;
		}
		if(newY > begY){
			height = newY - begY;
		}
		Wall wall = new Wall(begX, begY, width, height);
		//wall.print();
		walls.add(wall);
	}
	public void clearWalls(){
		System.out.println("Clearing wall...");
		for(int i = 0; i < walls.size(); i++)
		{
			walls.remove(i);
		}
	}
	// public void saveMap() {
	// 	Json ob = marshal();
	// 	ob.save("map.json");
	// }
	// public void loadMap(){
	// 	mapsave.unmarshal("map.json");
	// }
	Json marshal() {
		System.out.println("marshal from model called.");
        Json ob = Json.newObject();
        Json tmpList = Json.newList();
        ob.add("walls", tmpList);
        for(int i = 0; i < walls.size(); i++){
			tmpList.add(walls.get(i).marshal());
		}
		return ob;
    }
	public void unmarshal(Json ob){
		System.out.println("unmarshal from model called.");
		clearWalls();
		begX = (int)ob.getLong(begX);
		begY = (int)ob.getLong(begY);
		walls = new ArrayList<Wall>();
		Json tmpList = ob.get("walls");
        for(int i = 0; i < tmpList.size(); i++){
			Wall wall = new Wall(tmpList.get(i));
			walls.add(wall);
		}
	}
}