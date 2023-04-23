package mc.tech.com.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static jakarta.persistence.GenerationType.SEQUENCE;
@Entity
@Setter
@Getter
@ToString
 @NoArgsConstructor @AllArgsConstructor
public class Customer {

    @Id
    @SequenceGenerator(name = "userAccount", sequenceName = "ORACLE_DB_SEQ_ID",
            allocationSize = 7, initialValue = 7001)
    @GeneratedValue(strategy = SEQUENCE, generator = "userAccount")
    private int EmplId;
    @NonNull
    private String name;
    @NonNull
    private String email;
    @NonNull
    private String phoneNumber;
    @NonNull
    private String password;
    @NonNull
    private String address;


    public Customer(@NonNull String name, @NonNull String email, @NonNull String phoneNumber, @NonNull String password, @NonNull String address, List<role> roles) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.address = address;
        this.roles = roles;
    }


    @ManyToMany(fetch = FetchType.EAGER)
    private List<role> roles = new ArrayList<>();

}
