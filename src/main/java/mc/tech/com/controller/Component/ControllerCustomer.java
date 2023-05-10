package mc.tech.com.controller.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;;
import mc.tech.com.entities.Customer;
import mc.tech.com.entities.Staff;
import mc.tech.com.service.entities.ServiceCustomer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
public class ControllerCustomer {
    private final ServiceCustomer serviceCustomer;
    @GetMapping({"/register"})
    public ModelAndView register(){
        ModelAndView mav= new ModelAndView("component/register");
        mc.tech.com.entities.Customer customer1= new mc.tech.com.entities.Customer();
        mav.addObject("employee",customer1);
        return mav;
    }
    @GetMapping({"/signup"})
    public ModelAndView signup(){
        ModelAndView mav= new ModelAndView("component/SignUp");
        mc.tech.com.entities.Customer customer1= new mc.tech.com.entities.Customer();
        mav.addObject("customerregister",customer1);
        return mav;
    }
    @PostMapping("/register/save")
    public RedirectView SaveCustomer(@ModelAttribute mc.tech.com.entities.Customer customer, BindingResult result, Model model){
        Customer existing = this.serviceCustomer.getCustomer(customer.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }
        if (result.hasErrors()) {
            model.addAttribute("employee", customer);
            return new RedirectView("http://localhost:8080/booking-haircut/register");
        }
        this.serviceCustomer.save(customer);
        return new RedirectView("http://localhost:8080/booking-haircut/signup?success");
    }

    @PostMapping("/admin/Edit/Customer")
    public RedirectView EditSaveStaff(@ModelAttribute mc.tech.com.entities.Customer customer){

        this.serviceCustomer.EditsaveCustomer(customer);
        return new RedirectView("http://localhost:8080/booking-haircut/admin");
    }

    @GetMapping({"/admin/editCustomer"})
    public  ModelAndView editEmployee( int id){
        ModelAndView mav= new ModelAndView("component/edit_Customer");
        Optional<mc.tech.com.entities.Customer> email1= Optional.ofNullable(this.serviceCustomer.findByID(id)).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mav.addObject("Customer",email1);
        return mav;
    }
    @GetMapping("/admin/CustomerDeleteId")
    public RedirectView deleteCustomer(int Id){
        this.serviceCustomer.delete(Id);
        return new RedirectView("http://localhost:8080/booking-haircut/admin");
    }

    @GetMapping("/admin/add_Cusomer")
    public ModelAndView regier(){
        ModelAndView mav= new ModelAndView("component/add_Customer");
        Customer Customer1 =new Customer();
        mav.addObject("customerAdd", Customer1);
        return mav;
    }
    @PostMapping("/admin/save/customer")
    public RedirectView adminSaveCustomer(@ModelAttribute mc.tech.com.entities.Customer customer){

        this.serviceCustomer.save(customer);
        return new RedirectView("http://localhost:8080/booking-haircut/admin");
    }




}
