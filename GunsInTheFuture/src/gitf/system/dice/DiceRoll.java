package gitf.system.dice;

import java.util.ArrayList;

public interface DiceRoll 
{
	public int getNumberOfDice();
	public int getNumberOfFaces();
	public int roll();
	public int getResult();
	public ArrayList<Integer> getComponentResults();
}
