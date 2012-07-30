package gitf.system.item.standard.ccweapon;

import gitf.system.dice.DiceRoll;
import gitf.system.dice.StandardDiceRoll;
import gitf.system.action.Action;
import gitf.system.item.CcWeapon;
import gitf.system.item.DroppableItem;

public class StandardSword implements CcWeapon, DroppableItem
{
	private String name = "Sword";
	private DiceRoll damage = new StandardDiceRoll(8);
	
	public String getName() {
		return name;
	}
	public DiceRoll getDamage() {
		return damage;
	}
	
	public void respondToAction(Action action) {
		// do nothing
	}
}
