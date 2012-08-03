package gitf.system.item.standard.rangedweapon;

import java.util.ArrayList;

import gitf.system.dice.DiceRoll;
import gitf.system.dice.StandardDiceRoll;
import gitf.system.action.Action;
import gitf.system.item.RangedWeapon;
import gitf.system.item.quality.Quality;

public class StandardRevolver implements RangedWeapon 
{
	private String name = "Revolver";
	private int range = 15;
	private DiceRoll damage = new StandardDiceRoll(1, 10);
	private ArrayList<Quality> qualities;
	
	public StandardRevolver()
	{
		qualities = new ArrayList<Quality>(0);
	}
	
	public void respondToAction(Action action) 
	{
		for (int i = 0; i < qualities.size(); i++)			// count through qualities : 
		{
			qualities.get(i).respondToAction(action);		// allow each quality to respond in turn
		}
	}
	
	public String getName() {
		return name;
	}
	public int getRange() {
		return range;
	}
	public DiceRoll getDamage() {
		return damage;
	}
	public ArrayList<Quality> getQualities() {
		return qualities;
	}
}
