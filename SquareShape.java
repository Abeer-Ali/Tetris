package TetrisFinal;

import java.awt.Color;

public class SquareShape extends AbstractPiece implements Piece
{
	public SquareShape(int r, int c, Grid g) {
		grid = g;
		square = new Square[PIECE_COUNT];
		
		Color brown = new Color(103,128,103);
		// Create the squares
		square[0] = new Square(g, r, c-1, Color.getHSBColor(hue, saturation, luminance), true);
		square[1] = new Square(g, r, c, Color.getHSBColor(hue, saturation, luminance), true);
		square[2] = new Square(g, r+1, c-1, Color.getHSBColor(hue, saturation, luminance), true);
		square[3] = new Square(g, r+1, c, Color.getHSBColor(hue, saturation, luminance), true);
	}
	
	public void rotate()
	{
		//do nothing
		return;
	}
	
	
}