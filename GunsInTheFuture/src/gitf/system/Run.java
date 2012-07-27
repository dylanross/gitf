package gitf.system;

import gitf.system.character.species.human.HumanCharac;
import gitf.system.action.standard.StandardAttack;
import gitf.system.item.standard.ccweapon.StandardSword;

public class Run 
{
	public static void main(String[] args)
	{
		HumanCharac attacker = new HumanCharac();
		HumanCharac defender = new HumanCharac();
		StandardSword sword = new StandardSword();
		
		StandardAttack attack = new StandardAttack();
		attack.execute(attacker, defender, sword);
		System.out.println(attack.report());
	}
}
