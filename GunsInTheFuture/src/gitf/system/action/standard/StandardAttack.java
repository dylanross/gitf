package gitf.system.action.standard;

import gitf.system.action.AttackAction;
import gitf.system.character.Charac;
import gitf.system.dice.DiceRoll;
import gitf.system.dice.StandardDiceRoll;
import gitf.system.item.Item;
import gitf.system.item.Weapon;
import gitf.system.map.Map;
import gitf.system.map.Area;

public class StandardAttack implements AttackAction
{
	private String name = "Attack";
	
	private Charac attacker;			// the character performing the attack
	private Charac defender;			// the character defending the attack
	private Weapon weapon;				// the item being used to attack
	
	private int range;					// the range between attacker and defender
	
	private int toHitChance;			// the chance of the attack hitting
	
	private DiceRoll toHitRoll;			// the dice roll used to determine whether the attack hit
	private DiceRoll damageRoll;		// the dice roll used to determine the amount of damage dealt
	private DiceRoll locationRoll;		// the dice roll used to determine the location hit
	
	private boolean preAction;			// whether the action has been performed yet
	
	private int toHitResult;			// the result of the to hit roll
	private int damageResult;			// the result of the damage roll
	private int locationRollResult;		// the result of the location roll as an int
	private Enum locationResult;		// the result of the location roll as an enum
	
	private String report;				// a report of this action
	
	/**
	 * Three argument (Charac, Charac, Item) constructor. Specifies attacker, defender,
	 * and proposed weapon.
	 */
	public StandardAttack(Charac attacker, Charac defender, Weapon weapon)
	{
		this.attacker = attacker;										// store attacker
		this.defender = defender; 										// store defender
		this.weapon = weapon;											// store weapon
	}
	
	/**
	 * Performs the attack and allows responses from involved characters.
	 */
	public void execute()
	{	
		Area fromArea = attacker.getCurrentArea();
		Area toArea = defender.getCurrentArea();
		Map map = fromArea.getMap();															// retrieve the map the attacker exists in 
		if (map == defender.getCurrentArea().getMap() && map.getLineOfSight(fromArea, toArea))	// ensure attacker and defender on same map, and that there is LoS
		{
			range = map.getDistance(fromArea, toArea);					// determine range between attacker and defender
			System.out.println("ATTACK RANGE " + range);
			
			if (range > weapon.getRange() * 2 == false)					// ensure defender within range of attacker
			{
				toHitChance = attacker.getAttributes().getAttribute(weapon.getTestedAttribute()); 	// store attribute that determines toHit roll
				
				if (range > weapon.getRange()) toHitChance += weapon.getLongRangeModifier();		// if at long range, apply long range mod.
				else toHitChance += weapon.getShortRangeModifier();									// if at short range, apply short range mod.
					
				toHitRoll = new StandardDiceRoll(10);												// store toHitRoll as 1d10
				locationRoll = defender.getHealth().getDiceRoll();									// find location roll and store
				damageRoll = weapon.getDamage();													// find damage roll and store
				
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
							 "with " + weapon.getName() + " and hits (" + toHitResult + ") " +
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
							 "with " + weapon.getName() + " and misses (" + toHitResult + ")!";
					
					report();
					
					attacker.setActionsRemaining(attacker.getActionsRemaining() - 1);
				}
			}	// if attacker out of range of defender
			else
			{
				report = attacker.getName() + " is out of range of " + defender.getName() + ".";
			}
		}
		else 	// if attacker and defender not on same map, or no line of sight
		{
			report = attacker.getName() + " cannot see " + defender.getName() + ".";	// appropriate report is generated
			report();																	// report is printed
		}
	}
	
	public void report()
	{
		System.out.println(report);
		System.out.println();
		System.out.println("--- defender status ---");
		defender.healthReport();
		defender.statusReport();
		System.out.println("--- defender equipped ---");
		defender.equippedReport();
		System.out.println("--- defender inventory ---");
		defender.inventoryReport();
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
		return weapon;
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
	
	public Weapon getWeapon() {
		return weapon;
	}
	
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	public int getRange() {
		return range;
	}
	
	public void setRange(int range) {
		this.range = range;
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
}