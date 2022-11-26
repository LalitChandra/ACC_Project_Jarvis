package pageranking;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PageRanking {
	public Map<String, Integer> calculatePageRank(String input) throws IOException {
		Map<String, Integer> pageRankMap = new HashMap<String, Integer>();
		Hashtable<String, Integer> pageMatchCount = new Hashtable<>();
		File pathOfFolder = new File("WebPages/");
		String files[] = pathOfFolder.list();
		int i=0;
		while(i<files.length)
		{
			String file = files[i];
			String filePath = "WebPages/"+file;
			byte[] readingBytes = Files.readAllBytes(Paths.get(filePath));
			String text= new String(readingBytes, StandardCharsets.US_ASCII);
			Pattern patternObject = Pattern.compile(input);
			Matcher matcherObject = patternObject.matcher(text);
			while(matcherObject.find()) pageMatchCount.merge(file, 1, Integer::sum);
			i++;
		}
		if(pageMatchCount.size()!=0) {
			pageRankMap = pageMatchCount.entrySet().stream().limit(1)
					.sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).collect(Collectors
							.toMap(Map.Entry::getKey, Map.Entry::getValue, (m1, m2) -> m1, LinkedHashMap::new));
			
		}
		
		return pageRankMap;
	}
}
