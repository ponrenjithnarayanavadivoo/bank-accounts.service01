package be.abc.bank.account.repository;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.abc.bank.account.entity.AccountEntity;

/**
 * Account service used to communicate with relational database services / repository
 * @author Renjith
 *
 */
@Service
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
	public void updateAccount(AccountEntity t,long accountId) {

		try {
			 myAccountRepository.findById(accountId);
			 myAccountRepository.save(t);
		} catch (EntityNotFoundException e) {
			throw e;
		}

		
	}

}
