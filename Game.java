/*
 * Lizzie Howell
 * 2/25/2024
 * Assignment  3- Map Editor
 */
import javax.swing.JFrame;
import java.awt.Toolkit;

public class Game extends JFrame
{
	private Model model;
	private View view;
	private Controller controller;

	public Game()
	{
		model = new Model();
		controller = new Controller(model);
		view = new View(controller, model);
		this.setTitle("Map Editor");
		this.setSize(750, 750);
		this.setFocusable(true);
		this.getContentPane().add(view);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		view.addMouseListener(controller);
		this.addKeyListener(controller);
		controller.setView(view);
	}

	public static void main(String[] args)
	{
		Game g = new Game();
		g.run();
	}

	public void run(){
		//show controls
		System.out.println("'c' or 'C' to remove all walls\n'a' or 'A' to add walls\n'e' or 'E' to enter edit mode\n's' or 'S' to save map\n'l' or 'L' to load map\n'q','Q', or 'ESC' to quit");
		while(true){
			controller.update();
			view.repaint(); // This will indirectly call View.paintComponent
			Toolkit.getDefaultToolkit().sync(); // Updates screen

			// Go to sleep for 40 milliseconds
			try
			{
				Thread.sleep(40);
			} catch(Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}
}
