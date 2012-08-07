package gitf.system.character.species.human;

import gitf.system.character.Charac;
import gitf.system.character.CharacterSheetGenerator;

public class HumanCharacterSheetGenerator implements CharacterSheetGenerator
{
	private String nL = System.getProperty("line.separator");	// the sequence of characters used to 
																// designate a new line on the host's OS
	
	public HumanCharacterSheetGenerator()
	{
		
	}
	
	public String buildCharacterSheet(Charac charac)
	{
		String characterSheet = "";
		characterSheet += "--- GENERAL INFORMATION" + nL;
		characterSheet += "Name : " + charac.getName() + nL;
		characterSheet += "Player : " + charac.getPlayer().getName() + nL;
		
		characterSheet += "--- ATTRIBUTES" + nL;
		characterSheet += charac.getAttributes().report() + nL;
		
		characterSheet += "--- HEALTH" + nL;
		characterSheet += charac.getHealth().report() + nL;
		
		characterSheet += "--- STATUS" + nL;
		characterSheet += charac.getStatus().report() + nL;
		
		characterSheet += "--- EQUIPPED" + nL;
		characterSheet += charac.getEquipped().report() + nL;
		
		characterSheet += "--- INVENTORY" + nL;
		characterSheet += charac.getInventory().report() + nL;
		
		return characterSheet;
	}
}
