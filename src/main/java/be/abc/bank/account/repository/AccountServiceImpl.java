package be.abc.bank.account.repository;

import java.sql.Timestamp;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.abc.bank.account.entity.AccountEntity;

/**
 * Account service used to communicate with relational database services 
 * @author Renjith
 *
 */
@Service
@Transactional
public class AccountServiceImpl implements IAccountService {

	@Autowired
	private IAccountRepository myAccountRepository;

	@Override
	public List<AccountEntity> getAccountDetailsById(int customerId) {

		return myAccountRepository.getAllRowsById(customerId);
	}

	@Override
	public void createAccount(AccountEntity t) {

		myAccountRepository.save(t);
	}

	@Override
	public void updateAccount(long balance, Timestamp timestamp, long accountId) {

		try {
			 myAccountRepository.findById(accountId);
			 myAccountRepository.saveAccountInfoById(balance,timestamp,accountId);
		} catch (Exception e) {
			throw e;
		}

	}

}
