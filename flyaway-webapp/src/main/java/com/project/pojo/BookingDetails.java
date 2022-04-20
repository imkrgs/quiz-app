package com.project.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BookingDetails {
	@Id
	private String flightNumber;
	private String time;
	private String date;
	private int price;
	private String flight;
	private String source;
	private String destination;

	/**
	 * @return the flightNumber
	 */
	public String getFlightNumber() {
		return flightNumber;
	}

	/**
	 * @param flightNumber the flightNumber to set
	 */
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	@Override
	public String toString() {
		return "BookingDetails [flightNumber=" + flightNumber + ", time=" + time + ", date=" + date + ", price=" + price
				+ ", flight=" + flight + ", source=" + source + ", destination=" + destination + "]";
	}

	public BookingDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * @return the flight
	 */
	public String getFlight() {
		return flight;
	}

	/**
	 * @param flight the flight to set
	 */
	public void setFlight(String flight) {
		this.flight = flight;
	}

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

}
