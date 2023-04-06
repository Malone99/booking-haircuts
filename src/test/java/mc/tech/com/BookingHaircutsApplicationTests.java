package mc.tech.com;

import mc.tech.com.entities.Booking;
import mc.tech.com.entities.Service;
import mc.tech.com.entities.Staff;
import mc.tech.com.service.entities.ServceService;
import mc.tech.com.service.entities.ServiceCustomer;
import mc.tech.com.service.entities.ServiceStaff;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookingHaircutsApplicationTests {
    @Autowired
    private ServiceStaff serviceStaff;

    Staff staff,staff1,staff2,staff3,staff4;

    @Test
    void contextLoads() {
    }

}
