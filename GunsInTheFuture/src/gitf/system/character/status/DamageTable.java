package gitf.system.character.status;

import gitf.system.character.Charac;

/**
 * Interface to a damage table.
 * Classes implementing this interface should specify what adverse effects happen at each level of injury,
 * and put them into play.
 *  
 * @author dylanross
 */
public interface DamageTable<Location extends Enum<Location>> 
{
	public void causeEffect(Charac<Location> target, Location location, int damageLevel);
}