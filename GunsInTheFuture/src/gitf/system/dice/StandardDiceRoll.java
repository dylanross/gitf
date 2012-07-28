package gitf.system.dice;

import java.lang.Math;
import java.util.ArrayList;

public class StandardDiceRoll implements DiceRoll
{
	private int numberOfDice;
	private int numberOfFaces;
	private int modifier;
	
	private int summedResult;
	private ArrayList<Integer> componentResults;
	
	/**
	 * 1 argument constructor. Rolls a single die with no modifier,
	 * with the number of faces specified.
	 */
	public StandardDiceRoll(int numberOfFaces)
	{
		this(1, numberOfFaces, 0);
	}
	
	public StandardDiceRoll(int numberOfDice, int numberOfFaces)
	{
		this.numberOfDice = numberOfDice;
		this.numberOfFaces = numberOfFaces;
		this.modifier = 0;
	}
	
	public StandardDiceRoll(int numberOfDice, int numberOfFaces, int modifier)
	{
		this(numberOfDice, numberOfFaces);
		this.modifier = modifier;
	}
	
	public int roll() 
	{
		summedResult = 0;
		componentResults = new ArrayList<Integer>(0);
		for (int i = 0; i < numberOfDice; i++)
		{
			int diceResult = 1 + ((int) Math.floor(Math.random() * numberOfFaces));
			summedResult += diceResult;
			componentResults.add(diceResult);
		}
		summedResult += modifier;
		return summedResult;
	}
	
	public void addModifierToComponents()
	{
		summedResult = 0;
		for (int i = 0; i < componentResults.size(); i++)
		{
			Integer currentResult = componentResults.get(i) + modifier;
			componentResults.set(i, currentResult);
			summedResult += currentResult;
		}
	}
	
	public int getNumberOfDice() {
		return numberOfDice;
	}
	
	public int getNumberOfFaces() {
		return numberOfFaces;
	}
	
	public int getResult() {
		return summedResult;
	}
	
	public ArrayList<Integer> getComponentResults() {
		return componentResults;
	}
}
