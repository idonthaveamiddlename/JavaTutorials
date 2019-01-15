package com.devank.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {
	
	public static String convertToSQLFormat(Date date) {
		String pattern = "yyyy-MM-dd";
	    SimpleDateFormat formatter = new SimpleDateFormat(pattern);
	    String mysqlDateString = formatter.format(date);
	    return mysqlDateString;
	}
    
}
