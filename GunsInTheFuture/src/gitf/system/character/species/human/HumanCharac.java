package gitf.system.character.species.human;

import java.util.ArrayList;

import gitf.system.action.Action;
import gitf.system.action.standard.NewTurn;
import gitf.system.action.standard.StandardActionRoll;
import gitf.system.character.Charac;
import gitf.system.character.Attributes;
import gitf.system.character.StandardAttributes;
import gitf.system.character.Equipped;
import gitf.system.character.Inventory;
import gitf.system.character.Health;
import gitf.system.character.status.DamageTable;
import gitf.system.character.status.Status;
import gitf.system.character.status.Dead;
import gitf.system.character.status.Unconscious;
import gitf.system.character.status.Down;
import gitf.system.character.status.Stunned;
import gitf.system.character.status.standard.StandardStance;
import gitf.system.character.status.standard.StandardStance.StanceType;
import gitf.system.character.feat.Feat;
import gitf.system.character.ai.IntelligenceCore;
import gitf.system.character.ai.StandardBot;
import gitf.system.player.Player;
import gitf.system.player.BotPlayer;
import gitf.system.item.standard.ccweapon.StandardSword;

/**
 * An implementation of the Charac interface for normal human characters.
 *
 * @author dylanross
 *
 */
public class HumanCharac implements Charac<HumanLocation>
{
	private String name;										// the name of the character
	
	private Player player;										// the player with control over the character
	
	private IntelligenceCore intelCore;							// the intelligence core of the character
	
	private Attributes attributes;								// the statline of the character
	
	private Health health;										// the Health object representing the health of the character
	private DamageTable damageTable = new HumanDamageTable();	// the DamageTable object used when damaging the character
	
	private ArrayList<Status> status;							// a list of statuses attributed to the character
	
	private ArrayList<Feat> feats;								// a list of feats owned by the character
	
	private Inventory inventory;								// the Inventory object representing the inventory of the character
	private Equipped equipped;									// the Equipped object representing the items the character has equipped
	
	private int actionsRemaining;								// the number of actions the character has remaining
	
	/**
	 * Zero argument constructor. Produces generic human character
	 * with no equipment and no wounds. The character produced is a bot -
	 * it is entirely computer controlled.
	 */
	public HumanCharac()
	{
		name = HumanNameGenerator.generate();													// set to random name
		player = new BotPlayer();																// give character a Bot player
		intelCore = new StandardBot(this);														// give character a standard Bot intelligence core
		try 
		{
			attributes = new StandardAttributes(new int[] { 4, 4, 4, 4, 4, 4, 4, 4, 4, 4 });	// set all attributes to 4
		}
		catch (Exception e) { }
		health = new HumanHealth(0, 0, 0, 0);													// sets all damage levels to 0
		feats = new ArrayList<Feat>(0);															// creates empty feats list
		status = new ArrayList<Status>(0);														// creates empty status lists
		inventory = new HumanInventory(this);													// creates empty inventory
		equipped = new HumanEquipped(this);														// creates empty equipped
		
		new StandardStance(this, StanceType.STANDING).addToOwner();								// give HumanCharac a Standing Stance status
		equipped.equip(new StandardSword());													// give HumanCharac a StandardSword
	}
	
	/**
	 * Allows the character to respond to an external action.
	 */
	public void respondToAction(Action action)
	{
		equipped.respondToAction(action);
		
		for (int i = 0; i < feats.size(); i ++)							// count through Feats :
		{
			feats.get(i).respondToAction(action);						// allow Feats to respond
		}
		
		for (int i = 0; i < status.size(); i ++)						// count through Statuses :
		{
			status.get(i).respondToAction(action);						// allow Statuses to respond
		}
		
		intelCore.respondToAction(action);								// allow the intelligence core to respond
		
		if (action instanceof NewTurn)
		{
			new StandardActionRoll(this).execute();						// roll for actions
		}
	}
	
	/**
	 * Prints out a report of the character's health.
	 */
	public void healthReport()
	{
		System.out.println(health.report());					// print the Health object's report
	}
	
	/**
	 * Prints out a report of the character's statuses.
	 */
	public void statusReport()
	{
		for (int i = 0; i < status.size(); i++)					// count through Statuses :
		{
			System.out.println("- " + status.get(i).getName());	// print the Status's name
		}
	}
	
	/**
	 * Prints out a report of the character's equipped items.
	 */
	public void equippedReport()
	{
		System.out.println(equipped.report());					// print the Equipped object's report
	}
	
	/**
	 * Prints out a report of the character's inventory.
	 */
	public void inventoryReport()
	{
		System.out.println(inventory.report());					// print the Inventory object's report
	}
	
	/**
	 * toString() method.
	 */
	public String toString()
	{
		return name;
	}
	
	/**
	 * Getter methods.
	 */
	
	public boolean isIncapacitated() 
	{
		boolean result = false;
		
		for (int i = 0; i < status.size(); i++)
		{
			if (status.get(i) instanceof Dead ||
				status.get(i) instanceof Unconscious ||
				status.get(i) instanceof Down ||
				status.get(i) instanceof Stunned)
			{
				result = true;
			}
		}
		
		return result;
	}
	
	/**
	 * Getters / Setters.
	 */
	
	public String getName() {
		return name;
	}
	public Player getPlayer() {
		return player;
	}
	public IntelligenceCore getIntelligenceCore() {
		return intelCore;
	}
	public Attributes getAttributes() {
		return attributes;
	}
	public Health getHealth() {
		return health;
	}
	public DamageTable getDamageTable() {
		return damageTable;
	}
	public ArrayList<Feat> getFeats() {
		return feats;
	}
	public ArrayList<Status> getStatus() {
		return status;
	}
	public Equipped getEquipped() {
		return equipped;
	}
	public Inventory getInventory() {
		return inventory;
	}
	public int getActionsRemaining() {
		return actionsRemaining;
	}
	public void setActionsRemaining(int actionsRemaining) {
		this.actionsRemaining = actionsRemaining;
	}
}