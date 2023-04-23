package mc.tech.com.controller.Component;


import lombok.RequiredArgsConstructor;
import mc.tech.com.service.entities.ServceService;
import mc.tech.com.service.entities.ServiceStaff;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("booking-haircut")
public class ControllerStaff {
//
//    private final ServiceStaff service;
//    @GetMapping({"/all/name"})
//    public ModelAndView editEmployee(int id){
//        ModelAndView mav= new ModelAndView("component/edit_Booking");
//        List<String> Names= this.service.findStaffAllName();
//        mav.addObject("StaffNames",Names);
//        return mav;
//    }
}
