
package be.abc.bank.accounts;

import javax.persistence.EntityNotFoundException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.abc.bank.accounts.accounts.v1.ApiException;
import be.abc.bank.accounts.accounts.v1.model.AccountDetailsInfo;
import be.abc.bank.accounts.accounts.v1.model.AccountInfo;
import be.abc.bank.accounts.accounts.v1.model.CustomerInfo;
import be.abc.bank.accounts.accounts.v1.model.CustomerRequestInfo;
import be.abc.bank.accounts.foundation.ApplicationConstants;
import be.abc.bank.accounts.management.IAccountManagementService;

/**
 * REST controller that exposes the rest operations which takes the input
 * message as request and sends back the response output as Json
 *
 * @author Renjith
 *
 */
@RestController
@RequestMapping("accounts/v1")
public class AccountServiceController {

	private static final Logger LOGGER = Logger.getLogger(AccountServiceController.class);

	@Autowired
	private IAccountManagementService myManagerService;

	@GetMapping(path = "/customer-detail/{customerId}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<CustomerInfo> getCustomerDetail(@PathVariable("customerId") int customerId)
			throws ApiException

	{
		LOGGER.debug("Rest endpoint getCustomerDetail()is called ..");

		try {
			return new ResponseEntity<CustomerInfo>(myManagerService.getCustomerDetail(customerId), HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			LOGGER.error(e);
			throw new ApiException(HttpStatus.NOT_FOUND.value(), "Customer ID not found");
		} catch (Exception e) {
			throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error" + e.getMessage());
		}
	}

	@PostMapping(path = "/create-account", consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> createAccount(@RequestBody CustomerRequestInfo aInput) throws ApiException {
		LOGGER.debug("Rest endpoint createAccount() is called ..");
		try {

			return new ResponseEntity<String>(myManagerService.createAccounts(aInput), HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e);
			throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error" + e.getMessage());
		}
	}

	@PutMapping(path = "/update-account/{accountId}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> updateaccountDetail(@PathVariable("accountId") long accountId,
			@RequestBody CustomerRequestInfo anInput) throws ApiException

	{
		LOGGER.debug("Rest endpoint updateaccountDetail() is called ..");

		try {
			myManagerService.updateAccountDetail(accountId, anInput);
			return new ResponseEntity<String>(HttpStatus.NO_CONTENT);

		}

		catch (EntityNotFoundException e) {
			LOGGER.error(e);
			throw new ApiException(HttpStatus.NOT_FOUND.value(), "Account ID not found");
		} catch (Exception e) {
			throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error" + e.getMessage());
		}
	}

	@GetMapping(path = "/account-detail/{customerId}", consumes = "application/json", produces = "application/json")
	public AccountDetailsInfo getAccountDetail(@PathVariable("customerId") int customerId) throws ApiException

	{
		try {
			return myManagerService.getAccountDetail(customerId);
		}

		catch (EntityNotFoundException e) {
			LOGGER.error(e);
			throw new ApiException(HttpStatus.NOT_FOUND.value(), "Account ID not found");
		} catch (Exception e) {
			throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error" + e.getMessage());
		}
	}
}
