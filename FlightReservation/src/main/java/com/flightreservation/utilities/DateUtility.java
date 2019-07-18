package com.flightreservation.utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtility {

	public Date currentDate;
	public String todayStr;
	public DateFormat dateFormat;

	public int getCurrentDay() {

		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		currentDate = calendar.getTime();
		int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
		todayStr = Integer.toString(todayInt);

		return todayInt;
	}

	public int addDaysToCurrentDate() {
		dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		currentDate = calendar.getTime();
		Calendar c = Calendar.getInstance();
		c.setTime(currentDate);
		c.add(Calendar.DATE, 15);
		Date currentDatePlus = c.getTime();

		return currentDatePlus.getDate();
	}

}
