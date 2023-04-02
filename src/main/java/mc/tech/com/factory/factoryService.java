package mc.tech.com.factory;


import mc.tech.com.entities.Service;

public class factoryService {

    public static Service BuildService(String name, String description,int duration, double price){

    return new Service.Builder().setName(name) .setDescription(description).setDuration(duration).setPrice(price).builder();
    }

    public static Service BuildServiceEdit( int serviceId,String name, String description,int duration, double price){

        return new Service.Builder().setServiceId(serviceId).setName(name) .setDescription(description).setDuration(duration).setPrice(price).builder();
    }
}
