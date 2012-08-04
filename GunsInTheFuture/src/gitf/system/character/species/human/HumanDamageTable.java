package gitf.system.character.species.human;

import java.util.ArrayList;

import gitf.system.action.standard.StandardDrop;
import gitf.system.character.Charac;
import gitf.system.character.status.DamageTable;
import gitf.system.character.status.standard.*;
import gitf.system.character.status.standard.StandardStance.StanceType;
import gitf.system.dice.StandardDiceRoll;
import gitf.system.item.Item;
import gitf.system.item.Equippable;

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
		if (location.equals(HumanLocation.LEGS))
		{
			if (damageLevel == 1);	// do nothing
			if (damageLevel == 2) 
			{
				new StandardCantRun(target).addToOwner();
				new StandardStance(target, StanceType.PRONE).addToOwner();
			}
			if (damageLevel == 3) 
			{
				new StandardCrawlOnly(target).addToOwner();
				if (downTest(target) == true) new StandardDown(target).addToOwner();
			}
			if (damageLevel > 3) new StandardDown(target).addToOwner();
		}
		if (location.equals(HumanLocation.ARMS))
		{
			if (damageLevel == 1);	// do nothing
			if (damageLevel == 2)
			{
				Item droppedItem = getRandomHeldItem(target);
				if (droppedItem != null)
				{
					new StandardDrop(target, droppedItem).execute();
				}
			}
			if (damageLevel == 3)
			{
				if (downTest(target) == true) new StandardDown(target).addToOwner();
			}
			if (damageLevel > 3) new StandardDown(target).addToOwner();
		}
		if (location.equals(HumanLocation.TORSO))
		{
			if (damageLevel == 1) new StandardStance(target, StanceType.PRONE).addToOwner();;
			if (damageLevel == 2)
			{
				new StandardStance(target, StanceType.PRONE).addToOwner();;
				if (downTest(target) == true) new StandardDown(target).addToOwner();
			}
			if (damageLevel == 3) new StandardDown(target).addToOwner();
			if (damageLevel > 3) new StandardUnconscious(target).addToOwner();
		}
		if (location.equals(HumanLocation.HEAD))
		{
			if (damageLevel == 1) new StandardStunned(target, 2).addToOwner();
			if (damageLevel == 2) new StandardDown(target).addToOwner();
			if (damageLevel == 3) new StandardUnconscious(target).addToOwner();
			if (damageLevel > 3) new StandardDead(target).addToOwner();
		}
	}
	
	public boolean downTest(Charac<HumanLocation> target)
	{
		if (new StandardDiceRoll(10).roll() > target.getAttributes().getToughness()) return true;
		else return false;
	}
	
	public Item getRandomHeldItem(Charac<HumanLocation> target)
	{
		ArrayList<Equippable> equippedItems = target.getEquipped().getItems();
		ArrayList<Item> heldItems = new ArrayList<Item>(0);
		for (int i = 0; i < equippedItems.size(); i++)
		{
			if (equippedItems.get(i).getHandSlots() > 0) 
			{
				heldItems.add(equippedItems.get(i));
			}
		}
		
		if (heldItems.size() == 0)
		{
			return null;
		}
		else
		{
			return heldItems.get(new StandardDiceRoll(heldItems.size()).roll() - 1);
		}
	}
}