package gitf.gui;

import java.io.File;
import java.awt.Font;

public class FontLoader 
{
	private static String filepath = "lib/Perfect DOS VGA 437.ttf";
	
	public static Font load()
	{
		File fontfile = new File(filepath);
		Font font;
		try
		{
			font = Font.createFont(Font.TRUETYPE_FONT, fontfile);
			font = font.deriveFont(16);
		}
		catch (Exception e)
		{
			font = new Font("Monospaced", 0, 16);
		}
		return font;
	}
}
