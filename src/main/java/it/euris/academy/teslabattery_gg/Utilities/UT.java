package it.euris.academy.teslabattery_gg.Utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class UT {

	public static Long toLong(String value) {
		return value == null ? null : Long.parseLong(value);
	}
	
	 public static Date addDays(Date date, int days)
	    {
		 
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(date);
	        cal.add(Calendar.DATE, days);
	        return cal.getTime();
	    }
	 
	 public static Instant DateToInstant(Date date) {
		  return date.toInstant();
	 }
	 
	 public static Date StringToDate(String date) throws ParseException {
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		 Date d = format.parse(date);
		 return d ;
	 }
	 
}
