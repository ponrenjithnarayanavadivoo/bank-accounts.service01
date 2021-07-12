package be.abc.bank.account.management;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import be.abc.bank.account.entity.AccountEntity;
import be.abc.bank.account.entity.CustomerEntity;
import be.abc.bank.account.foundation.ApplicationUtil;
import be.abc.bank.account.repository.IAccountService;
import be.abc.bank.account.repository.ICustomerService;
import be.abc.bank.accounts.accounts.v1.model.AccountDetailsInfo;
import be.abc.bank.accounts.accounts.v1.model.AccountInfo;
import be.abc.bank.accounts.accounts.v1.model.CustomerInfo;
import be.abc.bank.accounts.accounts.v1.model.CustomerRequestInfo;

/**
 * Manager service supervise the account service operations or communications.
 * It is used to create the business logic and communicating with other sub ordinate services.
 *
 * @author Renjith
 *
 */

@Component
public class AccountManagementServiceImpl implements IAccountManagementService {

	@Autowired
	IAccountService myAccountService;
	@Autowired
	ICustomerService myCustomerService;

	/**
	 * create a new account for customer
	 * @param anInput CustomerRequestInfo
	 * @return String
	 */
	
	@Override
	public String createAccount(CustomerRequestInfo anInput) {
		long accountNumber;
		AccountEntity aAccountEntity = new AccountEntity();

		aAccountEntity.setCustomerId(anInput.getCustomerId());
		aAccountEntity.setAccountType(anInput.getAccountType());
		aAccountEntity.setCreationTimeStamp(ApplicationUtil.currentTimeStamp());
		accountNumber = ApplicationUtil.getAccountNumber();
		aAccountEntity.setaccountId(accountNumber);

		myAccountService.createAccount(aAccountEntity);

		return String.valueOf(accountNumber);
	}

	/**
	 * get the account detail from account table
	 * @param customerId int
	 * @return AccountDetailsInfo
	 */
	@Override
	public AccountDetailsInfo getAccountDetail(int customerId) {

		AccountDetailsInfo aAccountDetailsInfo = null;

		List<AccountEntity> theAccountEntity = getAccountDetailsbyId(customerId);
		if (theAccountEntity.isEmpty()) {
			return aAccountDetailsInfo;
		}
		List<AccountInfo> theAccountDetails = theAccountEntity.stream().map(accountEntity -> {
			AccountInfo theAccountInfo = new AccountInfo();
			theAccountInfo.setAccountType(accountEntity.getAccountType());
			theAccountInfo.setBalance(accountEntity.getBalance());
			theAccountInfo.setCustomerId(accountEntity.getCustomerId());
			theAccountInfo.setCreatedDate(
					accountEntity.getCreationTimeStamp() != null ? accountEntity.getCreationTimeStamp().toString()
							: "");
			theAccountInfo.setModifiedDate(
					accountEntity.getModifiedTimeStamp() != null ? accountEntity.getModifiedTimeStamp().toString()
							: "");
			theAccountInfo.setAccountNumber(String.valueOf(accountEntity.getAccountId()));
			return theAccountInfo;
		}).collect(Collectors.toList());
		aAccountDetailsInfo = new AccountDetailsInfo();
		aAccountDetailsInfo.setAccountDetails(theAccountDetails);

		return aAccountDetailsInfo;
	}

	/**
	 * get the customer detail from customer table
	 * @param customerId int
	 * @return CustomerInfo
	 */
	@Override
	public CustomerInfo getCustomerDetail(int customerId) {

		CustomerInfo aCustomerInfo = null;
		try {
			CustomerEntity theCustomerEntity = myCustomerService.getCustomerDetails(customerId);
			aCustomerInfo = new CustomerInfo();
			aCustomerInfo.setCustomerName(theCustomerEntity.getCustomerName());
			aCustomerInfo.setCustomerSurName(theCustomerEntity.getCustomerSurname());
		} catch (EntityNotFoundException e) {
			return aCustomerInfo;
		}
		return aCustomerInfo;
	}

	/**
	 * To update the account details in the account table
	 * @param accountId long
	 * @param CustomerRequestInfo anInput
	 */
	@Override
	public void updateAccountDetail(long accountId, CustomerRequestInfo anInput) {

		myAccountService.updateAccount(anInput.getCreditAmount(), ApplicationUtil.currentTimeStamp(), accountId);

	}

	/**
	 * Get the account details by using the customer id 
	 * @param anInput int
	 * @return List
	 */
	private List<AccountEntity> getAccountDetailsbyId(int customerId) {

		return myAccountService.getAccountDetailsById(customerId);
	}

}
