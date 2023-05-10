package mc.tech.com.entities;


import javax.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;
    @NonNull
    private String customerName;
    @NonNull
    private String customerEmail;
    @NonNull
    private String serviceName;
    @NonNull
    private String date;
    @NonNull
    private String time;
    @NonNull
    private int duration;
    private double price;
    private String message;
    private String status;

    public Booking(int bookingId, @NonNull String customerName, @NonNull String customerEmail, @NonNull String serviceName, @NonNull String date, @NonNull String time, @NonNull int duration, double price, String message, String status) {
        this.bookingId = bookingId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.serviceName = serviceName;
        this.date = date;
        this.time = time;
        this.duration = duration;
        this.price = price;
        this.message = message;
        this.status = status;
    }

    public Booking(String customerName, String customerEmail, String serviceName, String date, String time, int duration, double price, String message, String status) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.serviceName = serviceName;
        this.date = date;
        this.time = time;
        this.duration = duration;
        this.price = price;
        this.message = message;
        this.status = status;
    }


    public Booking() {

    }
}