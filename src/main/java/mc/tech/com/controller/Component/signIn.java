package mc.tech.com.controller.Component;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
@Slf4j
@RestController
@Controller
@RequiredArgsConstructor
@RequestMapping("booking-haircut")
public class signIn {

    @GetMapping({"/login"})
    public ModelAndView loginForm(){
        ModelAndView mav= new ModelAndView("component/Login");
        return mav;
    }
}
