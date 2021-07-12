/**
 * 
 */
package be.abc.bank.account.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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
	
	@Modifying
	@Query("Update accountdetails ad set ad.balance = ?1, ad.modifiedTimeStamp = ?2 where ad.accountId = ?3")
	void saveAccountInfoById(long balance, Timestamp timeSTamp, long accountId);
	
	

}
