package gitf.system.character.species.human;

import java.util.ArrayList;

import gitf.system.character.Charac;
import gitf.system.character.Attributes;
import gitf.system.character.StandardAttributes;
import gitf.system.character.Health;
import gitf.system.character.status.DamageTable;
import gitf.system.character.status.Status;
import gitf.system.item.Item;

/**
 * An implementation of the Charac interface for normal human characters.
 *
 * @author dylanross
 *
 */
public class HumanCharac implements Charac<HumanLocation>
{
	private String name;
	private Attributes attributes;
	private Health health;
	private DamageTable damageTable = new HumanDamageTable();
	private ArrayList<Status> status;
	
	private ArrayList<Item>	equipped;
	private ArrayList<Item>	inventory;
	
	/**
	 * Zero argument constructor. Produces generic human character
	 * with no equipment and no wounds.
	 */
	public HumanCharac()
	{
		name = "HumanCharac";																	// set to boring name
		try
		{
			attributes = new StandardAttributes(new int[] { 4, 4, 4, 4, 4, 4, 4, 4, 4, 4 });	// set all attributes to 4
		}
		catch (Exception e)
		{
			attributes = new StandardAttributes();												// this should never be reached,
		}																						// but sets all attributes to 0
		health = new HumanHealth(0, 0, 0, 0);													// sets all damage levels to 0
		status = new ArrayList<Status>(0);														// creates empty status list
		equipped = new ArrayList<Item>(0);														// creates empty equipped list
		inventory = new ArrayList<Item>(0);														// creates empty inventory list
	}
	
	/**
	 * Getter methods.
	 */
	
	public String getName() {
		return name;
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
	public ArrayList<Status> getStatus() {
		return status;
	}
	public ArrayList<Item> getEquipped() {
		return equipped;
	}
	public ArrayList<Item> getInventory() {
		return inventory;
	}
	
	/**
	 * Setter methods.
	 */
	
	public void setStatus(ArrayList<Status> status) {
		this.status = status;
	}
}
