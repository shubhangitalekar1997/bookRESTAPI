package com.shubh.book.rest.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Shubhangi.Talekar
 *
 */
public class IdGenerator {

	public static int get() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmmssMs");
		String datetime = ft.format(dNow);
		return Integer.parseInt(datetime.substring(2));
	}
}
