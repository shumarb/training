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

// package com.fdmgroup.hangman;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Runner {
	private ArrayList <String> possibleWordsList = new ArrayList <String> ();
	private HashSet <String> lettersEntered = new HashSet <String> ();
	private final boolean isTest = false; // Only used for testing (eg: ensuring word formed is correct, etc...)
	private int numberOfGuessesLeft = 8;
	private Scanner sc = new Scanner(System.in);
	private String word;
	private String wordGuessSoFar = "";
	
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
	
	private void wordGuessSoFar() {
		System.out.println("The word now looks like this: " + wordGuessSoFar);
	}
	
	private void displayNumberOfGuessesLeft() {
		if (numberOfGuessesLeft > 1) {
			System.out.println("You have " + numberOfGuessesLeft + " guesses left.");
		}
		
		if (numberOfGuessesLeft == 1) {
			System.out.println("You have only one guess left.");
		}
	}
	
	private void closesScanner() {
		sc.close();
	}
	
	private void displaysLine() {
		System.out.println("------------------------------------------------------------------------------");
	}
	
	private void displaysPossibleWords() {
		displaysLine();
		System.out.println("Possible Words:");
		for (int i = 0; i < possibleWordsList.size(); i++) {
			System.out.println(" * " + possibleWordsList.get(i));
		}
	}
	
	private void formsPossibleWords() {
		possibleWordsList.add("HELLO");
		possibleWordsList.add("CHICKEN");
		possibleWordsList.add("TURKEY");
		possibleWordsList.add("TITANIC");
		possibleWordsList.add("HOCKEY");
		possibleWordsList.add("SENTOSA");
		possibleWordsList.add("EUNOS");
		possibleWordsList.add("BLUE");
		possibleWordsList.add("PURPLE");
		possibleWordsList.add("GREEN");
		possibleWordsList.add("IPHONE");
		possibleWordsList.add("BOTTLE");
		possibleWordsList.add("FUZZY");
		possibleWordsList.add("TISSUE");
		possibleWordsList.add("COMPUTER");
	}
	
	private void start() {
		System.out.println("Welcome to Hangman!");
		formsPossibleWords();
		Random myRandom = new Random();
		int index = myRandom.nextInt(0, possibleWordsList.size() - 1);
		word = possibleWordsList.get(index);
		for (int i = 0; i < word.length(); i++) {
			wordGuessSoFar = wordGuessSoFar.concat("-");
		}
		if (isTest) {
			displaysPossibleWords();
			System.out.println();
			System.out.println("Word: " + word + "\t\t| length: " + word.length() + " | index: " + index);
			System.out.println("wordGuessSoFar: " + wordGuessSoFar + "\t| length: " + wordGuessSoFar.length());
			displaysLine();
		}
		wordGuessSoFar();
		displayNumberOfGuessesLeft();
	}
	
	private String readsLetter() {
		System.out.print("Your guess: ");
		String letter = sc.next();
		if (!letter.equals(letter.toUpperCase())) {
			letter = letter.toUpperCase();
		}
		return letter;
	}
	
	private boolean isWordGuessedCorrectly() {
		return word.equals(wordGuessSoFar);
	}
	
	private boolean hasLetterBeenEnteredEarlier(String letter) {
		if (lettersEntered.contains(letter)) {
			return true;
		}
		// For future checks of letters entered
		// Proceed with current check that assumes the letter was not entered.
		lettersEntered.add(letter);
		return false;
	}
	
	private void game() {
		while (!isWordGuessedCorrectly() && numberOfGuessesLeft > 0) {
			String letter = readsLetter();
			if (hasLetterBeenEnteredEarlier(letter)) {
				System.out.println("You had entered this letter earlier. Enter a different letter.");
			} else {
				boolean isLetterInWord = check(letter);
				if (!isLetterInWord) {
					numberOfGuessesLeft--;
				}
				resultOfGuess(isLetterInWord, letter);
				wordGuessSoFar();
				displayNumberOfGuessesLeft();
			}
		}
	}
	
	private boolean check(String letter) {
		if (!word.contains(letter)) {
			return false;
		}
		
		char letterChar = letter.charAt(0);
		StringBuilder stringBuilder = new StringBuilder(wordGuessSoFar);
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == letterChar) {
				stringBuilder.setCharAt(i,letterChar);
				wordGuessSoFar = stringBuilder.toString();
			}
		}
		
		return true;
	}
	
	private void resultOfGuess(boolean isCorrectGuess, String letter) {
		if (isCorrectGuess) {
			System.out.println("That guess is correct.");
		} else {
			System.out.println("There are no " + letter + "'s in the word.");
		}
	}
	
	private void end() {
		finalResult();
		closesScanner();
	}
	
	private void run() {
		start();
		game();
		end();
	}
	
	public static void main(String[] args) {
		Runner obj = new Runner();
		obj.run();
	}

}
