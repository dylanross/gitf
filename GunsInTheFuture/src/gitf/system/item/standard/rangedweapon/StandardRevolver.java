package gitf.system.item.standard.rangedweapon;

import gitf.system.dice.DiceRoll;
import gitf.system.dice.StandardDiceRoll;
import gitf.system.action.responder.PropertyListResponder;
import gitf.system.item.Item;
import gitf.system.item.quality.Quality;

public class StandardRevolver extends RangedWeapon 
{
	private String name = "Revolver";
	private int range = 15;
	private int shortRangeModifier = 1;
	private int longRangeModifier = -2;
	private DiceRoll damage = new StandardDiceRoll(1, 10);
	private PropertyListResponder<Item, Quality> qualities;
	private int handSlots = 1;
	private boolean natural = false;
	
	public StandardRevolver()
	{
		qualities = new PropertyListResponder<Item, Quality>(this);
		setResponders(qualities);
	}
	
	public String getName() {
		return name;
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
	public DiceRoll getDamage() {
		return damage;
	}
	public PropertyListResponder<Item, Quality> getQualities() {
		return qualities;
	}
	public int getHandSlots() {
		return handSlots;
	}
	public boolean isNatural() {
		return natural;
	}
}