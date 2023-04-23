package mc.tech.com.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

@Entity
@Setter
@Getter
@ToString
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int staffId;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private String password;

    public Staff(int staffId, String name, String surname, String email, String phoneNumber, String password, String position) {
        this.staffId = staffId;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.position = position;
    }

    private String position;
    public Staff() {
    }


    public Staff(String name, String surname, String email, String phoneNumber, String password, String position) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.position = position;
    }



}