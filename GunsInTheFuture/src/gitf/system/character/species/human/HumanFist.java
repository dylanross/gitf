package gitf.system.character.species.human;

import gitf.system.action.responder.PropertyListResponder;
import gitf.system.dice.DiceRoll;
import gitf.system.dice.StandardDiceRoll;
import gitf.system.character.UnarmedAttack;
import gitf.system.character.Attributes.AttributeName;
import gitf.system.item.Item;
import gitf.system.item.quality.Quality;

public class HumanFist extends UnarmedAttack
{
	private String name = "Fist";											// the name of this weapon
	private DiceRoll damage = new StandardDiceRoll(4);						// the dice roll for this weapon's damage
	private PropertyListResponder<Item, Quality> qualities;									// qualities of this item
	private int range = 1;													// the range of attacks made with this weapon
	private int shortRangeModifier = 0;										// the short range modifier to toHit rolls
	private int longRangeModifier = -3;										// the long range modifier to toHit rolls
	private AttributeName testedAttribute = AttributeName.WEAPON_SKILL;		// the attribute needed to test to hit
	
	public HumanFist()
	{
		qualities = new PropertyListResponder<Item, Quality>(this);			// item has no qualities
	}
	
	public String getName() {
		return name;
	}
	public DiceRoll getDamage() {
		return damage;
	}
	public PropertyListResponder<Item, Quality> getQualities() {
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