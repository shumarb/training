/*
 * Runner.java
 * 
 * This program represents an implementation of a currency conversion system.
 * 
 * This program involves a set of user profiles, as well as instructions pertaining to a set of transactions,
 * 
 * Every transaction will involve a conversion of currency from one form to another for a user.
 * This program will process every transaction by checking its validity, displaying an output to the console,
 * and storing it in a logger file.
 * 
 * @author Sheikh Umar
 */

package com.fdmgroup.ood3assessment.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/*
 * This program serves as an automated currency conversion system that 
 * processes all of a user's transactions, and updates the user's wallet accordingly.
 * 
 * The automated currency conversion system works as follows:
 * 
 * 1. The program validates at least one transaction.
 * Every transaction has four components:
 * 1.1. The user's name.
 * 1.2. The currency to be converted from (fromCurrency).
 * 1.3. The currency to be converted to (toCurrency).
 * 1.4. The amount of the fromCurrency to be converted to the toCurrency.
 * 
 * 2. A transaction is either valid or invalid.
 * Every invalid transaction is skipped, whilst a currency conversion occurs for a valid transaction.
 * after which th the currencies and amounts in the user's wallet are updated.
 * 
 * 3. After every transaction, a message will be displayed in the console and stored in a logger.
 * The message displayed indicates either one of the following:
 * 3.1. A valid transaction, and the amount and currencies involved in the conversion.
 * 3.2. An invalid transaction, and the reason that the transaction was skipped.
 * 
 */
public class Runner {
	
	/*
	 * Constant variables named according to the files it is accessing
	 */
	private static final String FX_RATES_FILE = "src/main/resources/fx_rates.json";
	private static final String TRANSACTIONS_FILE = "src/main/resources/transactions.txt";
	private static final String USERS_FILE = "src/main/resources/users.json";
	
	/*
	 * Logger to log message on validity of every transaction
	 */
	private static final Logger logger = LogManager.getLogger(Runner.class);
	
	/*
	 * List of users from Users.json
	 */
	public static List <User> usersList = new ArrayList <User> ();
	
	/*
	 * List of currency and it's respective currency object from fx_rate.json
	 */
	public static Map <String, Currency> currenciesMap = new HashMap <String, Currency> ();
	
	/*
	 * Processes every transaction
	 * For every outcome of a transaction, 
	 * display its output in console and log it in a logger file
	 */
	private static void validateTransactions() throws StreamReadException, DatabindException, IOException {
		/*
		 * Using try-with-resources ensure the resources are automatically closed
		 * after usage. This prevents resource leaks.
		 */
		try (
				InputStream inputStream = new FileInputStream(TRANSACTIONS_FILE);
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);	
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
				
        ) {    
            	/*
	             * 1. Retrieve every transaction in transaction.txt
	             * 
	             * 2. Check if it is a valid/skipped transaction,
	             * and carry out the steps for valid and invalid transactions
	             * 
	             * 3. Display a log result on console and append it to the logger file
	             */
	            String transaction;
	            
	            while ((transaction = bufferedReader.readLine()) != null) {
	            	/*
	            	 * A transaction comprises of every line in the transaction.txt file.
	            	 * 
	            	 * Every transaction comprises of four components:
	            	 * name, from currency, to currency, and amount of from currency to convert to the to currency
	            	 * 
	            	 * Split the transaction using the white space to create an array comprising of these four attributes
	            	 * Every element corresponds to its index in the transaction.
	            	 * Example: a transaction comprises of: bob SGD MYR 122
	            	 * In the transactionInformation array, bob is the first element, SGD is the second element,
	            	 * MYR is the third element, and 122 is the fourth element.
	            	 * 
	            	 * In summary
	            	 * transactionInformation[0]: name of user
	            	 * transactionInformation[1]: from currency
	            	 * transactionInformation[2]: to currency
	            	 * transactionInformation[3]: amount of from currency to convert into the to currency
	            	 */
	                String[] transactionInformation = transaction.split(" ");
	                
	                
	                /*
	                 * 1. Check if transaction has exactly 4 fields.
	                 * Skipped transaction if it does not have 4 fields
	                 */
	                if (transactionInformation.length == 4) {
	                	
	                	/*
	                	 * 2. Check if user exists
	                	 * Skipped transaction if user does not exist
	                	 */
	                	String username = transactionInformation[0];
	                	User user = getsUser(username);
	                	if (user != null) {
	                		
	                		/*
	                		 * 3. Check if currencies provided both exist
	                		 * Skipped transaction if either one or both do not exist
	                		 */
	                		String fromCurrency = transactionInformation[1];
	                		String toCurrency = transactionInformation[2];
	      
	                		if (doesCurrencyExist(fromCurrency) && doesCurrencyExist(toCurrency)) {
	                			/* 
			                	 * 4. Check if both fromCurrency and toCurrency are the same
			                	 * Skipped transaction of these two currencies are the same
			                	 */
	                			if (!isSameCurrency(toCurrency, fromCurrency)) {
			                		
	                				/*
		                			 * 5. Checks if amount to be converted from the fromCurrency to the toCurrency is valid
		                			 * Skipped transaction if amount is <= 0
		                			 */
		                			double amountToConvert = Double.parseDouble(transactionInformation[3]);
		                			if (isValidAmount(amountToConvert)) {
		                				
		                				/*
		                				 * 6. Check if user has the fromCurrency in his/her wallet
		                				 * Skipped transaction if user does not have the from currency in his/her wallet
		                				 */
		                				if (doesUserHaveCurrency(user, fromCurrency)) {
		                					/*
			                				 * 7. Check if value of fromCurrency in user's wallet is more than or equal to the amount specified for conversion
			                				 * Skipped transaction if the from currency in user's wallet is less than the amount to be converted to
			                				 */
		                					if (isSufficientAmountForConversion(user, fromCurrency, amountToConvert)) {
		                						
		                						/*
		                						 * 8. Transaction is valid. Proceed with conversion
		                						 * then update users.json via Serialization
		                						 */
		                						currencyConversion(user, fromCurrency, toCurrency, amountToConvert);
		                					
		                					} else {
		                						
		                						logger.error("Skipped Transaction: " + username + " does not enough " + fromCurrency + " for conversion.");
		                						
		                					}
		                					
		                				} else {
		                					
		                					logger.error("Skipped Transaction: " + username + " does not have the currency to be converted from.");
		                				}
		                			
		                			} else {
		                				
		                				logger.error("Skipped Transaction: Amount to convert is less than or equal to " + fromCurrency + "0.");
		                			
		                			}
	                				
			                	} else {
			                		
			                		logger.error("Skipped Transaction: The two currencies provided are the same.");
			                	}
	                			
	                		} else {
	                			
	                			/*
	                			 * 3.1. The fromCurrency exists but not the toCurrency
	                			 */
	                			if (doesCurrencyExist(fromCurrency) && !doesCurrencyExist(toCurrency)) {
		                			
		                			logger.error("Skipped Transaction: The currency " + toCurrency + " does not exist on the foreign exchange.");
		                		
		                		} else if (!doesCurrencyExist(fromCurrency) && doesCurrencyExist(toCurrency)) {
		                			/*
		                			 * 3.2. The toCurrency exists but not the fromCurrency
		                			 */
		                			logger.error("Skipped Transaction: The currency " + fromCurrency + " does not exist on the foreign exchange.");
		                		
		                		} else {
		                			/*
		                			 * 3.3. Both the fromCurrency and toCurrency do not exist
		                			 */
		                			logger.error("Skipped Transaction: Both currencies " + fromCurrency + " and " + toCurrency + " do not exist on the foreign exchange.");
		                		}
	                		}
	                			
	                	} else {
	                		
	                		logger.error("Skipped Transaction: User named " + username + " does not exist.");
	                	}
	                	
	                } else {
	                	
	                	logger.error("Skipped Transaction: Transaction has " + transactionInformation.length + " components instead of 4 components as required.");
	                }
	                
	            }

        } catch (IOException e) {
        	
        	logger.error("Unable to access the transaction.txt file.");
            
        } catch (NullPointerException e) {
        	
        	logger.error("Unable to access the transaction.txt file.");
        }
	}
	
	/*
	 * Convert an amount to usd
	 * 
	 * @params: amount and currency to convert to usd
	 */
	private static double convertAmountToUsd(String currency, double amount) {
		
		return amount * currenciesMap.get(currency).getInverseRate();
	}
	
	/*
	 * Convert an amount to usd
	 * 
	 * @params: amount and currency to convert to usd
	 */
	private static double convertAmountFromUsd(String currency, double amount) {
		
		return amount * currenciesMap.get(currency).getRate();
	}
	
	/*
	 * Convert the user's fromCurrency to the toCurrency
	 * And update the values of the currencies in the user's wallet
	 * 
	 * @params: user's name, currency to be converted from (fromCurrency), currency to be converted to (toCurrency), 
	 * and amount of fromCurrency to be converted to toCurrency
	 */
	public static void currencyConversion(User user, String fromCurrency, String toCurrency, double amountToConvert) throws StreamReadException, DatabindException, IOException {
		
		double amountToIncreaseToCurrencyBy = 0;
		
		// 1. Conversion of currency
		
		// 1.1. toCurrency is in usd
		if (toCurrency.equals("usd")) {
			
			// 1.1.1. Get usd equivalent of amountToConvert
			amountToIncreaseToCurrencyBy = convertAmountToUsd(fromCurrency, amountToConvert);
			
		} else if (fromCurrency.equals("usd")) {
			// 1.2. fromCurrency is in usd
			
			// 1.2.1. Compute the equivalent of the fromCurrency in usd
			amountToIncreaseToCurrencyBy = convertAmountFromUsd(toCurrency, amountToConvert);
			
		} else {
			// 1.3. Both fromCurrency and toCurrency are not usd
			
			// 1.3.1. Get usd equivalent of amountToConvert
			double amountToConvertInUsd = convertAmountToUsd(fromCurrency, amountToConvert);
			
			// 1.3.2. Get toCurrency equivalent of amountToConvertInUsd
			amountToIncreaseToCurrencyBy = convertAmountFromUsd(toCurrency, amountToConvertInUsd);		
		}
		
		// 2. Update toCurrency and fromCurrency values in the user's wallet
		
		// 2.1 Increase the value of toCurrency in the user's wallet by amountToIncreaseToCurrencyBy
		user.increaseCurrencyValueInWallet(toCurrency, amountToIncreaseToCurrencyBy);
		
		// 2.2. Decrease the value of the from currency in the user's wallet by the amountToConvert
		user.decreaseCurrencyValueInWallet(fromCurrency, amountToConvert);
					
		// 3. If the value of the fromCurrency in the user's wallet is now zero, remove it from the user's wallet
		if (user.isValueOfCurrencyInWalletEqualToZero(fromCurrency)) {
			user.removesCurrencyWithValueOfZero(fromCurrency);
		}
		
		// 4. Display message to indicate conversion of currencies has been successfully completed
		logger.info("Valid Transaction: Success! Converted " + fromCurrency + amountToConvert + " to " + toCurrency + amountToIncreaseToCurrencyBy + ".");
		
		// 5. Update user's profile in users.json with updated values and currencies in wallet
		serialization(user);
	}
	
	/*
	 * Checks if a user has enough value in the from currency for conversion (fromCurrency)
	 * 
	 * @params: user's name, currency to be converted from, and amount of currency to be converted from
	 */
	public static boolean isSufficientAmountForConversion(User user, String fromCurrency, double amountToConvert) {
		
		return user.getCurrencyValueInWallet(fromCurrency) >= amountToConvert;
	}

	/*
	 * Checks if a user has a currency to be converted from (fromCurrency) in his/her wallet
	 * 
	 * @params user's name, and currency that user wants to convert from
	 * @return true if user has currency to be converted from, false otherwise
	 */
	public static boolean doesUserHaveCurrency(User user, String fromCurrency) {
		
		return user.isCurrencyInWallet(fromCurrency);
	}

	/*
	 * Checks if an amount to be converted is less than or equal to 0
	 * 
	 * @params amount to be converted from the for currency to the to currency
	 * @return false if amount is less than or equal to 0, true otherwise
	 */
	public static boolean isValidAmount(double amountToConvert) {
		
		return amountToConvert > 0;
	}

	/*
	 * Checks if a currency is exists in the forex exchange
	 * 
	 * @params currency
	 * @return boolean result of whether currency exists on foreign exchange
	 */
	public static boolean doesCurrencyExist(String currency) {
		
		// Even though USD is not in the currenciesMap,
		// it is a valid currency because all currency rates are 
		// based on a comparison against usd (USD currency)
		if (currency.equals("usd")) {
			return true;
		}
		
		return currenciesMap.containsKey(currency);
	}

	/*
	 * Checks if two currencies are the same
	 * 
	 * @params currency to be converted from, and currency to be converted to
	 * @return outcome of comparison of these two currencies
	 */
	public static boolean isSameCurrency(String toCurrency, String fromCurrency) {
		
		return toCurrency.equals(fromCurrency);
	}

	/*
	 * Check if the user exists in the usersList
	 * by checking that a user's name matches name provided
	 * 
	 * @params: name of user
	 * @return: result of whether the user exists in the usersList
	 */
	public static User getsUser(String name) {
		
		for (int i = 0; i < usersList.size(); i++) {
			User currentUser = usersList.get(i);
			if (currentUser.getName().equals(name)) {
				return currentUser;
			}
		}
		
		return null;
	}
	
	/*
	 * Serialization is the process of converting a Java object to a data format.
	 * In this case, the data format is JSON.
	 * 
	 * Execute serialization for users.json after a valid transaction
	 * in order to update the user's profile
	 * 
	 * @args User of valid currency conversion transaction
	 * @throws StreamReadException, DatabindException, IOException
	 */
	private static void serialization(User user) {
		
		File destination = new File(USERS_FILE);
		ObjectMapper objectMapper = new ObjectMapper();

		try {
            objectMapper.writeValue(destination, usersList);
        } catch (IOException e) {
        	logger.error("Unable to update the users.json file.");
        }
	}
	

	/*
	 * Deserialization is the process of converting JSON objects into Java object
	 * 
	 * Execute deserialization for fx_rates.json and users.json
	 * Before processing transactions.txt
	 * 
	 * @throws StreamReadException, DatabindException, IOException
	 */
	private static void deserialization() throws StreamReadException, DatabindException, IOException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		/*
		 * Deserialize
		 * Extract every entry in users.json,
		 * parse it into a User object,
		 * and add it to the users list called usersList
		 */
		usersList = objectMapper.readValue(
				
					new File(USERS_FILE),
					objectMapper.getTypeFactory().constructCollectionType(List.class, User.class)
					
				);
		
		/*
		 * Deserialize
		 * Extract every entry in fx_rates.json,
		 * form a Currency object, 
		 * and add it to the currencies hashMap called currenciesMap,
		 * where the key-value mappings are currencyCode-Currency object
		 */
		currenciesMap = objectMapper.readValue(
				
	            new File(FX_RATES_FILE),
	            objectMapper.getTypeFactory().constructMapType(HashMap.class, String.class, Currency.class)
	            
	    );
		
	}
	
	public static void main(String[] args) {
		
		try {    
			
				/*
				 * 1. Deserialize the users.json and fx_rates.json files
				 * to populate the users list and currencies map respectively.
				 */
				deserialization();
				
				/*
				 * 2. Read every line in the transaction
				 * and determine if it is a valid or invalid transaction.
				 * Finally, logging is carried out for every transaction
				 * both on the console and in a log file.
				 */
				validateTransactions();

        } catch (NullPointerException e) {
        	
        	logger.error("Unable to access the transactions.txt file.");
            
        } catch (JsonParseException e) {
        	
        	logger.error("Unable to parse the JSON file.");
            
        }  catch (StreamReadException e) {
        	
        	logger.error("Unable to parse the JSON file.");
            
        } catch (DatabindException e) {
        	
        	logger.error("Unable to parse the JSON file.");
            
        } catch (JsonProcessingException e) {
        	
        	logger.error("Unable to parse the JSON file.");
            
		}  catch (IOException e) {
			
			logger.error("Unable to access the file.");
            
        }
		
    }

}
