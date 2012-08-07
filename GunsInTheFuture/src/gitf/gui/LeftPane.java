package gitf.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import gitf.gui.AreaToCharMapConverter;
import gitf.gui.component.map.StandardGameMap;
import gitf.gui.component.textio.StandardTextIoArea;
//import gitf.system.map.Area;

public class LeftPane extends JPanel 
{
	public static final long serialVersionUID = 001;
	
	public AreaToCharMapConverter areaToCharMapConverter;
	public StandardGameMap map;
	public StandardTextIoArea inputOutputArea;
	
	public LeftPane(int width, int height)
	{
		// grid layout - 2 rows, 1 column
		GridLayout2 gl = new GridLayout2(2, 1); 
		setLayout(gl);

		int mapWidth = width;
		int mapHeight = (height / 3) * 2;
		map = new StandardGameMap(mapWidth, mapHeight);
		map.setPreferredSize(new Dimension(mapWidth, mapHeight));
		map.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(map);

		int ioWidth = width;
		int ioHeight = height / 3;
		inputOutputArea = new StandardTextIoArea(ioWidth, ioHeight);
		inputOutputArea.setPreferredSize(new Dimension(ioWidth, ioHeight));
		inputOutputArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(inputOutputArea);
	}
	
	public void printMap(char[][] chars, Color[][] colors)
	{
		map.draw(chars, colors);
	}
	
	public void println(String content)
	{
		inputOutputArea.println(content);
	}
	
	public String getln()
	{
		return inputOutputArea.getln();
	}
	
	public StandardGameMap getMap() {
		return map;
	}
}