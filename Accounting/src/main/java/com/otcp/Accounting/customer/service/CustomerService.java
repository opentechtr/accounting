
package com.otcp.Accounting.customer.service;

import com.otcp.Accounting.customer.entity.Customer;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface CustomerService {
    Customer saveCustomer(Customer customer);
    Customer getCustomerById(Long id);
    List<Customer> getAllCustomers();
    List<Customer> getCustomersByStatus(String status);
    Customer updateCustomer(Long id, Customer customer);
    void deleteCustomer(Long id);
    List<Customer> searchCustomersByEmail(String email);
}
