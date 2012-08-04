package gitf.system.map;

/**
 * A Class for determining the distance between two objects in an N-dimensional Euclidean space.
 * 
 * @author dylanross
 *
 */
public class EuclideanGeometry
{
	public static int calculateDistance(int[] firstCoords, int[] secondCoords)
	{
		double[] firstCoordsDouble = new double[firstCoords.length];
		double[] secondCoordsDouble = new double[secondCoords.length];
		
		for (int i = 0; i < firstCoordsDouble.length; i++)
		{
			firstCoordsDouble[i] = firstCoords[i];
		}
		
		for (int i = 0; i < secondCoordsDouble.length; i++)
		{
			secondCoordsDouble[i] = secondCoords[i];
		}
		
		int result;
		
		try
		{
			result = (int) calculateDistance(firstCoordsDouble, secondCoordsDouble);
		}
		catch (Exception e)
		{
			result = Integer.MAX_VALUE;
		}
		
		return result;
	}
	
	/**
	 * Returns the euclidean distance between two sets of coordinates in an N-dimensional Euclidean space.
	 * Both sets of coordinates must contain the same number of dimensions.
	 */
	public static double calculateDistance(double[] firstCoords, double[] secondCoords) throws Exception
	{
		if (firstCoords.length == secondCoords.length) 										// check both sets of coordinates have same number of dimensions
		{
			double[] terms = subtract(firstCoords, secondCoords); 			// subtract coordinates
			
			for (int i = 0; i < terms.length; i++) 													// count through subtracted coordinates
			{
				terms[i] = Math.pow(terms[i], 2); 														// square each term
			}
			
			double summedTerms = 0.00; 																			// create variable to hold sum of terms
			
			for (int i = 0; i < terms.length; i++) 													// count through squared terms
			{
				summedTerms += terms[i]; 																			// add to sum of previous terms
			}
			
			return Math.sqrt(summedTerms);
		}
		else
		{
			throw new Exception("Number of dimensions mismatch : " + firstCoords.length + ", " + secondCoords.length);
		}
	}
	
	/**
	 * Subtracts one array from another.
	 */
	public static double[] subtract(double[] first, double[] second) throws Exception
	{
		if (first.length != second.length)
		{
			throw new Exception("Can't mismatch array lengths.");
		}
		else
		{
			double[] result = new double[first.length];
			
			for (int i = 0; i < first.length; i++)
			{
				result[i] = first[i] - second[i];
			}
			
			return result;
		}
	}
}
