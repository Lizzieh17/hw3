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
		//System.out.println("Starting wall...");
		begX = x;
		begY = y;
	}
	public void stopWalls(int newX, int newY)
	{
		//System.out.println("Stoping wall...");
		int width = 0;
		int height = 0;

		//accounting for when the user drags right to left
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
		//add the new wall
		Wall wall = new Wall(begX, begY, width, height);
		walls.add(wall);
	}
	public void clearWalls(){
		System.out.println("Clearing walls...");
		for(int i = getWalls().size() - 1; i >= 0; i--){ 
			Wall wall = getWalls().get(i);
			getWalls().remove(wall);
		}
	}

	JSON marshal() {
		//System.out.println("marshal from model called.");
        JSON ob = JSON.newObject();
        JSON tmpList = JSON.newList();
        ob.add("walls", tmpList);
        for(int i = 0; i < walls.size(); i++){
			tmpList.add(walls.get(i).marshal());
		}
		return ob;
    }

	public void unmarshal(JSON ob){
		//System.out.println("unmarshal from model called.");
		clearWalls();
		walls = new ArrayList<Wall>();
		JSON tmpList = ob.get("walls");
        for(int i = 0; i < tmpList.size(); i++){
			Wall wall = new Wall(tmpList.get(i));
			walls.add(wall);
		}
	}
}