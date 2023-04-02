package mc.tech.com.repository;


import mc.tech.com.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface repositoryBooking extends JpaRepository<Booking,Integer> {
    Booking findById(int id);
    List<Booking> findByCustomerId(int customerId);
    List<Booking> findByStaffId(int staffId);
    List<Booking> findByDate(String date);

}
