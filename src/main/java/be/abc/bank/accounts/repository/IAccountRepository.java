/**
 * 
 */
package be.abc.bank.accounts.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import be.abc.bank.accounts.entity.AccountEntity;

/**
 * @author Renjith
 * @param <T>
 *
 */
@Repository
public interface IAccountRepository extends JpaRepository<AccountEntity, Long>   {

	@Query("Select ad from accountdetails ad where ad.customerId=?1")
	List<AccountEntity> getAllRowsById (int customerId);
	
	

}
