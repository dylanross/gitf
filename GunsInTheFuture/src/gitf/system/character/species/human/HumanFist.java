package gitf.system.character.species.human;

import java.util.ArrayList;

import gitf.system.action.Action;
import gitf.system.dice.DiceRoll;
import gitf.system.dice.StandardDiceRoll;
import gitf.system.character.UnarmedAttack;
import gitf.system.item.quality.Quality;
import gitf.system.item.ItemResponder;

public class HumanFist implements UnarmedAttack
{
	private String name = "Fist";							// the name of this weapon
	private DiceRoll damage = new StandardDiceRoll(4);		// the dice roll for this weapon's damage
	private ArrayList<Quality> qualities;					// qualities of this item
	private ItemResponder responder;						// responds to actions on behalf of this Item
	
	public HumanFist()
	{
		qualities = new ArrayList<Quality>(0);				// item has no qualities
		responder = new ItemResponder(this);				// use standard item responder
	}
	
	/**
	 * Allows this item to respond to external actions
	 */
	public void respondToAction(Action action) 
	{
		responder.respondToAction(action);
	}
	
	public String getName() {
		return name;
	}
	public DiceRoll getDamage() {
		return damage;
	}
	public ArrayList<Quality> getQualities() {
		return qualities;
	}
}