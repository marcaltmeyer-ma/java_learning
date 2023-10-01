
import java.io.Console;
import java.io.IOException;
import java.nio.file.Files;
//import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import CheckPackage.Checker;

public class Main {
	static Scanner scanner = new Scanner(System.in);


	public static void main(String[] args) {
		boolean replay = true;
		while (replay) {
			char playerNum = 'l';

			System.out.println("For local multiplayer, enter 'l'.");
			System.out.println("For network multiplayer, enter 'n'.");
			System.out.println("For singleplayer, enter 's'.");

			playerNum = scanner.next().charAt(0);

			if (playerNum == 'l') {
				replay = localMultiplayer(replay);
			} else if (playerNum == 's') {
				replay = singleplayer(replay);
			} else if (playerNum == 'n') {
				System.out.println("Network not yet implemented");
			}
		} // while(replay)
		scanner.close();
	}

	// The function that starts local multiplayer
	public static boolean localMultiplayer(boolean replay) {
		System.out.println("Enter a word.");
		int lives = 10;
		char[] word = enterWord();

		String solution = String.valueOf(word).toLowerCase();
		word = getArray(solution);

		askRules();
		replay = enterLetter(word, solution, lives, replay);
		return replay;
	}// localMultiplayer

	// Starts single player with a random word
	public static boolean singleplayer(boolean replay) {
		int lives = 10;
		List<String> wordlst = openWordList();
		Random rand = new Random();
		String randomElement = wordlst.get(rand.nextInt(wordlst.size()));
		String solution = randomElement.toLowerCase();
		char[] word = getArray(solution);
		System.out.println(word);
		askRules();
		replay = enterLetter(word, solution, lives, replay);
		// }
		return replay;
	}// singleplayer

	// The function for the first player entering the word
	public static char[] enterWord() {
		Console cons = System.console();
		char[] word;
		word = cons.readPassword();
		return word;
	}// enterWord

	// Opening Word list
	public static List<String> openWordList() {
		List<String> words = null;
		try {
			words = Files.readAllLines(Paths.get("wordlist.txt"));
		} catch (IOException e) {
			System.out.println("WordList fuckup");
		}
		return words;
	}// openWordList

	// A helping function to get the Hangman-typical _-notation of the word
	public static char[] getArray(String solu) {
		char[] word = new char[solu.length()];
		Arrays.fill(word, '_');
		return word;
	}// getArray

	// The function if the player asks for the words' length
	public static void askLength(char[] word) {
		System.out.println("The word has" + " " + word.length + " " + "tokens.");
	}// askLength

	// The function to return the rules if the player asks
	public static void askRules() {
		System.out.println("Enter a letter.");
		System.out.println("You can check thow many tokens the word has by entering '#'.");
		System.out.println("By entering '*', you can see how many lives you have left.");
		System.out.println("To see the letters that were guessed wrong, enter '-'.");
		System.out.println("To see these rules again, enter '?'.");
		System.out.println("To see the current state of the word, press '='");
	}// askRules

	// Gives out the lives the player has left
	public static void askLives(int lives) {
		System.out.println("You have " + lives + " lives left.");
	}// askLives

	// Prints the list of wrong tokens
	public static void askWrong(char[] wrg) {
		System.out.println(wrg);
	}// askWrong

	// Ask the player if they want to play again
	public static boolean askAgain(boolean replay) {
		System.out.println("If you want to play again, enter 'y', else enter 'n'.");
		String rep = scanner.next();
		if (rep.equals("y")) {
			return true;
		} else if (rep.equals("n")) {
			return false;
		}
		return false;
	}// askAgain
	
	public static void askWordGuessed(char[] word) {
		System.out.println(word);
	}

	// The gameplay-function. Here, the processes that are caused by player-input
	// happen
	public static boolean enterLetter(char[] word, String solution, int lives, boolean replay) {
		char[] wrong = new char[26];
		int i = 0;
		int idx = 0;
		boolean guessedCharInWord = false;
		boolean guessedCharInWrong = false;
		System.out.println("word: " + String.valueOf(word));

		while (!String.valueOf(word).equals(solution) && lives > 0) {
			String inputWord = scanner.next();
			if (inputWord.length() == 1) {
				char token = inputWord.charAt(0);
				boolean helper = false;
				if (token == '#') {
					askLength(word);
				} else if (token == '*') {
					askLives(lives);
				} else if (token == '-') {
					askWrong(wrong);
				} else if (token == '?') {
					askRules();
				} else if (token == '=') {
					askWordGuessed(word);
				} else if ((guessedCharInWrong = Checker.checker(token, wrong))
						|| (guessedCharInWord = Checker.checker(token, word))) {
					System.out.println(token
							+ " has already been guessed. Press - to check the wrongly guessed letters, or = to see the word so far.");
				} else {
					for (; idx < solution.length(); idx++) {
						if (token == solution.charAt(idx)) {
							helper = true;
							System.out.println(token + " " + "is in the word!");
							word[idx] = token;
							System.out.println("word: " + String.valueOf(word));
						}
					}
					if (idx >= solution.length() && helper == false) {
						System.out.println(token + " is not in the word!");
						lives--;
						System.out.println("You have " + lives + " lives left.");
						wrong[i] = token;
						i++;
						System.out.println("word: " + String.valueOf(word));
					}
					idx = 0;

				}
			} else if (inputWord.equals(solution)) {
				System.out.println("You are correct! The word is " + solution);
				System.out.println("You had " + lives + " lives left.");
				replay = askAgain(replay);
				return replay;
			} else {
				System.out.println(inputWord + " is not the word. Guess again!");
				lives -=2;
				System.out.println("You have " + lives + " lives left.");
				System.out.println("word: " + String.valueOf(word));
			}
		}
		if (String.valueOf(word).equals(solution)) {
			System.out.println("You are correct! The word is " + solution);
			System.out.println("You had " + lives + " lives left.");
			replay = askAgain(replay);
			return replay;
		} else if (lives == 0) {
			System.out.println("Welp, you suck. The word was " + solution + ", btw.");
			replay = askAgain(replay);
			return replay;
		}
		return replay;
	}// enterLetter
}
