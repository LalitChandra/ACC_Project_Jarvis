package invertedindexing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class InvertedIndexing {
	static ArrayList<String> documents = new ArrayList<String>();
	public static void fileAccessories() {
		HashMap<String, Integer> frequencyofWord = new HashMap<>();
		Scanner scanFile;
		String readWord;
		//read data from folder
		File pathOfFolder = new File("WebPages/");
		for (File fileEntry : pathOfFolder.listFiles())
			documents.add(fileEntry.getName());
		int x=0;
		int frequency;
		while(x<documents.size()) {
			try {
				scanFile = new Scanner(new FileReader("WebPages/"+ documents.get(x)));
			}
			catch(FileNotFoundException e) {
				System.err.println(e);
				return;
			}
			while(scanFile.hasNext()) {
				readWord = scanFile.next();
				scanFile.useDelimiter("[^a-zA-Z]+");
				readWord= readWord.toLowerCase();
				if(frequencyofWord.containsKey(readWord))
					frequency = frequencyofWord.get(readWord)+1;
				else frequency=1;
				frequencyofWord.put(readWord, frequency);
			}
			x++;
		}
	}
}
