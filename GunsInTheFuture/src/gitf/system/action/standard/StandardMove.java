package gitf.system.action.standard;

import gitf.system.action.MoveAction;
import gitf.system.character.Charac;
import gitf.system.map.Area;

public class StandardMove implements MoveAction
{
	private String name = "Move";
	private String report;
	private boolean preAction = true;
	private int actionCost;
	
	private Charac mover;
	private Area origin;
	private Area destination;
	
	public StandardMove(Charac mover, Area origin, Area destination)
	{
		this.mover = mover;
		this.origin = origin;
		this.destination = destination;
	}
	
	public void execute()
	{
	
	}
	
	public void report()
	{
		System.out.println(mover.getName() + " moved from " + origin.getName() + " to " + destination.getName());
	}
	
	public String getName() {
		return name;
	}
	public String getReport() {
		return report;
	}
	public void setReport(String report) {
		this.report = report;
	}
	public boolean isPreAction() {
		return preAction;
	}
	public int getActionCost() {
		return actionCost;
	}
	public void setActionCost(int actionCost) {
		this.actionCost = actionCost;
	}
	
	public Charac getMover() {
		return mover;
	}
	public Area getOrigin() {
		return origin;
	}
	public Area getDestination() {
		return destination;
	}
}