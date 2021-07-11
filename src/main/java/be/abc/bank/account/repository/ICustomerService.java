package be.abc.bank.account.repository;

import be.abc.bank.account.entity.CustomerEntity;

/**
 * Customer service interface for customer entity
 * @author Renjith
 *
 */
public interface ICustomerService {

 CustomerEntity getCustomerDetails(int customerId);

}