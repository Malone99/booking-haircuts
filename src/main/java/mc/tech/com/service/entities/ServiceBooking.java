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
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
@Slf4j
public class ServiceBooking implements BookingImplementation {

    private final repositoryBooking repository;
    private final repositoryService ServiceRepository;
    private final mc.tech.com.repository.repositoryCustomer repositoryCustomer;
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
    public List<Booking> findAll() {
        List<Booking> find=this.repository.findAllByOrderByBookingIdDesc();
        log.info("find Booking By all:"+find);
        return find;
    }



    @Override
    public List<Booking> findByDate(String date) {
        List<Booking>  Date=this.repository.findByDate(date);
        log.info("find Booking By Date:"+date+" ::"+Date);
        return Date;
    }

    public Booking savet( Booking booking) {
        mc.tech.com.entities.Service serviceName= this.ServiceRepository.findByName(booking.getServiceName());

        if(!serviceName.getName().equals(booking.getServiceName())){

            throw new IllegalArgumentException("Service Name Does not Exit ::"+booking.getServiceName());
        } else if(repository.existsBookingByCustomerEmail(booking.getCustomerEmail())){
            throw new IllegalArgumentException("Customer Email Does not Exit ::"+booking.getCustomerEmail());
        } else if (repository.existsBookingByDateAndTime(booking.getDate(),booking.getTime()))
        {
            throw new IllegalArgumentException("Booking already exists for this date and time");
        }


        Booking booking1= new Booking(booking.getCustomerName(),booking.getCustomerEmail(),booking.getServiceName()
                ,booking.getDate(),booking.getTime(),serviceName.getDuration(),serviceName.getPrice(),booking.getMessage()
                ,"Booked");
     return    this.repository.save(booking1);
    }

    @Override
    public Booking save(@NotNull Booking booking) {

        mc.tech.com.entities.Service serviceName= this.ServiceRepository.findByName(booking.getServiceName());
        Customer CustomerName=this.repositoryCustomer.findByName(booking.getCustomerName());
        System.out.println("serviceName"+booking.getServiceName());
        System.out.println("email"+booking.getCustomerEmail());
        System.out.println("CustomerName"+booking.getCustomerName());


        if(!serviceName.getName().equals(booking.getServiceName())){

            throw new IllegalArgumentException("Service Name Does not Exit ::"+booking.getServiceName());
        } else if(repository.existsBookingByCustomerEmail(booking.getCustomerEmail())){
            throw new IllegalArgumentException("Customer Email Does not Exit ::"+booking.getCustomerEmail());
        } else if (repository.existsBookingByDateAndTime(booking.getDate(),booking.getTime()))
        {
            throw new IllegalArgumentException("Booking already exists for this date and time");
        }
        Booking bookingsave= new Booking(booking.getCustomerName(),
                    CustomerName.getEmail(),
                    booking.getServiceName(),
                    booking.getDate(),
                    booking.getTime(),
                    serviceName.getDuration(),
                    serviceName.getPrice(),
                    booking.getMessage(),
                    "booked");
        Booking save=this.repository.save(bookingsave);
        log.info(" Book your Haircut:"+save+"::"+save);
        return save;
    }
    public Optional<Booking> EditsaveBooking(Booking name) {
        int ID=name.getBookingId();
        return findByID(ID).map(name1 -> {
            int id=name1.getBookingId();
            String CustomerName=name.getCustomerName();
            String ServiceName= name.getServiceName();
            String message=name.getMessage();
            String email=name.getCustomerEmail();
            String date=name.getDate();
            String time= name.getTime();
            int Duration=name1.getDuration();
            double price= name1.getPrice();
            String status=name1.getStatus();
            Booking update = new Booking(id,CustomerName,email,ServiceName,date,time,Duration,price,message,status);
            System.out.println("updated "+update);
            return this.repository.save(update);
        });

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

    public long getTotalBookingRCount() {
        return this.repository.count();
    }

    public double TotalMoney() {
        Double totalMoney = repository.getTotalPriceByStatus("done");
        return totalMoney != null ? totalMoney : 0;

    }
    public Optional<Booking> findByID(int id) {
        return Optional.ofNullable(this.repository.findById(id));
    }


}
