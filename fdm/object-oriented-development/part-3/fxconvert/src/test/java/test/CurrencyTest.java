package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import entities.Currency;

class CurrencyTest {

	@Mock
	Map <String, Currency> currenciesMap;
	
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
		
		currenciesMap = new HashMap <String, Currency> ();
		
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
	}

	@Test
	public void test_currenciesMapIsZero_whencurrenciesMapIsEmpty() {
		
		assertEquals(0, currenciesMap.size());
	}
	
	@Test
	public void test_currencyListIsNotANonZeroValue_whenCurrenciesMapIsEmpty() {
		
		assertNotEquals(10, currenciesMap.size());
	}
	
	@Test
	public void test_currenciesMapSizeIsCorrectSingleValue_afterInsertingOneCurrency() {
		
		currenciesMap.put("eur", eur);
		assertEquals(1, currenciesMap.size());
	}
	
	@Test
	public void test_currenciesMapSizeIsCorrectMultipleValue_afterInsertingFourCurrencies() {
		
		currenciesMap.put("eur", eur);
		currenciesMap.put("jpy", eur);
		currenciesMap.put("gbp", eur);
		currenciesMap.put("aud", eur);
		assertEquals(4, currenciesMap.size());
	}
	
	@Test
	public void test_currenciesMapReturnsTrue_afterInsertingCurrency() {
		
		currenciesMap.put("eur", eur);
		assertEquals(true, currenciesMap.containsKey("eur"));
	}
	
	@Test
	public void test_currenciesMapDoesNotReturnFalse_afterInsertingCurrency() {
		
		currenciesMap.put("eur", eur);
		assertNotEquals(false, currenciesMap.containsKey("eur"));
	}
	
	@Test
	public void test_correctAcronymReturned_afterInsertingCurrency() {
		
		currenciesMap.put("aud", aud);
		assertEquals("aud", currenciesMap.get("aud").getAcronym());
	}
	
	@Test
	public void test_incorrectAcronymNotReturned_afterInsertingCurrency() {
		
		currenciesMap.put("aud", aud);
		currenciesMap.put("eur", eur);
		assertNotEquals(currenciesMap.get("eur").getAcronym(), currenciesMap.get("aud").getAcronym());
	}
	
	@Test
	public void test_correctRateReturned_afterInsertingCurrency() {
		
		currenciesMap.put("jpy", jpy);
		assertEquals(142.32291211472, currenciesMap.get("jpy").getRate());
		
	}
	
	@Test
	public void test_incorrectRateNotReturned_afterInsertingCurrency() {
		
		currenciesMap.put("jpy", jpy);
		currenciesMap.put("aud", aud);
		assertNotEquals(currenciesMap.get("jpy").getRate(), currenciesMap.get("aud").getRate());
		
	}
	
	@Test
	public void test_correctInverseRateReturned_afterInsertingCurrency() {
		
		currenciesMap.put("gbp", gbp);
		assertEquals(1.1704259482983, currenciesMap.get("gbp").getInverseRate());
		
	}
	
	@Test
	public void test_incorrectInverseRateNotReturned_afterInsertingCurrency() {
		
		currenciesMap.put("gbp", gbp);
		currenciesMap.put("aud", aud);
		assertNotEquals(currenciesMap.get("gbp").getInverseRate(), currenciesMap.get("aud").getInverseRate());
		
	}
	
	@Test
	public void test_correctCodeReturned_afterInsertingCurrency() {
		
		currenciesMap.put("gbp", gbp);
		assertEquals("GBP", currenciesMap.get("gbp").getCode());
		
	}
	
	@Test
	public void test_inCorrectCodeNotReturned_afterInsertingCurrency() {
		
		currenciesMap.put("gbp", gbp);
		currenciesMap.put("jpy", jpy);
		assertNotEquals(currenciesMap.get("jpy").getCode(), currenciesMap.get("gbp").getCode());
		
	}
	
	@Test
	public void test_correcAlphaCodeReturned_afterInsertingCurrency() {
		
		currenciesMap.put("eur", eur);
		assertEquals("EUR", currenciesMap.get("eur").getAlphaCode());
		
	}
	
	@Test
	public void test_incorrecAlphaCodeNotReturned_afterInsertingCurrency() {
		
		currenciesMap.put("eur", eur);
		currenciesMap.put("aud", aud);
		assertNotEquals(currenciesMap.get("eur").getAlphaCode(), currenciesMap.get("aud").getAlphaCode());
		
	}
	
	@Test
	public void test_correcNumericCodeReturned_afterInsertingCurrency() {
		
		currenciesMap.put("eur", eur);
		assertEquals("978", currenciesMap.get("eur").getNumericCode());
		
	}
	
	@Test
	public void test_incorrecNumericCodeNotReturned_afterInsertingCurrency() {
		
		currenciesMap.put("eur", eur);
		currenciesMap.put("jpy", jpy);
		assertNotEquals(currenciesMap.get("eur").getNumericCode(), currenciesMap.get("jpy").getNumericCode());
		
	}
	
	@Test
	public void test_correctNameReturned_afterInsertingCurrency() {
		
		currenciesMap.put("gbp", gbp);
		assertEquals("U.K. Pound Sterling", currenciesMap.get("gbp").getName());
		
	}
	
	@Test
	public void test_incorrectNameNotReturned_afterInsertingCurrency() {
		
		currenciesMap.put("gbp", gbp);
		currenciesMap.put("jpy", jpy);
		assertNotEquals(currenciesMap.get("jpy").getName(), currenciesMap.get("gbp").getName());
		
	}
	
	@Test
	public void test_correctDateReturned_afterInsertingCurrency() {
		
		currenciesMap.put("aud", aud);
		assertEquals("Tue, 13 Sep 2022 11:55:01 GMT", currenciesMap.get("aud").getDate());
		
	}
	
	@Test
	public void test_acronymSetCorrectly_afterInsertingCurrency() {
		
		currenciesMap.put("aud", aud);
		currenciesMap.get("aud").setAcronym("mmm");
		assertEquals("mmm", currenciesMap.get("aud").getAcronym());
	}
	
	@Test
	public void test_acronymNotSetIncorrectly_afterInsertingCurrency() {
		
		currenciesMap.put("aud", aud);
		currenciesMap.get("aud").setAcronym("gvvkv");
		assertNotEquals("mmm", currenciesMap.get("aud").getAcronym());
	}
	
	@Test
	public void test_codeSetCorrectly_afterInsertingCurrency() {
		
		currenciesMap.put("jpy", jpy);
		currenciesMap.get("jpy").setCode("ERAFA");
		assertEquals("ERAFA", currenciesMap.get("jpy").getCode());
	}
	
	@Test
	public void test_codeNotSetIncorrectly_afterInsertingCurrency() {
		
		currenciesMap.put("eur", eur);
		currenciesMap.get("eur").setCode("ERAFA");
		assertNotEquals("eur", currenciesMap.get("eur").getCode());
	}
	
	@Test
	public void test_alphaCodeSetCorrectly_afterInsertingCurrency() {
		
		currenciesMap.put("jpy", jpy);
		currenciesMap.get("jpy").setAlphaCode("araer");
		assertEquals("araer", currenciesMap.get("jpy").getAlphaCode());
	}
	
	@Test
	public void test_alphaCodeNotSetIncorrectly_afterInsertingCurrency() {
		
		currenciesMap.put("jpy", jpy);
		currenciesMap.get("jpy").setAlphaCode("ERAFA");
		assertNotEquals("jpy", currenciesMap.get("jpy").getAlphaCode());
	}
	
	@Test
	public void test_numericCodeSetCorrectly_afterInsertingCurrency() {
		
		currenciesMap.put("jpy", jpy);
		currenciesMap.get("jpy").setNumericCode("131");
		assertEquals("131", currenciesMap.get("jpy").getNumericCode());
	}
	
	@Test
	public void test_numericCodeNotSetIncorrectly_afterInsertingCurrency() {
		
		currenciesMap.put("jpy", jpy);
		currenciesMap.get("jpy").setNumericCode("131");
		assertNotEquals("392", currenciesMap.get("jpy").getNumericCode());
	}
	
	@Test
	public void test_nameSetCorrectly_afterInsertingCurrency() {
		
		currenciesMap.put("jpy", jpy);
		currenciesMap.get("jpy").setName("Singapore Dollar");
		assertEquals("Singapore Dollar", currenciesMap.get("jpy").getName());
	}
	
	@Test
	public void test_nameNotSetIncorrectly_afterInsertingCurrency() {
		
		currenciesMap.put("jpy", jpy);
		currenciesMap.get("jpy").setName("Singapore Dollar");
		assertNotEquals("Japanese Yen", currenciesMap.get("jpy").getName());
	}
	
	@Test
	public void test_dateSetCorrectly_afterInsertingCurrency() {
		
		currenciesMap.put("jpy", jpy);
		currenciesMap.get("jpy").setDate("1 January 2024");
		assertEquals("1 January 2024", currenciesMap.get("jpy").getDate());
	}
	
	@Test
	public void test_dateNotSetIncorrectly_afterInsertingCurrency() {
		
		currenciesMap.put("jpy", jpy);
		currenciesMap.get("jpy").setDate("1 January 2024");
		assertNotEquals("Tue, 13 Sep 2022 11:55:01 GMT", currenciesMap.get("jpy").getDate());
	}

}
