package mc.tech.com.service.entities;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mc.tech.com.entities.Staff;
import mc.tech.com.factory.factoryStaff;
import mc.tech.com.repository.repositoryStaff;
import mc.tech.com.service.implementation.StaffImplementation;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@org.springframework.stereotype.Service
@Slf4j
public class ServiceStaff implements StaffImplementation {

    private final repositoryStaff StaffRepository;
    @Override
    public Staff save(Staff staff) {


        if (StaffRepository.existsStaffByName(staff.getName()))
        {
            throw new IllegalArgumentException("Staff Name already Exist");
        }else if(StaffRepository.existsStaffByEmail(staff.getEmail())){

            throw new IllegalArgumentException("Staff Email already Exist");
        } else if(StaffRepository.existsStaffByPhoneNumber(staff.getPhoneNumber())){

            throw new IllegalArgumentException("Staff Phone Number already Exist");
        }
        Staff getStaffDetails= factoryStaff.BuildStaff(staff.getName(),
                staff.getEmail(),staff.getPhoneNumber(),staff.getPassword(),staff.getPosition());

        Staff saveStaff=this.StaffRepository.save(getStaffDetails);
        log.info("staff was register:"+saveStaff);
        return saveStaff;
    }

    @Override
    public Optional<Staff> read(Integer integer) {
        Optional<Staff> read=this.StaffRepository.findById(integer);
        log.info("Find  staff by id :"+read);
        return read;
    }

    @Override
    public void delete(int deleteById) {
    this.StaffRepository.deleteById(deleteById);
    }

    @Override
    public Staff findById(int id) {
        Staff find=this.StaffRepository.findById(id);
        log.info("Find  staff by id :"+find);
        return find;
    }

    @Override
    public Staff findByEmail(String email) {
        Staff findByEmail=this.StaffRepository.findByEmail(email);
        log.info("Find  staff by email :"+findByEmail);
        return findByEmail;
    }

    @Override
    public Staff findByName(String StaffName) {
        Staff StaffName1=this.StaffRepository.findByName(StaffName);
        log.info("Find  staff by name :"+StaffName1);
        return StaffName1;
    }

    @Override
    public List<Staff> findAll() {
        List<Staff> findAll=this.StaffRepository.findAll();
        log.info("Find All staff  :"+findAll);
        return findAll;
    }
}
