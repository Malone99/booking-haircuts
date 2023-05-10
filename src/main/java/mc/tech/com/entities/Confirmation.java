package mc.tech.com.entities;




import javax.persistence.*;

@Entity
public class Confirmation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int confirmationId;
    private int bookingId;
    private String email;
    private String phoneNumber;

    public Confirmation(Builder builder) {
        this.confirmationId =builder. confirmationId;
        this.bookingId =builder.  bookingId;
        this.email =builder.  email;
        this.phoneNumber = builder. phoneNumber;
    }

    public Confirmation() {

    }

    public int getConfirmationId() {
        return confirmationId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public String getEmail() {
        return email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }


    @Override
    public String toString() {
        return "Confirmation{" +
                "confirmationId=" + confirmationId +
                ", bookingId=" + bookingId +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public static class Builder {

        private int confirmationId;
        private int bookingId;
        private String email;
        private String phoneNumber;

        public Builder setConfirmationId(int confirmationId) {
            this.confirmationId = confirmationId;
            return this;
        }

        public Builder setBookingId(int bookingId) {
            this.bookingId = bookingId;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Confirmation builder()
        {
            return new Confirmation(this);
        }
    }





}
