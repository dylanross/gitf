package gitf.system.character.species.human;

import gitf.system.character.Charac;
import gitf.system.character.status.DamageTable;

/**
 * An implementation of the DamageTable interface for Human characters.
 * Specifies what adverse effects occur at each level of injury for each location.
 * Used when a Human character is damaged.
 * 
 * @author dylanross
 *
 */
public class HumanDamageTable implements DamageTable<HumanLocation> 
{
	/**
	 * Zero argument constructor. Produces the damage table.
	 */
	public HumanDamageTable()
	{
		
	}
	
	/**
	 * Cause the specified character to be exposed to the effects of the specified level of damage
	 * to the specified location.
	 */
	public void causeEffect(Charac<HumanLocation> target, HumanLocation location, int damageLevel)
	{
		
	}
}
