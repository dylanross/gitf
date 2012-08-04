package gitf.system.item.standard.rangedweapon;

import gitf.system.character.Attributes.AttributeName;
import gitf.system.item.Weapon;
import gitf.system.item.AbstractItem;

public abstract class RangedWeapon extends AbstractItem implements Weapon
{
	public AttributeName getTestedAttribute() {
		return AttributeName.BALLISTIC_SKILL;
	}
}
