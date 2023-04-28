package mc.tech.com.controller;



import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mc.tech.com.entities.Booking;
import mc.tech.com.entities.Staff;
import mc.tech.com.repository.repositoryService;
import mc.tech.com.service.entities.ServiceBooking;
import mc.tech.com.service.entities.ServiceCustomer;
import mc.tech.com.service.entities.ServiceStaff;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;


@Slf4j
@RestController
@Controller
@RequiredArgsConstructor
@RequestMapping("booking-haircut")
public class main {
    private final repositoryService service;
    private final ServiceCustomer serviceCustomer;
    private final ServiceStaff serviceStaff;
    private final ServiceBooking booking;
    private final mc.tech.com.repository.repositoryStaff repositoryStaff;
    @GetMapping({""})
    public ModelAndView mains()
    {
        String name="Shaving";
        String nameBEAUTY="BEAUTY";
        String nameFACE_WASHING="FACE WASHING";
        String nameBODY="BODY TREATMENTS";
        String MEDITATIONS="MEDITATIONS";
        ModelAndView modelAndView = new ModelAndView("main");

        modelAndView.addObject("MEDITATIONS",this.service.findByTitle(MEDITATIONS));
        modelAndView.addObject("BODY",this.service.findByTitle(nameBODY));
        modelAndView.addObject("ApiShaving", this.service.findByTitle(name));
        modelAndView.addObject("ApiBEAUTY", this.service.findByTitle(nameBEAUTY));
        modelAndView.addObject("ApiFACE", this.service.findByTitle(nameFACE_WASHING));
        mc.tech.com.entities.Booking booking = new Booking();
        modelAndView.addObject("BookAppointment",booking);
        return modelAndView;
    }

    @GetMapping({"/admin"})
    public ModelAndView Dashboard_Admin_listOfUsers()
    {
        ModelAndView modelAndView = new ModelAndView("component/user-admin");
        modelAndView.addObject("totalCustomer",this.serviceCustomer.getTotalCustomerCount());
        modelAndView.addObject("ListOfcustomer",this.serviceCustomer.findAll());
        modelAndView.addObject("totalStaff",this.serviceStaff.getTotalStaffRCount());
        modelAndView.addObject("totalBooking",this.booking.getTotalBookingRCount());
        modelAndView.addObject("totalMoney",this.booking.TotalMoney());
        modelAndView.addObject("ListOfStaff",this.serviceStaff.findAll());
        return modelAndView;
    }

    @GetMapping({"/admin/Employee"})
    public ModelAndView Dashboard_Admin_listOfEmployee( String keyword)
    {
        ModelAndView modelAndView = new ModelAndView("component/Employee-admin");
        modelAndView.addObject("totalCustomer",this.serviceCustomer.getTotalCustomerCount());
        modelAndView.addObject("ListOfcustomer",this.serviceCustomer.findAll());
        modelAndView.addObject("totalStaff",this.serviceStaff.getTotalStaffRCount());
        modelAndView.addObject("totalBooking",this.booking.getTotalBookingRCount());
        modelAndView.addObject("totalMoney",this.booking.TotalMoney());
        if (keyword !=null){
            modelAndView.addObject("ListOfStaff",this.serviceStaff.findByKeyword(keyword));

        }else {
            modelAndView.addObject("ListOfStaff", this.serviceStaff.findAllByOrderByStaffIdDesc());
        }
        return modelAndView;
    }

    @GetMapping({"/login"})
    public ModelAndView loginForm(){
        ModelAndView mav= new ModelAndView("component/Login");
        return mav;
    }



    @GetMapping("/add_Employee")
    public ModelAndView regier(){
        ModelAndView mav= new ModelAndView("component/add_Employee");
        Staff staff1= new Staff ();
        mav.addObject("staffAdd",staff1);
        return mav;
    }

    @PostMapping("/saveStaff")
    public RedirectView SaveStaff(@ModelAttribute Staff staff){

        this.repositoryStaff.save(staff);
        return new RedirectView("http://localhost:8080/booking-haircut/admin/Employee");
    }
    @PostMapping("/Edit/Staff")
    public RedirectView EditSaveStaff(@ModelAttribute Staff staff){

        this.serviceStaff.Editsave(staff);
        return new RedirectView("http://localhost:8080/booking-haircut/admin/Employee");
    }
    @GetMapping({"/editEmployee"})
    public  ModelAndView editEmployee( int id){
        ModelAndView mav= new ModelAndView("component/edit_Employee");
        Optional<Staff> email1= Optional.ofNullable(this.serviceStaff.findByID((id)).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
        mav.addObject("staffEmail",email1);
        return mav;
    }

    @GetMapping("/EmployeeDeleteId")
    public RedirectView deleteEmployee(int Id){
        this.serviceStaff.delete(Id);
        return new RedirectView("http://localhost:8080/booking-haircut/admin/Employee");
    }


}