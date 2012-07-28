package gitf.system.action.standard;

import gitf.system.action.MoveAction;
import gitf.system.character.Charac;
import gitf.system.map.Area;

public class StandardMove implements MoveAction
{
	private String name = "Move";
	private Charac mover;
	
	private boolean preAction = true;
	
	private Area position;
	private Area destination;
	
	public void execute(Charac mover, Area position, Area destination)
	{
		this.mover = mover;
		this.position = position;
		this.destination = destination;
	}
	
	public void report()
	{
		System.out.println(mover.getName() + " moved from " + position.getName() + " to " + destination.getName());
	}
	
	public String getName()
	{
		return name;
	}
	
	public Charac getMover()
	{
		return mover;
	}
	
	public Area getPosition()
	{
		return position;
	}
	
	public Area getDestination()
	{
		return destination;
	}
	
	public boolean isPreAction() {
		return preAction;
	}
}
