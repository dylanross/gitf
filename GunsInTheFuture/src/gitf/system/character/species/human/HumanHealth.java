package gitf.system.character.species.human;

import gitf.system.DiceRoll;
import gitf.system.character.Health;

/**
 * An implementation of the Health interface for Human characters.
 * Keeps track of the amount of damage to each location : Head, Torso, Arms, and Legs.
 * 
 * @author dylanross
 *
 */
public class HumanHealth implements Health<HumanLocation>
{
	public int headDamageLevel;
	public int torsoDamageLevel;
	public int armsDamageLevel;
	public int legsDamageLevel;
	
	/**
	 * 0 argument constructor. Sets all damage levels to 0.
	 */
	public HumanHealth()
	{
		this(0, 0, 0, 0);
	}
	
	/**
	 * 1 argument constructor. Sets damage levels to given values.
	 */
	public HumanHealth(int[] damageLevels)
	{
		this(damageLevels[0], damageLevels[1], damageLevels[2], damageLevels[3]);
	}
	
	/**
	 * 4 argument constructor. Sets damage levels to given values.
	 */
	public HumanHealth(int headDamageLevel, int torsoDamageLevel, int armsDamageLevel, int legsDamageLevel)
	{
		this.headDamageLevel = headDamageLevel;
		this.torsoDamageLevel = torsoDamageLevel;
		this.armsDamageLevel = armsDamageLevel;
		this.legsDamageLevel = legsDamageLevel;
	}
	
	public DiceRoll getDiceRoll()
	{
		return new DiceRoll(1, 10);
	}
	
	public HumanLocation getLocation(int toHitRoll)
	{
		switch(toHitRoll)
		{
			case 1 :
				return HumanLocation.LEGS;
			case 2 :
				return HumanLocation.LEGS;
			case 3 :
				return HumanLocation.LEGS;
			case 4 :
				return HumanLocation.ARMS;
			case 5 :
				return HumanLocation.ARMS;
			case 6 :
				return HumanLocation.ARMS;
			case 7 :
				return HumanLocation.TORSO;
			case 8 :
				return HumanLocation.TORSO;
			case 9 :
				return HumanLocation.TORSO;
			case 10 :
				return HumanLocation.HEAD;
			default :
				return null;
		}
	}
	
	public int getLocationDamage(HumanLocation location)
	{
		switch(location)
		{
			case HEAD :
				return headDamageLevel;
			case TORSO :
				return torsoDamageLevel;
			case ARMS :
				return armsDamageLevel;
			case LEGS :
				return legsDamageLevel;
			default :
				return -1;
		}
	}
	
	public void setLocationDamage(HumanLocation location, int damage)
	{
		switch(location)
		{
			case HEAD :
				headDamageLevel = damage;
			case TORSO :
				torsoDamageLevel = damage;
			case ARMS :
				armsDamageLevel = damage;
			case LEGS :
				legsDamageLevel = damage;
		}
	}
}
