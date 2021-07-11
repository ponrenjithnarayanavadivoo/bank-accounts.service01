/**
 * 
 */
package be.abc.bank.account.management;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import be.abc.bank.account.entity.AccountEntity;
import be.abc.bank.account.management.AccountManagementServiceImpl;
import be.abc.bank.account.repository.IAccountService;
import be.abc.bank.accounts.accounts.v1.model.CustomerRequestInfo;

/**
 * Unit Testing for Account Service
 *
 * @author Renjith
 *
 */
@RunWith(MockitoJUnitRunner.Silent.class)
public class AccountServiceManagementImpTest {

	@Mock
	private IAccountService myAccountService;

	@InjectMocks
	private AccountManagementServiceImpl unitTest;

	/**
	 * create account test method
	 */
	@Before
	public void initMocks() {
		unitTest = new AccountManagementServiceImpl();
		MockitoAnnotations.initMocks(this);
		myAccountService = mock(IAccountService.class);
	}

	/**
	 * Create Account Test
	 */
	@Test
	public void createAccountTest() {
		CustomerRequestInfo customer = getTestInputCustomer();
		AccountEntity t = new AccountEntity();
		doNothing().when(myAccountService).createAccount(t);
		unitTest.createAccount(customer);
	}

	private CustomerRequestInfo getTestInputCustomer() {
		CustomerRequestInfo customer = new CustomerRequestInfo();
		customer.accountType("CURRENT");
		customer.creditAmount((long) 100);
		customer.customerId(748248);
		return customer;
	}

}
