package mc.tech.com.service.entities;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mc.tech.com.entities.Customer;

import mc.tech.com.entities.role;
import mc.tech.com.repository.repositoryCustomer;
import mc.tech.com.repository.roleRepository;
import mc.tech.com.service.implementation.EmplImpl;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
@Slf4j
@Transactional
public class ServiceCustomer implements EmplImpl{

    private final repositoryCustomer repository;
    private final roleRepository rolerepository;





    @Override
    public Customer save(Customer empl) {
//        password=  passwordEncoder.encode(empl.getPassword());

        if(repository.existsEmplByEmail(empl.getEmail())){

            throw new IllegalArgumentException("customer Email already Exist");
        } else if(repository.existsEmplByPhoneNumber(empl.getPhoneNumber())){

            throw new IllegalArgumentException("customer Phone Number already Exist");
        }
        Customer getCustomerDetails= new Customer(empl.getName(),
                empl.getEmail(),empl.getPhoneNumber(),empl.getPassword(),
                empl.getAddress(),new ArrayList<>());
        Customer SaveCustomer=this.repository.save(getCustomerDetails);
        log.info("Save ControllerCustomer :"+SaveCustomer);
        return SaveCustomer;
    }


    public Optional<Customer> EditsaveCustomer(Customer name) {
        int ID=name.getEmplId();
        return findByID(ID).map(name1 -> {
            String Name=name.getName();
            String address= name.getAddress();
            String phoneNumber=name.getPhoneNumber();
            int id=name1.getEmplId();
            String Email=name1.getEmail();
            String password=name.getPassword();
            Customer update = new Customer(id,Name,Email,phoneNumber,password,address,new ArrayList<>());
            System.out.println("updated "+update);
            return this.repository.save(update);
        });

    }

    @Override
    public Optional<Customer> read(Integer integer) {
        Optional<Customer>readId=this.repository.findById(integer);
        log.info("read ControllerCustomer By Id :"+readId);
        return readId;
    }
    @Override
    public Customer findById(int CustomerId) {
        Customer CustomerID=this.repository.findById(CustomerId) ;
        log.info("ControllerCustomer find By Id:"+CustomerID);
        return CustomerID;
    }

    public List<Customer> findAll() {
        List<Customer> CustomerList=this.repository.findAll();
        log.info("List Of ControllerCustomer "+CustomerList);
        return CustomerList;
    }

    @Override
    public Customer findByEmailOrPhoneNumber(String emailOrPhone) {
        return null;
    }

    @Override
    public void addRoletoUser(String email, String rolename) {

        //log.info("adding role to a User {}",username,rolename);
        Customer customer= this.repository.findByEmail(email);
        role roles= rolerepository.findByName(rolename);
        customer.getRoles().add(roles);  //the @transaction going to save it
    }

    @Override
    public Customer getCustomer(String email) {
        Customer customer =this.repository.findByEmail(email);
        return customer;
    }

    @Override
    public void delete(int deleteById) {

        this.repository.deleteById(deleteById);
    }
    public long getTotalCustomerCount() {
        return this.repository.count();
    }

    public Optional<Customer> findByID(int id) {
        return Optional.ofNullable(this.repository.findById(id));
    }


}
