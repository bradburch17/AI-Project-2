/**
 * Equation class handles forming the equation from the text file. 
 * 
 * @author Brad Burch & Katherine Martin 
 * Created 3-3-2017
 */

import java.util.ArrayList;

public class Equation {
	
	//Solves the function one individual at a time with the parameter of the grid and one individual
	public static int solveFunction(int[][] grid, Individual individual)
	{
		ArrayList<Integer> functionList = new ArrayList<Integer>();
		int count = 0;

		//Go through the grid 
		for(int i = 0; i < grid.length; i++)
		{
			
			for(int j = count; j < grid.length; j++)
			{
				//Checks if the grid is in 0, 0 and then adds it to the arraylist
				if (i == 0 && j == 0)
				{
					functionList.add(grid[i][j]);
				}
				//Checks to see if i is 0 and then checks for the correct position in the binary string
				else if (i == 0)
				{	
					//Used to check the position in the binary string to the j position 
					for (int x = 0; x <= (j * 8); x += 8)
					{
						//Finds the starting point of Xj
						if (x == (((j-1) * 8))) //This should be checking if it is in the correct starting spot in the binary string
						{
							String s = individual.getBinary(x);
							int d = Integer.parseInt(s, 2); 
							functionList.add(grid[i][j] * d);
							break;
						}
					}
				}
				//Checks to see if j is 0 and then checks for the correct position in the binary string
				else if (j == 0)
				{
					//Used to check the position in the binary string to the i position
					for (int x = 0; x <= (i * 8); x+=8)
					{
						//Finds the starting point of Xi
						if (x == (((i - 1) * 8)))
						{
							String s = individual.getBinary(x);
							int d = Integer.parseInt(s, 2);
							functionList.add(grid[i][j] * d);
							break;
						}
					}
				}
				//Every other case
				else 
				{		
					int var = 0; 
					int var1 = 0;
					//Used to check the position in the binary string to the j position 
					for (int x = 0; x <= (j * 8); x+=8)
					{
						
						if (x == (((j - 1) * 8)))
						{
							String s = individual.getBinary(x);
							var = Integer.parseInt(s, 2);
							break;
						}
					}
					
					//Used to check the position in the binary string to the i position
					for (int x = 0; x <= (i * 8); x += 8)
					{
						if (x == (((i - 1) * 8)))
						{
							String s = individual.getBinary(x);
							var1 = Integer.parseInt(s, 2);
							break;
						}
					}
					functionList.add(grid[i][j] * var * var1);
				}
			}
			count++;
		}
		return addArrayList(functionList);
	}
	
	//Adds everything in the arraylist together to complete the equation and returns the total
	public static int addArrayList(ArrayList<Integer> arraylist)
	{
		int total = 0;
		for(int i = 0; i < arraylist.size(); i++)
		{
			total += arraylist.get(i);
		}

		return total;
	}
}
