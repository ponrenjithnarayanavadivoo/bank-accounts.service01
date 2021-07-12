package be.abc.bank.account;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

import be.abc.bank.accounts.accounts.v1.model.CustomerRequestInfo;

/**
 * Integration Test for Account Services
 * 
 * @author Renjith
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class AccountApplicationTests {

	@Autowired
	private MockMvc mvc;
	@Autowired
	private ObjectMapper objectMapper;

	private static MvcResult createAccountMvcResult;
	
	@Test
	public void givenCustomer_whenGetCustomer_thenStatus200() throws Exception {

		mvc.perform(get("http://localhost:9082/abc/accounts/v1/getCustomerDetail/7654310").header("Request-id", "1")
				.header("version", "1.0.0").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.customerName", is("Jason")));
	}

	@Test
	public void createAccount_whenAccount_thenStatus200() throws Exception {

		CustomerRequestInfo aCustomerRequestInfo = new CustomerRequestInfo();
		aCustomerRequestInfo.accountType("CURRENT");
		aCustomerRequestInfo.setCustomerId(7654310);
		aCustomerRequestInfo.setCreditAmount((long) 1000);

		createAccountMvcResult = mvc.perform(post("http://localhost:9082/abc/accounts/v1/createAccount")
				.header("Request-id", "1").header("version", "1.0.0").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(aCustomerRequestInfo)))
				.andExpect(status().isOk()).andReturn();
	}

	/*
	 * @Test public void updateAccount_whenAccount_thenStatus204() throws Exception
	 * {
	 * 
	 * mvc.perform(get("http://localhost:8082/abc/accounts/v1/updateAccount/" +
	 * createAccountMvcResult.getResponse().getContentAsString()).header(
	 * "Request-id", "1") .header("version",
	 * "1.0.0").contentType(MediaType.APPLICATION_JSON))
	 * .andExpect(status().isNoContent()); }
	 * 
	 * @Test public void givenAccount_whenGetAccountList_thenStatus200() throws
	 * Exception {
	 * 
	 * mvc.perform(get("http://localhost:8082/abc/accounts/v1/getAccountDetail/" +
	 * createAccountMvcResult.getResponse().getContentAsString()).header(
	 * "Request-id", "1") .header("version",
	 * "1.0.0").contentType(MediaType.APPLICATION_JSON))
	 * .andExpect(status().isOk()); }
	 */
}
