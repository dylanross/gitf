package gitf.system.item.standard.ccweapon;

import gitf.system.DiceRoll;
import gitf.system.item.CcWeapon;

public class StandardSword implements CcWeapon 
{
	private String name = "Sword";
	private DiceRoll damage = new DiceRoll(1, 10);
	
	public String getName() {
		return name;
	}
	public DiceRoll getDamage() {
		return damage;
	}
}
