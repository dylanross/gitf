package gitf.system.character;

import java.util.ArrayList;

import gitf.system.action.Action;
import gitf.system.action.standard.NewTurn;
import gitf.system.action.standard.StandardActionRoll;
import gitf.system.action.responder.IgnoreResponder;
import gitf.system.character.feat.Feat;
import gitf.system.character.status.Status;
import gitf.system.character.ai.IntelligenceCore;

public abstract class CharacterResponder extends IgnoreResponder
{
	private Charac owner;
	
	public CharacterResponder(Charac owner)
	{
		this.owner = owner;
	}
	
	/**
	 * Allows different elements of the owner to respond
	 * to the incoming action, then allows this object
	 * to respond appropriately.
	 */
	public void respondToAction(Action action)
	{
		owner.getEquipped().respondToAction(action);
		
		ArrayList<Feat> feats = owner.getFeats();						// retrieve the owner's feats
		for (int i = 0; i < feats.size(); i ++)							// count through Feats :
		{
			feats.get(i).respondToAction(action);						// allow Feats to respond
		}
		
		ArrayList<Status> status = owner.getStatus();					// retrieve the owner's statuses
		for (int i = 0; i < status.size(); i ++)						// count through Statuses :
		{
			status.get(i).respondToAction(action);						// allow Statuses to respond
		}
		
		IntelligenceCore intelCore = owner.getIntelligenceCore();		// retrieve the owner's intelligence core
		intelCore.respondToAction(action);								// allow the intelligence core to respond
		
		appropriateResponse(action);									// ask for an appropriate response to this action from within this object
	}
	
	/**
	 * Respond to NewTurn actions by performing a StandardActionRoll.
	 */
	public void respondToAction(NewTurn newTurn)
	{
		new StandardActionRoll(owner).execute();		// roll for actions
	}
}
