package gitf.system;

import java.util.ArrayList;

import gitf.system.action.NewTurn;
import gitf.system.action.standard.StandardAttack;
import gitf.system.character.species.human.HumanCharac;
import gitf.system.item.standard.ccweapon.StandardSword;
import gitf.system.character.status.Status;
import gitf.system.game.StandardGame;

public class Run 
{
	public static void main(String[] args)
	{
		new StandardGame().start();
		
		HumanCharac attacker = new HumanCharac();
		HumanCharac defender = new HumanCharac();
		StandardSword attackerSword = new StandardSword();
		StandardSword defenderSword = new StandardSword();
		defender.getEquipped().add(defenderSword);
		
		for (int i = 0; i < 7; i++)
		{
			new NewTurn().execute(attacker);
			StandardAttack attack = new StandardAttack();
			attack.execute(attacker, defender, attackerSword);
			new NewTurn().execute(defender);
			
			System.out.println("-----------------STATUS-----------------");
			System.out.println(defender.getHealth().report());
			ArrayList<Status> status = defender.getStatus();
			for (int j = 0; j < status.size(); j++)
			{
				System.out.println(status.get(j).getName());
			}
			System.out.println("----------------------------------------");
		}
	}
}