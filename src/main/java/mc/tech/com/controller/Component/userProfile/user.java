package mc.tech.com.controller.Component.userProfile;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mc.tech.com.entities.Customer;
import mc.tech.com.service.entities.ServiceCustomer;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
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
public class user {
    private final ServiceCustomer serviceCustomer;
    @GetMapping({"/user/profile"})
    public ModelAndView user_profile(String email){
        ModelAndView mav= new ModelAndView("component/userProfile/user_profile_update");
        Customer customer= this.serviceCustomer.getCustomer(email);
        mav.addObject("UserDetails",customer);
        return mav;
    }
    @PostMapping("/user/Edit/Customer")
    public RedirectView EditSaveStaff(@ModelAttribute mc.tech.com.entities.Customer customer){

        this.serviceCustomer.EditSaveUser(customer);
        return new RedirectView("http://localhost:8080/booking-haircut");
    }


}
