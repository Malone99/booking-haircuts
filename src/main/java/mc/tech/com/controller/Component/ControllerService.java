package mc.tech.com.controller.Component;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mc.tech.com.entities.Booking;
import mc.tech.com.service.entities.ServceService;
import mc.tech.com.service.entities.ServiceCustomer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@Controller
@RequiredArgsConstructor
@RequestMapping("booking-haircut")
public class ControllerService {
//
//    private final ServceService service;
//    @GetMapping({"/all/name"})
//    public ModelAndView editEmployee(int id){
//        ModelAndView mav= new ModelAndView("component/edit_Booking");
//        List<String> Names= this.service.findAllName();
//        mav.addObject("Names",Names);
//        return mav;
//    }
}
