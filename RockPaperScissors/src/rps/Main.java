package rps;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Integer score = 0;
		List<String> strat = null;

		try {
			strat = Files.readAllLines(Paths.get(args[0]));
		} catch (IOException e) {
			System.out.println("Error while reading words from file");
		}
		for (int i = 0; i < strat.size(); i++) {
			if (strat.get(i).equals("A Z")) { //LOSE
				score += 3; //Scissors +3, Loss +0
			} else if (strat.get(i).equals("B X")) {
				score += 1; //Rock +1, Loss +0
			} else if (strat.get(i).equals("C Y")) {
				score += 2; //Paper +2, Loss +0
			} else if (strat.get(i).equals("A X")) { //DRAW
				score += 4; //Rock +1. Draw +3
			} else if (strat.get(i).equals("B Y")) {
				score += 5; //Paper +2, Draw +3
			} else if (strat.get(i).equals("C Z")) {
				score += 6; //Scissors +3, Draw +3
			} else if (strat.get(i).equals("A Y")) { //WIN
				score += 8; //Paper +2, Win +6
			} else if (strat.get(i).equals("B Z")) {
				score += 9; //Scissors +3, Win +6
			} else if (strat.get(i).equals("C X")) {
				score += 7; //Rock +1, Win +6
			} else {
				System.out.println("Invalid input");
			}
		}
		System.out.println("Final score Part 1: " + score);
		
		score = 0;
		for (int i = 0; i < strat.size(); i++) {
			String currentStrat = strat.get(i);
			if (currentStrat.charAt(strat.get(i).length() - 1) == 'X') { //X = need to lose
				if (currentStrat.charAt(0) == 'A') { //if opponent uses rock
					score += 3; //Lose +0, Scissors +3
				} else if (currentStrat.charAt(0) == 'B') { //if opponent uses paper
					score += 1; //Lose +0, Rock +1
				} else if (currentStrat.charAt(0) == 'C') {
					score += 2;//Lose +0, Paper +2
				}
			} else if (currentStrat.charAt(strat.get(i).length() - 1) == 'Y') { //Y = need draw
				if (currentStrat.charAt(0) == 'A') { //if opponent uses rock
					score += 4; //Draw +3, Rock +1
				} else if (currentStrat.charAt(0) == 'B') { //if opponent uses paper
					score += 5; //Draw +3, Paper +2
				} else if (currentStrat.charAt(0) == 'C') { //if opponent uses scissors
					score += 6; //Draw +3, Scissors +3
				}
			} else if (currentStrat.charAt(strat.get(i).length() - 1) == 'Z') { //Y need to win
				if (currentStrat.charAt(0) == 'A') { //if opponent uses rock
					score += 8; //Win +6, Paper +2
				} else if (currentStrat.charAt(0) == 'B') { //if opponent uses paper
					score += 9; //Win +6, Scissors +3
				} else if (currentStrat.charAt(0) == 'C') { //if opponent uses scissors
					score += 7; //Win +6, Rock +1
				}				
			}
		}
		System.out.println("Final score Part 2: " + score);
	}

}