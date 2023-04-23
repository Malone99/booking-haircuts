package mc.tech.com.service.implementation;

import mc.tech.com.entities.Staff;

import java.util.List;
import java.util.Optional;

public interface StaffImplementation extends  IService<Staff,Integer>{

    Optional<Staff> findByEmail(String email);
    Staff findByName(String StaffName);
    List<Staff> findAll();
    List<Staff> findAllByOrderByStaffIdDesc();
}
