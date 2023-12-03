package basics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class OpenFile {
	public static List<String> readFile(String fileName) {
		List<String> fileLines = null;
 		try {
 			fileLines = Files.readAllLines(Paths.get(fileName));
		} catch (IOException e) {
			System.out.println("Error while reading lines from file");
		}		
		return fileLines;
	}
}
