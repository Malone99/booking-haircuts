package mc.tech.com.service.implementation;

import mc.tech.com.entities.Staff;

import java.util.List;

public interface StaffImplementation extends  IService<Staff,Integer>{
    Staff findById(int id);
    Staff findByEmail(String email);
    Staff findByName(String StaffName);
    List<Staff> findAll();
}
