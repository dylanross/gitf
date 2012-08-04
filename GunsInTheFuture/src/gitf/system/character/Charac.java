package gitf.system.character;

import gitf.system.action.responder.ActionResponder;
import gitf.system.action.responder.PropertyListResponder;
import gitf.system.character.ai.IntelligenceCore;
import gitf.system.character.status.DamageTable;
import gitf.system.character.status.Status;
import gitf.system.character.feat.Feat;
import gitf.system.player.Player;
import gitf.system.item.Item;
import gitf.system.map.Area;

/**
 * An interface specifying what any character within the game should implement
 * in order to be able to interact with other characters and the world.
 * 
 * @author dylanross
 *
 * @param <Location>
 */
public interface Charac<Location extends Enum<Location>> extends ActionResponder
{	
	public String getName();									// returns the name of the character
	
	public Player getPlayer();									// returns the Player with control of the character
	
	public IntelligenceCore getIntelligenceCore();				// returns the character's intelligence core
	
	public Attributes getAttributes();							// returns the character's attributes
	public Health<Location> getHealth();						// returns the Health object associated with this character
	public DamageTable<Location> getDamageTable();				// returns the DamageTable associated with this character
	
	public Equipped getEquipped();								// returns the Equipped object associated with this character
	public PropertyListResponder<Charac, Item> getInventory();	// returns the Inventory associated with this character
	public PropertyListResponder<Charac, Feat> getFeats();		// returns a CharacPropertyList of Feats associated with the character
	public PropertyListResponder<Charac, Status> getStatus();	// returns a CharacPropertyList of Statuses
	
	public int getActionsRemaining();							// returns the number of actions this character has remaining
	public void setActionsRemaining(int actionsRemaining);		// sets the number of actions this character has remaining
	
	public Area getCurrentArea();								// returns the area the character currently occupies
	public void setCurrentArea(Area currentArea);				// sets the area the character currently occupies
	
	public String toString();									// returns a String representation of this character
	
	public void healthReport();									// returns a report of this Charac's health
	public void statusReport();									// returns a report of this Charac's statuses
	public void equippedReport();								// returns a report of this Charac's equipped items
	public void inventoryReport();								// returns a report of this Charac's inventory
	
	public boolean isIncapacitated();							// returns true if the character is unable to act
}