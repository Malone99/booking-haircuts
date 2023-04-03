package mc.tech.com.factory;


import mc.tech.com.entities.Booking;

public class factoryBooking {

    public static Booking BuildBooking( String customerName, String serviceName, String staffName,String date, String time,int duration,double price , String status)
    {


     return  new Booking.Builder().setCustomerName(customerName)
             .setServiceName(serviceName)
             .setStaffName(staffName)
             .setDate(date)
             .setTime(time)
             .setPrice(price)
             .setDuration(duration).setStatus(status)
             .builder();

    }

    public static Booking BuildBookingEdit(int bookingId,  String customerName, String serviceName, String staffName,String date, String time,int duration, String status)
    {


        return  new Booking.Builder().setBookingId(bookingId).setCustomerName(customerName)
            .setServiceName(serviceName)
            .setStaffName(staffName)
            .setDate(date)
            .setTime(time)
            .setDuration(duration).setStatus(status)
            .builder();

    }
}
