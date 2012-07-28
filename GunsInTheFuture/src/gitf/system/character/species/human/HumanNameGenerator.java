package gitf.system.character.species.human;

import gitf.system.dice.StandardDiceRoll;

public class HumanNameGenerator 
{
	private static String[] firstNameComponents = new String[] { "khan", "tongue", "tom", "special", "delicious", "lovely", "big" };
	private static String[] lastNameComponents = new String[] { "fitz", "gerald", "s", "lark", "bird", "snake", "rattling", "cat" };;
	
	public static String generate()
	{
		String name;
		int numberFirstNameComponents = new StandardDiceRoll(2).roll();
		int numberLastNameComponents = new StandardDiceRoll(2).roll();
		
		String firstName = "";
		for (int i = 0; i < numberFirstNameComponents; i++)
		{
			firstName += firstNameComponents[new StandardDiceRoll(firstNameComponents.length - 1).roll()];
		}
		
		String lastName = "";
		for (int i = 0; i < numberLastNameComponents; i++)
		{
			lastName += lastNameComponents[new StandardDiceRoll(lastNameComponents.length - 1).roll()];
		}
		
		name = firstName + " " + lastName;
		
		return name;
	}
}
