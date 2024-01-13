/*
 * This program is a command line version of the classic hangman game.
 * 
 * Hangman is a paper and pencil guessing game for two or more players.
 * One player thinks of a word, phrase or sentence,
 * and the other tries to guess it by suggesting letters within a certain number of guesses.
 * 
 * You are given 8 attempts to guess a word that has at least four characters.
 * This word is randomly selected from a pre-populated list of words.
 * You enter a letter, and the program displays the word guessed so far based on the letters you had entered.
 * If you enter a letter that is not in the word, your number of guesses is reduced by 1.
 * If you enter either a letter you had previously entered, a message is displayed to
 * inform you that you had entered this letter earlier, and your number of guesses remains unchanged,
 * and you are to enter a letter again.
 * If you enter a letter that is in the word, your number of guesses remains unchanged, and you are to enter a letter again.
 * 
 * At the end of the game, a message is displayed 
 * that indicates whether or not you successfully guessed the word.
 * 
 * This program was written by Sheikh Umar.
 */

 package com.fdmgroup.hangman;

 import java.util.ArrayList;
 import java.util.HashSet;
 import java.util.List;
 import java.util.Random;
 import java.util.Scanner;
 
 public class Runner {
	 
	 /*
	  * ArrayList to store possible words for the user to guess
	  */
	 private List <String> possibleWords = new ArrayList <String> ();
	 
	 /*
	  * HashSet to store the letters that the user has entered
	  * even letters that are not part of the word to be guessed
	  * Words that are not part of the word to be guessed are not counted against
	  * the number of guesses the user has left
	  */
	 private HashSet <String> lettersEntered = new HashSet <String> ();
	 
	 /*
	  * Boolean test variable for debugging
	  */
	 private final boolean isTest = false;
	 
	 /*
	  * Number of guesses a user has at the start of the game
	  */
	 private int numberOfGuessesLeft = 8;
	 
	 /*
	  * Scanner to read letter
	  */
	 private Scanner sc = new Scanner(System.in);
	 
	 /*
	  * Word to be guessed for the Hangman game
	  */
	 private String word;
	 
	 /*
	  * Word formed based on letters that the user has entered
	  * Letters in the word that the user has not guessed
	  * are denoted by -
	  */
	 private String wordGuessedSoFar = "";
	 
	 /*
	  * Displays the final result
	  * 
	  * If the user guesses the word correctly,
	  * display the word and inform the user that he/she has won the game
	  * 
	  * If the user has exhausted all attempts and fails to guess the word correctly,
	  * display a message that the user is completely hung,
	  * followed by the word, and that the user has lost
	  */
	 private void finalResult() {
		 if (isWordGuessedCorrectly()) {
			 System.out.println("You guessed the word: " + word);
			 System.out.println("You win.");
		 } else {
			 System.out.println("You're completely hung.");
			 System.out.println("The word was: " + word);
			 System.out.println("You lose.");
		 }
	 }
	 
	 /*
	  * Displays the word guessed so far
	  * based on the letters that the user has entered
	  */
	 private void wordGuessedSoFar() {
		 System.out.println("The word now looks like this: " + wordGuessedSoFar);
	 }
	 
	 /*
	  * Displays the number of guesses the user has left
	  */
	 private void displayNumberOfGuessesLeft() {
		 if (numberOfGuessesLeft > 1) {
			 System.out.println("You have " + numberOfGuessesLeft + " guesses left.");
		 }
		 
		 if (numberOfGuessesLeft == 1) {
			 System.out.println("You have only one guess left.");
		 }
	 }
	 
	 /*
	  * Closes the scanner after use
	  */
	 private void closesScanner() {
		 sc.close();
	 }
	 
	 /*
	  * Display a line
	  * This is only for debugging
	  */
	 private void displaysLine() {
		 System.out.println("------------------------------------------------------------------------------");
	 }
	 
	 /*
	  * Display all the possible words for the user to guess
	  * This is only for debugging
	  */
	 private void displaysPossibleWords() {
		 displaysLine();
		 System.out.println("Possible Words:");
		 for (int i = 0; i < possibleWords.size(); i++) {
			 System.out.println(" * " + possibleWords.get(i));
		 }
	 }
	 
	 /*
	  * Forms all possible words for the game
	  * and stored in an ArrayList
	  */
	 private void formsPossibleWords() {
		 possibleWords.add("HELLO");
		 possibleWords.add("CHICKEN");
		 possibleWords.add("TURKEY");
		 possibleWords.add("TITANIC");
		 possibleWords.add("HOCKEY");
		 possibleWords.add("SENTOSA");
		 possibleWords.add("EUNOS");
		 possibleWords.add("BLUE");
		 possibleWords.add("PURPLE");
		 possibleWords.add("GREEN");
		 possibleWords.add("IPHONE");
		 possibleWords.add("BOTTLE");
		 possibleWords.add("FUZZY");
		 possibleWords.add("TISSUE");
		 possibleWords.add("COMPUTER");
	 }
	 
	 /*
	  * Start of the game
	  * 
	  * A welcome message will be displayed
	  * 
	  * All the possible words for this game are formed
	  * and populated in the possibleWords ArrayList
	  * 
	  * The word to be guessed for this game is randomly selected
	  * using a variable called myRandom, which is of type Random
	  * 
	  * The length of the wordGuessedSoFar is the length
	  * of the word to be guessed for the game, and every character in
	  * wordGuessedSoFar is -
	  * 
	  * All possible words are only displayed for debugging and not
	  * for the actual game
	  * 
	  * The word guessed so far is displayed.
	  * Letters that user has guessed correctly are displayed
	  * while letters that have not been guessed correctly
	  * are displayed as -
	  * 
	  * Lastly, the number of guesses the user has left is displayed
	  */
	 private void start() {
		 System.out.println("Welcome to Hangman!");
		 formsPossibleWords();
		 Random myRandom = new Random();
		 int index = myRandom.nextInt(0, possibleWords.size() - 1);
		 word = possibleWords.get(index);
		 for (int i = 0; i < word.length(); i++) {
			 wordGuessedSoFar = wordGuessedSoFar.concat("-");
		 }
		 if (isTest) {
			 displaysPossibleWords();
			 System.out.println();
			 System.out.println("Word: " + word + "\t\t| length: " + word.length() + " | index: " + index);
			 System.out.println("wordGuessedSoFar: " + wordGuessedSoFar + "\t| length: " + wordGuessedSoFar.length());
			 displaysLine();
		 }
		 wordGuessedSoFar();
		 displayNumberOfGuessesLeft();
	 }
	 
	 /*
	  * User enters a letter
	  * 
	  * If the user entered a non-letter character,
	  * inform the user that he/she has entered a non-letter character,
	  * and that he/she has to enter a letter character
	  * Repeat this until the user has entered a letter character
	  * The number of attempts that the user has to guess the word correctly
	  * remains unchanged
	  * 
	  * If the letter the user entered is in lowercase, convert it to uppercase
	  * and return this uppercase to the caller function
	  * 
	  * @return letter: uppercase version of the letter that the user entered
	  */
	 private String readsLetter() {
		 String input;
		 char letter = 'a'; // only for initialisation, will be updated to first character of input that user entered
		 
		 do {
			 System.out.print("Your guess: ");
			 input = sc.next();
			 if (input.length() > 1) {
				 System.out.println("The input that you provided is a word and not a letter. Enter a letter.");
			 } else {
				 letter = input.charAt(0);
				 if (!Character.isLetter(letter)) {
					 System.out.println("The input that you provided is not a letter. Enter a letter.");
				 }
			 }
		 } while (input.length() > 1 || !Character.isLetter(letter));
		 
		 if (Character.isLowerCase(letter)) {
			 letter = Character.toUpperCase(letter);
		 }
		 
		 return Character.toString(letter);
	 }
	 
	 /*
	  * Checks if the word has been guessed correctly
	  * based on the letters that the user has entered
	  * 
	  * @return true/false: outcome on whether the word 
	  * has been guessed correctly based on the letters that the user has entered
	  */
	 private boolean isWordGuessedCorrectly() {
		 return word.equals(wordGuessedSoFar);
	 }
	 
	 /*
	  * Checks if the letter the user entered has been entered earlier
	  * If the letter entered has not been entered earlier,
	  * add it to the HashSet of letters that the user has entered
	  * 
	  * @params letter: the letter that the user has entered
	  * @return true/false: the outcome on whether the user entered has been entered earlier
	  */
	 private boolean hasLetterBeenEnteredEarlier(String letter) {
		 if (lettersEntered.contains(letter)) {
			 return true;
		 }
		 lettersEntered.add(letter);
		 return false;
	 }
	 
	 /*
	  * Operation of the Hangman game
	  * 
	  * First, user enters a letter
	  * If the user had entered the letter earlier,
	  * inform the user that the letter had been entered earlier,
	  * and instruct the user to enter a different letter
	  * If the user entered a letter that was entered earlier,
	  * his/her number of attempts to guess the word remains unchanged
	  * 
	  * Secondly, the letter that the user entered is not in the word to be guessed,
	  * reduce his/her number of attempts to guess the letter for the remainder of the game
	  * 
	  * Thirdly, display the word guessed so far.
	  * This comprises of the letters that the user has guessed correctly,
	  * and a - for the letters that the user has not guessed correctly
	  * 
	  * Lastly, display the number of guesses the user has left
	  * for the remainder of the game
	  * 
	  * Repeat this as long as the user has not guessed the word correctly
	  * and the user has at least 1 attempt left at guessing the word correctly
	  */
	 private void game() {
		 do {
			 String letter = readsLetter();
			 if (hasLetterBeenEnteredEarlier(letter)) {
				 System.out.println("You had entered this letter earlier. Enter a different letter.");
			 } else {
				 boolean isLetterInWord = check(letter);
				 if (!isLetterInWord) {
					 numberOfGuessesLeft--;
				 }
				 resultOfGuess(isLetterInWord, letter);
				 wordGuessedSoFar();
				 displayNumberOfGuessesLeft();
			 }
		 } while (!isWordGuessedCorrectly() && numberOfGuessesLeft > 0);
	 }
	 
	 /*
	  * Checks if the letter that the user entered
	  * is part of the word to be guessed
	  * 
	  * If the letter that the user entered is not in the word to be guessed,
	  * return false
	  * 
	  * If the letter that the user entered is not in the word to be guessed,
	  * add the letter to the string wordGuessedSoFar,
	  * and return true
	  * 
	  * @params letter: the letter that the user has entered
	  * @return true/false: the outcome of whether the letter that the user entered
	  * is in the word to be guessed
	  */
	 private boolean check(String letter) {
		 if (!word.contains(letter)) {
			 return false;
		 }
		 char letterChar = letter.charAt(0);
		 StringBuilder stringBuilder = new StringBuilder(wordGuessedSoFar);
		 for (int i = 0; i < word.length(); i++) {
			 if (word.charAt(i) == letterChar) {
				 stringBuilder.setCharAt(i,letterChar);
				 wordGuessedSoFar = stringBuilder.toString();
			 }
		 }
		 return true;
	 }
	 
	 /*
	  * If a user guessed a letter correctly,
	  * display a message that the letter guessed was correct
	  * else display a message that the letter guessed is not
	  * in the word to be guessed
	  * 
	  * @params isCorrectGuess: the result on whether the letter
	  * that the user entered is in the word to be guessed
	  * @params letter: the letter that the user has entered
	  */
	 private void resultOfGuess(boolean isCorrectGuess, String letter) {
		 if (isCorrectGuess) {
			 System.out.println("That guess is correct.");
		 } else {
			 System.out.println("There are no " + letter + "'s in the word.");
		 }
	 }
	 
	 /*
	  * The game ends when the user has guessed the word correctly
	  * or has exhausted all 8 attempts
	  * 
	  * Once the game ends, display the outcome on whether
	  * the user guessed the word correctly,
	  * and close the scanner to prevent a resource leak
	  */
	 private void end() {
		 finalResult();
		 closesScanner();
	 }
	 
	 /*
	  * Using a non-static run method to run the program
	  * so that the static keyword need not be declared
	  * at every method if it is being accessed from the main method
	  */
	 private void run() {
		 start();
		 game();
		 end();
	 }
	 
	 /*
	  * Instantiate a Runner object,
	  * and execute the Runner object's run method
	  */
	 public static void main(String[] args) {
		 Runner obj = new Runner();
		 obj.run();
	 }
 
 }
 