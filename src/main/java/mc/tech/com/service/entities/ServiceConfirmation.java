package mc.tech.com.service.entities;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mc.tech.com.entities.Confirmation;
import mc.tech.com.service.implementation.ConfirmationImplementation;
import org.springframework.stereotype.Service;

import java.util.Optional;
@RequiredArgsConstructor
@Service
@Slf4j
public class ServiceConfirmation implements ConfirmationImplementation {


    @Override
    public Confirmation findConfirmationByBookingId(int id) {
        return null;
    }

    @Override
    public Confirmation findByBookingId(int bookingId) {
        return null;
    }

    @Override
    public Confirmation save(Confirmation confirmation) {
        return null;
    }

    @Override
    public Optional<Confirmation> read(Integer integer) {
        return Optional.empty();
    }

    @Override
    public void delete(int deleteById) {

    }
}
