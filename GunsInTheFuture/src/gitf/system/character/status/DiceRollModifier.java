package gitf.system.character.status;

import gitf.system.dice.DiceRoll;

public interface DiceRollModifier 
{
	public DiceRoll getModifiedDiceRoll(DiceRoll originalDiceRoll);
}