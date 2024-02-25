/*
 * Lizzie Howell
 * 2/25/2024
 * Assignment 3 - Map Editor
 */
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
//import java.io.IOException;
import java.io.File;

public class View extends JPanel
{
	private BufferedImage wall_image;
	private Model model;
	private int scrollY;

	public View(Controller c, Model m)
	{
		model = m;
		c.setView(this);
		try {
			this.wall_image = ImageIO.read(new File("walls/wall.png"));
		}
		catch(Exception e){
			e.printStackTrace(System.err);
			System.exit(1);
		}
	}

	public void paintComponent(Graphics g){
		g.setColor(new Color(128, 255, 255));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		for(int i = 0; i < model.getWalls().size(); i++)
		{
			Wall wall = model.getWalls().get(i);
			g.drawImage(wall_image, wall.getX(), (wall.getY() - scrollY), wall.getW(), wall.getH(), null);
		}
	}
	public void cameraUp(){
		scrollY += - 5;
	}
	public void cameraDown(){
		scrollY += 5;
	}
}
