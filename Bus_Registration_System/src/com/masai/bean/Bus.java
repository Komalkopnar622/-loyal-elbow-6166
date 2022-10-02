package com.masai.bean;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Bus {
	private int busNo;
	private String busname;
	private String busRoute;
	private String busType;
	private int seat;
	private Time arriveTime;
	
	private Time departuretime;
	private LocalDate date;
 
	private String source;
	private String destination;
	
	public Bus() {
		
	}

	public Bus(int busNo, String busname, String busRoute, String busType, int seat,String source,String destination) {
		super();
		this.busNo = busNo;
		this.busname = busname;
		this.busRoute = busRoute;
		this.busType = busType;
		this.seat = seat;
		this.source=source;
		this.destination=destination;
	}
	public Bus(int busNo, String busname, String busRoute, String busType, int seat, Time arriveTime,
			Time departuretime, LocalDate date,String source,String destination) {
		super();
		this.busNo = busNo;
		this.busname = busname;
		this.busRoute = busRoute;
		this.busType = busType;
		this.seat = seat;
		this.arriveTime = arriveTime;
		this.departuretime = departuretime;
		this.date = date;
		this.source=source;
		this.destination=destination;
	}

	public int getBusNo() {
		return busNo;
	}

	public void setBusNo(int busNo) {
		this.busNo = busNo;
	}

	public String getBusname() {
		return busname;
	}

	public void setBusname(String busname) {
		this.busname = busname;
	}

	public String getBusRoute() {
		return busRoute;
	}

	public void setBusRoute(String busRoute) {
		this.busRoute = busRoute;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	public Time getArriveTime() {
		return arriveTime;
	}

	public void setArriveTime(Time arriveTime) {
		this.arriveTime = arriveTime;
	}

	public Time getDeparturetime() {
		return departuretime;
	}

	public void setDeparturetime(Time lt) {
		this.departuretime = lt;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date2) {
		this.date = date2;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "Bus [busNo=" + busNo + ", busname=" + busname + ", busRoute=" + busRoute + ", busType=" + busType
				+ ", seat=" + seat + ", arriveTime=" + arriveTime + ", departuretime=" + departuretime + ", date="
				+ date + ", source=" + source + ", destination=" + destination + "]";
	}

	
	
	
	

}
