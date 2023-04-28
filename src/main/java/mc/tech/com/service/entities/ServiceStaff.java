package mc.tech.com.service.entities;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mc.tech.com.entities.Staff;
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
        Staff getStaffDetails= new Staff(staff.getName(),staff.getSurname(),
                staff.getEmail(),staff.getPhoneNumber(),staff.getPassword(),staff.getPosition());

        Staff saveStaff=this.StaffRepository.save(getStaffDetails);
        log.info("staff was register:"+saveStaff);
        return saveStaff;
    }


    public Optional<Staff> Editsave(Staff name) {
        int ID=name.getStaffId();
        return findByID(ID).map(name1 -> {
            String firstName=name.getName();
            String surname= name.getSurname();
            String phoneNumber=name.getPhoneNumber();
            int id=name1.getStaffId();
            String Email=name1.getEmail();
            String password=name.getPassword();
            String position= name.getPosition();
            Staff update = new Staff(id,firstName,surname,Email,phoneNumber,password,position);
            System.out.println("updated "+update);
            return this.StaffRepository.save(update);
        });

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
    public  Optional<Staff> findByEmail(String email) {
        Optional<Staff> findByEmail= Optional.ofNullable(this.StaffRepository.findByEmail(email));
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

    @Override
    public List<Staff> findAllByOrderByStaffIdDesc() {
        List<Staff> list=this.StaffRepository.findAllByOrderByStaffIdDesc();
        System.out.println(list);
        return list;
    }

    public long getTotalStaffRCount() {
        return this.StaffRepository.count();
    }

    public Optional<Staff> findByID(int id) {
        return Optional.ofNullable(this.StaffRepository.findById(id));
    }

    public List<String> findStaffAllName() {
        List<String> ListOfStaff=this.StaffRepository.findAllStaffNames();

        log.info("List Of Staff Names"+ListOfStaff);
        return ListOfStaff;
    }

    public List<Staff> findByKeyword(String keyword) {
        List<Staff> ListOfStaff=this.StaffRepository.findByKeyword(keyword);

        log.info("List Of Staff find by keyword"+ListOfStaff);
        return ListOfStaff;
    }
}
