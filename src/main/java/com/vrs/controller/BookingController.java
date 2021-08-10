package com.vrs.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.vrs.entities.Booking;

import com.vrs.entities.Vehicle;
import com.vrs.exception.BookingNotFoundException;
import com.vrs.exception.BookingVehicleNotFoundException;
import com.vrs.service.IBookingService;


@RestController
public class BookingController {

	 private static final Logger logger = LogManager.getLogger(BookingController.class);

	
	@Autowired
	IBookingService bookingServ;

	// add booking -Post
	@PostMapping("/booking/add")
	public ResponseEntity<?> addBooking(@Valid @RequestBody Booking book) {
		try {
		
		return new ResponseEntity<>(bookingServ.addBooking(book), HttpStatus.OK);
		}
		catch(Exception e){
			logger.error("Didnt Add a Booking", e.getCause());
			
			return  new ResponseEntity<>(e.getMessage(),HttpStatus.EXPECTATION_FAILED);
		}
	}

	// cancel boooking
	@DeleteMapping("/booking/cancel/{id}")
	public String deleteBookingById(@Valid @PathVariable("id") int bookingId) {
		try {
			bookingServ.cancelBooking(bookingId);
		
			return "Deleted booking record success";
		} 
		catch (BookingNotFoundException e) {
			logger.error("error deleting booking record since booking id does not exists", e.getCause());
			return e.toString();
			}
	}

	// update booking
	@PutMapping("/booking/update")
	public ResponseEntity<?> updateBooking(@Valid @RequestBody Booking book) {
		try {
			
			return new ResponseEntity<>(bookingServ.updateBooking(book), HttpStatus.OK);
		}
		catch (Exception e) {
			logger.error("error updating booking record", e.getCause());
			return  new ResponseEntity<>(e.getMessage(),HttpStatus.EXPECTATION_FAILED);
			}
		}

	// get booking by id -Get
	@GetMapping("/booking/bookingById/{id}")
	public ResponseEntity<?> getBookingById(@Valid @PathVariable("id") int bookingId) {
		try {

	      
	        return new ResponseEntity<>(bookingServ.viewBooking(bookingId), HttpStatus.OK);
		}
		catch(Exception e) {
			logger.error("Error updating booking record", e.getCause());
			return  new ResponseEntity<>(e.getMessage(),HttpStatus.EXPECTATION_FAILED);
		}
	}

	// getting all bookings -Get
	@GetMapping("/booking/all")
	public ResponseEntity<?> getAllBookings() {
	
		//try {
			return new ResponseEntity<>(bookingServ.viewAllBooking(), HttpStatus.OK);
	//	}
		//catch(BookingNotFoundException e) {
		//	logger.error("No bookings found", e.getCause());
		//	return  new ResponseEntity<>("Something went wrong,Please try again.",HttpStatus.EXPECTATION_FAILED);

		}
	

	// getting all bookings by date -Get
	@GetMapping("/booking/byDate/{date}")
	public ResponseEntity<?> getAllBookingsByDate(@Valid @PathVariable("date") String bookDate) {
		try {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-dd-MM");
		LocalDate localDate = LocalDate.parse(bookDate, formatter);
		
		return new ResponseEntity<>(bookingServ.viewAllBookingByDate(localDate), HttpStatus.OK);
		}
		catch(DateTimeParseException e){
			logger.error("Invalid Date Input", e.getCause());
			return  new ResponseEntity<>("Date not in given format",HttpStatus.EXPECTATION_FAILED);
		}
		
	}

	// getting all vehicles by Booking Id  -Get
	@GetMapping("/booking/byVehicle/{vehicle_id}")
	public List<Booking> getAllBookingsByVehicle(@Valid @PathVariable("vehicle_id") Vehicle vehicle) {
		
		return bookingServ.viewAllBookingByVehicleId(vehicle.getVehicleId());
	}

	// getting customer details by booking-id
	@GetMapping("/booking/CustomerDetails/{bookingId}")
	public ResponseEntity<?> getCustomerByBookingId(@Valid @PathVariable("bookingId") int bookingId) {
		try {
			
		return new ResponseEntity<>(bookingServ.viewCustomerDetailsByBookingId(bookingId), HttpStatus.OK);
		}
		catch(Exception e) {
			logger.error("no bookings found", e.getCause());
			return  new ResponseEntity<>(e.getMessage(),HttpStatus.EXPECTATION_FAILED);
		}
	}

	
	// getting vehicle details by booking-id
	@GetMapping("/booking/VehicleDetails/{bookingId}")
	public ResponseEntity<?> getVehicleByBookingId(@Valid @PathVariable("bookingId") int bookingId) {
		try {
			
		return new ResponseEntity<>(bookingServ.viewVehicleDetailsByBookingId(bookingId), HttpStatus.OK);}
		catch(BookingVehicleNotFoundException e) {
			logger.error("no vehicle found with booking id", e.getCause());
			return  new ResponseEntity<>(e.getMessage(),HttpStatus.EXPECTATION_FAILED);
		}
		
	}
	
	// getting driver details by booking-id
	@GetMapping("/booking/DriverDetails/{bookingId}")
	public ResponseEntity<?> getDriverByBookingId(@Valid @PathVariable("bookingId") int bookingId) {
		try {

			return new ResponseEntity<>(bookingServ.viewDriverDetailsByBookingId(bookingId), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("no driver found with booking id", e.getCause());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}

	}
	

}