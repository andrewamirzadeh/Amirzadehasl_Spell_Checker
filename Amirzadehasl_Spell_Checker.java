import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Amirzadehasl_Spell_Checker {
	// create scanner
	static Scanner input = new Scanner(System.in);

	static void printMenu() {
		// C:\Users\andre\Downloads\testStates.txt
		// C:\Users\andre\Downloads\dictionary.txt

		// create arraylists to store collection of words from testfile to correctfile
		ArrayList<String> listFile1 = new ArrayList<>();
		ArrayList<String> listFile2 = new ArrayList<>();

		// loop to get acceptable input file from user
		while (true) {
			try {

				System.out.println("Please enter a file in order to be spell checked: ");
				String filename = input.nextLine();
				File inputFile = new File(filename);
				Scanner reader = new Scanner(inputFile);
				// adding the text from user file into the array list
				while (reader.hasNext()) {
					listFile1.add(reader.nextLine());
				}
				break;
			} catch (FileNotFoundException e) {
				System.out.println("File not found!");
				continue;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Something else happened");
				continue;
			}
		}

		while (true) {
			try {
				System.out.println("Please enter a file to test against the first file for spelling errors: ");
				String filename2 = input.nextLine();
				File inputFile2 = new File(filename2);
				Scanner reader2 = new Scanner(inputFile2);

				while (reader2.hasNext()) {
					listFile2.add(reader2.nextLine());
				}
				break;
			} catch (FileNotFoundException e) {
				System.out.println("File not found!");
				continue;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Something else happened!");
				continue;
			}
		}
		//first for loop i wrote that compares indexes side by side
		// there will be problems if list lengths are different 
		//so I wrote a nested for loop below that checks the first file index against all indexes of the dictionary 
		
/*
		for (int i = 0; i < listFile1.size(); i++) {

			if (!listFile1.get(i).equalsIgnoreCase(listFile2.get(i))) {

				System.out.println(
						listFile1.get(i) + " is not a correct word." + " Did you mean: " + listFile2.get(i) + "?");
				System.out.println();
			}

		}
*/
		for (int i = 0; i < listFile1.size(); i++) {
			int count = 0;
			for (int j = 0; j < listFile2.size(); j++) {
				
				if (listFile1.get(i).equalsIgnoreCase(listFile2.get(j))) {
					count++;
				}
				
			}
			if (count == 0) {
				System.out.println(listFile1.get(i) + " is not a word.");
			}
		}
	}

}
