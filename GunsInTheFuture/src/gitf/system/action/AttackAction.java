package gitf.system.action;

import gitf.system.character.Charac;
import gitf.system.dice.DiceRoll;
import gitf.system.item.Weapon;

/**
 * Interface implemented by Classes which execute Attack actions.
 * 
 * @author dylanross
 *
 */
public interface AttackAction extends TargettedAction, ItemAction
{
	/**
	 * The main objects involved in the action.
	 */
	
	public Charac getAttacker();										// return the character who is attacking

	public Charac getDefender();										// return the character who is defending 
	public void setDefender(Charac defender);							// set the character who is defending
	
	public Weapon getWeapon();											// return the weapon being used in the attack
	public void setWeapon(Weapon weapon);								// set the weapon being used in the attack
	
	public int getRange();												// return the distance between attacker and defender
	public void setRange(int range);									// set the distance between attacker and defender (does not move characters)
	
	/**
	 * Methods for modifying the to hit roll.
	 */
	
	public int getToHitChance();										// return the toHit chance
	public void setToHitChance(int toHitChance);						// set the toHit chance
	public DiceRoll getToHitRoll();										// return the toHit DiceRoll
	public void setToHitRoll(DiceRoll toHitRoll);						// set the toHit DiceRoll

	public int getToHitResult();										// return result of toHit roll
	public void setToHitResult(int toHitResult);						// set result of toHit roll

	/**
	 * Methods for modifying the damage roll.
	 */
	
	public DiceRoll getDamageRoll();									// return the damage DiceRoll
	public void setDamageRoll(DiceRoll damageRoll);						// set the damage DiceRoll
	
	public int getDamageResult();										// return the result of the damage roll
	public void setDamageResult(int damageResult);						// set the result of the damage roll

	/**
	 * Methods for modifying the location roll.
	 */
	
	public DiceRoll getLocationRoll();									// return the location DiceRoll
	public void setLocationRoll(DiceRoll locationRoll);					// set the location DiceRoll

	public int getLocationRollResult();									// return the location result (as an int)
	public void setLocationRollResult(int locationRollResult);			// set the location result (to int)
	public Enum getLocationResult();									// return the location result (as an enum)
	public void setLocationResult(Enum locationResult);					// set the location result (to enum)
	
	public String getReport();											// return a report of the action
	public void setReport(String report);								// set the report of the action
}
