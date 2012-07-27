package gitf.system.character;

/**
 * An implementation of the Attributes interface for the standard
 * Guns in the Future statline.
 * 
 * @author dylanross
 *
 */
public class StandardAttributes implements Attributes
{
	/**
	 * The attribute values for :
	 * 
	 * 0 - Weapon Skill (WS)
	 * 1 - Ballistic Skill (BS)
	 * 2 - Strength (S)
	 * 3 - Toughness (T)
	 * 4 - Agility (Ag)
	 * 5 - Awareness (Aw)
	 * 6 - Intelligence (In)
	 * 7 - Nerve (Nv)
	 * 8 - Charisma (Ch)
	 * 9 - Speed (Spd)
	 */
	
	private int[] attributes = new int[10];
	
	/**
	 * 0 argument constructor. Sets attributes to 0.
	 */
	public StandardAttributes()
	{
		this.attributes = new int[10];
	}
	
	/**
	 * 1 argument constructor. Sets attributes to given values.
	 */
	public StandardAttributes(int[] attributes) throws Exception
	{
		if (attributes.length == 10)
		{
			this.attributes = attributes;
		}
		else
		{
			throw new Exception("Invalid attribute array length (" + attributes.length + ") - should be 10");
		}
	}
	

	/**
	 * Getter methods.
	 */
	
	public int getWeaponSkill() {
		return attributes[0];
	}
	public int getBallisticSkill() {
		return attributes[1];
	}
	public int getStrength() {
		return attributes[2];
	}
	public int getToughness() {
		return attributes[3];
	}
	public int getAgility() {
		return attributes[4];
	}
	public int getAwareness() {
		return attributes[5];
	}
	public int getIntelligence() {
		return attributes[6];
	}
	public int getNerve() {
		return attributes[7];
	}
	public int getCharisma() {
		return attributes[8];
	}
	public int getSpeed() {
		return attributes[9];
	}
	
	/**
	 * Setter methods.
	 */
	
	public void setWeaponSkill(int weaponSkill) {
		attributes[0] = weaponSkill;
	}
	public void setBallisticSkill(int ballisticSkill) {
		attributes[1] = ballisticSkill;
	}
	public void setStrength(int strength) {
		attributes[2] = strength;
	}
	public void setToughness(int toughness) {
		attributes[3] = toughness;
	}
	public void setAgility(int agility) {
		attributes[4] = agility;
	}
	public void setAwareness(int awareness) {
		attributes[5] = awareness;
	}
	public void setIntelligence(int intelligence) {
		attributes[6] = intelligence;
	}
	public void setNerve(int nerve) {
		attributes[7] = nerve;
	}
	public void setCharisma(int charisma) {
		attributes[8] = charisma;
	}
	public void setSpeed(int speed) {
		attributes[9] = speed;
	}
}