package mc.tech.com.service.entities;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mc.tech.com.entities.Role;
import mc.tech.com.repository.RoleRepository;
import mc.tech.com.entities.Customer;

import mc.tech.com.repository.repositoryCustomer;
import mc.tech.com.service.email.EmailSender;
import mc.tech.com.service.implementation.EmplImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static mc.tech.com.service.email.EmailService.buildEmail;


@org.springframework.stereotype.Service
@Slf4j
@Transactional
@AllArgsConstructor
public class ServiceCustomer implements EmplImpl{

    private final repositoryCustomer repository;
    private PasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;
    private final EmailSender emailSender;


 @Override
    public Customer save(Customer empl) {
    String password=  passwordEncoder.encode(empl.getPassword());
     Role roles = this.roleRepository.findByName("ROLE_USER");
     if(roles == null){
         throw new IllegalArgumentException(" does not ROLE_ADMIN Exist");
     }

        if(repository.existsEmplByEmail(empl.getEmail())){

            throw new IllegalArgumentException("customer Email already Exist");
        } else if(repository.existsEmplByPhoneNumber(empl.getPhoneNumber())){

            throw new IllegalArgumentException("customer Phone Number already Exist");
        }
         List<Role> roles1= Arrays.asList(roles);
        Customer getCustomerDetails= new Customer(empl.getName(),
                empl.getEmail(),empl.getPhoneNumber(),password,
                empl.getAddress(),roles1);
        Customer SaveCustomer=this.repository.save(getCustomerDetails);
        log.info("Save ControllerCustomer :"+SaveCustomer);
     emailSender.send(
             empl.getEmail(),
             buildEmail(empl.getName()));
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
            Customer update = new Customer(id,Name,Email,phoneNumber,password,address);
            System.out.println("updated "+update);
            return this.repository.save(update);
        });

    }
    public Customer EditSaveUser(Customer name) {
        Customer customer1=this.repository.findByEmail(name.getEmail())  ;
           if(customer1==null){
               throw new IllegalArgumentException(" Email doeas not exist");
           }
            Customer update = new Customer(customer1.getEmplId(),name.getName(),
                    name.getEmail(),name.getPhoneNumber(),customer1.getPassword(),name.getAddress());

            return this.repository.save(update);


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
        Role roles= roleRepository.findByName(rolename);
        Customer useradd= repository.findByEmail(email);
        if(useradd==null ||roles==null ){

            log.info("Can not find this email::",email);
            log.info("Error",roles);
        }
        useradd.getRoles().add(roles);  //the @transaction going to save it

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

    public Role saveRole(Role role) {
        Role role1=new Role(role.getName(),role.getUsers());
        Role rl= this.roleRepository.save(role1);
        return  rl;
    }


}
