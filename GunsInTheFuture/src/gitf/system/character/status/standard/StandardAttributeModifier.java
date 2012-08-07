package gitf.system.character.status.standard;

import gitf.system.action.responder.IgnoreResponder;
import gitf.system.character.Charac;
import gitf.system.character.Attributes.AttributeName;
import gitf.system.character.status.AttributeModifier;

public class StandardAttributeModifier extends IgnoreResponder implements AttributeModifier
{
	private String name = "Attribute Modifier";
	private Charac owner;
	
	private AttributeName attributeName; 
	private int modifier;
	private String signedModifier;
	
	public StandardAttributeModifier(Charac owner, AttributeName attributeName, int modifier)
	{
		this.owner = owner;
		this.attributeName = attributeName;
		this.modifier = modifier;
		
		signedModifier = getSignedModifier(modifier);
		name = attributeName.toShortHand() + " " + signedModifier;
	}
	
	public void addToOwner() {
		int currentValue = owner.getAttributes().getAttribute(attributeName);
		owner.getAttributes().setAttribute(attributeName, currentValue + modifier);
		owner.getStatus().add(this);
	}
	
	public void removeFromOwner() {
		int currentValue = owner.getAttributes().getAttribute(attributeName);
		owner.getAttributes().setAttribute(attributeName, currentValue - modifier);
		owner.getStatus().remove(this);
	}
	
	private String getSignedModifier(int modifier)
	{
		if (modifier < 0) return "" + modifier;
		if (modifier >= 0) return "+" + modifier;
		return null;
	}
	
	public String toString() {
		return name;
	}
	
	public String getName() {
		return name;
	}
	public Charac getOwner() {
		return owner;
	}
	
	public AttributeName getAttributeName() {
		return attributeName;
	}
	public int getModifier() {
		return modifier;
	}
}