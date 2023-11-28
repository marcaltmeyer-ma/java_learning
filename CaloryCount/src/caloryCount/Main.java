package caloryCount;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		ArrayList<Integer> elves = new ArrayList<>();
		List<String> cals = null;
		Integer calCount = 0;
		try {
			cals = Files.readAllLines(Paths.get(args[0]));
		} catch (IOException e) {
			System.out.println("Error while reading words from wordlist");
		}
		for (int i = 0; i < cals.size(); i++) {
			if (cals.get(i).equals("")) {
				elves.add(calCount);
				calCount = 0;
			} else {
				calCount += Integer.parseInt(cals.get(i));
			}
		}
		elves.add(calCount);
		System.out.println("Part 1: " + Collections.max(elves));
		
		Integer topThree = 0;
		Collections.sort(elves, Collections.reverseOrder());
		for (int i = 0; i < 3; i++) {
			topThree += elves.get(i);
		}
		System.out.println("Part 2: " + topThree);
	}
}
