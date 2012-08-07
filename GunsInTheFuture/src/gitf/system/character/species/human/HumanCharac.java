package gitf.system.character.species.human;

import java.util.ArrayList;

import gitf.system.Run;
import gitf.system.action.TurnAction;
import gitf.system.action.standard.StandardActionRoll;
import gitf.system.action.responder.ActionResponder;
import gitf.system.action.responder.PropertyListResponder;
import gitf.system.action.responder.ResponderHub;
import gitf.system.character.Charac;
import gitf.system.character.Attributes;
import gitf.system.character.DamageTable;
import gitf.system.character.StandardAttributes;
import gitf.system.character.Equipped;
import gitf.system.character.Health;
import gitf.system.character.CharacterSheetGenerator;
import gitf.system.character.status.Status;
import gitf.system.character.status.Dead;
import gitf.system.character.status.Unconscious;
import gitf.system.character.status.Down;
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
	
	private PropertyListResponder<Charac, Status> status;		// a list of Statuses attributed to the character
	private PropertyListResponder<Charac, Feat> feats;			// a list of Feats owned by the character
	private PropertyListResponder<Charac, Item> inventory;		// a list of Items owned by the character
	private Equipped equipped;									// the Equipped object representing the items the character has equipped
	
	private int actionsRemaining;								// the number of actions the character has remaining
	
	private Area currentArea;									// the area the character currently occupies
	
	private CharacterSheetGenerator characterSheetGenerator;	// an Object that can be used to generate a character sheet for this Charac
	
	/**
	 * Zero argument constructor. Produces generic human character
	 * with no equipment and no wounds. The character produced is a bot -
	 * it is entirely computer controlled.
	 */
	public HumanCharac()
	{
		name = HumanNameGenerator.generate();													// set to random name
		player = new BotPlayer();																// give character a Bot player
		getPlayer().setGUI(Run.getGUI());														// set to GUI
		
		ArrayList<ActionResponder> responders = new ArrayList<ActionResponder>(0);				// create ArrayList to hold responders
		
		intelCore = new StandardBot(this);														// give character a standard Bot intelligence core
		try 
		{
			attributes = new StandardAttributes(new int[] { 4, 4, 4, 4, 4, 4, 4, 4, 4, 4 });	// set all attributes to 4
		}
		catch (Exception e) { }
		health = new HumanHealth(0, 0, 0, 0);												// sets all damage levels to 0
		feats = new PropertyListResponder<Charac, Feat>(this);								// creates empty feats list
		status = new PropertyListResponder<Charac, Status>(this);							// creates empty status lists
		inventory = new PropertyListResponder<Charac, Item>(this);							// creates empty inventory
		equipped = new HumanEquipped(this);													// creates empty equipped
		characterSheetGenerator = new HumanCharacterSheetGenerator();
		
		responders.add(equipped);
		responders.add(feats);
		responders.add(status);
		responders.add(inventory);
		responders.add(intelCore);
		
		setResponders(responders);
		
		new StandardStance(this, StanceType.STANDING).addToOwner();								// give HumanCharac a Standing Stance status
		equipped.equip(new StandardSword());													// give HumanCharac a StandardSword
	}
	
	/**
	 * Allows the character to respond to an external action.
	 */
	@Override
	public void respondToAction(TurnAction action)
	{
		passToResponders(action);
		
		if (action.isNewTurn())
		{
			new StandardActionRoll(this).execute();
		}
		
		getPlayer().getGUI().printCharacterSheet(characterSheetGenerator.buildCharacterSheet(this));
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
	
	@Deprecated
	public boolean isIncapacitated() 
	{
		boolean result = false;
		
		for (int i = 0; i < status.getContents().size(); i++)
		{
			if (status.getContents().get(i) instanceof Dead ||
				status.getContents().get(i) instanceof Unconscious ||
				status.getContents().get(i) instanceof Down)
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
	public PropertyListResponder<Charac, Feat> getFeats() {
		return feats;
	}
	public PropertyListResponder<Charac, Status> getStatus() {
		return status;
	}
	public PropertyListResponder<Charac, Item> getInventory() {
		return inventory;
	}
	public Equipped getEquipped() {
		return equipped;
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
	
	public CharacterSheetGenerator getCharacterSheetGenerator()
	{
		return characterSheetGenerator;
	}
}