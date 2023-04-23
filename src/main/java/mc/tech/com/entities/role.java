package mc.tech.com.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.SEQUENCE;


@Entity
@Data
@NoArgsConstructor
public class role {
    @Id
    @SequenceGenerator(name = "userAccount", sequenceName = "ORACLE_DB_SEQ_ID",
            allocationSize = 7, initialValue = 7001)
    @GeneratedValue(strategy = SEQUENCE, generator = "userAccount")
    private int id;

    public role(String name) {
        this.name = name;
    }

    private String name;
}
