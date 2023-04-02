package mc.tech.com.repository;


import mc.tech.com.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface repositoryCustomer   extends JpaRepository<Customer,Integer> {
    Customer findById(int id);
    Customer findByEmailOrPhoneNumber(String emailOrPhone);


}
