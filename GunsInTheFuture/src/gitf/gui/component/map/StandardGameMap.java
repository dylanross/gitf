package gitf.gui.component.map;

import java.awt.Color;

import gitf.gui.JConsole;

public class StandardGameMap extends JConsole implements GameMap
{
	public static final long serialVersionUID = 001;
	
	public StandardGameMap(int columns, int rows)
	{
		super(columns / 11, rows / 11);
	}
	
	public void draw(char[][] tiles, Color[][] colors)
	{
		
	}
	
	public void draw(char[][] tiles)
	{

	}
}