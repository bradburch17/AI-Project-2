import java.util.ArrayList;

public class Equation {

	private Driver driver = new Driver();
	private int variable = driver.getVariables();
	private int[][] xValues = driver.getCoefficients();
	private static ArrayList<Integer> arraylist = new ArrayList<Integer>();
	
	//TODO: NEED TO AVOID REPEATS
	//Solves the function one individual at a time with the parameter of the grid and one individual
	public static int solveFunction(int[][] grid, Individual individual)
	{
		//Go through the grid 
		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid.length; j++)
			{
				//Checks if the grid is in 0, 0 and then adds it to the arraylist
				if (i == 0 && j == 0)
				{
					arraylist.add(grid[i][j]);
				}
				//Checks to see if i is 0 and then 
				else if (i == 0)
				{	
					//Used to check the position in the binary string to the j position 
					for (int x = 0; x <= (j * 8); x++)
					{
						//Finds the starting point of Xj
						if (x == (((j-1) * 8) + 1)) //This should be checking if it is in the correct starting spot in the binary string
						{
							String s = individual.getBinary(j);
							int d = Integer.parseInt(s, 2);
							int q = grid[i][j] * d;
							arraylist.add(q);
						}
					}
				}
				//Checks to see if j is 0 and then 
				else if (j == 0)
				{
					//Used to check the position in the binary string to the i position
					for (int x = 0; x <= (i * 8); x++)
					{
						//Finds the starting point of Xi
						if (x == (((i-1) * 8) + 1))
						{
							String s = individual.getBinary(i);
							int d = Integer.parseInt(s, 2);
							int q  = grid[i][j] * d;
							arraylist.add(q);
						}
					}
				}
				//Every other case
				else 
				{		
					int var = -10000000; //Needed to initialize to something that would be obvious if wrong
					int var1 = -1000000;
					//Used to check the position in the binary string to the j position 
					for (int x = 0; x <= (j*8); x++)
					{
						if (x == (((j-1) * 8) + 1))
						{
							String s = individual.getBinary(j);
							var = Integer.parseInt(s, 2);
						}
					}
					
					//Used to check the position in the binary string to the i position
					for (int x = 0; x <= (i*8); x++)
					{
						if (x == (((i-1) * 8) + 1))
						{
							String s = individual.getBinary(i);
							var1 = Integer.parseInt(s, 2);
						}
					}
					int q = grid[i][j] * var * var1;
					arraylist.add(q);
				}
			}
		}
		return addArrayList();
	}
	
	//Adds everything in the arraylist together to complete the equation and returns the total
	public static int addArrayList()
	{
		int total = 0;
		for(int i = 0; i < arraylist.size(); i++)
		{
			total += arraylist.get(i);
		}
		
		return total;
	}
}
