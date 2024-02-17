/*
 * User.java
 * 
 * A user has a name and a wallet.
 * 
 * The wallet contains mappings of currency to the value of the currency.
 * Example: A user has SGD100. Hence, the user's wallet SGD100 in this format: SGD-100,
 * where the key is the currency, and the value of the value of 100.
 */


package entities;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {

	/*
	 * A user has these attributes:
	 * 
	 * 1. A name in the form of a string
	 * 2. A wallet to store at least 1 currency and it's value
	 */
	private String name;
	private Map <String, Double> wallet;
	
	/*
	 * Creation of a user based on user's name
	 * 
	 * @params the user's name
	 */
	public User(String name) {
		
		this.name = name;
		this.wallet = new HashMap <String, Double> ();
		
	}
	
	/*
	 * Default constructor for Jackson Deserialisation
	 */
	public User() {
		
	}
	
	/*
	 * Retrieves the user's name
	 * 
	 * @return the user's name
	 */
	public String getName() {
		
		return this.name;
		
	}

	/*
	 * Retrieves the user's wallet
	 * 
	 * @return the user's wallet
	 */
	public Map<String, Double> getWallet() {
		
		return this.wallet;
		
	}
	
	/*
	 * Setters for Jackson Deserialisation
	 *
	 * @params user's name
	 */
	
	public void setName(String name) {
		
		this.name = name;
	}
	
	/*
	 * Setters for Jackson Deserialisation
	 * 
	 * @params user's wallet
	 */
	
	public void setWallet(HashMap <String, Double> wallet) {
		
		this.wallet = wallet;
	}

	/*
	 * Stores a currency and value of that currency into the the user's wallet
	 * when a valid transaction can be made
	 * 
	 * @params fromCurrency and the amount of this currency to be reflected in the user's wallet
	 */
	public void addCurrencyToWallet(String currency, double amount) {
		
		this.wallet.put(currency, amount);
		
	}
	
	/*
	 * Increases a currency's value in the user's wallet by the amountOfIncrease
	 * This happens when a transaction is successful
	 * 
	 * @params user's toCurrency, and the amount to increase this currency by
	 */
	public void increaseCurrencyValueInWallet(String currency, double amountOfIncrease) {
		
		DecimalFormat df = new DecimalFormat("#.##");
		String newAmount = df.format(this.wallet.getOrDefault(currency, 0.0) + amountOfIncrease);
		this.wallet.put(currency, Double.valueOf(newAmount));
		
	}
	
	/*
	 * Decreases the value of a user's currency by the amountOfDecrease
	 * This happens when a transaction is successful
	 * 
	 * @params user's fromCurrency, and the amount to decrease this currency by
	 */
	public void decreaseCurrencyValueInWallet(String currency, double amountOfDecrease) {
		
		DecimalFormat df = new DecimalFormat("#.##");
		if (this.wallet.containsKey(currency)) {
			double currentAmount = this.wallet.get(currency);
			String newAmount = df.format(currentAmount - amountOfDecrease);
			this.wallet.put(currency, Double.valueOf(newAmount));
		}
		
	}
	
	/*
	 * Checks if a currency's value in the user's wallet is 0.
	 * If yes, remove this currency from the user's wallet because it is of no value
	 * 
	 * @params fromCurrency after a successful transactionto check
	 * @return Boolean value of whether a currency in user's wallet is 0
	 */
	public boolean isValueOfCurrencyInWalletEqualToZero(String currency) {
		
		return this.wallet.get(currency) == 0;
		
	}
	
	/*
	 * Removes a currency from the wallet if it's value is equal to 0
	 * 
	 * @params Currency to remove
	 */
	public void removesCurrencyWithValueOfZero(String currency) {
		
		if (this.wallet.get(currency) == 0) {
			this.wallet.remove(currency);
		}
		
	}
	
	/*
	 * Retrieves the current value of a currency in the User's wallet
	 * If the currency does not exist, throw a NullPointerException.
	 * 
	 * @params a specified currency
	 * @return value of currency in the user's wallet
	 * @thrown NullPointerException if currency is not in the user's wallet
	 */
	public double getCurrencyValueInWallet(String currency) {
		
		if (this.wallet.containsKey(currency)) {
			return this.wallet.get(currency);
		} throw new NullPointerException(currency + " is not in " + this.name + "'s wallet");
		
	}
	
	/*
	 * Checks if a currency exists in a user's wallet
	 * 
	 * @return true if currency exists in a user's wallet, else false
	 */
	public boolean isCurrencyInWallet(String currency) {
		
		return wallet.containsKey(currency);
	}
	
	/*
	 * Update user's wallet after a valid transaction
	 * 
	 * @params currency to be converted from, currency to be converted to, amount of currency to be converted from, and amount to increase currency to be converted to
	 */
	public void updatesWallet(String fromCurrency, String toCurrency, double amountToConvert, double amountToIncreaseToCurrencyBy) {
		
		// 1. Increase value of toCurrency
		this.increaseCurrencyValueInWallet(toCurrency, amountToIncreaseToCurrencyBy);
		
		// 2. Decrease value of fromCurrency
		this.decreaseCurrencyValueInWallet(fromCurrency, amountToConvert);
		
		// 3. If the value of the fromCurrency in the user's wallet is zero, remove it from the user's wallet 
		if (this.isValueOfCurrencyInWalletEqualToZero(fromCurrency)) {
			removesCurrencyWithValueOfZero(fromCurrency);
		}
	
	}
	
	/*
	 * Retrieves number of currencies in a user's wallet
	 * 
	 * @return -1 if user's wallet is null, else a non-negative number
	 */
	@JsonIgnore
	public int getsNumberOfCurrenciesInWallet() {
		
		return this.wallet == null ? -1 : this.wallet.size();
		
	}
	
}
