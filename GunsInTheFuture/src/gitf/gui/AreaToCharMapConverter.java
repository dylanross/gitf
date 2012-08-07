package gitf.gui;

import java.awt.Color;

import gitf.system.map.Area;

public interface AreaToCharMapConverter 
{
	public char[][] getChar(Area[][] areas);
	public Color[][] getColor(Area[][] areas);
}
