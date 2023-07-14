
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.Console;
import java.io.IOException;
import java.nio.file.Files;
//import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
  //MAX I defined the Scanner as static class variable. It can be used
  //MAX everywhere where you created an extra Scanner.
  static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		boolean replay = true;
		//boolean multiplayer = true;
		char playerNum = 'l';
		
		System.out.println("For local multiplayer, enter 'l'.");
		System.out.println("For network multiplayer, enter 'n'.");
		System.out.println("For singleplayer, enter 's'.");
		
		playerNum = scanner.next().charAt(0);

		
		if (playerNum == 'l') {
			localMultiplayer(replay);
		} else if (playerNum == 's') {
			singleplayer(replay);
		} else if (playerNum == 'n') {
			System.out.println("Network not yet implemented");
		}

    //MAX That's a nice and concise main function.
    scanner.close();
	}

	
	//The function that starts local multiplayer
	public static void localMultiplayer(boolean replay) {
		while (replay == true) {
			System.out.println("Enter a word.");
			int lives = 10;
			//String solution = enterWord();
			char[] word = enterWord();
			
      //MAX I wouldn't want to have commented-out code in a "release" version.
			String solution = String.valueOf(word).toLowerCase();
			word = getArray(solution);
					
      //MAX Just an idea: What about putting these prints in a function and printing them when the user types '?'?
			askRules();
			enterLetter(word, solution, lives, replay);
		}
	}
	
	//Starts single player with a random word
	public static void singleplayer(boolean replay) {
		while (replay == true) {
			int lives = 10;
			List<String> wordlst = openWordList();
			Random rand = new Random();
			String randomElement = wordlst.get(rand.nextInt(wordlst.size()));
			String solution = randomElement.toLowerCase();
			char[] word = getArray(solution);
			System.out.println(word);
			askRules();
			enterLetter(word, solution, lives, replay);
			}
	}
	
	//The function for the first player entering the word
	public static char[] enterWord() {
		Console cons = System.console();
		char[] word;
		word = cons.readPassword();
		return word;
	}
	
	
	//Opening Word list
	public static List<String> openWordList() {
		List<String> words = null;
				try {
			words = Files.readAllLines(Paths.get("wordlist.txt"));
		} catch (IOException e) {
			System.out.println("WordList fuckup");
		}
		return words;
	}
	
	//A helping function to get the Hangman-typical _-notation of the word 
	public static char[] getArray(String solu) {
		char[] word = new char[solu.length()];
		Arrays.fill(word, '_');
		return word;
	}
	
	//The function if the player asks for the words' length
	public static void askLength(char[] word) {
		System.out.println("The word has" + " " + word.length + " " + "tokens.");
	}
	
	//The function to return the rules if the player asks
	public static void askRules() {
		System.out.println("Enter a letter.");
		System.out.println("You can check thow many tokens the word has by entering '#'.");
		System.out.println("By entering '*', you can see how many lives you have left.");
		System.out.println("To see the letters that were guessed wrong, enter '-'.");
		System.out.println("To see these rules again, enter '?'.");
	}
	
	//Gives out the lives the player has left
	public static void askLives(int lives) {
		System.out.println("You have " + lives + " lives left.");
	}
	
	//Prints the list of wrong tokens
	public static void askWrong(char[] wrg) {
		System.out.println(wrg);
	}
	
	//Ask the player if they want to play again
	//MAX trailing whitespace (well, before I put the comment on the line ^^)
	public static boolean askAgain(boolean replay) {
		System.out.println("If you want to play again, enter 'y', else enter 'n'.");
		String rep = scanner.next();
		if (rep == "y") {
      //MAX booleans are passed by *value* in Java, you get a copy of the value
      //MAX and the original value of the calling function won't be changed!
      //MAX You should return a bool, if you want to pass it to the calling function.
			System.out.println("replay = true");
			return true;
		} else if (rep == "n") {
			System.out.println("replay = false");
			return false;
		}
		return false;
	}

  //MAX for these kinds of "experiments" I would rather use git branches than commenting
  //MAX out large portions of code.

	//The gameplay-function. Here, the processes that are caused by player-input happen
	public static boolean enterLetter(char[] word, String solution, int lives, boolean replay) {
		char[] wrong = new char[26];
		int i = 0;
		int idx = 0;

		//MAX debug output in release version
		while (String.valueOf(word) != solution && lives > 0) {
			char token = scanner.next().charAt(0);
			boolean helper = false;
			if (token == '#') {
				askLength(word);
			} else if (token == '*') {
				askLives(lives);
			} else if (token == '-') {
				askWrong(wrong);
			} else if (token == '?') {
				askRules();
			}else if (token == '=') {//TODO Debug line! Delete!
				System.out.println(solution); 
			}	else {
				for (; idx < solution.length(); idx++) {
					if (token == solution.charAt(idx)) {
						helper = true; //MAX not quite sure what helper is used for. Is it just to
                           //MAX say that the current char is in the word?
                           //MAX You might want to use a better name here.
						System.out.println(true);
						System.out.println(token + " " + "is in the word!");
						word[idx] = token;
						System.out.println("word: " + String.valueOf(word));
            //MAX one important element of hangman isn't implmented yet:
            //MAX You don't show where the blanks in the word are.
            //MAX Let's say the word is "messer" and the user guesses "e"
            //MAX then your word would show as "ee". It would be nice if it
            //MAX showed as "_e__e_".

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

        //MAX this if statement kind of seems redundant...
        //MAX Does it do something different from the one above?
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
				System.out.println("You had " + lives + " lives left.");
				replay = askAgain(replay);
			} else if (lives == 0) {
				System.out.println("Welp, you suck. The word was " + solution + ", btw.");
				replay = askAgain(replay);
			}
		}
		return replay;
	}
}
