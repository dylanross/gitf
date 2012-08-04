package gitf.system.action;

import gitf.system.character.Attributes.AttributeName;
import gitf.system.dice.StandardDiceRoll;

public interface DiceRollAction extends PersonalAction
{
	public StandardDiceRoll getDiceRoll();		// the dice roll
	public AttributeName getAttributeName();	// the attribute this test is based on
}