package mc.tech.com.service.entities;

import lombok.extern.slf4j.Slf4j;
import mc.tech.com.entities.Booking;
import mc.tech.com.entities.Customer;
import mc.tech.com.entities.Service;
import mc.tech.com.entities.Staff;
import mc.tech.com.factory.factoryBooking;
import mc.tech.com.factory.factoryCustomer;
import mc.tech.com.factory.factoryService;
import mc.tech.com.factory.factoryStaff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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
    void BeforeEachTest()
    {

        booking = factoryBooking.BuildBooking("Emma","buzz cut","paul",
                "2022-04-01","11:30",30,00.0,"booked") ;
        booking1 = factoryBooking.BuildBooking("Franck","buzz cut","prince",
                "2022-04-02","09:30",30,00.0,"booked") ;
        booking2 = factoryBooking.BuildBooking("Jeremie","pomp","Nathan",
                "2022-04-01","10:30",30,00.0,"booked") ;
        booking3 = factoryBooking.BuildBooking("Emma","crew cut","Farai",
                "2022-04-02","08:30",30,00.0,"booked");
        booking4 = factoryBooking.BuildBooking("isaac","side part","Serge",
                "2022-04-01","14:30",30,00.0,"booked");


        service= factoryService.BuildService("undercut","percfect",30,300.99);
        service1= factoryService.BuildService("buzz cut","great",45,450.99);
        service2= factoryService.BuildService("pomp","Good",15,120.99);
        service3= factoryService.BuildService("crew cut","nice",30,250.99);
        service4= factoryService.BuildService("side part","percfect",30,300.99);


        staff= factoryStaff.BuildStaff("paul","paul@gmail.com","0812343622",
                "123456","member");
        staff1= factoryStaff.BuildStaff("prince","draybulambo45@gmail.com","0812343622",
                "123456","member");
        staff2= factoryStaff.BuildStaff("Nathan","franck@gmail.com","0812343622",
                "123456","member");
        staff3= factoryStaff.BuildStaff("Farai","paul@gmail.com","0812343622",
                "123456","member");
        staff4= factoryStaff.BuildStaff("Serge","paul@gmail.com","0812343622",
                "123456","member");



        customer= factoryCustomer.BuildCustomer("Emma","dray@gmail.com","+27814783125",
                "dry%142","15 rose road","");
        customer1= factoryCustomer.BuildCustomer("Franck","Jeremie@gmail.com","+27810983125",
                "dry%142","15 rose road","");
        customer2= factoryCustomer.BuildCustomer("Jeremie","dray@gmail.com","+27814783125",
                "dry%142","15 rose road","");
        customer3= factoryCustomer.BuildCustomer("isaac","dray@gmail.com","+27814783125",
                "dry%142","15 rose road","");
        customer4= factoryCustomer.BuildCustomer("Dray","dray@gmail.com","+27814783125",
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


        Service service11=this.serviceService.save(service);
        Service service12=this.serviceService.save(service1);
        Service service13=this.serviceService.save(service2);
        Service service14=this.serviceService.save(service3);
        Service service15=this.serviceService.save(service4);
        log.info("",service11);
        log.info("",service12);
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

        @Test
    void delete() {
        this.serviceBooking.delete(1);
    }

    @Test
    void findById() {
        Booking read   =this.serviceBooking.findById(1);
        log.info("find id "+read);
    }
    @Test
    void findAllBooking() {
        List<Booking> bookingList=this.serviceBooking.findAllBooking();
        log.info("List of Booking",bookingList);

    }

    @Test
    void findByStaffName() {
        List<Booking> read=this.serviceBooking.findByStaffName("paul");
        assertNotNull(read);
        log.info("List of Booking finding By "+read);
    }

    @Test
    void findByDate() {

        List<Booking> read=this.serviceBooking.findByDate("2023-04-01");
        assertNotNull(read);
        log.info("List of Booking finding By "+read);
    }

}