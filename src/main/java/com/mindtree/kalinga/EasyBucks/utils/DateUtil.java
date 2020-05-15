package com.mindtree.kalinga.EasyBucks.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.openqa.selenium.WebDriver;
import java.util.Date;

public class DateUtil {
	WebDriver driver;
	String format1 = null;// give input here
	String[] Date = format1.split("-");
	String dateTime = null;
	String date_dd_MM_yyyy[] = (dateTime.split(" ")[0]).split("-");
	String age = "";
	String y = day(Date);
	String d = mon(Date);
	String m = year(Date);

	public static String day(String[] Date) {
		String day = Date[0];
		return day;
	}

	public static String mon(String[] Date) {
		String month = Date[1];
		return month;
	}

	public String year(String[] Date) {
		String year = Date[2];
		return year;
	}

	// To find difference between dates methods
	public int diffYear() {
		int yearDiff = Integer.parseInt(date_dd_MM_yyyy[2]) - Calendar.getInstance().get(Calendar.YEAR);
		return yearDiff;
	}

	public int diffMon() {
		int monDiff = Integer.parseInt(date_dd_MM_yyyy[1]) - Calendar.getInstance().get(Calendar.MONTH);
		return monDiff;
	}

	public int diffDate() {
		int dateDiff = Integer.parseInt(date_dd_MM_yyyy[0]) - Calendar.getInstance().get(Calendar.DATE);
		return dateDiff;
	}

	// category based on age
	public void age1() {
		int yearDiff = 0;
		if (yearDiff > 18 && yearDiff < 30) {
			age = "youth";
		} else if (yearDiff > 30 && yearDiff < 45) {
			age = "middle";
		} else {
			age = "old";
		}
	}


	

	
	public static String currentDateTime(){
		DateFormat df = new SimpleDateFormat("dd_MM_yyyy_HH-mm-ss");
		Date dateobj = new Date();
		String dateNtime = df.format(dateobj);
		return dateNtime;
	}

}
