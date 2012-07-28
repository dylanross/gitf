package gitf.system.item.standard.rangedweapon;

import gitf.system.dice.DiceRoll;
import gitf.system.dice.StandardDiceRoll;
import gitf.system.action.Action;
import gitf.system.item.RangedWeapon;

public class StandardRevolver implements RangedWeapon 
{
	private String name = "Revolver";
	private int range = 15;
	private DiceRoll damage = new StandardDiceRoll(1, 10);
	
	public String getName() {
		return name;
	}
	public int getRange() {
		return range;
	}
	public DiceRoll getDamage() {
		return damage;
	}
	
	public void respondToAction(Action action) {
		
	}
}
