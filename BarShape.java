package TetrisFinal;

import java.awt.Color;

public class BarShape extends AbstractPiece implements Piece
{
	public BarShape(int r, int c, Grid g) {
		grid = g;
		square = new Square[PIECE_COUNT];
		
		// Create the squares
		square[0] = new Square(g, r, c-1, Color.getHSBColor(hue, saturation, luminance), true);
		square[1] = new Square(g, r, c, Color.getHSBColor(hue, saturation, luminance), true);
		square[2] = new Square(g, r, c+1, Color.getHSBColor(hue, saturation, luminance), true);
		square[3] = new Square(g, r, c+2, Color.getHSBColor(hue, saturation, luminance), true);
	}
	
	//overrides 
	public boolean rotateIsLegal()
	{
		Square center = square[1];
		//the four bounds of my 4x4 square
		int leftOffset=0, rightOffset=0, topOffset=0, bottomOffset=0;

		if (square[3].getCol() == center.getCol() + 2)
		{
			leftOffset = 1;
			rightOffset = 2;
			topOffset = 1;
			bottomOffset = 2;
		}
		else if (square[3].getRow() == center.getRow() + 2)
		{
			rightOffset = 1;
			leftOffset = 2;
			topOffset = 1;
			bottomOffset = 2;
		}
		else if (square[3].getCol() == center.getCol() - 2)
		{
			leftOffset = 2;
			rightOffset = 1;
			topOffset = 2;
			bottomOffset = 1;
		}
		else if (square[3].getRow() == center.getRow() - 2)
		{
			leftOffset = 1;
			rightOffset = 2;
			topOffset = 2;
			bottomOffset = 1;
		}
for (int r = center.getRow() - topOffset; r <= center.getRow() + bottomOffset; r++)
	for (int c = center.getCol() - leftOffset; c <= center.getCol() + rightOffset; c++)
			{
				//out of bounds
				if (c < 0 || c > Grid.WIDTH-1 || r < 0 || r > Grid.HEIGHT - 1)
					return false;
				//if its occupied by ANOTHER square
				if (grid.isSet(r,c) && !squareIsPartOfThisShape(r,c))
					return false;		
			}
		return true;
	}
	
	
}