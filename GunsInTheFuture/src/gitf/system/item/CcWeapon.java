package gitf.system.item;

import gitf.system.dice.DiceRoll;

public interface CcWeapon extends Equippable
{
	public DiceRoll getDamage();
}
