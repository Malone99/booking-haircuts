package mc.tech.com.factory;


import mc.tech.com.entities.Service;

public class factoryService {

    public static Service BuildService(String title ,String name, String description,int duration, int price,byte[] imageData){

    return new Service.Builder().setTitle(title).setName(name) .setDescription(description).setDuration(duration).setPrice(price).setImageData(imageData).builder();
    }

    public static Service BuildServiceEdit( int serviceId,String name, String description,int duration, int price){

        return new Service.Builder().setServiceId(serviceId).setName(name) .setDescription(description).setDuration(duration).setPrice(price).builder();
    }
}
