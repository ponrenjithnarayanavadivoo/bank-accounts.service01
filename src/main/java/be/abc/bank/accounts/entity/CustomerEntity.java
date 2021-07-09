package be.abc.bank.accounts.entity;


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
public class CustomerEntity {
	
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
	
}
