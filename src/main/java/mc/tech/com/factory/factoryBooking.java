package mc.tech.com.factory;


import mc.tech.com.entities.Booking;

public class factoryBooking {

    public static Booking BuildBooking( int customerId, int serviceId, int staffId,String date, String time,int duration, String status)
    {


     return  new Booking.Builder().setCustomerId(customerId)
             .setServiceId(serviceId)
             .setStaffId(staffId)
             .setDate(date)
             .setTime(time)
             .setDuration(duration).setStatus(status)
             .builder();

    }

    public static Booking BuildBookingEdit(int bookingId, int customerId, int serviceId, int staffId,String date, String time,int duration, String status)
    {


        return  new Booking.Builder().setBookingId(bookingId).setCustomerId(customerId)
                .setServiceId(serviceId)
                .setStaffId(staffId)
                .setDate(date)
                .setTime(time)
                .setDuration(duration).setStatus(status)
                .builder();

    }
}
