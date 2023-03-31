package mc.tech.com.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private String address;
    private String paymentInformation;


    public Customer(Builder builder) {
        this.customerId = builder. customerId;
        this.name =builder.  name;
        this.email = builder. email;
        this.phoneNumber =builder.  phoneNumber;
        this.password =builder.  password;
        this.address = builder. address;
        this.paymentInformation =builder.  paymentInformation;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }
    public String getPaymentInformation() {
        return paymentInformation;
    }
    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", paymentInformation='" + paymentInformation + '\'' +
                '}';
    }
    public static class Builder {
        private int customerId;
        private String name;
        private String email;
        private String phoneNumber;
        private String password;
        private String address;
        private String paymentInformation;

        public Builder setCustomerId(int customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
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

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setPaymentInformation(String paymentInformation) {
            this.paymentInformation = paymentInformation;
            return this;
        }
        public Customer builder()
        {
            return new Customer(this);
        }



    }




}