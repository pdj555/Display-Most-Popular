import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/** This program will take a file name, read in data in the file, and fine the line that occurred
 * most frequently (not considering case).
 * 
 * @author Deborah A. Trytten and prestonjones
 * @version 1.0
 *
 */
public class Project8
{
	/** Read in a file name from the user. The file should contain the names of movies, one
	 * to a line. These names will be converted to lower case, sorted, and the most common movie
	 * name found and reported to the user.
	 * 
	 * @param args There are no command line arguments.
	 * @throws FileNotFoundException If the file name the user enters is not stored in the appropriate
	 * project directory.
	 */
	
	public static String FILENAME = "movie-test1.txt";
	
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner keyboard = new Scanner(System.in);
		
		// Ask/read in the file that the user wants to use
		System.out.println("Enter a file name: ");
		FILENAME = keyboard.nextLine();
		
		// Construct a perfect array that contains the information in the given file
		String[] readFileDone = readFile(FILENAME);
		
		// Make the array consistent so it can be sorted
		String[] lowercaseDone = lowercase(readFileDone);
		
		// Sort and find that most frequent string in the data
		String mostFrequent = findMostFrequent(lowercaseDone);
		System.out.println("Most popular movie: " + mostFrequent);
		
		
		
		keyboard.close();
	}

	/** Read the contents of a file into an array. The size of the array will be determined by the
	 * number of lines in the file.
	 * 
	 * @param filename The name of the file that contains the data.
	 * @return An array that contains the contents of the file, one line to an array element.
	 * @throws FileNotFoundException If the given file name does not exist in the project directory.
	 */
	public static String[] readFile(String FILENAME) throws FileNotFoundException
	{
		int count = 0;
		Scanner file = new Scanner(new File(FILENAME));
		
		while (file.hasNextLine())
		{
			file.nextLine();
			++count;
		}
		file.close();
		
		Scanner file2 = new Scanner(new File(FILENAME));
		
		String[] listMovies = new String[count];
		
		for (int index = 0; index < count; ++index)
		{
			listMovies[index] = file2.nextLine();
		}
		
		file2.close();
		
		
		return listMovies; // A stub--remember to change this
	}

	/** Convert each line in an array of Strings to lower case.
	 * 
	 * @param array The array to be converted. The contents of this array, but not its location in the heap
	 * will be modified by this method.
	 */
	public static String[] lowercase(String[] array)
	{
		String[] temp = new String[array.length];
		
		for (int i = 0; i < array.length; ++i)
		{
			temp[i] = array[i].toLowerCase();
		}
		
		return temp;
	}

	/** Find the line in the array that occurs most frequently. The array contents will be modified by this method.
	 * 
	 * @param array An array that contains movie titles.
	 * @return The most commonly occurring line in the array.
	 */
	public static String findMostFrequent(String[] array)
	{
		Arrays.sort(array);
		
		int count = 0;
		int max = 0;
		int numMovies = 1;
		String maxMovie = "null";
		String movieHolder = "null";
		
		
		for (count = 0; count < array.length; ++count)
		{
			if (!array[count].equals(movieHolder))
			{
				movieHolder = array[count];
				numMovies = 1;
			}
			else if (array[count].equals(movieHolder))
			{
				++numMovies;
			}
			if (numMovies > max)
			{
				max = numMovies;
				maxMovie = array[count];
			}
		}
		
		return maxMovie; // A stub--remember to change this
	}
}