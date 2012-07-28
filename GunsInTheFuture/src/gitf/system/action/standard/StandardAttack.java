package gitf.system.action.standard;

import gitf.system.action.TargettedItemAction;
import gitf.system.character.Charac;
import gitf.system.dice.DiceRoll;
import gitf.system.dice.StandardDiceRoll;
import gitf.system.item.Item;
import gitf.system.item.CcWeapon;

public class StandardAttack implements TargettedItemAction
{
	private String name = "Attack";
	
	private Charac attacker;
	private Charac defender;
	private Item item;
	
	private int toHitChance;
	
	private DiceRoll toHitRoll;
	private DiceRoll damageRoll;
	private DiceRoll locationRoll;
	
	private boolean preAction;
	
	private int toHitResult;
	private int damageResult;
	private int locationRollResult;
	private Enum locationResult;
	
	private String report;
	
	public void execute(Charac attacker, Charac defender, Item item)
	{
		this.attacker = attacker;										// store attacker
		this.defender = defender; 										// store defender
		
		if (item instanceof CcWeapon)									// check the given item is valid, then :
		{
			CcWeapon ccWeapon = (CcWeapon) item;						// cast item to CcWeapon
			
			toHitChance = attacker.getAttributes().getBallisticSkill(); // store attacker's ballistic skill
			toHitRoll = new StandardDiceRoll(10);						// store toHitRoll as 1d10
			locationRoll = defender.getHealth().getDiceRoll();			// find location roll and store
			damageRoll = ccWeapon.getDamage();							// find damage roll and store
			
			preAction = true;
			attacker.respondToAction(this);								// allow the attacker to modify this action's details pre-attack
			defender.respondToAction(this);								// allow the defender to modify this action's details pre-attack
			
			toHitResult = toHitRoll.roll();											// determine to hit roll
			locationRollResult = locationRoll.roll();								// determine location hit (int)
			locationResult = defender.getHealth().getLocation(locationRollResult);	// determine location hit (Enum)
			damageResult = damageRoll.roll();										// determine damage result
			
			preAction = false;
			attacker.respondToAction(this);								// allow the attacker to modify this action's details post-attack
			defender.respondToAction(this);								// allow the defender to modify this action's details post-attack
			
			if (toHitResult <= toHitChance)																	// check if the attacker hit, then :
			{
				int damageLevels;																			// declare int to hold new damage levels caused
				if (damageResult <= 0) damageLevels = 0;													// if no damage was done, damageLevels is 0
				else damageLevels = (damageResult - 1) / defender.getAttributes().getToughness() + 1;		// if damage was done, determine how many levels of damage
				
				report = attacker.getName() + " attacks " + defender.getName() + " " +
						 "with " + item.getName() + " and hits (" + toHitResult + ") " +
						 "the " + locationResult + " (" + locationRollResult + ") for " +
						 damageLevels + " damage levels (" + damageResult + ")!";
				report();
				
				int totalDamage = defender.getHealth().getLocationDamage(locationResult) + damageLevels;	// add this to the amount of damage already sustained
				defender.getHealth().setLocationDamage(locationResult, totalDamage);						// set the defender's health appropriately
				defender.getDamageTable().causeEffect(defender, locationResult, totalDamage);				// cause any adverse effects of this new level of damage
				
				attacker.setActionsRemaining(attacker.getActionsRemaining() - 1);
			}
			else	// if attacker missed :
			{
				report = attacker.getName() + " attacks " + defender.getName() + " " +
						 "with " + item.getName() + " and misses (" + toHitResult + ")!";
				report();
				
				attacker.setActionsRemaining(attacker.getActionsRemaining() - 1);
			}
			
		}
		else																				// if the given item was not valid, then :
		{
			report = attacker.getName() + " can't attack with " + item.getName();			// generate appropriate report
			report();
		}	
	}
	
	public void report()
	{
		System.out.println(report);
	}
	
	/**
	 * Getter methods.
	 */
	
	public String getName()
	{
		return name;
	}
	
	public Charac getTargetter()
	{
		return attacker;
	}
	
	public Charac getTargetted()
	{
		return defender;
	}
	
	public Item getItem()
	{
		return item;
	}

	/**
	 * Getters / Setters for all fields.
	 * Useful for respondToAction() methods.
	 */
	
	public boolean isPreAction() {
		return preAction;
	}
	
	public Charac getAttacker() {
		return attacker;
	}

	public void setAttacker(Charac attacker) {
		this.attacker = attacker;
	}

	public Charac getDefender() {
		return defender;
	}

	public void setDefender(Charac defender) {
		this.defender = defender;
	}

	public int getToHitChance() {
		return toHitChance;
	}

	public void setToHitChance(int toHitChance) {
		this.toHitChance = toHitChance;
	}

	public DiceRoll getToHitRoll() {
		return toHitRoll;
	}

	public void setToHitRoll(DiceRoll toHitRoll) {
		this.toHitRoll = toHitRoll;
	}

	public int getToHitResult() {
		return toHitResult;
	}

	public void setToHitResult(int toHitResult) {
		this.toHitResult = toHitResult;
	}

	public DiceRoll getDamageRoll() {
		return damageRoll;
	}

	public void setDamageRoll(DiceRoll damageRoll) {
		this.damageRoll = damageRoll;
	}

	public int getDamageResult() {
		return damageResult;
	}

	public void setDamageResult(int damageResult) {
		this.damageResult = damageResult;
	}

	public DiceRoll getLocationRoll() {
		return locationRoll;
	}

	public void setLocationRoll(DiceRoll locationRoll) {
		this.locationRoll = locationRoll;
	}

	public int getLocationRollResult() {
		return locationRollResult;
	}

	public void setLocationRollResult(int locationRollResult) {
		this.locationRollResult = locationRollResult;
	}

	public Enum getLocationResult() {
		return locationResult;
	}

	public void setLocationResult(Enum locationResult) {
		this.locationResult = locationResult;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setItem(Item item) {
		this.item = item;
	}
}