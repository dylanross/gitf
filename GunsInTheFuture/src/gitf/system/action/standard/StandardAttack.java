package gitf.system.action.standard;

import java.util.ArrayList;

import gitf.system.DiceRoll;
import gitf.system.action.TargettedItemAction;
import gitf.system.character.Charac;
import gitf.system.item.Item;
import gitf.system.item.CcWeapon;

public class StandardAttack implements TargettedItemAction
{
	private String name = "Attack";
	private Charac attacker;
	private Charac defender;
	private Item item;
	private String report;
	
	public void execute(Charac attacker, Charac defender, Item item)
	{
		this.attacker = attacker;										// store attacker
		this.defender = defender; 										// store defender
		
		if (item instanceof CcWeapon)									// check the given item is valid, then :
		{
			CcWeapon ccWeapon = (CcWeapon) item;						// cast item to CcWeapon
			report = attacker.getName() + " attacks " + 				// begin report of action
					 defender.getName() + " with a " + 
					 item.getName() + " ";
			
			int diceResult = new DiceRoll(1, 10).getResult(); 			// roll to hit
			
			if (diceResult <= attacker.getAttributes().getWeaponSkill()) 						// if attacker hits :
			{
				report += "and hits (" + diceResult + ") ";										// report the hit
				int locationRoll = defender.getHealth().getDiceRoll().getResult();				// roll for location
				Enum location = defender.getHealth().getLocation(locationRoll);					// store the location that has been hit
				report += "the " + location.toString() + " (" + locationRoll + ") ";			// report the location
				
				int damage = ccWeapon.getDamage().getResult();									// determine how much damage has been done
				report += "for " + damage + " damage! (ARMOUR NOT DEDUCTED YET!!!)";
			}
			else	// if attacker missed :
			{
				report += "and misses! (" + diceResult + ") ";
			}
		}
		else																				// if the given item was not valid, then :
		{
			report = attacker.getName() + " can't attack with a " + item.getName();			// generate appropriate report
		}
		
	}
	
	public String report()
	{
		return report;
	}
	
	/**
	 * Getter methods.
	 */
	
	public String getName()
	{
		return name;
	}
	
	public Charac getTargetter()
	{
		return attacker;
	}
	
	public Charac getTargetted()
	{
		return defender;
	}
	
	public Item getItem()
	{
		return item;
	}
}
