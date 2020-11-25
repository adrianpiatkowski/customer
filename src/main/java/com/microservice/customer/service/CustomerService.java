package com.microservice.customer.service;

import com.microservice.customer.dto.CustomerDto;
import com.microservice.customer.mapper.CustomerMapper;
import com.microservice.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper mapper;

    public Optional<CustomerDto> findCustomer(Long customerId) {
        return customerRepository.findById(customerId)
                .map(mapper::mapToCustomerDto);
    }
}
