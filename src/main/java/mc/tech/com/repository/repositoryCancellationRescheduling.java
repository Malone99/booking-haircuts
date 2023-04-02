package mc.tech.com.repository;

import mc.tech.com.entities.CancellationRescheduling;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface repositoryCancellationRescheduling extends JpaRepository<CancellationRescheduling,Integer> {
    CancellationRescheduling findById(int id);
    List<CancellationRescheduling> findByBookingId(int bookingId);
}
