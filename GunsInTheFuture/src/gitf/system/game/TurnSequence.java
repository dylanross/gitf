package gitf.system.game;

import java.util.ArrayList;

import gitf.system.character.Charac;

public interface TurnSequence 
{
	public ArrayList<Charac> getTurnSequence();
	
	public void order();
	public void add(Charac character);
	public void remove(Charac character);
	public Charac getFirstCharacter();
	public Charac getNextCharacter(Charac currentCharacter);
}