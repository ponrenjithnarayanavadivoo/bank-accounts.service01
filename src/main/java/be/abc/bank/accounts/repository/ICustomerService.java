package be.abc.bank.accounts.repository;

import java.util.List;

import be.abc.bank.accounts.entity.CustomerEntity;

public interface ICustomerService {

 CustomerEntity getCustomerDetails(int customerId);

}