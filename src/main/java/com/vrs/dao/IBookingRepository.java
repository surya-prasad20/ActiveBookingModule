package com.vrs.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.vrs.entities.Booking;
import com.vrs.entities.Customer;
import com.vrs.entities.Driver;
import com.vrs.entities.Vehicle;

public interface IBookingRepository extends CrudRepository<Booking, Integer> {

	/*
	 * public Booking addBooking(Booking booking); public Booking
	 * cancelBooking(Booking b); public Booking updateBooking(Booking b); public
	 * Booking viewBooking(Booking b); public List<Booking> viewAllBooking(Customer
	 * customer); public List<Booking> viewAllBookingByDate (LocalDate bookingDate);
	 * public List<Booking> viewAllBookingByVehicle(Vehicle vehicle);
	 */

	//fetch booking records by booking date
	@Query("select b from Booking b where b.bookingDate=:bookedDate")
	List<Booking> findAllBookingsByDate(@Param("bookedDate") LocalDate date);

	//fetch customer record by booking id
	//@Query("Select new com.vrs.dto.CustomerBookingDto(c.customerId,c.firstName,c.lastName,c.mobileNumber,c.emailId,c.address) from Customer c left join Booking b on c.customerId=b.customer where b.bookingId=:book_id")
	@Query("Select c from Customer c left join Booking b on c.customerId=b.customer where b.bookingId=:book_id")
	Customer findCustomerByBookingId(@Param("book_id") int bookingId);
	//CustomerBookingDto findCustomerByBookingId(@Param("book_id") int bookingId);

	
	//fetch vehicle record by booking id
	//@Query("Select new com.vrs.dto.BookingVehicleDto(v.vehicleId,v.vehicleNumber,v.type,v.category,v.description,v.location,v.capacity,v.chargesPerKM,v.fixedCharges) from Booking b right join Vehicle v on v. booking=b.bookingId where b.bookingId=:book_id")
	@Query("Select v from Booking b right join Vehicle v on v. booking=b.bookingId where b.bookingId=:book_id")
	Vehicle findVehicleByBookingId(@Param("book_id") int bookingId);
	
	
	
	//fetch driver record by booking id
	@Query("select d from Driver d where d.driverId in (select v.driver from Vehicle v,Booking b where v.booking = b.bookingId AND b.bookingId=:booking_id)")
	Driver findDriverByBookingId(@Param("booking_id") int bookingId);

}
