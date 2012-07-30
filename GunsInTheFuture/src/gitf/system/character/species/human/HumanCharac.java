package gitf.system.character.species.human;

import java.util.ArrayList;

import gitf.system.action.Action;
import gitf.system.action.NewTurn;
import gitf.system.action.standard.StandardActionRoll;
import gitf.system.character.Charac;
import gitf.system.character.Attributes;
import gitf.system.character.StandardAttributes;
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
import gitf.system.item.Item;
import gitf.system.player.Player;
import gitf.system.player.BotPlayer;
import gitf.system.dice.StandardDiceRoll;

/**
 * An implementation of the Charac interface for normal human characters.
 *
 * @author dylanross
 *
 */
public class HumanCharac implements Charac<HumanLocation>
{
	private String name;
	
	private Player player;
	
	private IntelligenceCore intelCore;
	
	private Attributes attributes;
	
	private Health health;
	private DamageTable damageTable = new HumanDamageTable();
	
	private ArrayList<Status> status;
	
	private ArrayList<Feat> feats;
	
	private ArrayList<Item>	equipped;
	private ArrayList<Item>	inventory;
	
	private int actionsRemaining;
	
	/**
	 * Zero argument constructor. Produces generic human character
	 * with no equipment and no wounds.
	 */
	public HumanCharac()
	{
		player = new BotPlayer();
		name = HumanNameGenerator.generate();													// set to boring name
		intelCore = new StandardBot(this);
		try
		{
			attributes = new StandardAttributes(new int[] { 4, 4, 4, 4, 4, new StandardDiceRoll(10).roll(), 4, 4, 4, 4 });	// set all attributes to 4
		}
		catch (Exception e)
		{
			attributes = new StandardAttributes();												// this should never be reached,
		}																						// but sets all attributes to 0
		health = new HumanHealth(0, 0, 0, 0);													// sets all damage levels to 0
		feats = new ArrayList<Feat>(0);															// creates empty feats list
		status = new ArrayList<Status>(0);														// creates empty status lists
		equipped = new ArrayList<Item>(0);														// creates empty equipped list
		inventory = new ArrayList<Item>(0);														// creates empty inventory list
		
		new StandardStance(this, StanceType.STANDING).addToOwner();								// give HumanCharac a Standing Stance status
	}
	
	/**
	 * Respond to an action.
	 */
	public void respondToAction(Action action)
	{
		for (int i = 0; i < equipped.size(); i ++)
		{
			equipped.get(i).respondToAction(action);
		}
		for (int i = 0; i < feats.size(); i ++)
		{
			feats.get(i).respondToAction(action);
		}
		for (int i = 0; i < status.size(); i ++)
		{
			status.get(i).respondToAction(action);
		}
		
		intelCore.respondToAction(action);
		
		if (action instanceof NewTurn)
		{
			new StandardActionRoll().execute(this);
		}
	}
	
	public void healthReport()
	{
		System.out.println(health.report());
	}
	
	public void statusReport()
	{
		for (int i = 0; i < status.size(); i++)
		{
			System.out.println("- " + status.get(i).getName());
		}
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
	
	public String getName() {
		return name;
	}
	public Player getPlayer() {
		return player;
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
	public ArrayList<Item> getEquipped() {
		return equipped;
	}
	public ArrayList<Item> getInventory() {
		return inventory;
	}
	public int getActionsRemaining() {
		return actionsRemaining;
	}
	public void setActionsRemaining(int actionsRemaining) {
		this.actionsRemaining = actionsRemaining;
	}
}
