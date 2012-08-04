package gitf.system.item.standard.ccweapon;

import gitf.system.dice.DiceRoll;
import gitf.system.dice.StandardDiceRoll;
import gitf.system.action.responder.PropertyListResponder;
import gitf.system.item.Item;
import gitf.system.item.quality.Quality;

public class StandardSword extends CcWeapon
{
	private String name = "Sword";
	private DiceRoll damage = new StandardDiceRoll(8);
	private int handSlots = 1;
	private PropertyListResponder<Item, Quality> qualities;
	private boolean natural = false;
	
	public StandardSword()
	{
		qualities = new PropertyListResponder<Item, Quality>(this);
		setResponders(qualities);
	}
	
	public String getName() {
		return name;
	}
	public DiceRoll getDamage() {
		return damage;
	}
	public int getHandSlots() {
		return handSlots;
	}
	public PropertyListResponder<Item, Quality> getQualities() {
		return qualities;
	}
	public boolean isNatural() {
		return natural;
	}
}