package mc.tech.com.service.implementation;

import mc.tech.com.entities.Service;

import java.util.List;

public interface ServiceImplementation extends  IService<Service,Integer>{
    Service findById(int id);
    List<Service> findAll();
    Service findByName(String name);
}
