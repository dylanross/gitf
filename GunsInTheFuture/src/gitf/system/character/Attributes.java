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
	public enum AttributeName { 
									WEAPON_SKILL, 
									BALLISTIC_SKILL, 
									STRENGTH, 
									TOUGHNESS, 
									AGILITY, 
									AWARENESS, 
									INTELLIGENCE, 
									NERVE, 
									CHARISMA, 
									SPEED;
									
									public String toString()
									{
										switch(this)
										{
											case WEAPON_SKILL :
												return "Weapon Skill";
											case BALLISTIC_SKILL :
												return "Ballistic Skill";
											case STRENGTH :
												return "Strength";
											case TOUGHNESS :
												return "Toughness";
											case AGILITY :
												return "Agility";
											case AWARENESS :
												return "Awareness";
											case INTELLIGENCE :
												return "Intelligence";
											case NERVE :
												return "Nerve";
											case CHARISMA :
												return "Charisma";
											case SPEED :
												return "Speed";
											default :
												return "Unknown Attribute";
										}
									}
									
									public String toShortHand()
									{
										switch(this)
										{
											case WEAPON_SKILL :
												return "WS";
											case BALLISTIC_SKILL :
												return "BS";
											case STRENGTH :
												return "S";
											case TOUGHNESS :
												return "T";
											case AGILITY :
												return "Ag";
											case AWARENESS :
												return "Aw";
											case INTELLIGENCE :
												return "In";
											case NERVE :
												return "Nv";
											case CHARISMA :
												return "Ch";
											case SPEED :
												return "Spd";
											default :
												return "Unknown Attribute";
										}
									}
									
									public AttributeName fromString(String attributeName)
									{
										if (attributeName.equalsIgnoreCase("Weapon Skill")) return WEAPON_SKILL;
										if (attributeName.equalsIgnoreCase("Ballistic Skill")) return BALLISTIC_SKILL;
										if (attributeName.equalsIgnoreCase("Strength")) return STRENGTH;
										if (attributeName.equalsIgnoreCase("Toughness")) return TOUGHNESS;
										if (attributeName.equalsIgnoreCase("Agility")) return AGILITY;
										if (attributeName.equalsIgnoreCase("Awareness")) return AWARENESS;
										if (attributeName.equalsIgnoreCase("Intelligence")) return INTELLIGENCE;
										if (attributeName.equalsIgnoreCase("Nerve")) return NERVE;
										if (attributeName.equalsIgnoreCase("Charisma")) return CHARISMA;
										if (attributeName.equalsIgnoreCase("Speed")) return SPEED;
										return null;
									}
									
									public AttributeName fromShortHand(String attributeName)
									{
										if (attributeName.equalsIgnoreCase("WS")) return WEAPON_SKILL;
										if (attributeName.equalsIgnoreCase("BS")) return BALLISTIC_SKILL;
										if (attributeName.equalsIgnoreCase("S")) return STRENGTH;
										if (attributeName.equalsIgnoreCase("T")) return TOUGHNESS;
										if (attributeName.equalsIgnoreCase("Ag")) return AGILITY;
										if (attributeName.equalsIgnoreCase("Aw")) return AWARENESS;
										if (attributeName.equalsIgnoreCase("In")) return INTELLIGENCE;
										if (attributeName.equalsIgnoreCase("Nv")) return NERVE;
										if (attributeName.equalsIgnoreCase("Ch")) return CHARISMA;
										if (attributeName.equalsIgnoreCase("Spd")) return SPEED;
										return null;
									}
							  }
	
	public int getAttribute(AttributeName attributeName);
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
	
	public void setAttribute(AttributeName attributeName, int attributeValue);
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
	
	public String report();
}