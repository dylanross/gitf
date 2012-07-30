package gitf.gui;

/**
 * Interface defining a terminal- or console- style GUI.
 * 
 * @author dylanross
 *
 */
public interface PromptInterface 
{
	/**
	 * For drawing text to the prompt's output.
	 */
	public void print();
	public void println();
	
	/**
	 * Wait for user to input, then return the input.
	 */
	public String getNextInput();
	
	/**
	 * For configuring the prompt.
	 */
	public boolean isInputEcho();
	public void setInputEcho(boolean echo);
}
