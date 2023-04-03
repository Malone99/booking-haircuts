package mc.tech.com.service.implementation;

import mc.tech.com.entities.Booking;

import java.util.List;

public interface BookingImplementation extends IService<Booking, Integer>{
    Booking findById(int id);
//    List<Booking> findByCustomerId(int customerId);
    List<Booking> findAllBooking();
    List<Booking> findByStaffName(String staffId);
    List<Booking> findByDate(String date);
}
