package gitf.system.item.standard.ccweapon;

import gitf.system.item.Weapon;
import gitf.system.item.AbstractItem;
import gitf.system.character.Attributes.AttributeName;

/**
 * Abstract implementation of Weapon which sets
 * range to 1. Will probably be useful for other
 * things in the future.
 * 
 * @author dylanross
 *
 */

public abstract class CcWeapon extends AbstractItem implements Weapon
{
	private int range = 1;
	private int longRangeModifier = -3;
	private int shortRangeModifier = 0;
	
	public int getRange()
	{
		return range;
	}
	
	public int getLongRangeModifier() {
		return longRangeModifier;
	}
	
	public int getShortRangeModifier() {
		return shortRangeModifier;
	}
	
	public AttributeName getTestedAttribute() {
		return AttributeName.WEAPON_SKILL;
	}
}