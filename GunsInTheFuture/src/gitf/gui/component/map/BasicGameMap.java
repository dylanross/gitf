package gitf.gui.component.map;

import gitf.gui.GridLayout2;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class BasicGameMap extends JPanel implements GameMap
{
	public static final long serialVersionUID = 001;

	private JTextArea output = new JTextArea();				// JTextArea for text output
	
	private String nL = System.getProperty("line.separator");	// the sequence of characters used to 
																// designate a new line on the host's OS

	public BasicGameMap(int width, int height)
	{
		String welcomeMessage = "GITF ALPHA (.00)" + nL + nL + nL + nL + nL + nL + nL + nL + "              " +
								"                               __ 1      1 __        _.xxxxxx" + nL + "              " +
								"                 [xxxxxxxxxxxxxx|##|xxxxxxxx|##|xxxxxxXXXXXXXXX|" + nL + "              " +
								" ____            [XXXXXXXXXXXXXXXXXXXXX/.\\||||||XXXXXXXXXXXXXXX|" + nL + "              " +
								"|::: `-------.-.__[=========---___/::::|::::::|::::||X O^XXXXXX|" + nL + "              " +
								"|::::::::::::|2|%%%%%%%%%%%%\\::::::::::|::::::|::::||X /" + nL + "              " +
								"|::::,-------|_|~~~~~~~~~~~~~`---=====-------------':||  5" + nL + "              " +
								" ~~~~                       |===|:::::|::::::::|::====:\\O" + nL + "              " +
								"                            |===|:::::|:.----.:|:||::||:|" + nL + "              " +
								"                            |=3=|::4::`'::::::`':||__||:|" + nL + "              " +
								"                            |===|:::::::/  ))\\:::`----':/" + nL + "              " +
								"BlasTech Industries'        `===|::::::|  // //~`######b" + nL + "              " +
								"DL-44 Heavy Blaster Pistol      `--------=====/  ######B" + nL + "              " +
								"                                                 `######b" + nL + "              " +
								"1 .......... Sight Adjustments                    #######b" + nL + "              " +
								"2 ............... Stun Setting                    #######B" + nL + "              " +
								"3 ........... Air Cooling Vent                    `#######b" + nL + "              " +
								"4 ................. Power Pack                     #######P" + nL + "              " +
								"5 ... Power Pack Release Lever                     `#####B";
		
		// grid layout - 1 row, 1 column
		GridLayout2 gl = new GridLayout2(1, 1); 
		setLayout(gl);

		// Don't let the user change the output.
		output.setEditable(false);

		// Colour the map
		output.setBackground(Color.DARK_GRAY);
		output.setForeground(Color.LIGHT_GRAY);
		
		// Size the map
		int oWidth = width;
		int oHeight = height;
		output.setPreferredSize(new Dimension(oWidth, oHeight));

		add(output);
		
		output.setText(welcomeMessage);
	}

	public void draw(char[][] tiles, Color[][] colours)
	{
		draw(tiles);
	}	
	
	public void draw(char[][] tiles)
	{
		output.setText("");
		String outputString = "";
		
		for (int i = 0; i < tiles.length; i++)
		{
			outputString += (new String(tiles[i]) + nL);
		}
		
		output.append(outputString);
	}
}