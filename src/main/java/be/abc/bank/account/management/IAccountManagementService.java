package be.abc.bank.account.management;

import be.abc.bank.accounts.accounts.v1.model.AccountDetailsInfo;
import be.abc.bank.accounts.accounts.v1.model.CustomerInfo;
import be.abc.bank.accounts.accounts.v1.model.CustomerRequestInfo;

public interface IAccountManagementService {

	String createAccount(CustomerRequestInfo anInput);
	
	AccountDetailsInfo getAccountDetail(int customerId);
	
	void updateAccountDetail(long accountId,CustomerRequestInfo anInput);
	
	CustomerInfo getCustomerDetail(int CustomerId);
	
}
