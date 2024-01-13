# Hangman
Hangman is a paper and pencil guessing game for two or more players.
One player thinks of a word, phrase or sentence, and the other tries to guess it by suggesting letters within a certain number of guesses.
 
You are given 8 attempts to guess a word that has at least four characters.
This word is randomly selected from a pre-populated list of words. You enter a letter, and the program displays the word guessed so far based on the letters you had entered.
If you enter a letter that is not in the word, your number of guesses is reduced by 1.
If you enter either a letter you had previously entered, a message is displayed to inform you that you had entered this letter earlier, and your number of guesses remains unchanged, and you are to enter a letter again.

If you enter a letter that is in the word, your number of guesses remains unchanged, and you are to enter a letter again. 
At the end of the game, a message is displayed that indicates whether or not you successfully guessed the word.

## How to use this folder
1. If your local machine has not been configured with both the Eclipse IDE, follow the installation instructions [here](https://github.com/shumarb/training/blob/main/fdm/software-to-install/EclipseIDEInstallation.md)
2. If your local machine has not been configured with both the Java 17, follow the installation instructions [here](https://github.com/shumarb/training/blob/main/fdm/software-to-install/Java17Installation.md)
3. Download the [zip folder](https://github.com/shumarb/training/blob/main/fdm/object-oriented-development/part-1/ood-1-assessment-sheikh-umar.zip) of the project to your local machine
4. Unzip the zip file. The unzipped folder is called com.fdmgroup.hangman
5. Open the Eclipse IDE
6. Select File
7. Open Projects from File System
8. Select Directory next to Import source
9. Navigate to the location of the unzipped file
10. Select this file
11. Select Finish. You will see com.fdmgroup.hangman project in the Package Explorer
12. Select the > icon of the com.fdmgroup.hangman project
13. Select the > icon of the src folder
14. Select the > icon of the com.fdmgroup.hangman package
15. Right-click Runner.java
16. Select Run As
17. Select 1. Java Application
18. Follow the instructions displayed in console on how to play the Hangman game
