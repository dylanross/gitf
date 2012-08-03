package gitf.system;

import java.util.ArrayList;

import gitf.system.character.Charac;
import gitf.system.character.species.human.HumanCharac;
import gitf.system.game.StandardGame;
import gitf.system.game.victory.Deathmatch;;

/**
 * Main Class of the Guns In The Future game.
 * This is executed on startup.
 * 
 * @author dylanross
 *
 */
public class Run 
{
	private static int numberGames = 1;				// number of games in the simulation
	private static boolean drawGraph = false;		// whether to draw a frequency distribution of game length at the end of the simulation
	private static int numberCharacters = 3;		// the number of characters in the simulation
	
	private static ArrayList<Integer> metrics = new ArrayList<Integer>(0);		// frequency distribution of game lengths
	
	/**
	 * Starts GITF.
	 */
	public static void main(String[] args)
	{
		for (int i = 0; i < 50; i++)
		{
			metrics.add(0);
		}
		
		for (int j = 0; j < numberGames; j++)
		{
			ArrayList<Charac> characters = new ArrayList<Charac>(0);
			
			for (int i = 0; i < numberCharacters; i++)
			{
				characters.add(new HumanCharac());
			}
			
			StandardGame game = new StandardGame(characters);
			game.setVictoryConditions(new Deathmatch(game));
			game.start();
			
			int length = game.getLength();
			if (length < metrics.size())
			{
				metrics.set(length, metrics.get(length) + 1);
			}
		}
		
		if (drawGraph == true)
		{
			drawGraph(metrics);
		}
	}
	
	public static void drawGraph(ArrayList<Integer> input)
	{
		for (int i = 0; i < input.size(); i++)
		{
			System.out.print(i + " : ");
			for (int j = 0; j < input.get(i); j++) System.out.print("=");
			System.out.println();
		}
	}
}