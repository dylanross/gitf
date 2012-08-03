package gitf.system.character.ai;

import java.util.ArrayList;

import gitf.system.action.Action;
import gitf.system.action.standard.EndTurn;
import gitf.system.action.standard.StandardAttack;
import gitf.system.character.Charac;
import gitf.system.dice.StandardDiceRoll;
import gitf.system.item.standard.ccweapon.StandardSword;

public class StandardBot implements IntelligenceCore 
{
	private Charac owner;
	private ArrayList<Charac> gameCharacters;
	
	public StandardBot(Charac owner)
	{
		this.owner = owner;
	}
	
	public void respondToAction(Action action) 
	{
		gameCharacters = owner.getPlayer().getGame().getCharacters();
		
		if (action instanceof EndTurn) 
		{
			EndTurn endTurnAction = (EndTurn) action;
			if (owner.getActionsRemaining() > 0)
			{
				endTurnAction.setEndTurn(false);
				attackRandom();
			}
		}
	}
	
	private void attackRandom()
	{
		Charac randomTarget = gameCharacters.get(new StandardDiceRoll(gameCharacters.size()).roll() - 1);
		
		if (randomTarget != owner)
		{
			new StandardAttack(owner, randomTarget, new StandardSword()).execute();
		}
		else
		{
			attackRandom();
		}
	}
	
	public Charac getOwner() {
		return owner;
	}
}
