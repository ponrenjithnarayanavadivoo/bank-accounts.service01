/**
 * 
 */
package be.abc.bank.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import be.abc.bank.account.entity.AccountEntity;

/**
 * Account Repository interface inherited with JpaRepository
 * @author Renjith
 *
 */
@Repository
public interface IAccountRepository extends JpaRepository<AccountEntity, Long>   {

	@Query("Select ad from accountdetails ad where ad.customerId=?1")
	List<AccountEntity> getAllRowsById (int customerId);
	
	

}
