package be.abc.bank.account.entity;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Renjith
 *
 */
@Entity(name = "customerdetails")
@Table(name = "ABC_BANK_CUSTOMER_DETAILS")
public class CustomerEntity implements Serializable {
	
	private static final long serialVersionUID = -3369462373899422833L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id")
	private int customerId;
	
	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "customer_surname")
	private String customerSurname;


	@Column(name = "customer_gender")
	private String customerGender;
	

	@Column(name = "customer_dob")
	private Date customer_dob;
	
	public CustomerEntity() {
		super();
	}

	/**
	 * CustomerEntity constructor
	 * @param customerId int
	 * @param customerName String 
	 * @param customerSurname String 
	 * @param customerGender Gender
	 * @param customer_dob Date
	 */
	public CustomerEntity(int customerId, String customerName, String customerSurname, String customerGender,
			Date customer_dob) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerSurname = customerSurname;
		this.customerGender = customerGender;
		this.customer_dob = customer_dob;
	}

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}
	
	
	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return the customerSurname
	 */
	public String getCustomerSurname() {
		return customerSurname;
	}

	/**
	 * @param customerSurname the customerSurname to set
	 */
	public void setCustomerSurname(String customerSurname) {
		this.customerSurname = customerSurname;
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
	 * @return the customerGender
	 */
	public String getCustomerGender() {
		return customerGender;
	}

	/**
	 * @param customerGender the customerGender to set
	 */
	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}

	/**
	 * @return the customer_dob
	 */
	public Date getCustomer_dob() {
		return customer_dob;
	}

	/**
	 * @param customer_dob the customer_dob to set
	 */
	public void setCustomer_dob(Date customer_dob) {
		this.customer_dob = customer_dob;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerGender == null) ? 0 : customerGender.hashCode());
		result = prime * result + customerId;
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((customerSurname == null) ? 0 : customerSurname.hashCode());
		result = prime * result + ((customer_dob == null) ? 0 : customer_dob.hashCode());
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
		CustomerEntity other = (CustomerEntity) obj;
		if (customerGender == null) {
			if (other.customerGender != null)
				return false;
		} else if (!customerGender.equals(other.customerGender))
			return false;
		if (customerId != other.customerId)
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (customerSurname == null) {
			if (other.customerSurname != null)
				return false;
		} else if (!customerSurname.equals(other.customerSurname))
			return false;
		if (customer_dob == null) {
			if (other.customer_dob != null)
				return false;
		} else if (!customer_dob.equals(other.customer_dob))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomerEntity [customerId=");
		builder.append(customerId);
		builder.append(", customerName=");
		builder.append(customerName);
		builder.append(", customerSurname=");
		builder.append(customerSurname);
		builder.append(", customerGender=");
		builder.append(customerGender);
		builder.append(", customer_dob=");
		builder.append(customer_dob);
		builder.append("]");
		return builder.toString();
	}
	
}
