package com.otcp.Accounting.customer.repository;

import com.otcp.Accounting.customer.entity.Address;
import com.otcp.Accounting.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Customer saveCustomer(Customer customer);
    Customer getCustomerById(Long id);
    List<Customer> getAllCustomers();
    List<Customer> getCustomersByStatus(String status);
    Customer updateCustomer(Long id, Customer customer);
    void deleteCustomer(Long id);
    List<Customer> searchCustomersByEmail(String email);
}