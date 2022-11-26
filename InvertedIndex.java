package Project;

import java.util.*;
import java.io.*;

public class InvertedIndex {
	static ArrayList<String> documents = new ArrayList<String>();
	@SuppressWarnings("null")
	public static void readFile() {
		HashMap<String, List<Integer>> occurencesOfWord = new HashMap<String, List<Integer>>();
		HashMap<String, HashMap<String, List<Integer>>> resultMap = new HashMap<String, HashMap<String, List<Integer>>>();
		Scanner scanFile;
		String readWord;
		//read data from folder
		File pathOfFolder = new File("WebPages/");
		for (File fileEntry : pathOfFolder.listFiles())
			documents.add(fileEntry.getName());
		int x=0;
		int frequency;
		List<Integer> occurencesList = null;
//		HashMap<String, HashMap<List<Integer>, Integer>> resultSubMap;
		while(x<documents.size()) {
			
			try {
				scanFile = new Scanner(new FileReader("WebPages/"+ documents.get(x)));
			}
			catch(FileNotFoundException e) {
				System.err.println(e);
				return;
			}
			List<Integer> list = new ArrayList<Integer>();
			int i=0;
			while(scanFile.hasNext()) {
				readWord = scanFile.next();
				scanFile.useDelimiter("[^a-zA-Z]+");
				readWord= readWord.toLowerCase();
				i = i+readWord.length();
				if(occurencesOfWord.containsKey(readWord)) {
					occurencesList = occurencesOfWord.get(readWord);
					occurencesList.add(i);
				}
					
				else { 
					occurencesList = new ArrayList<Integer>();
					occurencesList.add(i);
					}
				occurencesOfWord.put(readWord, occurencesList);
				occurencesList = new ArrayList<Integer>();
			}
			resultMap.put(documents.get(x), occurencesOfWord);
			System.out.println(documents.get(x));
//			System.out.println(resultMap);
			occurencesOfWord = new HashMap<String, List<Integer>>();
			x++;
		}
		
		
	}
	public static void main(String[] args) {
		readFile();
	}

}
