package mc.tech.com.repository;


import mc.tech.com.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface repositoryStaff  extends JpaRepository<Staff,Integer> {
    Staff findById(int id);
    Staff findByEmail(String email);
    Staff findByName(String StaffName);
    List<Staff> findAll();
    boolean existsStaffByName(String StaffName);
    boolean existsStaffByPhoneNumber(String PhoneNumber);
    boolean existsStaffByEmail(String email);
}
