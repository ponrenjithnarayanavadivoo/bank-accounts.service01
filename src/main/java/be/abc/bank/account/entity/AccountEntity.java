/**
 * 
 */
package be.abc.bank.account.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import be.abc.bank.account.foundation.ApplicationUtil;

/**
 * @author Renjith
 *
 */

@Entity(name = "accountdetails")
@Table(name = "ABC_BANK_ACCOUNT_DETAILS")
public class AccountEntity implements Serializable {

	private static final long serialVersionUID = 5543669796861150522L;

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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (accountId ^ (accountId >>> 32));
		result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
		result = prime * result + (int) (balance ^ (balance >>> 32));
		result = prime * result + ((createdTimeStamp == null) ? 0 : createdTimeStamp.hashCode());
		result = prime * result + customerId;
		result = prime * result + ((modifiedTimeStamp == null) ? 0 : modifiedTimeStamp.hashCode());
		return result;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountEntity other = (AccountEntity) obj;
		if (accountId != other.accountId)
			return false;
		if (accountType == null) {
			if (other.accountType != null)
				return false;
		} else if (!accountType.equals(other.accountType))
			return false;
		if (balance != other.balance)
			return false;
		if (createdTimeStamp == null) {
			if (other.createdTimeStamp != null)
				return false;
		} else if (!createdTimeStamp.equals(other.createdTimeStamp))
			return false;
		if (customerId != other.customerId)
			return false;
		if (modifiedTimeStamp == null) {
			if (other.modifiedTimeStamp != null)
				return false;
		} else if (!modifiedTimeStamp.equals(other.modifiedTimeStamp))
			return false;
		return true;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AccountEntity [accountId=");
		builder.append(accountId);
		builder.append(", accountType=");
		builder.append(accountType);
		builder.append(", createdTimeStamp=");
		builder.append(createdTimeStamp);
		builder.append(", modifiedTimeStamp=");
		builder.append(modifiedTimeStamp);
		builder.append(", balance=");
		builder.append(balance);
		builder.append(", customerId=");
		builder.append(customerId);
		builder.append("]");
		return builder.toString();
	}

}
