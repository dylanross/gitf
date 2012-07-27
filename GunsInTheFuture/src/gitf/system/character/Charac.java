package gitf.system.character;

import java.util.ArrayList;

import gitf.system.item.Item;
import gitf.system.character.status.DamageTable;
import gitf.system.character.status.Status;

/**
 * An interface specifying what any character within the game should implement
 * in order to be able to interact with other characters and the world.
 * 
 * @author dylanross
 *
 * @param <Location>
 */
public interface Charac<Location extends Enum<Location>>
{	
	public String getName();
	
	public Attributes getAttributes();
	public Health<Location> getHealth();
	public DamageTable<Location> getDamageTable();
	
	public ArrayList<Item> getEquipped();
	public ArrayList<Item> getInventory();
	
	public ArrayList<Status> getStatus();
	public void setStatus(ArrayList<Status> status);
}