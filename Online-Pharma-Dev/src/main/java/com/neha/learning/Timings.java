package com.neha.learning;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Timings {

	Date openingTime = null;
	Date closingTime = null;
	long functioningHours = 0;

	SimpleDateFormat ft = new SimpleDateFormat("EEE, h:mm a");

	public Timings() {
	}

	public Timings(Date openingTime, Date closingTime, long functioningHours, SimpleDateFormat ft) {
		super();
		this.openingTime = openingTime;
		this.closingTime = closingTime;
		this.functioningHours = functioningHours;
		this.ft = ft;
	}

	public Date enterDate() {
		System.out.println("Enter the day - eg Mon");
		Scanner s = new Scanner(System.in);
		String ip1 = s.nextLine();
		

		System.out.println("Enter the Time - eg 9:30 PM or 7:00 AM");
		Scanner s2 = new Scanner(System.in);
		String ip2 = s2.nextLine();
	

		Date date1 = null;
		try {
			date1 = new SimpleDateFormat("EEE, h:mm a").parse(ip1 + ", " + ip2);

			;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return date1;
	}

	public Date printDate(Date d) {
		System.out.println(ft.format(d));
		return d;
	}

	public Date getOpeningTime() {
		openingTime = printDate(this.openingTime);
		return openingTime;
	}

	public void setOpeningTime() {
		this.openingTime = enterDate();
	}

	public Date getClosingTime() {
		closingTime = printDate(this.closingTime);
		return closingTime;
	}

	public void setClosingTime() {
		this.closingTime = enterDate();
	}

	public long getFunctioningHours() {
		return functioningHours;
	}

	public void setFunctioningHours() {
		this.functioningHours = this.closingTime.getTime() - this.openingTime.getTime();
	}

	@Override
	public String toString() {
		return "Timings [openingTime=" + openingTime + ", closingTime=" + closingTime + ", functioningHours="
				+ functioningHours + ", ft=" + ft + "]";
	}

}
