package day1;

import java.util.Arrays;
import java.util.List;
import basics.*;

public class Main {

	public static void main(String[] args) {
		Integer result = 0;
		String[] numbers = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
		
		
		List<String> calibration = OpenFile.readFile(args[0]);
 		for (int i = 0; i < calibration.size(); i++) {
 			String word = calibration.get(i); 
 			Integer number = 0;
 			System.out.println("String: " + word);
 			for (int j = 0; j < word.toCharArray().length; j++) {
 				boolean brk = false;
				//System.out.println(word.toCharArray());
 				if (Character.isDigit(word.toCharArray()[j])) {
					number += Character.getNumericValue(word.toCharArray()[j]) * 10;
					System.out.println("Zehner: " + number);
					result += number;
 					break;
				} else {
					for (int k = 0; k < numbers.length; k++) {
						if (numbers[k].regionMatches(0, word, j, numbers[k].length())) {
							number += (k+1) * 10;
							System.out.println("Zehner: " + number);
							result += number;
							brk = true;
							break;
						}
					}
					if (brk) {
						break;
					}
				}
			}
 			number = 0;
 			for (int j = word.toCharArray().length -1; j >= 0; j--) {
 				boolean brk = false;
				if (Character.isDigit(word.toCharArray()[j])) {
					number += Character.getNumericValue(word.toCharArray()[j]);
					System.out.println("Einer: " + number);
					result += number;
					break;
				} else {
					for (int k = 0; k < numbers.length; k++) {
						if (numbers[k].regionMatches(0, word, j, numbers[k].length())) {
							number += k+1;
							System.out.println("Einer: " + number);
							result += number;
							brk = true;
							break;
						}
					}
					if (brk) {
						break;
					}
				}
			}
		}
 		System.out.println("Result: " + result);

 		
	}

}
