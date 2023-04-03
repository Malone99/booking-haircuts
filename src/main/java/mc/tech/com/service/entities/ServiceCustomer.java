package mc.tech.com.service.entities;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mc.tech.com.entities.Customer;
import mc.tech.com.repository.repositoryCustomer;
import mc.tech.com.service.implementation.CustomerImplementation;
import org.springframework.stereotype.Service;

import java.util.Optional;
@RequiredArgsConstructor
@Service
@Slf4j
public class ServiceCustomer implements CustomerImplementation {

    private final repositoryCustomer repository;

    @Override
    public Customer findById(int CustomerId) {
        Customer CustomerID=this.repository.findById(CustomerId) ;
        log.info("Customer find By Id:"+CustomerID);
        return CustomerID;
    }

    @Override
    public Customer findByEmailOrPhoneNumber(String emailOrPhone) {

//        Customer CustomerEmailOrPhone=this.repository.findByEmailOrPhoneNumber(emailOrPhone);
//        log.info("Customer find By CEmail Or Phone:"+CustomerEmailOrPhone);

        return null;
    }

    @Override
    public Customer save(Customer customer) {
        int email=customer.getCustomerId();
        Customer SaveCustomer=this.repository.save(customer);
        log.info("Save Customer :"+SaveCustomer);
        return SaveCustomer;
    }

    @Override
    public Optional<Customer> read(Integer integer) {
        Optional<Customer>readId=this.repository.findById(integer);
        log.info("read Customer By Id :"+readId);
        return readId;
    }

    @Override
    public void delete(int deleteById) {

        this.repository.deleteById(deleteById);
   }
}
