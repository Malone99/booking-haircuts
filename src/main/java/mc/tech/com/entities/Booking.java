package mc.tech.com.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;
    private int customerId;
    private int serviceId;
    private int staffId;
    private String date;
    private String time;
    private int duration;
    private String status;


    public Booking(Builder builder) {
        this.bookingId = builder.bookingId;
        this.customerId =  builder.customerId;
        this.serviceId =  builder.serviceId;
        this.staffId =  builder.staffId;
        this.date = builder. date;
        this.time = builder. time;
        this.duration =  builder.duration;
        this.status =  builder.status;
    }

    public Booking() {

    }

    public int getBookingId() {
        return bookingId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public int getStaffId() {
        return staffId;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public int getDuration() {
        return duration;
    }

    public String getStatus() {
        return status;
    }


    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", customerId=" + customerId +
                ", serviceId=" + serviceId +
                ", staffId=" + staffId +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", duration=" + duration +
                ", status='" + status + '\'' +
                '}';
    }
    public static class Builder {

        private int bookingId;
        private int customerId;
        private int serviceId;
        private int staffId;
        private String date;
        private String time;
        private int duration;
        private String status;


        public Builder setBookingId(int bookingId) {
            this.bookingId = bookingId;
            return this;
        }

        public Builder setCustomerId(int customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder setServiceId(int serviceId) {
            this.serviceId = serviceId;
            return this;
        }

        public Builder setStaffId(int staffId) {
            this.staffId = staffId;
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

        public Builder setDuration(int duration) {
            this.duration = duration;
            return this;
        }
        public void setStatus(String status) {
            this.status = status;
        }

        public Booking builder()
        {
            return new Booking(this);
        }
    }


}