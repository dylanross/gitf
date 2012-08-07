package gitf.system.map;

import java.util.ArrayList;

public class TestMap implements Map 
{
	private String name = "Testing Map";
	private ArrayList<Area> areas;
	
	public TestMap() {
		areas = new ArrayList<Area>(0);
		areas.add(new TestArea(this, new int[] { 0, 0, 0 }));
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Area> getAreas() {
		return areas;
	}
	
	public int getDistance(Area from, Area to) {
		return EuclideanGeometry.calculateDistance(from.getCoordinates(), to.getCoordinates());
	}
	
	public boolean getLineOfSight(Area from, Area to) {
		return true;
	}
	
	public boolean getLineOfHearing(Area from, Area to) {
		return true;
	}
}
