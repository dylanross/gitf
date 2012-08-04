package gitf.system.item;

import gitf.system.character.Attributes.AttributeName;
import gitf.system.dice.DiceRoll;

public interface Weapon extends Equippable
{
	public int getRange();						// returns the range of the weapon (in m)
	public int getLongRangeModifier();			// returns the toHit roll modifier at long range
	public int getShortRangeModifier();			// returns the toHit roll modifier at short range
	public DiceRoll getDamage();				// returns the damage roll for this weapon
	public AttributeName getTestedAttribute();	// returns the attribute to roll against to use the weapon
}