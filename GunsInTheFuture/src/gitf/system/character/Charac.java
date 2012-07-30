package gitf.system.character;

import java.util.ArrayList;

import gitf.system.action.Action;
import gitf.system.item.Item;
import gitf.system.character.status.DamageTable;
import gitf.system.character.status.Status;
import gitf.system.character.feat.Feat;
import gitf.system.player.Player;

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
	
	public Player getPlayer();
	
	public Attributes getAttributes();
	public Health<Location> getHealth();
	public DamageTable<Location> getDamageTable();
	
	public ArrayList<Item> getEquipped();
	public ArrayList<Item> getInventory();
	
	public ArrayList<Feat> getFeats();
	
	public ArrayList<Status> getStatus();
	
	public int getActionsRemaining();
	public void setActionsRemaining(int actionsRemaining);
	
	public String toString();
	
	/**
	 * This method should allow the Character to respond (usually automatically or
	 * without player choice) to actions. Sometimes a dialogue of options will be 
	 * given.
	 * 
	 * E.g. buff WS due to a feat that activates when attacked by a knife, etc.
	 * 
	 * @param action
	 */
	public void respondToAction(Action action);
	
	public void healthReport();
	public void statusReport();
	
	public boolean isIncapacitated();
}