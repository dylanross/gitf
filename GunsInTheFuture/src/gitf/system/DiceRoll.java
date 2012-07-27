package gitf.system;

import java.lang.Math;

public class DiceRoll 
{
	private int numberOfDice;
	private int numberOfFaces;
	private int modifier;
	
	public DiceRoll(int numberOfDice, int numberOfFaces)
	{
		this.numberOfDice = numberOfDice;
		this.numberOfFaces = numberOfFaces;
		this.modifier = 0;
	}
	
	public DiceRoll(int numberOfDice, int numberOfFaces, int modifier)
	{
		this(numberOfDice, numberOfFaces);
		this.modifier = modifier;
	}
	
	public int getResult() {
		int result = 0;
		for (int i = 0; i < numberOfDice; i++)
		{
			result += 1 + ((int) Math.floor(Math.random() * numberOfFaces));
		}
		return result + modifier;
	}
	
	public int getNumberOfDice() {
		return numberOfDice;
	}
	
	public int getNumberOfFaces() {
		return numberOfFaces;
	}
}
