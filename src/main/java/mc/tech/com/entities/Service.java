package mc.tech.com.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serviceId;
    private String name;
    private String description;
    private int duration;
    private double price;



    public Service(Builder builder){
        this.serviceId =builder. serviceId;
        this.name = builder.name;
        this.description = builder.description;
        this.duration = builder.duration;
        this.price = builder.price;
    }

    public int getServiceId() {
        return serviceId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getDuration() {
        return duration;
    }
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Service{" +
                "serviceId=" + serviceId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                ", price=" + price +
                '}';
    }

    public static class Builder {

        private int serviceId;
        private String name;
        private String description;
        private int duration;
        private double price;
        public Builder setServiceId(int serviceId) {
            this.serviceId = serviceId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setDuration(int duration) {
            this.duration = duration;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }
        public Service builder()
        {
            return new Service(this);
        }

    }





}