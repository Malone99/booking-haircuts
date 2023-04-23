package mc.tech.com.entities;

import jakarta.persistence.*;

@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serviceId;
    private String title;
    private String name;
    private String description;
    private int duration;
    private int price;
    @Column( columnDefinition="BLOB")
    @Lob
    private byte[] imageData;



    public Service(Builder builder){
        this.serviceId =builder. serviceId;
        this.title=builder.title;
        this.name = builder.name;
        this.description = builder.description;
        this.duration = builder.duration;
        this.price = builder.price;
        this.imageData=builder.imageData;

    }

    public Service() {

    }

    public int getServiceId() {
        return serviceId;
    }
    public String getTitle() {
        return title;
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
    public int getPrice() {
        return price;
    }

    public byte[] getImageData() {
        return imageData;
    }



    @Override
    public String toString() {
        return "Service{" +
                "serviceId=" + serviceId +
                ", title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                ", price=" + price +
                ", imageData=" + imageData +
                '}';
    }

    public static class Builder {

        private int serviceId;
        private String title;
        private String name;
        private String description;
        private int duration;
        private int price;

        public Builder setImageData(byte[] imageData) {
            this.imageData = imageData;
            return this;
        }

        private byte[] imageData;

        public Builder setImage(String image) {
            this.image = image;
            return this;
        }

        private String image;
        public Builder setServiceId(int serviceId) {
            this.serviceId = serviceId;
            return this;
        }
        public Builder setTitle(String title) {
            this.title = title;

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

        public Builder setPrice(int price) {
            this.price = price;
            return this;
        }
        public Service builder()
        {
            return new Service(this);
        }

    }





}