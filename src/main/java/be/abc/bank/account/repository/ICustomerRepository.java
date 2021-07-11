/**
 * 
 */
package be.abc.bank.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import be.abc.bank.account.entity.CustomerEntity;

/**
 * Customer Repository interface inherited with JpaRepository
 * @author Renjith
 *
 */

@Repository
public interface ICustomerRepository extends JpaRepository<CustomerEntity, Integer>   {

}
