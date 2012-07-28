package gitf.system.item;

import gitf.system.dice.DiceRoll;

public interface RangedWeapon extends Item
{
	public int getRange();
	public DiceRoll getDamage();
}
