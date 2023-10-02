## Hangman
### Checking out and finding the game
- Check out the files from the fckit-branch
- Maneuver through the following folder structure:
  - Hangman
  - src
- **Important: To compile the files, you need a JDK, and to run them, you need a JRE**
### Running the game
  - Open the command line
- When running the game for the first time, you have to compile it by running the following command:
  - javac Main.java
- To start the game, run the following command:
  - java Main
**Important:**
For compiling, you need the file extension .java, while you must not use it for starting the game!
### Rules and Controls
When you start the game, you can choose between three modes:<br>
![image](https://github.com/marcaltmeyer-ma/learning-java/assets/135340116/c1e7ffa1-9751-4c50-a554-d8fa72357532)

|Mode|Input|Explanation|
|----|-----|-----------|
|Singleplayer|s|Randomly selects word from list of 1524 English words, 2-15 letters of length|
|Local Multiplayer|l|Player 1 can enter a word, and player 2 can guess it on the same machine|
|Netwoork Multiplayer|n|Like Local Multiplayer, but over the a network|

- After the word has been set, you will be prompted to enter a letter. You will see an overview of the controls and the underscore representation of the word. In the screenshot below, this can be seen with the word "test"<br>
  ![image](https://github.com/marcaltmeyer-ma/learning-java/assets/135340116/0afee17a-c9a1-48c7-b1f6-44f8e75d3870)
- If the letter is in the word, it will be added to the appropriate spot in the underscore notation<br>
  ![image](https://github.com/marcaltmeyer-ma/learning-java/assets/135340116/ab6140ae-765e-4cf5-b19d-15c3d1f7d9a6)
  - If the letter is in the word multiple times, it will be added at all the positions
- If the letter is not in the word, you will lose a life. You start with 10 lives (representing the 10 strokes needed to draw the hangman in the analog game)
  - The wrong letter will be added to a list, which you can ask the game to be shown
  - If you reach 0 lives, the game will be over. The game will tell you the word and ask you if you want to play again
  ![image](https://github.com/marcaltmeyer-ma/learning-java/assets/135340116/b876eae7-8a5c-475f-911c-3abda1d6da6f)
  - If you enter a letter that has already been guessed, the game will tell you so and, if it is a wrong letter, not subtract another life
- If you are feeling lucky, you can try to enter a full word at any point in the game. Keep in mind, though, that you will lose two lives when you guess the wrong word
- If you have entered the full word, you win the game. The word will be shown to you<br>
  ![image](https://github.com/marcaltmeyer-ma/learning-java/assets/135340116/acb5e158-98fd-41a0-8ebe-6fda5249a462)

- There are five special tokens you can enter during the game to get shown information
  |Token|Description|
  |-----|-----------|
  |#|Get the number of letters in the word|
  |*|Get the amount of lives you have left|
  |-|Get a list of the wrongly guessed letters|
  |?|Get this list of rules shown again|
  |=|Get the current underscore notation of the word|
