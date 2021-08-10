package com.vrs.dao;

import java.util.List; 


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vrs.entities.ActiveBooking;
@Repository
public interface IActiveBookingRepository extends JpaRepository<ActiveBooking,Integer>{

   @Query("select ab from ActiveBooking ab where ab.status=?1")
   List<ActiveBooking> findByStatus(String status);
    
   @Query("select ab from ActiveBooking ab where ab.status='pending'")
   List<ActiveBooking> findByPending();
   
   @Query("select ab from ActiveBooking ab where ab.status='inprogress'")
    List<ActiveBooking> findByInprogress();
   
   @Query("select ab from ActiveBooking ab where ab.status='cancelled'")
    List<ActiveBooking> findByCancelled();
   
   @Query("select ab from ActiveBooking ab where ab.status='completed'")
    List<ActiveBooking> findByCompleted();





   
   

	
}
