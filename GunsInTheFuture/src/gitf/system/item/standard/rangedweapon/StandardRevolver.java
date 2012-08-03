package gitf.system.item.standard.rangedweapon;

import java.util.ArrayList;

import gitf.system.dice.DiceRoll;
import gitf.system.dice.StandardDiceRoll;
import gitf.system.action.Action;
import gitf.system.item.RangedWeapon;
import gitf.system.item.ItemResponder;
import gitf.system.item.quality.Quality;

public class StandardRevolver implements RangedWeapon 
{
	private String name = "Revolver";
	private int range = 15;
	private DiceRoll damage = new StandardDiceRoll(1, 10);
	private ArrayList<Quality> qualities;
	private ItemResponder responder;
	
	public StandardRevolver()
	{
		qualities = new ArrayList<Quality>(0);
		responder = new ItemResponder(this);
	}
	
	public void respondToAction(Action action) 
	{
		responder.respondToAction(action);
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
