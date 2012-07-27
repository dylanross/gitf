package gitf.system.item;

import gitf.system.DiceRoll;

public interface RangedWeapon extends Item
{
	public int getRange();
	public DiceRoll getDamage();
}
