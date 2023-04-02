package mc.tech.com.factory;


import mc.tech.com.entities.Staff;

public class factoryStaff {


    public static Staff BuildStaff(String name, String email, String phoneNumber, String password,String position){

        return new Staff.Builder().setName(name)
                .setEmail(email)
                .setPhoneNumber(phoneNumber)
                .setPassword(password)
                .setPosition(position)
                .builder();
    }

    public static Staff BuildStaffEdit(int staffId,String name, String email, String phoneNumber, String password,String position){

        return new Staff.Builder().setName(name)
                .setStaffId(staffId)
                .setEmail(email)
                .setPhoneNumber(phoneNumber)
                .setPassword(password)
                .setPosition(position)
                .builder();
    }

    }





