package mc.tech.com.repository;


import mc.tech.com.entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface repositoryService extends JpaRepository<Service,Integer> {
    Service findById(int id);
    List<Service> findAll();
    Service findByName(String name);
    boolean existsServiceByName(String Name);
}
