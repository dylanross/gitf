package gitf.system.character.status;

import gitf.system.character.Charac;

public interface DamageTable<Location extends Enum<Location>> 
{
	public void causeEffect(Charac<Location> target, Location location, int damageLevel);
}
