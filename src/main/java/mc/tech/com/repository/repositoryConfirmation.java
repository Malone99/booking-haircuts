package mc.tech.com.repository;


import mc.tech.com.entities.Confirmation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface repositoryConfirmation extends JpaRepository<Confirmation,Integer> {
    Confirmation findConfirmationByBookingId(int id);
    Confirmation findByBookingId(int bookingId);
}
