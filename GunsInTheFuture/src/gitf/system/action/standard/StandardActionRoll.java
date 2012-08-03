package gitf.system.action.standard;

import java.util.ArrayList;

import gitf.system.action.FreeAction;
import gitf.system.action.PersonalAction;
import gitf.system.character.Charac;
import gitf.system.dice.StandardDiceRoll;

public class StandardActionRoll implements FreeAction, PersonalAction
{
	private String name = "Action Roll";		// the name of the action
	private Charac charac;						// the charac who is rolling for actions
	
	private StandardDiceRoll dicePool;			// the action dice pool
	private int threshold = 5;					// actions are awarded for dice with results equal to or higher than this number
	
	private boolean preAction;					// whether the action is yet to be performed
	
	private ArrayList<Integer> result;			// a list of the dice pool results
	
	private int numberOfActions = 0;			// the number of actions allowed by this dice roll
	
	/**
	 * One argument (Charac) constructor. Forms an action roll for the
	 * specified character.
	 */
	public StandardActionRoll(Charac charac)
	{
		this.charac = charac;								// assign charac
		int speed = charac.getAttributes().getSpeed();		// store speed of the charac
		dicePool = new StandardDiceRoll(speed, 10);			// form d10 dice pool with size equal to charac's speed
	}
	
	/**
	 * Performs the dice roll and assigns the resultant actions
	 * to the character specified by the constructor.
	 */
	public void execute()
	{
		numberOfActions = 0;										// default to 0 actions
		preAction = true;											// declare that the action is yet to be performed (useful for repeated execute() calls)
		charac.respondToAction(this);								// allow charac to respond to this action
		
		dicePool.roll();											// roll the dice pool
		result = dicePool.getComponentResults();					// store each die's result
		
		for (int i = 0; i < result.size(); i++)						// count through individual results
		{
			if (result.get(i) <= threshold) numberOfActions++;		// if the result is equal to or higher than the threshold, increase the number of actions
		}
		
		if (numberOfActions == 0) numberOfActions = 1;				// if no actions have been rolled, allow one
		
		preAction = false;											// declare that the action has been performed
		charac.respondToAction(this);								// allow the character to respond to this action
		charac.setActionsRemaining(numberOfActions);				// set the character's remaining actions
		
		report();													// generate and print report of this action
	}
	
	/**
	 * Generate and print a report of this action.
	 */
	public void report()
	{
		String report = charac.getName() + " rolled " + numberOfActions;	// start report String
		if (numberOfActions != 1) report += " actions!";					// if plural is needed
		else report += " action!";											// if plural is not needed
		System.out.println(report);											// print the report
	}
	
	/**
	 * Getters / Setters.
	 */
	
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