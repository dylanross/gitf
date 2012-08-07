package gitf.system.map;

public class TestArea implements Area
{
	private String name = "Test Area";
	private Map map;
	private int[] coordinates = new int[] { 0, 0, 0 };
	private boolean passable = true;
	
	public TestArea(Map map, int[] coordinates)
	{
		if (coordinates.length != 3) return;		// x, y and z coordinates must be supplied
		this.coordinates = coordinates;				// set coordinates
		this.map = map;								// set map
	}
	
	public String getName() {
		return name;
	}
	
	public Map getMap() {
		return map;
	}
	
	public int[] getCoordinates() {
		return coordinates;
	}
	
	public boolean isPassable() {
		return passable;
	}
}