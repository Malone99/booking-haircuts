package mc.tech.com.factory;

import mc.tech.com.entities.Confirmation;

public class factoryConfirmation {

    public static Confirmation BuildConfirmation( int bookingId, String email, String phoneNumber) {


        return new Confirmation.Builder().setBookingId(bookingId).setEmail(email).setPhoneNumber(phoneNumber).builder();
    }
    public static Confirmation BuildConfirmationEdit( int confirmationId,int bookingId, String email, String phoneNumber) {


        return new Confirmation.Builder().setConfirmationId(confirmationId).setBookingId(bookingId).setEmail(email).setPhoneNumber(phoneNumber).builder();
    }
}
