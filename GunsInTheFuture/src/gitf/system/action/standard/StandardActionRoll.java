package gitf.system.action.standard;

import java.util.ArrayList;

import gitf.system.action.FreeAction;
import gitf.system.action.PersonalAction;
import gitf.system.character.Charac;
import gitf.system.dice.StandardDiceRoll;

public class StandardActionRoll implements FreeAction, PersonalAction
{
	private String name = "Action Roll";
	private Charac charac;
	
	private StandardDiceRoll dicePool;
	private int threshold = 5;
	
	private boolean preAction;
	
	private ArrayList<Integer> result;
	
	private int numberOfActions = 0;
	
	public StandardActionRoll(Charac charac)
	{
		this.charac = charac;
		int speed = charac.getAttributes().getSpeed();
		dicePool = new StandardDiceRoll(speed, 10);
	}
	
	public void execute()
	{
		preAction = true;
		charac.respondToAction(this);
		
		dicePool.roll();
		result = dicePool.getComponentResults();
		
		for (int i = 0; i < result.size(); i++)
		{
			if (result.get(i) <= threshold) numberOfActions++;
		}
		
		if (numberOfActions == 0) numberOfActions = 1;
		
		preAction = false;
		charac.respondToAction(this);
		charac.setActionsRemaining(numberOfActions);
		
		report();
	}
	
	public void report()
	{
		String report = charac.getName() + " rolled " + numberOfActions;
		if (numberOfActions != 1) report += " actions!";
		else report += " action!";
		System.out.println(report);
	}
	
	public String getName() {
		return name;
	}
	
	public Charac getCharac() {
		return charac;
	}

	public StandardDiceRoll getDicePool() {
		return dicePool;
	}

	public void setDicePool(StandardDiceRoll dicePool) {
		this.dicePool = dicePool;
	}

	public int getThreshold() {
		return threshold;
	}

	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}

	public boolean isPreAction() {
		return preAction;
	}

	public void setPreAction(boolean preRoll) {
		this.preAction = preRoll;
	}

	public ArrayList<Integer> getResult() {
		return result;
	}

	public void setResult(ArrayList<Integer> result) {
		this.result = result;
	}

	public int getNumberOfActions() {
		return numberOfActions;
	}

	public void setNumberOfActions(int numberOfActions) {
		this.numberOfActions = numberOfActions;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCharac(Charac charac) {
		this.charac = charac;
	}
}