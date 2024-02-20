package com.bootcamp.library.service.impl;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.bootcamp.library.dto.CustomerDto;
import com.bootcamp.library.model.Customer;
import com.bootcamp.library.repository.CustomerRepository;
import com.bootcamp.library.repository.RoleRepository;
import com.bootcamp.library.service.CustomerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final RoleRepository roleRepository;

    @Override
    public Customer save(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setPassword(customerDto.getPassword());
        customer.setUserName(customerDto.getUserName());
        customer.setRoles(Arrays.asList(roleRepository.findByName("CUSTOMER")));
        return customerRepository.save(customer);
    }

    @Override
    public Customer findByUserName(String UserName) {
        return customerRepository.findByUserName(UserName);
    }

    @Override
    public CustomerDto getCustomer(String UserName) {
        CustomerDto customerDto = new CustomerDto();
        Customer customer = customerRepository.findByUserName(UserName);
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
        customerDto.setUserName(customer.getUserName());
        customerDto.setPassword(customer.getPassword());
        customerDto.setAddress(customer.getAddress());
        customerDto.setPhoneNumber(customer.getPhoneNumber());
        customerDto.setCity(customer.getCity());
        customerDto.setCountry(customer.getCountry());
        return customerDto;
    }

    @Override
    public Customer changePass(CustomerDto customerDto) {
        Customer customer = customerRepository.findByUserName(customerDto.getUserName());
        customer.setPassword(customerDto.getPassword());
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(CustomerDto dto) {
        Customer customer = customerRepository.findByUserName(dto.getUserName());
        customer.setAddress(dto.getAddress());
        customer.setCity(dto.getCity());
        customer.setCountry(dto.getCountry());
        customer.setPhoneNumber(dto.getPhoneNumber());
        return customerRepository.save(customer);
    }
}
