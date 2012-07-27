package gitf.system.item.standard.rangedweapon;

import gitf.system.DiceRoll;
import gitf.system.item.RangedWeapon;

public class StandardRevolver implements RangedWeapon 
{
	private String name = "Revolver";
	private int range = 15;
	private DiceRoll damage = new DiceRoll(1, 10);
	
	public String getName() {
		return name;
	}
	public int getRange() {
		return range;
	}
	public DiceRoll getDamage() {
		return damage;
	}
}
