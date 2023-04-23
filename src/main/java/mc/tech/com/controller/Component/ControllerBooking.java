package mc.tech.com.controller.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mc.tech.com.entities.Booking;
import mc.tech.com.entities.Customer;
import mc.tech.com.entities.Staff;
import mc.tech.com.repository.repositoryService;
import mc.tech.com.service.entities.ServceService;
import mc.tech.com.service.entities.ServiceBooking;
import mc.tech.com.service.entities.ServiceCustomer;
import mc.tech.com.service.entities.ServiceStaff;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@Controller
@RequiredArgsConstructor
@RequestMapping("booking-haircut")
public class ControllerBooking {

    private final ServiceBooking serviceBooking;
    private final ServiceCustomer serviceCustomer;
    private final ServiceStaff serviceStaff;
    private final ServiceBooking booking;
    private final ServceService service;

    @PostMapping("/Edit/Booking")
    public RedirectView EditSaveStaff(@ModelAttribute Booking booking){

        this.serviceBooking.EditsaveBooking(booking);
        return new RedirectView("http://localhost:8080/booking-haircut/Booking");
    }
    @GetMapping({"/editBooking"})
    public ModelAndView editEmployee(int id){
        ModelAndView mav= new ModelAndView("component/edit_Booking");
        Optional<Booking> email1= Optional.ofNullable(this.serviceBooking.findByID(id)).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mav.addObject("Booking",email1);
        return mav;
    }
    @GetMapping({"/Booking"})
    public ModelAndView Dashboard_Admin_listOfUsers( String keyword)
    {
        ModelAndView modelAndView = new ModelAndView("component/Booking-admin");
        modelAndView.addObject("totalCustomer",this.serviceCustomer.getTotalCustomerCount());
        modelAndView.addObject("ListOfcustomer",this.serviceCustomer.findAll());
        modelAndView.addObject("totalStaff",this.serviceStaff.getTotalStaffRCount());
        modelAndView.addObject("totalBooking",this.booking.getTotalBookingRCount());
        modelAndView.addObject("totalMoney",this.booking.TotalMoney());
        modelAndView.addObject("ListOfStaff",this.serviceStaff.findAll());
        if(keyword !=null){
            modelAndView.addObject("ALLBooking",this.serviceBooking.Searching(keyword));
            return modelAndView;
        }else {
            modelAndView.addObject("ALLBooking", this.serviceBooking.findAll());

        }
        return modelAndView;
    }
    @GetMapping("/BookingDeleteId")
    public RedirectView deleteId(int Id){
        this.serviceBooking.delete(Id);
        return new RedirectView("http://localhost:8080/booking-haircut/Booking");
    }

    @GetMapping("/add_Booking")
    public ModelAndView add_Booking(){
        ModelAndView mav= new ModelAndView("component/add_Booking");
        Booking booking =new Booking();
        List<String> Names= this.service.findAllName();
        List<String> StaffNames= this.serviceStaff.findStaffAllName();
        mav.addObject("ServiceNames",Names);
        mav.addObject("StaffNames",StaffNames);
        mav.addObject("add_Booking",booking);
        return mav;
    }


    @GetMapping("admin/save/Booking")
    public RedirectView EditSaveBooking(@ModelAttribute Booking booking){

        this.serviceBooking.save(booking);
        return new RedirectView("http://localhost:8080/booking-haircut");
    }


    @PostMapping("save/Booking")
    public RedirectView SaveBooking(@ModelAttribute Booking booking){

        this.serviceBooking.savet(booking);
        return new RedirectView("http://localhost:8080/booking-haircut");
    }

}
