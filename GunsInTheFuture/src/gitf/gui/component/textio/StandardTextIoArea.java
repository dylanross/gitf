package gitf.gui.component.textio;

import gitf.gui.GridLayout2;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.text.Document;
import javax.swing.text.BadLocationException;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StandardTextIoArea extends JPanel implements TextIoArea
{  
	public static final long serialVersionUID = 001;
	
	private String nL = System.getProperty("line.separator");	// the sequence of characters used to 
																// designate a new line on the host's OS
	
	private JTextField input = new JTextField(10);			// JTextField for text input
	private JTextPane output = new JTextPane();				// JTextArea for text output

	public StandardTextIoArea(int width, int height)
	{  
		// grid layout - 2 rows, 1 column
		GridLayout2 gl = new GridLayout2(2, 1); 
		setLayout(gl);
		
		// Register a listener with the textfield
		TextFieldListener tfListener = new TextFieldListener();
		input.addActionListener(tfListener);

		// Don't let the user change the output.
		output.setEditable(false);
		
		// Size the widgets
		int oWidth = width - 2000;
		int oHeight = (height / 10) * 9;
		output.setPreferredSize(new Dimension(oWidth, oHeight));
		input.setPreferredSize(new Dimension(width, (height / 10)));

		// Add all the widgets to the applet
		JScrollPane outputScrollPane = new JScrollPane(output);
		outputScrollPane.setPreferredSize(new Dimension(width, oHeight));
		add(outputScrollPane);
		add(input);
		input.requestFocus();        // start with focus on this field
	}

	// The listener for the textfield.
	private class TextFieldListener implements ActionListener
	{  
		public void actionPerformed(ActionEvent evt)
		{ 
			String inputString = input.getText();
			outputAppend(inputString + "\n");
			input.setText("");
		}
	}
	
	public void outputAppend(String s) 
	{
		int bufferSize = 10000;
		
		Document doc = output.getDocument();
		int overLength = doc.getLength() + s.length() - bufferSize;

		try 
		{
			if (overLength > 0)
			{
				doc.remove(0, overLength);
			}
			
			doc.insertString(doc.getLength(), s, null);
		} 
		catch(BadLocationException exc) 
		{
			exc.printStackTrace();
		}
		output.setCaretPosition(output.getDocument().getLength());
	}

	public String getln()
	{
		return null;
	}
	
	public void println(String content)
	{
		outputAppend(content + nL);
	}
}