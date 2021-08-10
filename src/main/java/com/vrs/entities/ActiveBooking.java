package com.vrs.entities;


import javax.persistence.CascadeType;    
import javax.persistence.Column;     
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.Data;


@Data  //For generating Getters , Setters , Constructors 
@Entity    //For specifying class as an entity
public class ActiveBooking {
	//fields
	@Id
	@NotNull
	private int activeBookingId;
	
	@NotNull
	@Column(name="status")
	private String status;
	
	public ActiveBooking() {}

	public ActiveBooking( int activeBookingId,String status)
	{
		super();
		this.activeBookingId = activeBookingId;
		this.status = status;
	}
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="booking_id_fk")
	private Booking booking;

	public ActiveBooking(int activeBookingId, String status, Booking booking) {
		super();
		this.activeBookingId = activeBookingId;
		this.status = status;
		this.booking = booking;
	}
	
	
	
	
	

}	