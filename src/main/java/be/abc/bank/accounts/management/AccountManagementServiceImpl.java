package be.abc.bank.accounts.management;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import be.abc.bank.accounts.accounts.v1.model.AccountDetailsInfo;
import be.abc.bank.accounts.accounts.v1.model.AccountInfo;
import be.abc.bank.accounts.accounts.v1.model.CustomerInfo;
import be.abc.bank.accounts.accounts.v1.model.CustomerRequestInfo;
import be.abc.bank.accounts.entity.AccountEntity;
import be.abc.bank.accounts.entity.CustomerEntity;
import be.abc.bank.accounts.foundation.ApplicationUtil;
import be.abc.bank.accounts.repository.IAccountService;
import be.abc.bank.accounts.repository.ICustomerService;

@Component
public class AccountManagementServiceImpl implements IAccountManagementService {

	private static final Logger LOGGER = Logger.getLogger(AccountManagementServiceImpl.class);

	@Autowired
	IAccountService myAccountService;
	@Autowired
	ICustomerService myCustomerService;

	@Override
	public String createAccounts(CustomerRequestInfo anInput) {
		long accountNumber;
		AccountEntity aAccountEntity = new AccountEntity();

		aAccountEntity.setCustomerId(anInput.getCustomerId());
		aAccountEntity.setAccountType(anInput.getAccountType());
		aAccountEntity.setCreationTimeStamp(ApplicationUtil.currentTimeStamp());
		accountNumber = ApplicationUtil.getAccountNumber();
		aAccountEntity.setaccountId(accountNumber);
		myAccountService.createAccount(aAccountEntity);

		return "" + accountNumber;
	}

	@Override
	public AccountDetailsInfo getAccountDetail(int customerId) {

		List<AccountEntity> theAccountEntity = getAccountDetailsbyId(customerId);
		List<AccountInfo> theAccountDetails = theAccountEntity.stream().map(accountEntity -> {
			AccountInfo theAccountInfo = new AccountInfo();
			theAccountInfo.setAccountType(accountEntity.getAccountType());
			theAccountInfo.setBalance(accountEntity.getBalance());
			theAccountInfo.setCustomerId(accountEntity.getCustomerId());
			theAccountInfo.setCreatedDate(accountEntity.getCreationTimeStamp()!=null ? accountEntity.getCreationTimeStamp().toString():"" );
			theAccountInfo.setModifiedDate(accountEntity.getModifiedTimeStamp() !=null ? accountEntity.getModifiedTimeStamp().toString() : "");
			theAccountInfo.setAccountNumber("" + accountEntity.getAccountId());
			return theAccountInfo;
		}).collect(Collectors.toList());
		myAccountService.getAccountDetailsById(customerId);
		AccountDetailsInfo aAccountDetailsInfo = new AccountDetailsInfo();
		aAccountDetailsInfo.setAccountDetails(theAccountDetails);

		return aAccountDetailsInfo;
	}

	@Override
	public CustomerInfo getCustomerDetail(int customerId) {

		CustomerEntity theCustomerEntity = myCustomerService.getCustomerDetails(customerId);
		CustomerInfo aCustomerInfo = new CustomerInfo();
		aCustomerInfo.setCustomerName(theCustomerEntity.getCustomerName());
		aCustomerInfo.setCustomerSurName(theCustomerEntity.getCustomerSurname());

		return aCustomerInfo;
	}

	@Override
	public void updateAccountDetail(long accountId, CustomerRequestInfo anInput) {

		AccountEntity aAccountEntity = new AccountEntity();

		aAccountEntity.setCustomerId(anInput.getCustomerId());
		aAccountEntity.setAccountType(anInput.getAccountType());
		aAccountEntity.setaccountId(accountId);
		aAccountEntity.setModifiedTimeStamp(ApplicationUtil.currentTimeStamp());
		aAccountEntity.setBalance(anInput.getCreditAmount());
		myAccountService.updateAccount(aAccountEntity, accountId);

	}

	/**
	 * @param anInput
	 * @return
	 */
	private List<AccountEntity> getAccountDetailsbyId(int customerId) {

		return myAccountService.getAccountDetailsById(customerId);
	}

}
