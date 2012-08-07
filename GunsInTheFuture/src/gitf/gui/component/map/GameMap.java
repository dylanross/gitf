package gitf.gui.component.map;

import java.awt.Color;

public interface GameMap
{
	public void draw(char[][] tiles, Color[][] colours);
	public void draw(char[][] tiles);
}