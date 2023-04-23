package mc.tech.com.service.implementation;

import mc.tech.com.entities.Customer;

public interface EmplImpl  extends IService<Customer, Integer>{
    Customer findById(int CustomerId);
    Customer findByEmailOrPhoneNumber(String emailOrPhone);
    void addRoletoUser(String username,String rolename);
    Customer getCustomer(String username);
}