package mc.tech.com.repository;


import mc.tech.com.entities.Booking;
import mc.tech.com.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface repositoryBooking extends JpaRepository<Booking,Integer> {
    Booking findById(int id);
    Booking findByCustomerEmail(String email);
    boolean existsBookingByDateAndTime(String date, String time);
    boolean existsBookingByCustomerEmail(String Email);
    List<Booking> findByDate(String date);
    List<Booking> findAllByOrderByBookingIdDesc();
    long count();
    @Query("SELECT SUM(b.price) FROM Booking b WHERE b.status = :status")
    Double getTotalPriceByStatus(@Param("status") String status);


}
