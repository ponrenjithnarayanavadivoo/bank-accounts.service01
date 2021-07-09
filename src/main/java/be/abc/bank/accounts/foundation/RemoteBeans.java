package be.abc.bank.accounts.foundation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
@Profile("!test")
public class RemoteBeans {

	/*
	 * @Bean public RestTemplate restTemplate() { return new
	 * RestTemplate(clientHttpRequestFactory());
	 * 
	 * }
	 * 
	 * private ClientHttpRequestFactory clientHttpRequestFactory() {
	 * HttpComponentsClientHttpRequestFactory theClientHttpRequestFactory = new
	 * HttpComponentsClientHttpRequestFactory(); // TODO Auto-generated method stub
	 * return null; }
	 */
}
