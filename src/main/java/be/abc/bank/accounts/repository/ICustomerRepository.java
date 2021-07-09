/**
 * 
 */
package be.abc.bank.accounts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import be.abc.bank.accounts.entity.CustomerEntity;

/**
 * @author Renjith
 * @param <T>
 *
 */
@Repository
public interface ICustomerRepository extends JpaRepository<CustomerEntity, Integer>   {

}
