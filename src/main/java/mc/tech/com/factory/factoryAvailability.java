package mc.tech.com.factory;

import mc.tech.com.entities.Availability;


public class factoryAvailability {

    public static Availability BuildAvailability( String date, String time, int serviceId,int staffId){


        return  new Availability.Builder().setDate(date).setTime(time).setServiceId(serviceId).setStaffId(staffId).builder();
    }
    public static Availability BuildAvailabilityEdit(int availabilityId ,String date, String time, int serviceId,int staffId){


        return  new Availability.Builder().setDate(date).setTime(time).setServiceId(serviceId).setStaffId(staffId).builder();
    }
}
