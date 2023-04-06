package mc.tech.com.service.entities;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mc.tech.com.entities.Customer;
import mc.tech.com.factory.factoryCustomer;
import mc.tech.com.repository.repositoryCustomer;
import mc.tech.com.service.implementation.CustomerImplementation;
import org.springframework.stereotype.Service;

import java.util.Optional;
@RequiredArgsConstructor
@Service
@Slf4j
public class ServiceCustomer implements CustomerImplementation {

    private final repositoryCustomer repositoryCustomer;

    @Override
    public Customer findById(int CustomerId) {


        Customer CustomerID=this.repositoryCustomer.findById(CustomerId) ;
        log.info("Customer find By Id:"+CustomerID);
        return CustomerID;
    }

    @Override
    public Customer findByEmailOrPhoneNumber(String emailOrPhone) {


//        Customer  getCustomer=this.repositoryCustomer.findCustomerByEmailOrPhoneNumber(emailOrPhone);
//         log.info("findCustomerByEmailOrPhoneNumber",getCustomer);

        return null;
    }

    @Override
    public Customer save(Customer customer) {

        if(repositoryCustomer.existsCustomerByEmail(customer.getEmail())){

            throw new IllegalArgumentException("customer Email already Exist");
        } else if(repositoryCustomer.existsCustomerByPhoneNumber(customer.getPhoneNumber())){

            throw new IllegalArgumentException("customer Phone Number already Exist");
        }
        Customer getCustomerDetails= factoryCustomer.BuildCustomer(customer.getName(),
                customer.getEmail(),customer.getPhoneNumber(),customer.getPassword(),
                customer.getAddress(),  customer.getPaymentInformation());
        Customer SaveCustomer=this.repositoryCustomer.save(getCustomerDetails);
        log.info("Save Customer :"+SaveCustomer);
        return SaveCustomer;
    }

    @Override
    public Optional<Customer> read(Integer integer) {
        Optional<Customer>readId=this.repositoryCustomer.findById(integer);
        log.info("read Customer By Id :"+readId);
        return readId;
    }

    @Override
    public void delete(int deleteById) {

        this.repositoryCustomer.deleteById(deleteById);
   }
}
