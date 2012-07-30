package gitf.system.game;

import java.util.ArrayList;

import gitf.system.character.Charac;
import gitf.system.character.species.human.HumanCharac;
import gitf.system.util.QuickSort;

public class StandardTurnSequence implements TurnSequence
{
	private ArrayList<Charac> turnSequence;
	
	public StandardTurnSequence()
	{
		turnSequence = new ArrayList<Charac>(0);
	}
	
	public StandardTurnSequence(ArrayList<Charac> characters)
	{
		turnSequence = characters;
		order();
	}
	
	/**
	 * Add new characters to the very beginning of the turn sequence, 
	 * so that they will not act until order() is next called (i.e. the
	 * start of the next turn)
	 */
	public void add(Charac character)
	{
		turnSequence.add(0, character);
	}
	
	/**
	 * Remove the specified character from the turn sequence if it is present.
	 */
	public void remove(Charac character)
	{
		turnSequence.remove(character);
	}
	
	public void order()
	{
		QuickSort.sort(turnSequence);
	}
	
	public Charac getFirstCharacter()
	{
		return turnSequence.get(0);
	}
	
	public Charac getNextCharacter(Charac currentCharacter)
	{
		
		return turnSequence.get(turnSequence.indexOf(currentCharacter) + 1);
	}
	
	/**
	 * Getters / Setters.
	 */
	
	public ArrayList<Charac> getTurnSequence() {
		return turnSequence;
	}
}
