package mc.tech.com.service.entities;

import lombok.extern.slf4j.Slf4j;
import mc.tech.com.entities.Booking;
import mc.tech.com.entities.Service;
import mc.tech.com.entities.Staff;
import mc.tech.com.factory.factoryService;
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
class ServceServiceTest {

    @Autowired
    private ServceService serviceService;
    Service service,service1,service2,service3,service4;
    @BeforeEach
    void setUp() {

        service= factoryService.BuildService("undercut","percfect",30,300.99);
        service1= factoryService.BuildService("buzz cut","great",45,450.99);
        service2= factoryService.BuildService("pomp","Good",15,120.99);
        service3= factoryService.BuildService("crew cut","nice",30,250.99);
        service4= factoryService.BuildService("side part","percfect",30,300.99);


    }



    @Test
    void a_save() {
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
    }

    @Test
    void b_read() {
        Optional<Service> read=this.serviceService.read(1);
        log.info("Find  staff by id :"+read);

    }

    @Test
    void c_delete() {
        this.serviceService.delete(1);
    }

    @Test
    void d_findById() {
        Service id=this.serviceService.findById(2);
        log.info("Find  Service by id :"+id);
    }

    @Test
    void f_findAll() {
        this.serviceService.findAll();
    }

    @Test
    void g_findByName() {
        this.serviceService.findByName(service3.getName());
    }

}