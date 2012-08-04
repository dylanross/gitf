package gitf.system.map;

public class TestArea implements Area
{
	private String name = "Test Area";
	private Map map;
	private int[] coordinates = new int[] { 0, 0, 0 };
	
	public TestArea(Map map)
	{
		this.map = map;
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
}