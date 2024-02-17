package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

import entities.Currency;
import entities.User;
import main.Runner;

class RunnerTest {
	
	@Mock
	User user1;
	
	@Mock 
	User user2;
	
	@Mock
	Currency eur;
	
	@Mock
	Currency gbp;
	
	@Mock
	Currency jpy;
	
	@Mock
	Currency aud;
	
	@BeforeEach
	void setUp() throws Exception {
		
		eur = new Currency
		(
			0.98535489535028, 
			1.0148627714936,
			"eur",
			"EUR",
			"EUR",
			"978",
			"Euro",
			"Tue, 13 Sep 2022 11:55:01 GMT"
		);
				
		gbp = new Currency
		(
			0.85438980693642, 
			1.1704259482983,
			"gbp",
			"GBP",
			"GBP",
			"826",
			"U.K. Pound Sterling",
			"Tue, 13 Sep 2022 11:55:01 GMT"
		);
				
		jpy = new Currency
		(
			142.32291211472, 
			0.007026275566888,
			"jpy",
			"JPY",
			"JPY",
			"392",
			"Japanese Yen",
			"Tue, 13 Sep 2022 11:55:01 GMT"
		);
				
		aud = new Currency
		(
			1.4537833499222, 
			0.68786040234504,
			"aud",
			"AUD",
			"AUD",
			"036",
			"Australian Dollar",
			"Tue, 13 Sep 2022 11:55:01 GMT"
		);
		
		Runner.usersList = new ArrayList <User> ();
		user1 = new User("Ali");
		user1.addCurrencyToWallet("jpy", 10.0);
		user1.addCurrencyToWallet("aud", 56.4);
		user1.addCurrencyToWallet("eur", 88.0);
		user1.addCurrencyToWallet("gbp", 1331.4);
		Runner.usersList.add(user1);
		
		user2 = new User("John");
		user2.addCurrencyToWallet("eur", 88.0);
		user2.addCurrencyToWallet("gbp", 1331.4);
		user2.addCurrencyToWallet("usd", 40);
		Runner.usersList.add(user2);
		
		Runner.currenciesMap = new HashMap <String, Currency> ();
		Runner.currenciesMap.put("eur", eur);
		Runner.currenciesMap.put("gbp", gbp);
		Runner.currenciesMap.put("jpy", jpy);
		Runner.currenciesMap.put("aud", aud);
		
	}
	
	@Test
	public void testUserExist_returnsCorrectUser() {
		
		Runner.usersList.add(user1);
		assertEquals(user1, Runner.getsUser("Ali"));
		
	}
	
	@Test
	public void testUserExist_doesNotReturnNull() {
		
		Runner.usersList.add(user1);
		assertNotEquals(null, Runner.getsUser("Ali"));
		
	}
	
	@Test
	public void testUserExist_doesNotReturnIncorrectUser() {
		
		Runner.usersList.add(user1);
		Runner.usersList.add(user2);
		assertNotEquals(user2, Runner.getsUser("Ali"));
		
	}
	
	@Test
	public void testUserDoesNotExist_returnsNull() {
		
		assertEquals(null, Runner.getsUser("William"));
		
	}
	
	@Test
	public void testUserDoesNotExist_doesNotReturnNonNullValue() {
		
		Runner.usersList.add(user1);
		assertNotEquals(null, Runner.getsUser("Ali"));
		
	}
	
	@Test
	public void testUserDoesNotExist_doesNotReturnExistingUser() {
		
		assertNotEquals(null, Runner.getsUser("Ali"));
		
	}

	@Test
	public void test_isSameCurrencyReturnsTrue_forSameCurrencies() {
		
		assertEquals(true, Runner.isSameCurrency("sgd", "sgd"));
	}
	
	@Test
	public void test_isSameCurrencyDoesNotReturnFalse_forSameCurrencies() {
		
		assertNotEquals(false, Runner.isSameCurrency("sgd", "sgd"));
	}
	
	@Test
	public void test_isSameCurrencyReturnsFalse_forDifferentCurrencies() {
		
		assertEquals(false, Runner.isSameCurrency("aud", "sgd"));
	}
	
	@Test
	public void test_isSameCurrencyDoesNotReturnTrue_forDifferentCurrencies() {
		
		assertNotEquals(true, Runner.isSameCurrency("aud", "sgd"));
	}
	
	@Test
	public void test_doesCurrencyExistReturnsTrue_forExistentCurrency() {
		
		assertEquals(true, Runner.isValidCurrency("eur"));
	}
	
	@Test
	public void test_doesCurrencyExistDoesNotReturnFalse_forExistentCurrency() {
		
		assertNotEquals(false, Runner.isValidCurrency("eur"));
	}
	
	@Test
	public void test_doesCurrencyExistReturnFalse_forNonExistentCurrency() {
		
		assertEquals(false, Runner.isValidCurrency("afaefae"));
	}
	
	@Test
	public void test_doesCurrencyExistDoesNotReturnTrue_forNonExistentCurrency() {
		
		assertNotEquals(true, Runner.isValidCurrency("afaefae"));
	}
	
	@Test
	public void test_isValidAmountReturnsTrue_forValidAmount() {
		
		assertEquals(true, Runner.isValidAmount(10));
	}
	
	public void test_isValidAmountDoesNotReturnFalse_forValidAmount() {
		
		assertNotEquals(false, Runner.isValidAmount(10));
	}
	
	@Test
	public void test_isValidAmountReturnsFalse_forInvalidAmount() {
		
		assertEquals(false, Runner.isValidAmount(-10));
	}
	
	@Test
	public void test_isValidAmountDoesNotReturnTrue_forInvalidAmount() {
		
		assertNotEquals(true, Runner.isValidAmount(-10));
	}
	
	@Test
	public void test_doesUserHaveCurrencyReturnsTrue_whenUserHasCurrency() {
		
		assertEquals(true, Runner.doesUserHaveCurrency(user1, "eur"));
		
	}
	
	@Test
	public void test_doesUserHaveCurrencyDoesNotReturnFalse_whenUserHasCurrency() {
		
		assertNotEquals(false, Runner.doesUserHaveCurrency(user1, "eur"));
		
	}
	
	@Test
	public void test_doesUserHaveCurrencyReturnsFalse_whenUserDoesNotHaveCurrency() {
		
		assertEquals(false, Runner.doesUserHaveCurrency(user1, "sgd"));
		
	}
	
	@Test
	public void test_doesUserHaveCurrencyDoesNotReturnTrue_whenUserDoesNotHaveCurrency() {
		
		assertNotEquals(true, Runner.doesUserHaveCurrency(user1, "sgd"));
		
	}
	
	@Test
	public void test_isSufficientAmountForConversionReturnsTrue_forSufficientAmount() {
		
		assertEquals(true, Runner.isSufficientAmountForConversion(user1, "eur", 5));
		
	}
	
	@Test
	public void test_isSufficientAmountForConversionDoesNotReturnFalse_forSufficientAmount() {
		
		assertNotEquals(false, Runner.isSufficientAmountForConversion(user1, "eur", 5));
	}
	
	@Test
	public void test_isSufficientAmountForConversionReturnsFalse_forInsufficientAmount() {
		
		assertEquals(false, Runner.isSufficientAmountForConversion(user1, "eur", 500));
		
	}
	
	@Test
	public void test_isSufficientAmountForConversionDoesNotReturnTrue_forInsufficientAmount() {
		
		assertNotEquals(true, Runner.isSufficientAmountForConversion(user1, "eur", 500));
		
	}
	
	@Test
	public void test_conversionOfCurrency_forAllAmountOfNonUsdCurrencyInWallet_toAnotherNonUsdCurrencyInWallet_totalCurrencyReducedByOne() throws StreamReadException, DatabindException, IOException {
		
		int numberOfCurrenciesBeforeConversion = user2.getsNumberOfCurrenciesInWallet();
		Runner.currencyConversion(user2, "eur", "gbp", 88.0);
		assertEquals(numberOfCurrenciesBeforeConversion - 1, user2.getsNumberOfCurrenciesInWallet());
		
	}
	
	@Test
	public void test_conversionOfCurrency_forAllAmountOfUsdCurrencyInWallet_toAnotherNonUsdCurrencyInWallet_totalCurrencyReducedByOne() throws StreamReadException, DatabindException, IOException {
		
		int numberOfCurrenciesBeforeConversion = user2.getsNumberOfCurrenciesInWallet();
		Runner.currencyConversion(user2, "usd", "gbp", 40.0);
		assertEquals(numberOfCurrenciesBeforeConversion - 1, user2.getsNumberOfCurrenciesInWallet());
		
	}
	
	@Test
	public void test_conversionOfCurrency_forAllAmountOfNonUsdCurrencyInWallet_toUsdCurrencyInWallet_totalCurrencyReducedByOne() throws StreamReadException, DatabindException, IOException {
		
		int numberOfCurrenciesBeforeConversion = user2.getsNumberOfCurrenciesInWallet();
		Runner.currencyConversion(user2, "gbp", "usd", 1331.4);
		assertEquals(numberOfCurrenciesBeforeConversion - 1, user2.getsNumberOfCurrenciesInWallet());
		
	}
	
	@Test
	public void test_conversionOfCurrency_forSomeAmountOfNonUsdCurrencyInWallet_toAnotherNonUsdCurrencyInWallet_totalCurrencyRemainsTheSame() throws StreamReadException, DatabindException, IOException {
		
		int numberOfCurrenciesBeforeConversion = user2.getsNumberOfCurrenciesInWallet();
		Runner.currencyConversion(user2, "eur", "gbp", 22.5);
		assertEquals(numberOfCurrenciesBeforeConversion, user2.getsNumberOfCurrenciesInWallet());
		
	}
	
	@Test
	public void test_conversionOfCurrency_forSomeAmountOfNonUsdCurrencyInWallet_toUsdCurrencyInWallet_totalCurrencyRemainsTheSame() throws StreamReadException, DatabindException, IOException {
		
		int numberOfCurrenciesBeforeConversion = user2.getsNumberOfCurrenciesInWallet();
		Runner.currencyConversion(user2, "eur", "usd", 22.5);
		assertEquals(numberOfCurrenciesBeforeConversion, user2.getsNumberOfCurrenciesInWallet());
		
	}
	
	@Test
	public void test_conversionOfCurrency_forSomeAmountOfUsdInWallet_toNonUsdCurrencyInWallet_totalCurrencyRemainsTheSame() throws StreamReadException, DatabindException, IOException {
		
		int numberOfCurrenciesBeforeConversion = user2.getsNumberOfCurrenciesInWallet();
		Runner.currencyConversion(user2, "usd", "eur", 20);
		assertEquals(numberOfCurrenciesBeforeConversion, user2.getsNumberOfCurrenciesInWallet());
		
	}
	
	@Test
	public void test_conversionOfCurrency_forSomeAmountOfNonUsdCurrencyInWallet_toNonUsdCurrencyNotInWallet_totalCurrencyIncreasedByOne() throws StreamReadException, DatabindException, IOException {
		
		int numberOfCurrenciesBeforeConversion = user2.getsNumberOfCurrenciesInWallet();
		Runner.currencyConversion(user2, "gbp", "jpy", 22.5);
		assertEquals(numberOfCurrenciesBeforeConversion + 1, user2.getsNumberOfCurrenciesInWallet());
		
	}
	
	@Test
	public void test_conversionOfCurrency_forSomeAmountOfUsdCurrencyInWallet_toNonUsdCurrencyNotInWallet_totalCurrencyIncreasedByOne() throws StreamReadException, DatabindException, IOException {
		
		int numberOfCurrenciesBeforeConversion = user2.getsNumberOfCurrenciesInWallet();
		Runner.currencyConversion(user2, "usd", "jpy", 12);
		assertEquals(numberOfCurrenciesBeforeConversion + 1, user2.getsNumberOfCurrenciesInWallet());
		
	}
	
}
