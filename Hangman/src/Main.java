import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		boolean replay = true;
		while (replay == true) {
			System.out.println("Enter a word.");
			int lives = 10;
			String solution = enterWord();

			// char[] word = solution.toCharArray();
			char[] word = new char[solution.length()];

			System.out.println("Enter a letter.");
			System.out.println("You can check thow many tokens the word has by entering '#'.");
			System.out.println("By entering '*', you can see how many lives you have left.");
			System.out.println("To see the letters that were guessed wrong, enter '-'.");

			enterLetter(word, solution, lives, replay);

		}
	}

	public static String enterWord() {
		Scanner scan = new Scanner(System.in);
		String word = scan.next();
		return word;
	}

	public static void askLength(char[] word) {
		System.out.println("The word has" + " " + word.length + " " + "tokens.");
	}

	public static void askLives(int lives) {
		System.out.println("You have " + lives + " lives left.");
	}

	public static void askWrong(char[] wrg) {
		System.out.println(wrg);
	}
	
	public static boolean askAgain(boolean replay) {
		System.out.println("If you want to play again, enter 'y', else enter 'n'.");
		Scanner rpl = new Scanner(System.in);
		String rep = rpl.next();
		if (rep == "y") {
			replay = true;
		} else if (rep == "n") {
			replay = false;
		}
		return replay;
	}


	// Iterating over every letter
	public static void enterLetter(char[] word, String solution, int lives, boolean replay) {
		char[] wrong = new char[26];
		int i = 0;
		int idx = 0;

		// System.out.println("solution1: "+solution);
		System.out.println("debug0: " + String.valueOf(word));
		while (String.valueOf(word) != solution && lives > 0) {
			// System.out.println("solution2: "+solution);
			Scanner guess = new Scanner(System.in);
			char token = guess.next().charAt(0);
			boolean helper = false;
			if (token == '#') {
				askLength(word);
			} else if (token == '*') {
				askLives(lives);
			} else if (token == '-') {
				askWrong(wrong);
			} else {
				for (; idx < solution.length(); idx++) {
					if (token == solution.charAt(idx)) {
						helper = true;
						System.out.println(true);
						System.out.println(token + " " + "is in the word!");
						word[idx] = token;
						System.out.println("word: " + String.valueOf(word));
						// helper = false;
						// continue;
					}
				}
				if (idx >= solution.length() && helper == false) {
					// System.out.println("End of word");
					System.out.println(token + " is not in the word!");
					System.out.println("You have " + lives + " lives left.");
					lives--;
					wrong[i] = token;
					i++;
				}
				// System.out.println("solution: " + solution);
				if (idx > solution.length()) {
					System.out.println("This letter is not in the word.");
					lives--;
					System.out.println("You have " + lives + " lives left.");
					wrong[i] = token;
					i++;
				}
				idx = 0;

			}
			if (String.valueOf(word).equals(solution)) {
				System.out.println("You are correct! The word is " + solution);
				System.out.println("You had " + lives + " left.");
				askAgain(replay);
			} else if (lives == 0) {
				System.out.println("Welp, you suck. The word was " + solution + ", btw.");
				askAgain(replay);
			}
		}
	}
}
