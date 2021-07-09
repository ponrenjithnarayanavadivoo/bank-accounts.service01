/**
 * 
 */
package be.abc.bank.accounts.repository;

import java.util.List;

import javax.management.AttributeNotFoundException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import be.abc.bank.accounts.entity.CustomerEntity;

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
					.orElseThrow(() -> new EntityNotFoundException("Employee not found for this id :: " + customerId));
		} catch (EntityNotFoundException e) {
			throw e;
		}

	}

}
