/**
 * 
 */
package be.abc.bank.accounts.foundation;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;


/**
 * @author Renjith
 *
 */
public class ApplicationUtil {
	private static final Logger LOGGER = Logger.getLogger(ApplicationUtil.class);

	public static long getAccountNumber()  {

		Date dateNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat(ApplicationConstants.YYYYMMDDHHMMSSSS);
		String datetime = ft.format(dateNow);
		
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				LOGGER.error(e);
			}
		
		return Long.parseLong(datetime);

	}
	
	public static Timestamp currentTimeStamp()
	{
		Date date = new Date();
		return new Timestamp(date.getTime());
	}

}