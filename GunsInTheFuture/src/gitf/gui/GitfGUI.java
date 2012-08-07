package gitf.gui;

//import java.util.Random;

import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.BorderFactory;

import gitf.gui.component.charactersheet.StandardCharacterSheet;
import gitf.system.map.Area;

public class GitfGUI extends JFrame implements GUI
{
	public static final long serialVersionUID = 001;
	
	public LeftPane leftPane;
	public StandardCharacterSheet characterSheet;
	public AreaToCharMapConverter areaToCharMapConverter;

	public GitfGUI()
	{
		Font font = new Font("Lucida Sans Typewriter", Font.PLAIN, 11);
		
		UIManager.put("Label.foreground", Color.DARK_GRAY);
		UIManager.put("TitledBorder.titleColor", Color.LIGHT_GRAY);
		UIManager.put("Panel.background", Color.DARK_GRAY);
		UIManager.put("TextArea.background", Color.WHITE);
		UIManager.put("TextArea.foreground", Color.DARK_GRAY);
		UIManager.put("TextPane.background", Color.WHITE);
		UIManager.put("TextPane.foreground", Color.DARK_GRAY);
		
		UIManager.put("Button.font", font);
		UIManager.put("ToggleButton.font", font);
		UIManager.put("RadioButton.font", font);
		UIManager.put("CheckBox.font", font);
		UIManager.put("ColorChooser.font", font);
		UIManager.put("ComboBox.font", font);
		UIManager.put("Label.font", font);
		UIManager.put("List.font", font);
		UIManager.put("MenuBar.font", font);
		UIManager.put("MenuItem.font", font);
		UIManager.put("RadioButtonMenuItem.font", font);
		UIManager.put("CheckBoxMenuItem.font", font);
		UIManager.put("Menu.font", font);
		UIManager.put("PopupMenu.font", font);
		UIManager.put("OptionPane.font", font);
		UIManager.put("Panel.font", font);
		UIManager.put("ProgressBar.font", font);
		UIManager.put("ScrollPane.font", font);
		UIManager.put("Viewport.font", font);
		UIManager.put("TabbedPane.font", font);
		UIManager.put("Table.font", font);
		UIManager.put("TableHeader.font", font);
		UIManager.put("TextField.font", font);
		UIManager.put("PasswordField.font", font);
		UIManager.put("TextArea.font", font);
		UIManager.put("TextPane.font", font);
		UIManager.put("EditorPane.font", font);
		UIManager.put("TitledBorder.font", font);
		UIManager.put("ToolBar.font", font);
		UIManager.put("ToolTip.font", font);
		UIManager.put("Tree.font", font);
		
		draw();
	}

	public void draw()
	{
		setTitle("Guns in the Future");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// grid layout - 1 row, 2 columns
		GridLayout2 gl = new GridLayout2(1, 2); 
		setLayout(gl);
		
		int windowWidth = 1024;
		int windowHeight = 760;
		
		// set size of frame
		setSize(windowWidth, windowHeight);

		int lpWidth = (windowWidth / 3) * 2;
		int lpHeight = windowHeight;
		leftPane = new LeftPane(lpWidth, lpHeight);
		leftPane.setPreferredSize(new Dimension(lpWidth, lpHeight));
		leftPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(leftPane);
		
		int csWidth = windowWidth / 3;
		int csHeight = windowHeight;
		characterSheet = new StandardCharacterSheet();
		characterSheet.setPreferredSize(new Dimension(csWidth, csHeight));
		add(characterSheet);

		// set to be visible
		setVisible(true);

		// set to not be resizeable
		setResizable(false);
		
		// leftPane.getMap().write("GitF alpha (0.00) \nMap non-functional");
	}
	
	public void printMap(Area[][] visibleAreas)
	{
		leftPane.printMap(areaToCharMapConverter.getChar(visibleAreas), areaToCharMapConverter.getColor(visibleAreas));
	}
	
	public void println(String content)
	{
		leftPane.println(content);
	}
	
	public void printCharacterSheet(String characterSheetString)
	{
		characterSheet.print(characterSheetString);
	}
	
	public String getln()
	{
		return leftPane.getln();
	}
	
	/*private void randomDrawMap()
	{
		char[][] chars = new char[35][97];
		for (int i = 0; i < chars.length; i++)
		{
			for (int j = 0; j < chars[i].length; j++)
			{
				Random r = new Random();
				char c = (char)(r.nextInt(26) + 'a');
				chars[i][j] = c;
			}
		}
		leftPane.map.draw(chars);
	}*/
}