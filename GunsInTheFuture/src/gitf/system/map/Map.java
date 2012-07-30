package gitf.system.map;

public interface Map 
{
	public String getName();
	public Area getAreas();
	
	public int getDistance(Area from, Area to);
	public int getLineOfSight(Area from, Area to);
	public int getLineOfHearing(Area from, Area to);
}