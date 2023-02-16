/**
 * Assigment01 - Movie Tags
 *
 * @author Maxwell Lubarsky 2/20/23
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Assignment01 {
	
	/**
     * Read and print the contents of the tags.csv file
     * @param file -> Pass in the tags.csv file
     * @return values -> List that contains each line of the file read
     */ 
	public static List<String> readFile (String file) {
		Path p2 = Path.of(file);
		List<String> values = new ArrayList<String>();
		
	    try (BufferedReader reader = Files.newBufferedReader(p2, StandardCharsets.UTF_8)) {
	    	String currentLine = null; //while there is content on the current line
	    	System.out.println("Reading the data file...");
	        while ((currentLine = reader.readLine()) != null) {
	            //System.out.println(currentLine); //print the current line
	            values.add(currentLine);
	        }
	        reader.close();
	    } catch (IOException ex) { //handle an exception here
	        ex.printStackTrace(); 
	    }	
	    System.out.println("Successfully read the file!");
	    return values;
	}
	
	/**
     * Read and print the contents of the tags.csv file
     * @param tags -> Pass in the read contents of the tags.csv file
     * @return Void -> 
     */ 
	public static void popularTags(List<String> tags) {
		// Create a map to count the frequency of each word
		Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : tags) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        // Sort the map by frequency in descending order
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());
        entryList.sort(Map.Entry.<String, Integer>comparingByValue().reversed());

        // Print the top 3 most occurred words
        System.out.println("Top 3 most occurred words:");
        for (int i = 0; i < 3 && i < entryList.size(); i++) {
            Map.Entry<String, Integer> entry = entryList.get(i);
            System.out.println(String.format("%d. \"%s\" (%d occurrences)", i + 1, entry.getKey(), entry.getValue()));
        }

        // Print the top 3 least occurred words
        System.out.println("\nTop 3 least occurred words:");
        for (int i = 0; i < 3 && i < entryList.size(); i++) {
            Map.Entry<String, Integer> entry = entryList.get(entryList.size() - 1 - i);
            System.out.println(String.format("%d. \"%s\" (%d occurrences)", i + 1, entry.getKey(), entry.getValue()));
        }
	}
	
	/**
     * Separate the tags from each line of the CSV file and store it in a List
     * @param fileRead -> Pass in the read contents of the tags.csv file
     * @return tags -> List of tags
     */ 
	public static List<String> getTags(List<String> fileRead) {
		List<String> tags = new ArrayList<String>();
		String[] tag = null;
		for (int i = 0; i < fileRead.size(); i++) {
			tag = fileRead.get(i).split(",");
			tags.add(tag[2]);
		}
		return tags;
	}
	
	public static void main(String[] args) {
		//Replace string with args[0];
		String file = "C:/Users/mluba/Downloads/tags.csv";
		System.out.println(" ==========================================");
		List<String> fileRead = readFile(file);
		System.out.println(" ==========================================");
		fileRead.remove(0); //remove the file header
		List<String> tags = getTags(fileRead);
		popularTags(tags);
		System.out.println(" ==========================================");
		
	}	
}