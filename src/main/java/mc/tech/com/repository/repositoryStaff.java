package mc.tech.com.repository;


import javax.persistence.*;
import javax.transaction.Transactional;

import mc.tech.com.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Transactional
@Repository
public interface repositoryStaff  extends JpaRepository<Staff,Integer> {
    Staff findById(int id);
    Staff findByEmail(String email);
    Staff findByName(String StaffName);
    List<Staff> findAllByOrderByStaffIdDesc();
    boolean existsStaffByName(String StaffName);
    boolean existsStaffByPhoneNumber(String PhoneNumber);
    boolean existsStaffByEmail(String email);
    long count();
    @Query(value = "SELECT * FROM Staff s where s.name like %:keyword% or s.surname like %:keyword%",nativeQuery = true)
    List<Staff> findByKeyword(@Param("keyword") String keyword);
    @Query("UPDATE Staff s SET s.name = :name, s.surname = :surname, s.phoneNumber = :phoneNumber, s.position = :position WHERE s.email = :email")
    Staff updateStaffByEmail(@Param("name") String name, @Param("surname") String surname, @Param("phoneNumber") String phoneNumber, @Param("position") String position, @Param("email") String email);
    @Query("SELECT s.name FROM Staff s")
    List<String> findAllStaffNames();

}
