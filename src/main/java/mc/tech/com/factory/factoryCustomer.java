package mc.tech.com.factory;


import mc.tech.com.entities.Customer;

public class factoryCustomer {

    public static Customer BuildCustomer(String name,String email,String phoneNumber,
                                         String password,String address, String paymentInformation){

        return  new Customer.Builder().setName(name).setEmail(email).setPhoneNumber(phoneNumber)
                .setPhoneNumber(password).setAddress(address).setPaymentInformation(paymentInformation).builder();

    }

    public static Customer BuildCustomerEdit(int customerId,String name,String email,String phoneNumber,
                                         String password,String address, String paymentInformation){

        return  new Customer.Builder().setCustomerId(customerId).setName(name).setEmail(email).setPhoneNumber(phoneNumber)
                .setPhoneNumber(password).setAddress(address).setPaymentInformation(paymentInformation).builder();

    }
}
