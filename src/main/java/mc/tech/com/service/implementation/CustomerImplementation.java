package mc.tech.com.service.implementation;

import mc.tech.com.entities.Customer;

public interface CustomerImplementation extends IService<Customer, Integer>{
    Customer findById(int CustomerId);
    Customer findByEmailOrPhoneNumber(String emailOrPhone);
}
