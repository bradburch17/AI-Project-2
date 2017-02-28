/**
 * Driver class for Project 2 in CSC330 Artificial Intelligence at DePauw University. 
 * Contains code to read in file for generic algorithm 
 * 
 * Created 2-24-2017
 * @author Brad Burch and Katherine Martin  
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args)
	{
		String fileName = new String();
		Scanner reader = new Scanner(System.in);
		String puzzle = new String();
		
		System.out.println("This program is used to solve a mathematical equation with a generic algorithm.");

		System.out.print("Please enter a file you would like to solve: ");
		fileName = reader.nextLine();
		
		try
		{
			File file = new File (fileName);
			Scanner scanner = new Scanner(file);
			
			System.out.println("Initial state loaded:");
			while (scanner.hasNext())
			{
				puzzle = scanner.next();
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Unable to open the file " + fileName + ".");
		}
		catch(IOException e)
		{
			System.out.println("Could not read from " + fileName + ".");
		}
	}
}
