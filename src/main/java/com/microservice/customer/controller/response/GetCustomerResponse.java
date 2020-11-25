package com.microservice.customer.controller.response;

import com.microservice.customer.dto.CustomerDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class GetCustomerResponse extends CustomerDto {

    public GetCustomerResponse(CustomerDto customerDto) {
        super(customerDto.getId(), customerDto.getFirstName(), customerDto.getLastName());
    }
}
