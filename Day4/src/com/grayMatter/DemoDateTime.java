package com.grayMatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class DemoDateTime {
	public static void main(String args[]) throws ParseException {
		Date date = new Date("7/24/24");
		System.out.println(date);
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyy",Locale.US);
		String myDate="18-JUL-2024";
		date=sdf.parse(myDate);
		System.out.println(date);
		
		LocalDate ld=LocalDate.now();
		System.out.println(ld);
		
		LocalDate ld1=LocalDate.of(2024,  7, 18);
		System.out.println(ld1);
		
		String temp="2024-07-12";
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		ld = LocalDate.parse(temp, dtf);
		System.out.println(ld);
		
		LocalTime time=LocalTime.now();
		System.out.println(time);
		
		System.out.println(ld.getDayOfWeek());
		System.out.println(ld.getDayOfMonth());
		System.out.println(ld.getMonthValue());
		System.out.println(ld.getDayOfYear());
		
		System.out.println(time.getHour());
		
		String myJoining="2023-03-19";
		LocalDate doj=LocalDate.parse(myJoining);
		String myLeaving="2023-07-18";
		LocalDate dol=LocalDate.parse(myLeaving);
		Period p = Period.between(doj, dol);
		System.out.println(p);
		System.out.println("Total period of time worked: "+p.getYears()
						+ " years, "+p.getMonths()+" months, "+p.getDays()+" days");
		
		String t1="11:01:02";
		LocalTime time1=LocalTime.parse(t1);
		LocalTime time2=LocalTime.now();
		Duration pt = Duration.between(time2, time1);
		System.out.println(pt);
		
		
	}

}
