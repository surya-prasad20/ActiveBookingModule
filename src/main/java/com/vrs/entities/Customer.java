package com.vrs.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

//For generating Getters , Setters , Constructors etc. 

@Entity
public class Customer {

	@Id
	@GeneratedValue
	private int customerId;
	private String firstName;
	private String lastName;
	private String mobileNumber;
	private String emailId;
	private String address;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Booking> bookings = new ArrayList<>();

	@JsonIgnore
	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
	private User user;

	/*
	 * public List<Booking> getBookings() { return bookings; }
	 */

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	public Customer(int customerId, String firstName, String lastName, String mobileNumber, String emailId,
			String address, List<Booking> bookings, User user) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.address = address;
		this.bookings = bookings;
		this.user = user;
	}




	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", mobileNumber=" + mobileNumber + ", emailId=" + emailId + ", address=" + address + "]";
	}

}
