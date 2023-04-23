package mc.tech.com.repository;


import mc.tech.com.entities.role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface roleRepository extends JpaRepository<role,Integer> {
    role findByName(String name);
}