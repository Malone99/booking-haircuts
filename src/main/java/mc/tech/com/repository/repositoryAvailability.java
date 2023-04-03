package mc.tech.com.repository;

import mc.tech.com.entities.Availability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface repositoryAvailability extends JpaRepository<Availability,Integer> {
    Availability findById(int id);
    List<Availability> findByDate(String date);
    List<Availability> findByStaffId(int staffId);
//    List<Availability> findAvailabilityByDateOrTime(String startDateTimeORendDateTime);

}
