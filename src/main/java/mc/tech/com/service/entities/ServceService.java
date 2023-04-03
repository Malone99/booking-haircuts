package mc.tech.com.service.entities;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mc.tech.com.entities.Service;
import mc.tech.com.repository.repositoryService;
import mc.tech.com.service.implementation.ServiceImplementation;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@org.springframework.stereotype.Service
@Slf4j
public class ServceService implements ServiceImplementation {

    private final repositoryService repositoryService;
    @Override
    public Service save(Service service) {
        Service service1=this.repositoryService.save(service);
        log.info("Haircut service created "+service1);
        return service1;
    }

    @Override
    public Optional<Service> read(Integer integer) {
        Optional<Service> read=this.repositoryService.findById(integer);
        log.info("Haircut service created "+read);
        return read;
    }

    @Override
    public void delete(int deleteById) {

        this.repositoryService.deleteById(deleteById);

    }

    @Override
    public Service findById(int id) {
        Service service=this.repositoryService.findById(id);
        log.info("find Haircut service By id"+service);
        return service;
    }

    @Override
    public List<Service> findAll() {
        List<Service> serviceList=this.repositoryService.findAll();
        log.info("List Haircut service "+serviceList);
        return serviceList;
    }

    @Override
    public Service findByName(String name) {
        Service service=this.repositoryService.findByName(name);
        log.info("find  Haircut service by Name"+service);
        return service;
    }
}
