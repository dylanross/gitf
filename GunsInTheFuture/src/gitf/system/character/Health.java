package gitf.system.character;

import gitf.system.dice.DiceRoll;

public interface Health<Location extends Enum<Location>>
{
	public DiceRoll getDiceRoll();
	public Location getLocation(int toHitRoll);
	public int getLocationDamage(Location location);
	public void setLocationDamage(Location location, int damage);
	public String report();
}