package mc.tech.com.repository;


import mc.tech.com.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface repositoryCustomer extends JpaRepository<Customer,Integer> {
    Customer findById(int id);
    Customer findByEmail(String email);
    Customer findByName(String CustomerName);
    boolean existsEmplByPhoneNumber(String PhoneNumber);
    boolean existsEmplByEmail(String email);
    long count();

}
