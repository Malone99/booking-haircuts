package mc.tech.com.entities;

import javax.persistence.*;

@Entity
public class Availability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int availabilityId;
    private String date;
    private String time;
    private int serviceId;
    private int staffId;

    public Availability(Builder builder) {
        this.availabilityId =builder.availabilityId;
        this.date = builder.date;
        this.time = builder.time;
        this.serviceId = builder.serviceId;
        this.staffId = builder.staffId;
    }

    public Availability() {

    }


    public int getAvailabilityId() {
        return availabilityId;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public int getServiceId() {
        return serviceId;
    }

    public int getStaffId() {
        return staffId;
    }

    @Override
    public String toString() {
        return "Availability{" +
                "availabilityId=" + availabilityId +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", serviceId=" + serviceId +
                ", staffId=" + staffId +
                '}';
    }
    public static class Builder {
        private int availabilityId;
        private String date;
        private String time;
        private int serviceId;
        private int staffId;

        public Builder setAvailabilityId(int availabilityId) {
            this.availabilityId = availabilityId;
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

        public Builder setServiceId(int serviceId) {
            this.serviceId = serviceId;
            return this;
        }

        public Builder setStaffId(int staffId) {
            this.staffId = staffId;
            return this;
        }



        public Availability builder()
        {
            return new Availability(this);
        }
    }


}