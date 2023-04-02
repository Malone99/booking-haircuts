package mc.tech.com.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class CancellationRescheduling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cancellationReschedulingId;
    private int bookingId;
    private String reason;
    private String date;
    private String time;



    public CancellationRescheduling(Builder builder)  {
        this.cancellationReschedulingId = cancellationReschedulingId;
        this.bookingId = builder.bookingId;
        this.reason = builder. reason;
        this.date = builder. date;
        this.time =  builder.time;
    }

    public CancellationRescheduling() {

    }

    public int getCancellationReschedulingId() {
        return cancellationReschedulingId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public String getReason() {
        return reason;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "factoryCancellationRescheduling{" +
                "cancellationReschedulingId=" + cancellationReschedulingId +
                ", bookingId=" + bookingId +
                ", reason='" + reason + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public static class Builder {

        private int cancellationReschedulingId;
        private int bookingId;
        private String reason;
        private String date;
        private String time;

        public Builder setCancellationReschedulingId(int cancellationReschedulingId) {
            this.cancellationReschedulingId = cancellationReschedulingId;
            return this;
        }

        public Builder setBookingId(int bookingId) {
            this.bookingId = bookingId;
            return this;
        }

        public Builder setReason(String reason) {
            this.reason = reason;
            return this;
        }

        public Builder setDate(String date) {
            this.date = date;
            return this;
        }

        public Builder setTime(String time) {
            this.time = time;
            return this;
        }
        public CancellationRescheduling builder()
        {
            return new CancellationRescheduling(this);
        }
    }



}