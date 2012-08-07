package gitf.gui;

import gitf.system.map.Area;

public interface GUI 
{
	public void printMap(Area[][] visibleAreas);
	public void println(String content);
	public void printCharacterSheet(String characterSheet);
	public String getln();
}