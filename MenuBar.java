package TetrisFinal;

import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar {
	private Tetris display; // the visual for the Tetris game

	public MenuBar(Tetris display)
	{
		 JFrame frame = new JFrame("");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JMenuBar menuBar = new JMenuBar();
	    JMenu fileMenu = new JMenu("File");
	    fileMenu.setMnemonic(KeyEvent.VK_F);
	    menuBar.add(fileMenu);
	    JMenuItem newMenuItem = new JMenuItem("New", KeyEvent.VK_N);
	    fileMenu.add(newMenuItem);

	    frame.setJMenuBar(menuBar);
	    frame.setSize(250,250);
	    frame.setVisible(true);
	    }
	  
 }