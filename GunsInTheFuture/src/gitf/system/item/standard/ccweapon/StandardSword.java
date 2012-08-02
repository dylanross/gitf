package gitf.system.item.standard.ccweapon;

import gitf.system.dice.DiceRoll;
import gitf.system.dice.StandardDiceRoll;
import gitf.system.action.Action;
import gitf.system.item.CcWeapon;
import gitf.system.item.HandHeld;

public class StandardSword implements CcWeapon, HandHeld
{
	private String name = "Sword";
	private DiceRoll damage = new StandardDiceRoll(8);
	private int numberSlots = 1;
	
	public void respondToAction(Action action) {
		// do nothing
	}
	public String getName() {
		return name;
	}
	public DiceRoll getDamage() {
		return damage;
	}
	public int getNumberSlots() {
		return numberSlots;
	}
}
