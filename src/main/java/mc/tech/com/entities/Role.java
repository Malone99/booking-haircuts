package mc.tech.com.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mc.tech.com.entities.Customer;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="roles")
public class Role
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, unique=true)
    private String name;

    public Role(String name, List<Customer> users) {
        this.name = name;
        this.users = users;
    }
    public Role(String name) {
        this.name = name;
        this.users = users;
    }

    @ManyToMany(mappedBy="roles")
    private List<Customer> users;
}
