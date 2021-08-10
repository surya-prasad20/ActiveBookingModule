package com.vrs.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

//For generating Getters , Setters , Constructors etc. 
@Entity
public class Booking {
	@Id
	//@GeneratedValue
	@NotNull
	@Min(2000)
	@Max(3000)
	private int bookingId;

	@NotNull
	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-dd-MM")
	private java.time.LocalDate bookingDate;

	@NotNull
	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-dd-MM")
	private LocalDate bookedTillDate;

	@Size(min = 1, message = "required")
	private String bookingDescription;

	@NotNull
	@DecimalMax("10000.0")
	@DecimalMin("0.0")
    private double totalCost;

	@NotNull
	@DecimalMax("1000.0")
	@DecimalMin("0.0")
	private double distance;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "payment_id_fk")
	private Payment payment;

	@JsonIgnore
	@OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
	private List<Vehicle> vehicles = new ArrayList<>();

	@OneToOne(mappedBy ="booking")
	private ActiveBooking activeBooking;

	/*
	 * @ManyToOne(cascade=CascadeType.ALL)
	 * 
	 * @JoinColumn(name="vehicle_id_fk") private Vehicle vehicles;
	 */

	// @Column(nullable=false)
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id_fk")
	private Customer customer;

	public Booking() {
		super();
		
	}

	public Booking(int bookingId, LocalDate bookingDate, LocalDate bookedTillDate, String bookingDescription,
			double totalCost, double distance, List<Vehicle> vehicles, Customer customer) {
		super();
		this.bookingId = bookingId;
		this.bookingDate = bookingDate;
		this.bookedTillDate = bookedTillDate;
		this.bookingDescription = bookingDescription;
		this.totalCost = totalCost;
		this.distance = distance;
		this.vehicles = vehicles;
		this.customer = customer;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public LocalDate getBookedTillDate() {
		return bookedTillDate;
	}

	public void setBookedTillDate(LocalDate bookedTillDate) {
		this.bookedTillDate = bookedTillDate;
	}

	public String getBookingDescription() {
		return bookingDescription;
	}

	public void setBookingDescription(String bookingDescription) {
		this.bookingDescription = bookingDescription;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	public ActiveBooking getActiveBooking() {
		return activeBooking;
	}

	public void setActiveBooking(ActiveBooking activeBooking) {
		this.activeBooking = activeBooking;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", bookingDate=" + bookingDate + ", bookedTillDate=" + bookedTillDate
				+ ", bookingDescription=" + bookingDescription + ", totalCost=" + totalCost + ", distance=" + distance
				+ ", payment=" + payment + ", vehicles=" + vehicles + ", activeBooking=" + activeBooking + ", customer="
				+ customer + "]";
	}

	

}
