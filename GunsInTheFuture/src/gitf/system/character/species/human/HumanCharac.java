package gitf.system.character.species.human;

import java.util.ArrayList;

import gitf.system.action.Action;
import gitf.system.action.standard.NewTurn;
import gitf.system.action.standard.StandardActionRoll;
import gitf.system.action.responder.ActionResponder;
import gitf.system.action.responder.ResponderHub;
import gitf.system.character.Charac;
import gitf.system.character.Attributes;
import gitf.system.character.StandardAttributes;
import gitf.system.character.Equipped;
import gitf.system.character.CharacPropertyList;
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
import gitf.system.item.Item;
import gitf.system.map.Area;
import gitf.system.item.standard.ccweapon.StandardSword;

/**
 * An implementation of the Charac interface for normal human characters.
 *
 * @author dylanross
 *
 */
public class HumanCharac extends ResponderHub implements Charac<HumanLocation>
{
	private String name;										// the name of the character
	
	private Player player;										// the player with control over the character
	
	private IntelligenceCore intelCore;							// the intelligence core of the character
	
	private Attributes attributes;								// the statline of the character
	
	private Health health;										// the Health object representing the health of the character
	private DamageTable damageTable = new HumanDamageTable();	// the DamageTable object used when damaging the character
	
	private CharacPropertyList<Status> status;					// a list of Statuses attributed to the character
	private CharacPropertyList<Feat> feats;						// a list of Feats owned by the character
	private CharacPropertyList<Item> inventory;					// a list of Items owned by the character
	private Equipped equipped;									// the Equipped object representing the items the character has equipped
	
	private int actionsRemaining;								// the number of actions the character has remaining
	
	private Area currentArea;									// the area the character currently occupies
	
	/**
	 * Zero argument constructor. Produces generic human character
	 * with no equipment and no wounds. The character produced is a bot -
	 * it is entirely computer controlled.
	 */
	public HumanCharac()
	{
		name = HumanNameGenerator.generate();													// set to random name
		player = new BotPlayer();																// give character a Bot player
		
		ArrayList<ActionResponder> responders = new ArrayList<ActionResponder>(0);				// create ArrayList to hold responders
		
		intelCore = new StandardBot(this);														// give character a standard Bot intelligence core
		responders.add(intelCore);
		try 
		{
			attributes = new StandardAttributes(new int[] { 4, 4, 4, 4, 4, 4, 4, 4, 4, 4 });	// set all attributes to 4
		}
		catch (Exception e) { }
		health = new HumanHealth(0, 0, 0, 0);													// sets all damage levels to 0
		feats = new HumanPropertyList<Feat>(this);												// creates empty feats list
		responders.add(feats);
		status = new HumanPropertyList<Status>(this);											// creates empty status lists
		responders.add(status);
		inventory = new HumanPropertyList<Item>(this);											// creates empty inventory
		responders.add(inventory);
		equipped = new HumanEquipped(this);														// creates empty equipped
		responders.add(equipped);
		
		setResponders(responders);
		
		new StandardStance(this, StanceType.STANDING).addToOwner();								// give HumanCharac a Standing Stance status
		equipped.equip(new StandardSword());													// give HumanCharac a StandardSword
	}
	
	/**
	 * Allows the character to respond to an external action.
	 */
	public void respondToAction(Action action)
	{
		if (action instanceof NewTurn)
		{
			new StandardActionRoll(this).execute();						// roll for actions
		}
		
		for (int i = 0; i < getResponders().size(); i++)				// allow other responders to respond
		{
			getResponders().get(i).respondToAction(action);
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
		System.out.println(status.report());
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
		
		for (int i = 0; i < status.getContents().size(); i++)
		{
			if (status.getContents().get(i) instanceof Dead ||
				status.getContents().get(i) instanceof Unconscious ||
				status.getContents().get(i) instanceof Down ||
				status.getContents().get(i) instanceof Stunned)
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
	public CharacPropertyList<Feat> getFeats() {
		return feats;
	}
	public CharacPropertyList<Status> getStatus() {
		return status;
	}
	public Equipped getEquipped() {
		return equipped;
	}
	public CharacPropertyList<Item> getInventory() {
		return inventory;
	}
	public int getActionsRemaining() {
		return actionsRemaining;
	}
	public void setActionsRemaining(int actionsRemaining) {
		this.actionsRemaining = actionsRemaining;
	}
	public Area getCurrentArea() {
		return currentArea;
	}
	public void setCurrentArea(Area currentArea) {
		this.currentArea = currentArea;
	}
}