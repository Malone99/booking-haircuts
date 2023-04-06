package mc.tech.com.service.entities;


import lombok.extern.slf4j.Slf4j;
import mc.tech.com.entities.Staff;
import mc.tech.com.factory.factoryStaff;
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
class ServiceStaffTest {


    @Autowired
    private ServiceStaff serviceStaff;
    Staff staff,staff1,staff2,staff3,staff4;
    @BeforeEach
    void setUp() {

        staff= factoryStaff.BuildStaff("paul","paul@gmail.com","0812343626",
                "123456","member");
        staff1= factoryStaff.BuildStaff("prince","draybulambo45@gmail.com","0812343622",
                "123456","member");
        staff2= factoryStaff.BuildStaff("Nathan","franck@gmail.com","0912343622",
                "123456","member");
        staff3= factoryStaff.BuildStaff("Farai","nathan@gmail.com","0012343622",
                "123456","member");
        staff4= factoryStaff.BuildStaff("Serge","cr7@gmail.com","0712343622",
                "123456","member");
    }

    @Test
    void a_save() {

        Staff staff11=this.serviceStaff.save(staff);
        Staff staff12=this.serviceStaff.save(staff1);
        Staff staff13=this.serviceStaff.save(staff2);
        Staff staff14=this.serviceStaff.save(staff3);
        Staff staff15=this.serviceStaff.save(staff4);
        log.info("created ",staff11);
        log.info("created",staff12);
        log.info("created",staff13);
        log.info("created",staff14);
        log.info("created",staff15);
    }

    @Test
    void b_read() {

       Optional<Staff> read   =this.serviceStaff.read(1);
        log.info("read id "+read);
    }

    @Test
    void c_delete() {
        this.serviceStaff.delete(1);
    }

    @Test
    void d_findById() {
        Staff read   =this.serviceStaff.findById(1);
        log.info("find id "+read);
    }

    @Test
    void f_findByEmail() {
        Staff read   =this.serviceStaff.findByEmail(staff1.getEmail());
        log.info("find email "+read);
    }

    @Test
    void g_findByName() {
        Staff read   =this.serviceStaff.findByName(staff2.getName());
        log.info("find id "+read);
    }

    @Test
    void h_findAll() {
        this.serviceStaff.findAll();
    }
}