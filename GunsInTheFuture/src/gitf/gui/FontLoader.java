package gitf.gui;

import java.io.File;
import java.awt.Font;

/**
 * Class for loading the custom monospaced font used in the GUI.
 * 
 * @author dylanross
 *
 */
public class FontLoader 
{
	private static String filepath = "lib/Perfect DOS VGA 437.ttf";				// the filepath for the font file
	
	/**
	 * Load the font and return it as a Font.
	 * 
	 * @return
	 */
	public static Font load()
	{
		File fontfile = new File(filepath);								// create File object for filepath
		Font font;														// create Font object to hold font
		try
		{
			font = Font.createFont(Font.TRUETYPE_FONT, fontfile);		// try to convert the font file to Font
			font = font.deriveFont(16);									// set to size 16
		}
		catch (Exception e)												// if the font couldn't be loaded
		{
			font = new Font("Monospaced", 0, 16);						// set font to standard Monospaced font
		}
		return font;													// return the loaded Font
	}
}
