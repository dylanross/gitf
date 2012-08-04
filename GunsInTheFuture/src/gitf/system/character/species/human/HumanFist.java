package gitf.system.character.species.human;

import java.util.ArrayList;

import gitf.system.action.Action;
import gitf.system.dice.DiceRoll;
import gitf.system.dice.StandardDiceRoll;
import gitf.system.character.UnarmedAttack;
import gitf.system.character.Attributes.AttributeName;
import gitf.system.item.quality.Quality;

public class HumanFist extends UnarmedAttack
{
	private String name = "Fist";											// the name of this weapon
	private DiceRoll damage = new StandardDiceRoll(4);						// the dice roll for this weapon's damage
	private ArrayList<Quality> qualities;									// qualities of this item
	private int range = 1;													// the range of attacks made with this weapon
	private int shortRangeModifier = 0;										// the short range modifier to toHit rolls
	private int longRangeModifier = -3;										// the long range modifier to toHit rolls
	private AttributeName testedAttribute = AttributeName.WEAPON_SKILL;		// the attribute needed to test to hit
	
	public HumanFist()
	{
		qualities = new ArrayList<Quality>(0);				// item has no qualities
	}
	
	/**
	 * Allows this item to respond to external actions
	 */
	public void respondToAction(Action action) 
	{
		for (int i = 0; i < qualities.size(); i++) 			// count through qualities :
		{
			qualities.get(i).respondToAction(action);		// allow each quality to respond in turn
		}
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
	public int getRange() {
		return range;
	}
	public int getShortRangeModifier() {
		return shortRangeModifier;
	}
	public int getLongRangeModifier() {
		return longRangeModifier;
	}
	public AttributeName getTestedAttribute() {
		return testedAttribute;
	}
}