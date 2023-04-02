package mc.tech.com.factory;


import mc.tech.com.entities.CancellationRescheduling;

public class factoryCancellationRescheduling {

    public static CancellationRescheduling BuildCancellationRescheduling( int bookingId, String reason, String date, String time){

        return new CancellationRescheduling.Builder().setBookingId(bookingId).setReason(reason).setDate(date).setTime(time).builder();
    }
    public static CancellationRescheduling BuildCancellationReschedulingEdit(int cancellationReschedulingId, int bookingId, String reason, String date, String time){

        return new CancellationRescheduling.Builder().setCancellationReschedulingId(cancellationReschedulingId).setBookingId(bookingId).setReason(reason).setDate(date).setTime(time).builder();
    }
}
