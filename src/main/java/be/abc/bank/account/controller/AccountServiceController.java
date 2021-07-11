
package be.abc.bank.account.controller;

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
import org.springframework.web.server.ResponseStatusException;

import be.abc.bank.account.foundation.ApplicationConstants;
import be.abc.bank.account.management.IAccountManagementService;
import be.abc.bank.accounts.accounts.v1.model.AccountDetailsInfo;
import be.abc.bank.accounts.accounts.v1.model.CustomerInfo;
import be.abc.bank.accounts.accounts.v1.model.CustomerRequestInfo;

/**
 * REST controller that exposes the account service related rest operations
 * which takes the input message as Json request and sends back the response
 * output as same.
 *
 * @author Renjith
 *
 */
@RestController
@RequestMapping("abc/accounts/v1")
public class AccountServiceController {

	private static final Logger LOGGER = Logger.getLogger(AccountServiceController.class);

	@Autowired
	private IAccountManagementService myManagerService;

	@GetMapping(path = "/getCustomerDetail/{customerId}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<CustomerInfo> getCustomerDetail(@PathVariable("customerId") int customerId)

	{
		LOGGER.debug("Rest endpoint getCustomerDetail()is called ..");
		try {
			return new ResponseEntity<CustomerInfo>(myManagerService.getCustomerDetail(customerId), HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					ApplicationConstants.INTERNAL_SERVER_ERROR, e);
		}
	}

	@PostMapping(path = "/createAccount", consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> createAccount(@RequestBody CustomerRequestInfo aInput) {

		LOGGER.debug("Rest endpoint createAccount() is called ..");
		try {

			return new ResponseEntity<String>(myManagerService.createAccount(aInput), HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					ApplicationConstants.INTERNAL_SERVER_ERROR, e);
		}
	}

	@PutMapping(path = "/updateAccount/{accountId}", consumes = "application/json")
	public ResponseEntity<String> updateaccountDetail(@PathVariable("accountId") long accountId,
			@RequestBody CustomerRequestInfo anInput)

	{
		LOGGER.debug("Rest endpoint updateaccountDetail() is called ..");
		try {
			myManagerService.updateAccountDetail(accountId, anInput);
			return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		}
		catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					ApplicationConstants.INTERNAL_SERVER_ERROR, e);
		}
	}

	@GetMapping(path = "/getAccountDetail/{customerId}", consumes = "application/json", produces = "application/json")
	public AccountDetailsInfo getAccountDetail(@PathVariable("customerId") int customerId)

	{
		LOGGER.debug("Rest endpoint getAccountDetail() is called ..");
		try {
			return myManagerService.getAccountDetail(customerId);
		}
		catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					ApplicationConstants.INTERNAL_SERVER_ERROR, e);
		}
	}
}
