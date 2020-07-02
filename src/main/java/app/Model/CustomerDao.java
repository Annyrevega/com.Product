package app.Model;

import app.object.Customer;

import java.util.List;

public interface CustomerDao {
    long saveCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(int id);
    Customer findCustomerById(int id);
    List <Customer> findAllCustomers();
}
