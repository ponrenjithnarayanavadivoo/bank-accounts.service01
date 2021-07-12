package be.abc.bank.account.repository;

import java.sql.Timestamp;
import java.util.List;

import be.abc.bank.account.entity.AccountEntity;

/**
 * Account service interface for account entity
 * @author Renjith
 *
 */
public interface IAccountService {
	
	List<AccountEntity> getAccountDetailsById(int customerId);

	void createAccount(AccountEntity t );
	
	void updateAccount(long balance,Timestamp timestamp,long accountId);
}