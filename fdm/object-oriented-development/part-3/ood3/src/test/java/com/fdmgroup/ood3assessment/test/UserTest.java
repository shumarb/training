package com.fdmgroup.ood3assessment.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.fdmgroup.ood3assessment.main.User;

class UserTest {

	@Mock
	List <User> usersList; 
	
	@Mock
	User user1;
	
	@BeforeEach
	void setUp() throws Exception {
		
		usersList = new ArrayList <User> ();
		user1 = new User("Luke");
	}
	
	@Test
	public void test_usersListIsEmpty_whenNoUsersAdded() {
		assertEquals(0, usersList.size());
	}
	
	@Test
	public void test_correctUserNameReturned() {
		
		assertEquals("Luke", user1.getName());
	}
	
	@Test
	public void test_incorrectUserNameNotReturned() {
		
		assertNotEquals("Harry", user1.getName());
	}
	
	@Test
	public void test_usersListHasOneUser_WhenOneUserAdded() {
		
		user1.addCurrencyToWallet("sgd", 10);
		user1.addCurrencyToWallet("myr", 50);
		usersList.add(user1);
		assertEquals(1, usersList.size());
		
	}
	
	@Test
	public void test_usersListDoesNotHaveMoreThanOneUser_WhenOneUserAdded() {
		
		user1.addCurrencyToWallet("sgd", 10);
		user1.addCurrencyToWallet("myr", 50);
		usersList.add(user1);
		assertNotEquals(2, usersList.size());
		
	}
	
	@Test
	public void test_currencyAddedToWallet_returnsTrue_afterAddingToWallet() {
		
		user1.addCurrencyToWallet("cad", 42);
		assertEquals(user1.isCurrencyInWallet("cad"), true);
		
	}
	
	@Test
	public void test_currencyAddedToWallet_doesNotreturnFalse_afterAddingToWallet() {
		
		user1.addCurrencyToWallet("cad", 42);
		assertNotEquals(user1.isCurrencyInWallet("cad"), false);
		
	}
	
	@Test
	public void test_correctCurrencyValueReturned_afterAddingCurrencyToWallet() {
		
		user1.addCurrencyToWallet("idr", 1412);
		assertEquals(1412, user1.getCurrencyValueInWallet("idr"));
		
	}
	
	@Test
	public void test_incorrectCurrencyValueNotReturned_afterAddingCurrencyToWallet() {
		
		user1.addCurrencyToWallet("idr", 1412);
		assertNotEquals(131, user1.getCurrencyValueInWallet("idr"));
		
	}
	
	@Test
	public void test_currencyValueOfZeroRemoved_afterAddingCurrencyToWallet() {
		
		user1.addCurrencyToWallet("idr", 0);
		user1.removesCurrencyWithValueOfZero("idr");
		assertEquals(0, user1.getWallet().size());
		
	}
	
	@Test
	public void test_currencyValueThatIsNotZeroIsNotRemoved_afterAddingCurrencyToWallet() {
		
		user1.addCurrencyToWallet("idr", 13130);
		user1.removesCurrencyWithValueOfZero("idr");
		assertNotEquals(0, user1.getWallet().size());
		
	}
	
	@Test
	public void test_returnValueIsZero_afterAddingCurrencyWithValueZero() {
		
		user1.addCurrencyToWallet("myr", 0);
		assertEquals(0, user1.getCurrencyValueInWallet("myr"));
		
	}
	
	@Test
	public void test_currencyValueIsZero_afterAddingCurrencyWithValueZero() {
		
		user1.addCurrencyToWallet("myr", 0);
		assertEquals(true, user1.isValueOfCurrencyInWalletEqualToZero("myr"));
		
	}

	@Test
	public void test_returnValueIsNotZero_afterAddingCurrencyWithNonZeroValue() {
		
		user1.addCurrencyToWallet("myr", 140);
		assertNotEquals(0, user1.getCurrencyValueInWallet("myr"));
		
	}
	
	@Test
	public void test_differentUsersHaveDifferentWallets_afterCallToReturnUserWalletInvoked() {
		
		User user2 = new User("Tim");
		user2.addCurrencyToWallet("eur", 1230);
		assertNotEquals(user2.getWallet(), user1.getWallet());
		
	}
	
	@Test
	public void test_currencyValueIncreasedCorrectly() {
		
		user1.addCurrencyToWallet("sgd", 50);
		user1.increaseCurrencyValueInWallet("sgd", 110);
		assertEquals(160, user1.getCurrencyValueInWallet("sgd"));
		
	}
	
	@Test
	public void test_currencyValueDidNotIncreasedIncorrectly() {
		
		user1.addCurrencyToWallet("sgd", 50);
		user1.increaseCurrencyValueInWallet("sgd", 110);
		assertNotEquals(12310, user1.getCurrencyValueInWallet("sgd"));
		
	}
	
	@Test
	public void test_currencyValueDecreasedCorrectly() {
		
		user1.addCurrencyToWallet("sgd", 150);
		user1.increaseCurrencyValueInWallet("sgd", 110);
		assertEquals(260, user1.getCurrencyValueInWallet("sgd"));
		
	}
	
	@Test
	public void test_currencyValueDidNotDecreasedInCorrectly() {
		
		user1.addCurrencyToWallet("sgd", 150);
		user1.increaseCurrencyValueInWallet("sgd", 110);
		assertNotEquals(11414, user1.getCurrencyValueInWallet("sgd"));
		
	}

}
