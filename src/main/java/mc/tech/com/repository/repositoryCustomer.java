package mc.tech.com.repository;


import mc.tech.com.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface repositoryCustomer   extends JpaRepository<Customer,Integer> {
    Customer findById(int id);
    Customer findByName(String CustomerName);
    boolean existsCustomerByPhoneNumber(String PhoneNumber);
    boolean existsCustomerByEmail(String email);
//    Customer findCustomerByEmailOrPhoneNumber(String emailOrPhoneNumber);
//


}
