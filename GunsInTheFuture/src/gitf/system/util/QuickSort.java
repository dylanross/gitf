package gitf.system.util;

import java.util.List;

import gitf.system.character.Charac;

public class QuickSort 
{ 	
	public static <T extends Charac> List<T> sort(List<T> input)
	{
		if (input == null || input.size() == 0) 
		{
			return null;
		}
		else
		{
			return sort(input, 0, input.size() - 1);
		}
	}
	
	private static <T extends Charac> List<T> sort(List<T> input, int low, int high) 
	{
		int i = low;
		int j = high;
		int pivot = input.get(low + ((high - low) / 2)).getAttributes().getAwareness();
		
		while (i <= j)
		{
			while (input.get(i).getAttributes().getAwareness() > pivot) i++;
			while (input.get(j).getAttributes().getAwareness() < pivot) j--;
			
			if (i <= j)
			{
				exchange(input, i, j);
				i++;
				j--;
			}
		}
		if (low < j) sort(input, low, j);
		if (i < high) sort(input, i, high);
		
		return input;
	}
	
	public static <T extends Charac> void exchange(List<T> input, int i, int j) 
	{
		T temp = input.get(i);
		input.set(i, input.get(j));
		input.set(j, temp);
	}
}
