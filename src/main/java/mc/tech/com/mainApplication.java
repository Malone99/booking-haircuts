package mc.tech.com;

import mc.tech.com.entities.Customer;
import mc.tech.com.entities.Role;
import mc.tech.com.service.entities.ServiceCustomer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class mainApplication {

    public static void main(String[] args) {
        SpringApplication.run(mainApplication.class, args);
    }

    @Bean
    CommandLineRunner run(ServiceCustomer user){

        return  args -> {
            user.saveRole(new Role("ROLE_ADMIN"));
            user.saveRole(new Role("ROLE_USER"));
            user.save(new Customer("prince","draybulambo45@gmail.com","0814783125","dray123","15 rose road"));
            user.addRoletoUser("draybulambo45@gmail.com","ROLE_ADMIN");

        };
    }

}
