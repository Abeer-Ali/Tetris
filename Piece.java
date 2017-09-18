package TetrisFinal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public interface Piece
{
	public void draw(Graphics g, double scaleWidth, double scaleHeight);
	public void move(Direction d);
	public Point[] getLocations();
	public Color getColor();
	public boolean canMove(Direction direction);
	public void rotate();
}