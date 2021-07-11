package be.abc.bank.account.foundation;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * It is a configuration class used to define the application configurations during run time.
 * @author Renjith
 *
 */
@Configuration
@Profile("!test")
public class AppConfig {

}
