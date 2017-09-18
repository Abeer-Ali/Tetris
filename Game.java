package TetrisFinal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * Manages the game Tetris. Keeps track of the current piece and the grid.
 * Updates the display whenever the state of the game has changed.
 * 
 * 
 */
public class Game {

	private Grid grid; // the grid that makes up the Tetris board

	private Tetris display; // the visual for the Tetris game

	private Piece piece; // the current piece that is dropping

	private boolean isOver; // has the game finished?
	
	private boolean freezeOnNextCycle = false;

	/**
	 * Creates a Tetris game
	 * 
	 * @param Tetris
	 *            the display
	 */
	private void setPieceToRandomShape()
	{
		//ZShape, SquareShape, JShape, TShape, SShape, BarShape, LShape
		int choice = (int)(Math.random()*7);
		switch(choice)
		{
		case 0:
			piece = new ZShape(1, Grid.WIDTH / 2 - 1, grid);
			break;
		case 1:
			piece = new SquareShape(1, Grid.WIDTH / 2 - 1, grid);
			break;
		case 2:
			piece = new JShape(1, Grid.WIDTH / 2, grid);
			break;
		case 3:
			piece = new TShape(1, Grid.WIDTH / 2 - 1, grid);
			break;
		case 4:
			piece = new SShape(1, Grid.WIDTH / 2, grid);
			break;
		case 5:
			piece = new BarShape(1, Grid.WIDTH / 2 - 2, grid);
			break;
		case 6:
			piece = new LShape(1, Grid.WIDTH / 2 - 1, grid);
			break;
		}

	}
	public Game(Tetris display) {
		grid = new Grid();
		this.display = display;
		setPieceToRandomShape();
		
		isOver = false;
	}

	/**
	 * Draws the current state of the game
	 * 
	 * @param g
	 *            the Graphics context on which to draw
	 */
	public void draw(Graphics g, double scaleWidth, double scaleHeight) {
		grid.draw(g, scaleWidth, scaleHeight);
		if (piece != null) {
			piece.draw(g, scaleWidth, scaleHeight);
		}
	}

	/**
	 * Moves the piece in the given direction
	 * 
	 * @param the
	 *            direction to move
	 */
	public void movePiece(Direction direction) {
		if (piece != null) {
			piece.move(direction);
		}
		updatePiece();
        grid.checkRows();
        display.update();
		
                
	}

	/**
	 * Returns true if the game is over
	 */
	public boolean isGameOver() {
		// game is over if the piece occupies the same space as some non-empty
		// part of the grid. Usually happens when a new piece is made
		if (piece == null) {
			return false;
		}

		// check if game is already over
		if (isOver) {
			return true;
		}

		// check every part of the piece
		Point[] p = piece.getLocations();
		for (int i = 0; i < p.length; i++) {
			if (grid.isSet((int) p[i].getX(), (int) p[i].getY())) {
				isOver = true;
				return true;
			}
		}
		return false;
	}

	public void tick()
	{
		
		//called every tick of the game (piece falling)
		if (freezeOnNextCycle == true && !piece.canMove(Direction.DOWN))
		{
			
			// set Grid positions corresponding to frozen piece
			// and then release the piece
			Point[] p = piece.getLocations();
			Color c = piece.getColor();
			for (int i = 0; i < p.length; i++) {
				grid.set((int) p[i].getX(), (int) p[i].getY(), c);
			}
			piece = null;
			
			freezeOnNextCycle = false;
		}
		else
			freezeOnNextCycle = false;
		
		if (piece != null && !piece.canMove(Direction.DOWN)) {
			freezeOnNextCycle = true;
		}
		
		
	}
	/** Updates the piece */
	private void updatePiece() {
		if (piece == null) {
			//create new Shape piece here
			setPieceToRandomShape();

		}

		

	}

            /** Rotate the piece*/
        public void rotatePiece()
        {
            if (piece != null) {
                            piece.rotate();
                    }
                    updatePiece();
            grid.checkRows();
            display.update();
        }


}
