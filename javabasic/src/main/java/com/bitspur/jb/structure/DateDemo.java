package com.bitspur.jb.structure;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {
	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(date);
		System.out.println(sdf.format(date));

		String dateString = "2017-11-11";
		try {
			Date date2 = sdf.parse(dateString);
			System.out.println(date2);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
}
