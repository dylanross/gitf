package gitf.system.item.standard.ccweapon;

import java.util.ArrayList;

import gitf.system.dice.DiceRoll;
import gitf.system.dice.StandardDiceRoll;
import gitf.system.action.Action;
import gitf.system.item.CcWeapon;
import gitf.system.item.HandHeld;
import gitf.system.item.quality.Quality;

public class StandardSword implements CcWeapon, HandHeld
{
	private String name = "Sword";
	private DiceRoll damage = new StandardDiceRoll(8);
	private int slots = 1;
	private ArrayList<Quality> qualities;
	
	public StandardSword()
	{
		qualities = new ArrayList<Quality>(0);				// item has no qualities
	}
	
	public void respondToAction(Action action) 
	{
		for (int i = 0; i < qualities.size(); i++) 			// count through qualities :
		{
			qualities.get(i).respondToAction(action);		// allow each quality to respond in turn
		}
	}
	public String getName() {
		return name;
	}
	public DiceRoll getDamage() {
		return damage;
	}
	public int getSlots() {
		return slots;
	}
	public ArrayList<Quality> getQualities() {
		return qualities;
	}
}
