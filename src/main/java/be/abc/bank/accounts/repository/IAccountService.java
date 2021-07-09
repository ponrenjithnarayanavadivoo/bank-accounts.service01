package be.abc.bank.accounts.repository;

import java.util.List;

import be.abc.bank.accounts.entity.AccountEntity;

public interface IAccountService {
	
	List<AccountEntity> getAccountDetailsById(int customerId);

	void createAccount(AccountEntity t );

	void updateAccount(AccountEntity t ,long accountId);
}