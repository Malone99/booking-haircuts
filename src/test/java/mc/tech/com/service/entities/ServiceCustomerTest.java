package mc.tech.com.service.entities;

import lombok.extern.slf4j.Slf4j;
import mc.tech.com.entities.Customer;
import mc.tech.com.entities.Staff;
import mc.tech.com.factory.factoryCustomer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
class ServiceCustomerTest {

    @Autowired
    private ServiceCustomer serviceCustomer;

    Customer customer,customer1,customer2,customer3,customer4;
    @BeforeEach
    void setUp() {


        customer= factoryCustomer.BuildCustomer("Emma","dray@gmail.com","+27894783125",
                "dry%142","15 rose road","");
        customer1= factoryCustomer.BuildCustomer("Franck","Jeremie@gmail.com","+27800983125",
                "dry%142","15 rose road","");
        customer2= factoryCustomer.BuildCustomer("Jeremie","faith@gmail.com","+27854783125",
                "dry%142","15 rose road","");
        customer3= factoryCustomer.BuildCustomer("isaac","neymar@gmail.com","+27814787125",
                "dry%142","15 rose road","");
        customer4= factoryCustomer.BuildCustomer("Dray","francine@gmail.com","+27814788125",
                "dry%142","15 rose road","");
    }
    @Test
    void a_save() {
        Customer customer11=this.serviceCustomer.save(customer) ;
        Customer customer12=this.serviceCustomer.save(customer1) ;
        Customer customer13=this.serviceCustomer.save(customer2) ;
        Customer customer14=this.serviceCustomer.save(customer3) ;
        Customer customer15=this.serviceCustomer.save(customer4) ;
        log.info("",customer11);
        log.info("",customer12);
        log.info("",customer13);
        log.info("",customer14);
        log.info("",customer15);
    }

    @Test
    void b_read() {
        Optional<Customer> read   =this.serviceCustomer.read(1);
        log.info("read id "+read);
    }
    @Test
    void c_findById() {
        Customer read   =this.serviceCustomer.findById(1);
        log.info("find id "+read);

    }

    @Test
    void d_findByEmailOrPhoneNumber() {

        Customer  EmailOrPhoneNumber=this.serviceCustomer.findByEmailOrPhoneNumber(customer1.getPhoneNumber());
        log.info("find id "+EmailOrPhoneNumber);
    }



    @Test
    void e_delete() {
        this.serviceCustomer.delete(1);
    }
}