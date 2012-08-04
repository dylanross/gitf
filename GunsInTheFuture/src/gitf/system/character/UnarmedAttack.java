package gitf.system.character;

import gitf.system.item.AbstractItem;
import gitf.system.item.Weapon;

/**
 * Abstract class for objects representing the unarmed attacks of
 * characters.
 * 
 * Always returns 0 from getHandSlots() method.
 * Always returns true from isNatural() method.
 * 
 * @author dylanross
 *
 */
public abstract class UnarmedAttack extends AbstractItem implements Weapon
{
	public final int getHandSlots() {
		return 0;
	}
	
	public final boolean isNatural() {
		return true;
	}
}