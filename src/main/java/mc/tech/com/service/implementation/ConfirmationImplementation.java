package mc.tech.com.service.implementation;

import mc.tech.com.entities.Confirmation;

public interface ConfirmationImplementation extends  IService<Confirmation,Integer>{
    Confirmation findConfirmationByBookingId(int id);
    Confirmation findByBookingId(int bookingId);
}
