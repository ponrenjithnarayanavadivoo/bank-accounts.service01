package be.abc.bank.accounts.repository;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import be.abc.bank.accounts.entity.AccountEntity;
import be.abc.bank.accounts.entity.CustomerEntity;

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
			 myAccountRepository.findById(accountId)
					.orElseThrow(() -> new EntityNotFoundException("A ccound details not found :: " + accountId));
			 myAccountRepository.save(t);
		} catch (EntityNotFoundException e) {
			throw e;
		}

		
	}

}
