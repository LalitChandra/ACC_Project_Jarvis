package pageranking;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PageRanking {
	// method for calculating the page rank
	public static void calculatePageRank(String input) throws IOException {

		// final map storing the data - text file name as key and rank frequency as
		// value
		Map<String, Integer> pageRankMap = new HashMap<String, Integer>();
		
		Hashtable<String, Integer> pageMatchCount = new Hashtable<>();
		//String variable holding the directory
		String currentDirectory = System.getProperty("user.dir");
		//String variable holding the text path location in current directory
		String textLocation = currentDirectory + "\\W3C Web Pages\\text\\";
		//File object for accessing the text files
		File pathOfFolder = new File(textLocation);
		// String files[] = pathOfFolder.list();
		//File array holding the list of files from the pathOfFolder
		File[] files = pathOfFolder.listFiles();

		// loop for accessing the files
		for (File f : files) {
			//extracting name of the file
			String file = f.getName();
			// System.out.println(f.getAbsolutePath());
			//extracting the entire path of the file
			String filePath = f.getAbsolutePath();
			//byte array holding the texts
			byte[] readingBytes = Files.readAllBytes(Paths.get(filePath));
			//extracting the entire text
			String text = new String(readingBytes, StandardCharsets.US_ASCII);
			//assigning the pattern based on the input word
			Pattern patternObject = Pattern.compile(input);
			//getting all the positions of the matcher
			Matcher matcherObject = patternObject.matcher(text);
			//iterting through all the matches
			while (matcherObject.find())
				//summing the count and adding it to pageMatchCount
				pageMatchCount.merge(file, 1, Integer::sum);
		}
		/*
		 * for(Map.Entry<String, Integer> entry: pageMatchCount.entrySet()) {
		 * System.out.println(entry.getKey()+": "+entry.getValue()); }
		 */
		/*
		 * int i=0; while(i<files.length) { String file = files[i]; String filePath =
		 * "C:\\Users\\david\\Desktop\\WebCrawlerProject-main\\Hoa_To_part\\text\\"+
		 * file; byte[] readingBytes = Files.readAllBytes(Paths.get(filePath)); String
		 * text= new String(readingBytes, StandardCharsets.US_ASCII); Pattern
		 * patternObject = Pattern.compile(input); Matcher matcherObject =
		 * patternObject.matcher(text); while(matcherObject.find())
		 * pageMatchCount.merge(file, 1, Integer::sum); i++; }
		 */
		
		//adding the pagematchcount to list for sorting
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(pageMatchCount.entrySet());
		//sorting the list in decreasing order
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});
		int i = 10;
		//printing the top 10 pages
		for (Map.Entry<String, Integer> e : list) {
			if (i == 0)
				break;
			System.out.println(e.getKey() + ": " + e.getValue());
			i--;
		}
		//adding the list to return Map
		// pageRankMap = list.addAll(list)
		for (Map.Entry<String, Integer> r : list) {
			pageRankMap.put(r.getKey(), r.getValue());
			// System.out.println(r.getKey()+": "+r.getValue());

		}
		/*
		 * for(Map.Entry<String, Integer> rank: pageRankMap.entrySet()) { if(i ==0)
		 * break; System.out.println(rank.getKey()+": "+rank.getValue()); i--; }
		 */
		System.out.println(pageRankMap);
//		return pageRankMap;
		/*
		 * if(pageMatchCount.size()!=0) { pageRankMap =
		 * pageMatchCount.entrySet().stream().limit(1) .sorted(Map.Entry.<String,
		 * Integer>comparingByValue().reversed()).collect(Collectors
		 * .toMap(Map.Entry::getKey, Map.Entry::getValue, (m1, m2) -> m1,
		 * LinkedHashMap::new));
		 * 
		 * }
		 * 
		 * return pageRankMap;
		 */
	}
	//main method for accessing the pageranking class
	public static void main(String[] args) throws IOException {
		calculatePageRank("the");

	}
}
