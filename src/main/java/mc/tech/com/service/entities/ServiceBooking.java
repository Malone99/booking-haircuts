package mc.tech.com.service.entities;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mc.tech.com.entities.Booking;
import mc.tech.com.entities.Customer;
import mc.tech.com.entities.Staff;
import mc.tech.com.factory.factoryBooking;
import mc.tech.com.repository.repositoryBooking;
import mc.tech.com.repository.repositoryCustomer;
import mc.tech.com.repository.repositoryService;
import mc.tech.com.repository.repositoryStaff;
import mc.tech.com.service.implementation.BookingImplementation;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
@Slf4j
public class ServiceBooking implements BookingImplementation {

    private final repositoryBooking repository;
    private final repositoryService ServiceRepository;
    private final repositoryCustomer repositoryCustomer;
    private final repositoryStaff repositoryStaff;
    @Override
    public Booking findById(int id) {
        Booking BookingFindById=this.repository.findById(id);
        log.info("find Booking By Id:"+id+"::"+BookingFindById);
        return BookingFindById;
    }


    public Booking findByCustomerId(int customerId) {
        Booking findByCustomerId=this.repository.findById(customerId);
        log.info("find Booking By Id:"+customerId+"::"+findByCustomerId);
        return findByCustomerId;
    }

    @Override
    public List<Booking> findAllBooking() {
        List<Booking> find=this.repository.findAll();
        log.info("find Booking By all:"+find);
        return find;
    }

    @Override
    public List<Booking> findByStaffName(String StaffName) {

        List<Booking> findByStaffName=this.repository.findByStaffName(StaffName);
        log.info("find Booking By Staff Name:"+StaffName+"::"+findByStaffName);

        return findByStaffName;
    }

    @Override
    public List<Booking> findByDate(String date) {
        List<Booking>  Date=this.repository.findByDate(date);
        log.info("find Booking By Date:"+date+" ::"+Date);
        return Date;
    }

    @Override
    public Booking save(Booking booking) {

        mc.tech.com.entities.Service serviceName= this.ServiceRepository.findByName(booking.getServiceName());
        Customer CustomerName=this.repositoryCustomer.findByName(booking.getCustomerName());
        Staff staffname=this.repositoryStaff.findByName(booking.getStaffName());


        if(!serviceName.getName().equals(booking.getServiceName())){

            throw new IllegalArgumentException("Service Name Does not Exit ::"+booking.getServiceName());
        } else if(!CustomerName.getName().equals(booking.getCustomerName())){
            throw new IllegalArgumentException("Customer Name Does not Exit ::"+booking.getCustomerName());
        } else if(!staffname.getName().equals(booking.getStaffName())){

            throw new IllegalArgumentException("Staff Name Does not Exit ::"+booking.getStaffName());
        } else if (repository.existsBookingByDateAndTime(booking.getDate(),booking.getTime()))
        {
            throw new IllegalArgumentException("Booking already exists for this date and time");
        }
        Booking bookingsave= factoryBooking.BuildBooking(CustomerName.getName(),
                    serviceName.getName(),
                    staffname.getName(),
                    booking.getDate(),
                    booking.getTime(),
                    serviceName.getDuration(),
                     serviceName.getPrice(),
                    booking.getStatus());
        Booking save=this.repository.save(bookingsave);
        log.info(" Book your Haircut:"+save+"::"+save);
        return save;
    }

    @Override
    public Optional<Booking> read(Integer integer) {

        Optional<Booking> read=this.repository.findById(integer);
        return read;
    }

    @Override
    public void delete(int deleteById) {
        this.repository.deleteById(deleteById);
    }
}
