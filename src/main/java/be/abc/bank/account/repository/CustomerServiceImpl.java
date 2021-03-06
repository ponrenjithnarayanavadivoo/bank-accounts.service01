/**
 * 
 */
package be.abc.bank.account.repository;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.abc.bank.account.entity.CustomerEntity;

/**
 * @author Renjith
 *
 */
@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerRepository myCustomerRepository;


	@Override
	public CustomerEntity getCustomerDetails(int customerId) {

		try {
			return myCustomerRepository.findById(customerId)
					.orElseThrow(() -> new EntityNotFoundException("Customer not found for this id :: " + customerId));
		} catch (EntityNotFoundException e) {
			throw e;
		}

	}

}
