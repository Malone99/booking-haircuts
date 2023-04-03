package mc.tech.com.repository;


import mc.tech.com.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface repositoryBooking extends JpaRepository<Booking,Integer> {
    Booking findById(int id);
    boolean existsBookingByDateAndTime(String date, String time);
//    List<Booking> findByCustomerId(int customerId);
    List<Booking> findByStaffName(String staffName);
    List<Booking> findByDate(String date);

}
