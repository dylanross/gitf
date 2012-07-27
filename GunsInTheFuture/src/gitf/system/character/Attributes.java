package gitf.system.character;

/**
 * Interface that a Character's statline must implement for use in actions.
 * Basically, a rating specifying how good the character is in a certain area.
 * Should be between 1 and 10.
 * 
 * @author dylanross
 *
 */
public interface Attributes 
{
	public int getWeaponSkill();
	public int getBallisticSkill();
	public int getStrength();
	public int getToughness();
	public int getAgility();
	public int getAwareness();
	public int getIntelligence();
	public int getNerve();
	public int getCharisma();
	public int getSpeed();
	
	public void setWeaponSkill(int weaponSkill);
	public void setBallisticSkill(int ballisticSkill);
	public void setStrength(int strength);
	public void setToughness(int toughness);
	public void setAgility(int agility);
	public void setAwareness(int awareness);
	public void setIntelligence(int intelligence);
	public void setNerve(int nerve);
	public void setCharisma(int charisma);
	public void setSpeed(int speed);
}