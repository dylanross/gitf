package gitf.system.action;

import gitf.system.character.Charac;
import gitf.system.dice.DiceRoll;
import gitf.system.item.Weapon;

public interface AttackAction extends TargettedAction, ItemAction
{
	/**
	 * The main objects involved in the action.
	 */
	
	public Charac getAttacker();
	public void setAttacker(Charac attacker);

	public Charac getDefender();
	public void setDefender(Charac defender);
	
	public Weapon getWeapon();
	public void setWeapon(Weapon weapon);
	
	public int getRange();
	public void setRange(int range);
	
	/**
	 * The to hit roll.
	 */
	
	public int getToHitChance();
	public void setToHitChance(int toHitChance);
	public DiceRoll getToHitRoll();
	public void setToHitRoll(DiceRoll toHitRoll);

	public int getToHitResult();
	public void setToHitResult(int toHitResult);

	/**
	 * The damage roll.
	 */
	
	public DiceRoll getDamageRoll();
	public void setDamageRoll(DiceRoll damageRoll);
	
	public int getDamageResult();
	public void setDamageResult(int damageResult);

	/**
	 * The location roll.
	 */
	
	public DiceRoll getLocationRoll();
	public void setLocationRoll(DiceRoll locationRoll);

	public int getLocationRollResult();
	public void setLocationRollResult(int locationRollResult);
	public Enum getLocationResult();
	public void setLocationResult(Enum locationResult);
	
	public String getReport();
	public void setReport(String report);
}
