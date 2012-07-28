package gitf.system.character.status;

import gitf.system.character.Attributes.AttributeName;

public interface AttributeModifier extends Status
{
	public AttributeName getAttributeName();
	public int getModifier();
}