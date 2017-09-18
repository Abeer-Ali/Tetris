package TetrisFinal;

/**


 * Create and control the game Tetris.
 * 
 *
 *
 *
 */


import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Tetris extends JPanel {

	private Game game;
	private JFrame f;
	public static final double ORIGINAL_WIDTH = 400, ORIGINAL_HEIGHT = 550;
	private double scaleWidth = 1, scaleHeight = 1;
	
	/**
	 * Sets up the parts for the Tetris game, display and user control
	 */
	public Tetris() {
		
		game = new Game(this);		
		f = new JFrame("The Tetris Game");
		f.add(this);	
		f.addComponentListener(new ComponentAdapter() 
		{  
		        public void componentResized(ComponentEvent evt) {
		            scaleWidth = f.getWidth()/ORIGINAL_WIDTH;
		            scaleHeight = f.getHeight()/ORIGINAL_HEIGHT;
		        }
		});
		
		/*JMenuBar menuBar = new JMenuBar();
	    JMenu fileMenu = new JMenu("File");
	    fileMenu.setMnemonic(KeyEvent.VK_F);
	    menuBar.add(fileMenu);
	    JMenuItem newMenuItem = new JMenuItem("New", KeyEvent.VK_N);
	    fileMenu.add(newMenuItem);*/
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize((int)ORIGINAL_WIDTH, (int)ORIGINAL_HEIGHT);
		f.setVisible(true);
		EventController ec = new EventController(game);
		f.addKeyListener(ec);
		setBackground(new Color(200, 200, 200));
	}

	/**
	 * Updates the display
	 */
	public void update() {
		repaint();
	}

	/**
	 * Paint the current state of the game
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		game.draw(g,scaleWidth, scaleHeight);
		if (game.isGameOver()) {
			g.setFont(new Font("Palatino", Font.BOLD, 40));
			g.setColor(Color.BLACK);
			g.drawString("GAME OVER", 80, 300);
			
		}
	}

	public static void main(String[] args) {
		new Tetris();
	}

}
