package mc.tech.com.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Value;

@Entity
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int staffId;
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private String position;

    public Staff(Builder builder){
        this.staffId = builder.staffId;
        this.name = builder.name;
        this.email =builder. email;
        this.phoneNumber = builder.phoneNumber;
        this.password = builder.password;
        this.position = builder.position;
    }

    public Staff() {

    }


    public int getStaffId() {
        return staffId;
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
    public String getPosition() {
        return position;
    }
    @Override
    public String toString() {
        return "factoryStaff{" +
                "staffId=" + staffId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
    public static class Builder {


        private int staffId;
        private String name;
        private String email;
        private String phoneNumber;
        private String password;
        private String position;

        public Builder setStaffId(int staffId) {
            this.staffId = staffId;
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

        public Builder setPosition(String position) {
            this.position = position;
            return this;
        }
        public Staff builder()
        {
            return new Staff(this);
        }

    }





}