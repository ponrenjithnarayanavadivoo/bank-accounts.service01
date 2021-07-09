/**
 * 
 */
package be.abc.bank.accounts.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import be.abc.bank.accounts.foundation.ApplicationUtil;

/**
 * @author Renjith
 *
 */
@Entity(name = "accountdetails")
@Table(name = "ABC_BANK_ACCOUNT_DETAILS")
public class AccountEntity {

	@Id
	@Column(name = "account_number")
	private long accountId;

	@Column(name = "account_type")
	private String accountType;

	@Column(name = "created_timestamp")
	private Timestamp createdTimeStamp;

	@Column(name = "modified_timestamp")
	private Timestamp modifiedTimeStamp;
	
	@Column(name = "balance")
	private long balance;

	@Column(name = "customer_id")
	private int customerId;



	
	/**
	 * @return the accountId
	 */
	public long getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId the accountId to set
	 */
	public void setaccountId(long aAccountId) {
		this.accountId = aAccountId;
	}

	/**
	 * @return the accountType
	 */
	public String getAccountType() {
		return accountType;
	}

	/**
	 * @param accountType the accountType to set
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	/**
	 * @return the balance
	 */
	public long getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(long balance) {
		this.balance = balance;
	}

	/**
	 * @return the customerId
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the creationTimeStamp
	 */
	public Timestamp getCreationTimeStamp() {
		return createdTimeStamp;
	}

	/**
	 * @param creationTimeStamp the creationTimeStamp to set
	 */
	public void setCreationTimeStamp(Timestamp createdTimeStamp) {

		this.createdTimeStamp = ApplicationUtil.currentTimeStamp();
	}

	/**
	 * @return the modifiedTimeStamp
	 */
	public Timestamp getModifiedTimeStamp() {
		return modifiedTimeStamp;
	}

	/**
	 * @param modifiedTimeStamp the modifiedTimeStamp to set
	 */
	public void setModifiedTimeStamp(Timestamp modifiedTimeStamp) {
		this.modifiedTimeStamp = modifiedTimeStamp;
	}
}
