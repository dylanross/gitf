package gitf.gui.component.charactersheet;

import gitf.gui.GridLayout2;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class StandardCharacterSheet extends JPanel implements CharacterSheet
{
	public static final long serialVersionUID = 001;
	
	private String nL = System.getProperty("line.separator");		// the sequence of characters used to 
																	// designate a new line on the host's OS

	private JTextArea output = new JTextArea(5, 15);				// JTextArea for text output

	public StandardCharacterSheet()
	{  
		// grid layout - 1 row, 1 column
		GridLayout2 gl = new GridLayout2(1, 1); 
		setLayout(gl);

		// Don't let the user change the output.
		output.setEditable(false);

		// Add all the widgets to the applet
		add(output);
	}
	
	public void print(String characterSheet)
	{
		output.setText("");
		output.append(characterSheet);
	}
}