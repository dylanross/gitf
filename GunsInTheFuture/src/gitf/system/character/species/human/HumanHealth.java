package gitf.system.character.species.human;

import gitf.system.character.Health;
import gitf.system.dice.DiceRoll;
import gitf.system.dice.StandardDiceRoll;

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
	
	public enum DamageDescriptor { 
									NONE,
									LIGHT, 
									HEAVY, 
									CRITICAL,
									IRREVERSIBLE;
									
									public static DamageDescriptor fromDamageLevel(int damageLevel)
									{
										switch (damageLevel)
										{
											case 0 :
												return NONE;
											case 1 :
												return LIGHT;
											case 2 :
												return HEAVY;
											case 3 :
												return CRITICAL;
											case 4 :
												return IRREVERSIBLE;
											default :
												return CRITICAL;
										}
									}
									
									public String shorthand()
									{
										switch (this)
										{
											case NONE :
												return " ";
											case LIGHT :
												return "L";
											case HEAVY :
												return "H";
											case CRITICAL :
												return "C";
											case IRREVERSIBLE :
												return "X";
											default :
												return " ";
										}
									}
								 }
	
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
		return new StandardDiceRoll(1, 10);
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
		if (damage > 4) damage = 4;
		switch(location)
		{
			case HEAD :
				headDamageLevel = damage;
				break;
			case TORSO :
				torsoDamageLevel = damage;
				break;
			case ARMS :
				armsDamageLevel = damage;
				break;
			case LEGS :
				legsDamageLevel = damage;
				break;
		}
	}
	
	public String report()
	{
		String report = "Legs : " + DamageDescriptor.fromDamageLevel(legsDamageLevel).shorthand() + " | " +
						"Arms : " + DamageDescriptor.fromDamageLevel(armsDamageLevel).shorthand() + " | " +
						"Torso : " + DamageDescriptor.fromDamageLevel(torsoDamageLevel).shorthand() + " | " +
						"Head : " + DamageDescriptor.fromDamageLevel(headDamageLevel).shorthand();
		return report;
	}
}