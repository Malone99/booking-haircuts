package mc.tech.com.entities;

import javax.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Setter
@Getter
@ToString
 @NoArgsConstructor @AllArgsConstructor
public class Customer {

    @Id
    @SequenceGenerator(name = "userAccount", sequenceName = "ORACLE_DB_SEQ_ID",
            allocationSize = 7, initialValue = 30012)
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

    public Customer(int emplId, @NonNull String name, @NonNull String email, @NonNull String phoneNumber, @NonNull String password, @NonNull String address) {
        EmplId = emplId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.address = address;
    }

    @NonNull
    private String address;


    public Customer(@NonNull String name, @NonNull String email, @NonNull String phoneNumber, @NonNull String password, @NonNull String address) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.address = address;
       
    }

    public Customer(@NonNull String name, @NonNull String email, @NonNull String phoneNumber, @NonNull String password, @NonNull String address, Collection<Role> roles) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.address = address;
        this.roles = roles;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name="users_roles",
            joinColumns={@JoinColumn(name="Customer_EmplId", referencedColumnName="EmplId")},
            inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})
    private Collection<Role> roles = new ArrayList<>();


   

}
