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
    private String customerName;
    private String serviceName;
    private String staffName;
    private String date;
    private String time;
    private int duration;
    private double price;
    private String status;


    public Booking(Builder builder) {
        this.bookingId = builder.bookingId;
        this.customerName =  builder.customerName;
        this.serviceName =  builder.serviceName;
        this.staffName =  builder.staffName;
        this.date = builder. date;
        this.time = builder. time;
        this.duration =  builder.duration;
        this.price = builder. price;
        this.status =  builder.status;
    }

    public Booking() {

    }

    public double getPrice() {
        return price;
    }


    public int getBookingId() {
        return bookingId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getStaffName() {
        return staffName;
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
                ", customerId=" + customerName +
                ", serviceId=" + serviceName +
                ", staffId=" + staffName +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", duration=" + duration +
                ", price=" + price +
                ", status='" + status + '\'' +
                '}';
    }
    public static class Builder {

        private int bookingId;
        private String customerName;
        private String serviceName;
        private String staffName;
        private String date;
        private String time;
        private int duration;



        private double price;
        private String status;


        public Builder setBookingId(int bookingId) {
            this.bookingId = bookingId;
            return this;
        }
        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setCustomerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        public Builder setServiceName(String serviceName) {
            this.serviceName = serviceName;
            return this;
        }

        public Builder setStaffName(String staffName) {
            this.staffName = staffName;
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
        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Booking builder()
        {
            return new Booking(this);
        }
    }


}