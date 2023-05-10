package mc.tech.com.service.entities;

import lombok.extern.slf4j.Slf4j;
//import mc.tech.com.entities.Role;
//import mc.tech.com.config.entity.User;
//import mc.tech.com.config.service.impl.UserServiceImpl;
import mc.tech.com.entities.Role;
import mc.tech.com.entities.*;
import mc.tech.com.factory.factoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
class ServiceBookingTest {

    @Autowired
    private ServiceBooking serviceBooking;
    @Autowired
    private ServiceStaff serviceStaff;
    @Autowired
    private ServiceCustomer serviceCustomer;
    @Autowired
    private ServceService serviceService;




    Booking booking,booking1,booking2,booking3,booking4;
    Service service,service1,service2,service3,service4;
    Staff staff,staff1,staff2,staff3,staff4;
    Customer customer,customer1,customer2,customer3,customer4;


    @BeforeEach
    void BeforeEachTest() throws IOException {
        String message="";
        booking = new Booking("Emma","dray@gmail.com","Hair Color",
                "2022-04-01","11:30",30,00.0,message,"done") ;
        booking1 =  new Booking("Franck","drabulambo45@gmail.com","Shaving & Facial",
                "2022-04-02","09:30",30,00.0,message,"booked") ;
        booking2 =  new Booking("Jeremie","Jeremie@gmail.com","Shaving & Facial",
                "2022-04-01","10:30",30,00.0,message,"booked") ;
        booking3 = new Booking("Emma","pal@gmail.com","Body massage",
                "2022-04-02","08:30",30,00.0,message,"done");
        booking4 =  new Booking("isaac","pau@gmail.com","Beauty & spa",
                "2022-04-01","14:30",30,00.0,message,"done");


        byte[] imageDataShave= Files.readAllBytes(Paths.get("/Users/draybulambo/Desktop/gallery-3.jpg"));
        service= factoryService.BuildService("SHAVING","Beauty & spa","Clean",45,300,imageDataShave);
        service1= factoryService.BuildService("SHAVING","Body massage","Clean",45,300,imageDataShave);
        service2= factoryService.BuildService("SHAVING","Shaving & Facial","Clean",45,300,imageDataShave);
        service3= factoryService.BuildService("SHAVING","Hair Color","Clean",45,300,imageDataShave);
        service4= factoryService.BuildService("SHAVING","und","Clean",45,300,imageDataShave);




        staff=  new Staff("paul","dray","paullk@gmail.com","0812343622",
                "123456","member");
        staff1= new Staff("prince","prince","drabulambo45@gmail.com","0812343602",
                "123456","member");
        staff2= new Staff("Nathan","paul","frnck@gmail.com","0812343682",
                "123456","member");
        staff3=  new Staff("Farai","nehemie","pal@gmail.com","0812343722",
                "123456","member");
        staff4=  new Staff("Serge","dra","pau@gmail.com","0812343022",
                "123456","member");



        customer= new Customer("Emma","dray@gmail.com","+27814783125",
                "dry%142","15 rose road");
        customer1=  new Customer("Franck","Jeremie@gmail.com","+27810983125",
                "dry%142","15 rose road");
        customer2= new Customer("Jeremie","drayff@gmail.com","+27844783125",
                "dry%142","15 rose road");
        customer3=  new Customer("isaac","drayfl@gmail.com","+27804783125",
                "dry%142","15 rose road");
        customer4=  new Customer("Dray","dy@gmail.com","+27824783125",
                "dry%142","15 rose road");


    }

    @Test
    void a_save() throws IOException {
        Role role1=new Role("ROLE_ADMIN");
        Role role2=new Role("ROLE_USER");
        serviceCustomer.saveRole(role2) ;
        serviceCustomer.saveRole(role1) ;
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


        Service service11=this.serviceService.save(service);
        Service service12=this.serviceService.save(service1);
        Service service13=this.serviceService.save(service2);
        Service service14=this.serviceService.save(service3);
        Service service15=this.serviceService.save(service4);
        log.info("",service11);
        log.info("",service12);
        log.info("",service13);
        log.info("",service13);
        log.info("",service14);
        log.info("",service15);

        Staff staff11=this.serviceStaff.save(staff);
        Staff staff12=this.serviceStaff.save(staff1);
        Staff staff13=this.serviceStaff.save(staff2);
        Staff staff14=this.serviceStaff.save(staff3);
        Staff staff15=this.serviceStaff.save(staff4);
        log.info("",staff11);
        log.info("",staff12);
        log.info("",staff13);
        log.info("",staff14);
        log.info("",staff15);

        Booking booking11=this.serviceBooking.save(booking);
        Booking booking12=this.serviceBooking.save(booking2);
        Booking booking13=this.serviceBooking.save(booking1);
        Booking booking14=this.serviceBooking.save(booking3);
        Booking booking15=this.serviceBooking.save(booking4);
        log.info("",booking11);
        log.info("",booking12);
        log.info("",booking13);
        log.info("",booking14);
        log.info("",booking15);



    }



}