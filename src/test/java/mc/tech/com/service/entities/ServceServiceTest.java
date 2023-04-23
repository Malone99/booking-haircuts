package mc.tech.com.service.entities;

import lombok.extern.slf4j.Slf4j;
import mc.tech.com.entities.Booking;
import mc.tech.com.entities.Service;
import mc.tech.com.entities.Staff;
import mc.tech.com.factory.factoryService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
class ServceServiceTest {

    @Autowired
    private ServceService serviceService;
    Service service,service1,service2,service3,service4,service5,service6,service7;
    @BeforeEach
    void setUp() throws IOException {

        byte[] imageDataShave= Files.readAllBytes(Paths.get("/Users/draybulambo/Desktop/gallery-3.jpg"));
        service= factoryService.BuildService("SHAVING","undercut","Clean",45,300,imageDataShave);
//        service1= factoryService.BuildService("BEAUTY","Chilled tea bags for puffy eyes","Clean",45,450);
//        service2= factoryService.BuildService("FACE WASHING","Brightening Face Wash","Clean",35,120);
//        service3= factoryService.BuildService("MEDITATIONS","Margao,","Clean",30,250);
//        service4= factoryService.BuildService("SHAVING","side part","Clean",30,300);
//        service5= factoryService.BuildService("FACE WASHING","Mamaearth Natural Face Wash","Clean",15,100);
//        service6= factoryService.BuildService("SHAVING","crew cut","Clean",25,250);
//        service7= factoryService.BuildService("BODY TREATMENTS","Long Top Short Sides","Clean",30,300);
//

    }






    @Order(1)
    @Test
    void save() throws IOException {
        Service service11=this.serviceService.save(service);
//        Service service12=this.serviceService.save(service1);
//        Service service13=this.serviceService.save(service2);
//        Service service14=this.serviceService.save(service3);
//        Service service15=this.serviceService.save(service4);
//        this.serviceService.save(service5);
//        this.serviceService.save(service6);
//        this.serviceService.save(service7);
        log.info("",service11);
//        log.info("",service12);
//        log.info("",service13);
//        log.info("",service14);
//        log.info("",service15);
    }
   @Order(2)
    @Test
    void read() {
        Optional<Service> read=this.serviceService.read(1);
        log.info("Find  staff by id :"+read);

    }
//
//    @Test
//    void c_delete() {
//        this.serviceService.delete(1);
//    }
    @Order(3)
    @Test
    void d_findById() {
        Service id=this.serviceService.findById(2);
        log.info("Find  Service by id :"+id);
    }
    @Order(4)
    @Test
    void f_findAll() {
        this.serviceService.findAll();
    }
    @Order(5)
    @Test
    void g_findByName() {
        this.serviceService.findByName(service.getName());
    }

}