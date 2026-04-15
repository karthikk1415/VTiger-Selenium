package genericUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class javaUtility {

	/**
	 * This is a generic method to fetch calendar details
	 * @param pattern
	 * @return
	 */
	public String getCalendarDetails(String pattern) 
	{
		Calendar cal=Calendar.getInstance();
		Date d=cal.getTime();
		SimpleDateFormat sdf=new SimpleDateFormat(pattern);
		String value=sdf.format(d);
		return value;
	}
	/**
	 * This is a generic method to generate random number 
	 * @param bound
	 * @return
	 */
	public int getRandomNumbers(int bound) 
	{
		Random r=new Random();
		int num=r.nextInt(bound);
		return num;	
	}
}
