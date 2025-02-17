
package com.otcp.Accounting.customer.service.impl;

import com.otcp.Accounting.customer.entity.Customer;
import com.otcp.Accounting.customer.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public Customer saveCustomer(Customer customer) {
        return null;
    }

    @Override
    public Customer getCustomerById(Long id) {
        return null;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return null;
    }

    @Override
    public List<Customer> getCustomersByStatus(String status) {
        return null;
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        return null;
    }

    @Override
    public void deleteCustomer(Long id) {

    }

    @Override
    public List<Customer> searchCustomersByEmail(String email) {
        return null;
    }
}
