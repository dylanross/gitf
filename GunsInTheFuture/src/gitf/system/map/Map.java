package gitf.system.map;

import java.util.ArrayList;

public interface Map 
{
	public String getName();
	public ArrayList<Area> getAreas();
	
	public int getDistance(Area from, Area to);
	public boolean getLineOfSight(Area from, Area to);
	public boolean getLineOfHearing(Area from, Area to);
}